package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONException;
import org.json.JSONObject;

public class AutomaticAnalyticsLogger
{
  private static final String TAG;
  private static final InternalAppEventsLogger internalAppEventsLogger;
  
  static
  {
    AppMethodBeat.i(17614);
    TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
    AppMethodBeat.o(17614);
  }
  
  private static PurchaseLoggingParameters getPurchaseLoggingParameters(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17613);
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = new JSONObject(paramString2);
      Bundle localBundle = new Bundle(1);
      localBundle.putCharSequence("fb_iap_product_id", paramString1.getString("productId"));
      localBundle.putCharSequence("fb_iap_purchase_time", paramString1.getString("purchaseTime"));
      localBundle.putCharSequence("fb_iap_purchase_token", paramString1.getString("purchaseToken"));
      localBundle.putCharSequence("fb_iap_package_name", paramString1.optString("packageName"));
      localBundle.putCharSequence("fb_iap_product_title", paramString2.optString("title"));
      localBundle.putCharSequence("fb_iap_product_description", paramString2.optString("description"));
      String str = paramString2.optString("type");
      localBundle.putCharSequence("fb_iap_product_type", str);
      if (str.equals("subs"))
      {
        localBundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(paramString1.optBoolean("autoRenewing", false)));
        localBundle.putCharSequence("fb_iap_subs_period", paramString2.optString("subscriptionPeriod"));
        localBundle.putCharSequence("fb_free_trial_period", paramString2.optString("freeTrialPeriod"));
        paramString1 = paramString2.optString("introductoryPriceCycles");
        if (!paramString1.isEmpty())
        {
          localBundle.putCharSequence("fb_intro_price_amount_micros", paramString2.optString("introductoryPriceAmountMicros"));
          localBundle.putCharSequence("fb_intro_price_cycles", paramString1);
        }
      }
      paramString1 = new PurchaseLoggingParameters(new BigDecimal(paramString2.getLong("price_amount_micros") / 1000000.0D), Currency.getInstance(paramString2.getString("price_currency_code")), localBundle);
      AppMethodBeat.o(17613);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      AppMethodBeat.o(17613);
    }
    return null;
  }
  
  public static boolean isImplicitPurchaseLoggingEnabled()
  {
    AppMethodBeat.i(17612);
    FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
    if ((localFetchedAppSettings != null) && (FacebookSdk.getAutoLogAppEventsEnabled()) && (localFetchedAppSettings.getIAPAutomaticLoggingEnabled()))
    {
      AppMethodBeat.o(17612);
      return true;
    }
    AppMethodBeat.o(17612);
    return false;
  }
  
  public static void logActivateAppEvent()
  {
    AppMethodBeat.i(17608);
    Context localContext = FacebookSdk.getApplicationContext();
    String str = FacebookSdk.getApplicationId();
    boolean bool = FacebookSdk.getAutoLogAppEventsEnabled();
    Validate.notNull(localContext, "context");
    if ((bool) && ((localContext instanceof Application))) {
      AppEventsLogger.activateApp((Application)localContext, str);
    }
    AppMethodBeat.o(17608);
  }
  
  public static void logActivityTimeSpentEvent(String paramString, long paramLong)
  {
    AppMethodBeat.i(17609);
    Object localObject1 = FacebookSdk.getApplicationContext();
    Object localObject2 = FacebookSdk.getApplicationId();
    Validate.notNull(localObject1, "context");
    localObject2 = FetchedAppSettingsManager.queryAppSettings((String)localObject2, false);
    if ((localObject2 != null) && (((FetchedAppSettings)localObject2).getAutomaticLoggingEnabled()) && (paramLong > 0L))
    {
      localObject1 = AppEventsLogger.newLogger((Context)localObject1);
      localObject2 = new Bundle(1);
      ((Bundle)localObject2).putCharSequence("fb_aa_time_spent_view_name", paramString);
      ((AppEventsLogger)localObject1).logEvent("fb_aa_time_spent_on_view", paramLong, (Bundle)localObject2);
    }
    AppMethodBeat.o(17609);
  }
  
  public static void logPurchaseInapp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17610);
    if (!isImplicitPurchaseLoggingEnabled())
    {
      AppMethodBeat.o(17610);
      return;
    }
    paramString1 = getPurchaseLoggingParameters(paramString1, paramString2);
    if (paramString1 != null) {
      internalAppEventsLogger.logPurchaseImplicitlyInternal(paramString1.purchaseAmount, paramString1.currency, paramString1.param);
    }
    AppMethodBeat.o(17610);
  }
  
  public static void logPurchaseSubs(SubscriptionType paramSubscriptionType, String paramString1, String paramString2)
  {
    AppMethodBeat.i(17611);
    if (!isImplicitPurchaseLoggingEnabled())
    {
      AppMethodBeat.o(17611);
      return;
    }
    String str = FacebookSdk.getApplicationId();
    switch (AutomaticAnalyticsLogger.1.$SwitchMap$com$facebook$appevents$internal$SubscriptionType[paramSubscriptionType.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17611);
      return;
      paramSubscriptionType = "SubscriptionRestore";
      for (;;)
      {
        paramString1 = getPurchaseLoggingParameters(paramString1, paramString2);
        if (paramString1 != null) {
          internalAppEventsLogger.logEventImplicitly(paramSubscriptionType, paramString1.purchaseAmount, paramString1.currency, paramString1.param);
        }
        AppMethodBeat.o(17611);
        return;
        paramSubscriptionType = "SubscriptionCancel";
        continue;
        paramSubscriptionType = "SubscriptionHeartbeat";
        continue;
        paramSubscriptionType = "SubscriptionExpire";
        continue;
        if (!FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_if_auto_log_subs", str, true)) {
          break;
        }
        paramSubscriptionType = "Subscribe";
      }
      logPurchaseInapp(paramString1, paramString2);
    }
  }
  
  static class PurchaseLoggingParameters
  {
    Currency currency;
    Bundle param;
    BigDecimal purchaseAmount;
    
    PurchaseLoggingParameters(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
    {
      this.purchaseAmount = paramBigDecimal;
      this.currency = paramCurrency;
      this.param = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.internal.AutomaticAnalyticsLogger
 * JD-Core Version:    0.7.0.1
 */