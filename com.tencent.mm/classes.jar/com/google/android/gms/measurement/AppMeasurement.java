package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.b.a;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzif;
import com.google.android.gms.internal.measurement.zzjr;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzka;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.firebase.analytics.FirebaseAnalytics.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement
{
  public static final String CRASH_ORIGIN = "crash";
  public static final String FCM_ORIGIN = "fcm";
  private final zzgl zzacw;
  
  public AppMeasurement(zzgl paramzzgl)
  {
    AppMethodBeat.i(2309);
    Preconditions.checkNotNull(paramzzgl);
    this.zzacw = paramzzgl;
    AppMethodBeat.o(2309);
  }
  
  @Deprecated
  public static AppMeasurement getInstance(Context paramContext)
  {
    AppMethodBeat.i(2303);
    paramContext = zzgl.zzg(paramContext).zzjr();
    AppMethodBeat.o(2303);
    return paramContext;
  }
  
  public void beginAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(2322);
    this.zzacw.zzft().beginAdUnitExposure(paramString);
    AppMethodBeat.o(2322);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(2326);
    this.zzacw.zzfu().clearConditionalUserProperty(paramString1, paramString2, paramBundle);
    AppMethodBeat.o(2326);
  }
  
  protected void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    AppMethodBeat.i(2327);
    this.zzacw.zzfu().clearConditionalUserPropertyAs(paramString1, paramString2, paramString3, paramBundle);
    AppMethodBeat.o(2327);
  }
  
  public void endAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(2323);
    this.zzacw.zzft().endAdUnitExposure(paramString);
    AppMethodBeat.o(2323);
  }
  
  public long generateEventId()
  {
    AppMethodBeat.i(2321);
    long l = this.zzacw.zzgb().zzlb();
    AppMethodBeat.o(2321);
    return l;
  }
  
  public String getAppInstanceId()
  {
    AppMethodBeat.i(2319);
    String str = this.zzacw.zzfu().zzja();
    AppMethodBeat.o(2319);
    return str;
  }
  
  public Boolean getBoolean()
  {
    AppMethodBeat.i(2333);
    Boolean localBoolean = this.zzacw.zzfu().zzjx();
    AppMethodBeat.o(2333);
    return localBoolean;
  }
  
  public List<ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2330);
    paramString1 = this.zzacw.zzfu().getConditionalUserProperties(paramString1, paramString2);
    AppMethodBeat.o(2330);
    return paramString1;
  }
  
  protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(2331);
    paramString1 = this.zzacw.zzfu().getConditionalUserPropertiesAs(paramString1, paramString2, paramString3);
    AppMethodBeat.o(2331);
    return paramString1;
  }
  
  public String getCurrentScreenClass()
  {
    AppMethodBeat.i(2318);
    Object localObject = this.zzacw.zzfy().zzkd();
    if (localObject != null)
    {
      localObject = ((zzie)localObject).zzaoi;
      AppMethodBeat.o(2318);
      return localObject;
    }
    AppMethodBeat.o(2318);
    return null;
  }
  
  public String getCurrentScreenName()
  {
    AppMethodBeat.i(2317);
    Object localObject = this.zzacw.zzfy().zzkd();
    if (localObject != null)
    {
      localObject = ((zzie)localObject).zzul;
      AppMethodBeat.o(2317);
      return localObject;
    }
    AppMethodBeat.o(2317);
    return null;
  }
  
  public Double getDouble()
  {
    AppMethodBeat.i(2337);
    Double localDouble = this.zzacw.zzfu().zzka();
    AppMethodBeat.o(2337);
    return localDouble;
  }
  
  public String getGmpAppId()
  {
    AppMethodBeat.i(2320);
    try
    {
      String str = GoogleServices.getGoogleAppId();
      AppMethodBeat.o(2320);
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.zzacw.zzge().zzim().zzg("getGoogleAppId failed with exception", localIllegalStateException);
      AppMethodBeat.o(2320);
    }
    return null;
  }
  
  public Integer getInteger()
  {
    AppMethodBeat.i(2336);
    Integer localInteger = this.zzacw.zzfu().zzjz();
    AppMethodBeat.o(2336);
    return localInteger;
  }
  
  public Long getLong()
  {
    AppMethodBeat.i(2335);
    Long localLong = this.zzacw.zzfu().zzjy();
    AppMethodBeat.o(2335);
    return localLong;
  }
  
  public int getMaxUserProperties(String paramString)
  {
    AppMethodBeat.i(2332);
    this.zzacw.zzfu();
    Preconditions.checkNotEmpty(paramString);
    AppMethodBeat.o(2332);
    return 25;
  }
  
  public String getString()
  {
    AppMethodBeat.i(2334);
    String str = this.zzacw.zzfu().zzhm();
    AppMethodBeat.o(2334);
    return str;
  }
  
  protected Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(2328);
    paramString1 = this.zzacw.zzfu().getUserProperties(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(2328);
    return paramString1;
  }
  
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    AppMethodBeat.i(2313);
    Object localObject = this.zzacw.zzfu().zzj(paramBoolean);
    a locala = new a(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      zzjx localzzjx = (zzjx)((Iterator)localObject).next();
      locala.put(localzzjx.name, localzzjx.getValue());
    }
    AppMethodBeat.o(2313);
    return locala;
  }
  
  protected Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(2329);
    paramString1 = this.zzacw.zzfu().getUserPropertiesAs(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(2329);
    return paramString1;
  }
  
  public final void logEvent(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(2304);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzacw.zzfu().zza("app", paramString, localBundle, true);
    AppMethodBeat.o(2304);
  }
  
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(2310);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzacw.zzfu().logEvent(paramString1, paramString2, localBundle);
    AppMethodBeat.o(2310);
  }
  
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    AppMethodBeat.i(2311);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      this.zzacw.zzfu().zza(paramString1, paramString2, paramBundle, paramLong);
      AppMethodBeat.o(2311);
      return;
    }
  }
  
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(2315);
    this.zzacw.zzfu().registerOnMeasurementEventListener(paramOnEventListener);
    AppMethodBeat.o(2315);
  }
  
  public void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(2324);
    this.zzacw.zzfu().setConditionalUserProperty(paramConditionalUserProperty);
    AppMethodBeat.o(2324);
  }
  
  protected void setConditionalUserPropertyAs(ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(2325);
    this.zzacw.zzfu().setConditionalUserPropertyAs(paramConditionalUserProperty);
    AppMethodBeat.o(2325);
  }
  
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    AppMethodBeat.i(2314);
    this.zzacw.zzfu().setEventInterceptor(paramEventInterceptor);
    AppMethodBeat.o(2314);
  }
  
  @Deprecated
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(2306);
    this.zzacw.zzfu().setMeasurementEnabled(paramBoolean);
    AppMethodBeat.o(2306);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    AppMethodBeat.i(2307);
    this.zzacw.zzfu().setMinimumSessionDuration(paramLong);
    AppMethodBeat.o(2307);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    AppMethodBeat.i(2308);
    this.zzacw.zzfu().setSessionTimeoutDuration(paramLong);
    AppMethodBeat.o(2308);
  }
  
  public final void setUserProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2305);
    int j = this.zzacw.zzgb().zzce(paramString1);
    if (j != 0)
    {
      this.zzacw.zzgb();
      paramString2 = zzka.zza(paramString1, 24, true);
      if (paramString1 != null) {}
      for (int i = paramString1.length();; i = 0)
      {
        this.zzacw.zzgb().zza(j, "_ev", paramString2, i);
        AppMethodBeat.o(2305);
        return;
      }
    }
    setUserPropertyInternal("app", paramString1, paramString2);
    AppMethodBeat.o(2305);
  }
  
  public void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(2312);
    this.zzacw.zzfu().setUserProperty(paramString1, paramString2, paramObject);
    AppMethodBeat.o(2312);
  }
  
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(2316);
    this.zzacw.zzfu().unregisterOnMeasurementEventListener(paramOnEventListener);
    AppMethodBeat.o(2316);
  }
  
  public static class ConditionalUserProperty
  {
    public boolean mActive;
    public String mAppId;
    public long mCreationTimestamp;
    public String mExpiredEventName;
    public Bundle mExpiredEventParams;
    public String mName;
    public String mOrigin;
    public long mTimeToLive;
    public String mTimedOutEventName;
    public Bundle mTimedOutEventParams;
    public String mTriggerEventName;
    public long mTriggerTimeout;
    public String mTriggeredEventName;
    public Bundle mTriggeredEventParams;
    public long mTriggeredTimestamp;
    public Object mValue;
    
    public ConditionalUserProperty() {}
    
    public ConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
    {
      AppMethodBeat.i(2299);
      Preconditions.checkNotNull(paramConditionalUserProperty);
      this.mAppId = paramConditionalUserProperty.mAppId;
      this.mOrigin = paramConditionalUserProperty.mOrigin;
      this.mCreationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
      this.mName = paramConditionalUserProperty.mName;
      if (paramConditionalUserProperty.mValue != null)
      {
        this.mValue = zzka.zzf(paramConditionalUserProperty.mValue);
        if (this.mValue == null) {
          this.mValue = paramConditionalUserProperty.mValue;
        }
      }
      this.mActive = paramConditionalUserProperty.mActive;
      this.mTriggerEventName = paramConditionalUserProperty.mTriggerEventName;
      this.mTriggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
      this.mTimedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
      if (paramConditionalUserProperty.mTimedOutEventParams != null) {
        this.mTimedOutEventParams = new Bundle(paramConditionalUserProperty.mTimedOutEventParams);
      }
      this.mTriggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
      if (paramConditionalUserProperty.mTriggeredEventParams != null) {
        this.mTriggeredEventParams = new Bundle(paramConditionalUserProperty.mTriggeredEventParams);
      }
      this.mTriggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
      this.mTimeToLive = paramConditionalUserProperty.mTimeToLive;
      this.mExpiredEventName = paramConditionalUserProperty.mExpiredEventName;
      if (paramConditionalUserProperty.mExpiredEventParams != null) {
        this.mExpiredEventParams = new Bundle(paramConditionalUserProperty.mExpiredEventParams);
      }
      AppMethodBeat.o(2299);
    }
  }
  
  public static final class Event
    extends FirebaseAnalytics.a
  {
    public static final String AD_REWARD = "_ar";
    public static final String APP_EXCEPTION = "_ae";
    public static final String[] zzacx = { "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter" };
    public static final String[] zzacy = { "_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep" };
    
    public static String zzak(String paramString)
    {
      AppMethodBeat.i(2300);
      paramString = zzka.zza(paramString, zzacx, zzacy);
      AppMethodBeat.o(2300);
      return paramString;
    }
  }
  
  public static abstract interface EventInterceptor
  {
    public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  public static abstract interface OnEventListener
  {
    public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  public static final class Param
    extends FirebaseAnalytics.b
  {
    public static final String FATAL = "fatal";
    public static final String TIMESTAMP = "timestamp";
    public static final String TYPE = "type";
    public static final String[] zzacz = { "firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "deferred_analytics_collection" };
    public static final String[] zzada = { "_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_dac" };
    
    public static String zzak(String paramString)
    {
      AppMethodBeat.i(2301);
      paramString = zzka.zza(paramString, zzacz, zzada);
      AppMethodBeat.o(2301);
      return paramString;
    }
  }
  
  public static final class UserProperty
    extends FirebaseAnalytics.c
  {
    public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
    public static final String[] zzadb = { "firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement" };
    public static final String[] zzadc = { "_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte" };
    
    public static String zzak(String paramString)
    {
      AppMethodBeat.i(2302);
      paramString = zzka.zza(paramString, zzadb, zzadc);
      AppMethodBeat.o(2302);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement
 * JD-Core Version:    0.7.0.1
 */