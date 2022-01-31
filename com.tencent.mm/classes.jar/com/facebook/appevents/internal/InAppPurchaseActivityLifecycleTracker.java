package com.facebook.appevents.internal;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseActivityLifecycleTracker
{
  private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
  private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$a";
  private static final String TAG;
  private static Application.ActivityLifecycleCallbacks callbacks;
  private static Boolean hasBiillingActivity;
  private static Boolean hasBillingService;
  private static Object inAppBillingObj;
  private static Intent intent;
  private static final AtomicBoolean isTracking;
  private static ServiceConnection serviceConnection;
  
  static
  {
    AppMethodBeat.i(72191);
    TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    isTracking = new AtomicBoolean(false);
    hasBillingService = null;
    hasBiillingActivity = null;
    AppMethodBeat.o(72191);
  }
  
  /* Error */
  private static void initializeIfNotInitialized()
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 52	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBillingService	Ljava/lang/Boolean;
    //   8: ifnull +9 -> 17
    //   11: ldc 84
    //   13: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: return
    //   17: ldc 11
    //   19: invokestatic 88	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: pop
    //   23: getstatic 93	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   26: putstatic 52	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBillingService	Ljava/lang/Boolean;
    //   29: ldc 8
    //   31: invokestatic 88	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   34: pop
    //   35: getstatic 93	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   38: putstatic 54	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBiillingActivity	Ljava/lang/Boolean;
    //   41: invokestatic 98	com/facebook/appevents/internal/InAppPurchaseEventManager:clearSkuDetailsCache	()V
    //   44: new 100	android/content/Intent
    //   47: dup
    //   48: ldc 102
    //   50: invokespecial 105	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   53: ldc 107
    //   55: invokevirtual 111	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   58: putstatic 113	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:intent	Landroid/content/Intent;
    //   61: new 115	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$1
    //   64: dup
    //   65: invokespecial 116	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$1:<init>	()V
    //   68: putstatic 118	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:serviceConnection	Landroid/content/ServiceConnection;
    //   71: new 120	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$2
    //   74: dup
    //   75: invokespecial 121	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$2:<init>	()V
    //   78: putstatic 123	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:callbacks	Landroid/app/Application$ActivityLifecycleCallbacks;
    //   81: ldc 84
    //   83: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_0
    //   88: getstatic 126	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   91: putstatic 52	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBillingService	Ljava/lang/Boolean;
    //   94: ldc 84
    //   96: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore_0
    //   101: getstatic 126	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   104: putstatic 54	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBiillingActivity	Ljava/lang/Boolean;
    //   107: goto -66 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   87	1	0	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   100	1	0	localClassNotFoundException2	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   17	29	87	java/lang/ClassNotFoundException
    //   29	41	100	java/lang/ClassNotFoundException
  }
  
  private static void logPurchaseInapp(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(72187);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(72187);
      return;
    }
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str1 = (String)paramArrayList.next();
      try
      {
        String str2 = new JSONObject(str1).getString("productId");
        localHashMap.put(str2, str1);
        localArrayList.add(str2);
      }
      catch (JSONException localJSONException) {}
    }
    paramContext = InAppPurchaseEventManager.getSkuDetails(paramContext, localArrayList, inAppBillingObj, false).entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramArrayList = (Map.Entry)paramContext.next();
      AutomaticAnalyticsLogger.logPurchaseInapp((String)localHashMap.get(paramArrayList.getKey()), (String)paramArrayList.getValue());
    }
    AppMethodBeat.o(72187);
  }
  
  private static void logPurchaseSubs(Context paramContext, Map<String, SubscriptionType> paramMap)
  {
    AppMethodBeat.i(72188);
    if (paramMap.isEmpty())
    {
      AppMethodBeat.o(72188);
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      try
      {
        String str3 = new JSONObject(str1).getString("productId");
        ((ArrayList)localObject1).add(str3);
        localHashMap.put(str3, str1);
      }
      catch (JSONException localJSONException) {}
    }
    paramContext = InAppPurchaseEventManager.getSkuDetails(paramContext, (ArrayList)localObject1, inAppBillingObj, true);
    localObject1 = paramContext.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str2 = (String)((Iterator)localObject1).next();
      localObject2 = (String)localHashMap.get(str2);
      str2 = (String)paramContext.get(str2);
      AutomaticAnalyticsLogger.logPurchaseSubs((SubscriptionType)paramMap.get(localObject2), (String)localObject2, str2);
    }
    AppMethodBeat.o(72188);
  }
  
  private static void startTracking()
  {
    AppMethodBeat.i(72186);
    if (!isTracking.compareAndSet(false, true))
    {
      AppMethodBeat.o(72186);
      return;
    }
    Context localContext = FacebookSdk.getApplicationContext();
    if ((localContext instanceof Application))
    {
      ((Application)localContext).registerActivityLifecycleCallbacks(callbacks);
      localContext.bindService(intent, serviceConnection, 1);
    }
    AppMethodBeat.o(72186);
  }
  
  public static void update()
  {
    AppMethodBeat.i(72184);
    initializeIfNotInitialized();
    if (!hasBillingService.booleanValue())
    {
      AppMethodBeat.o(72184);
      return;
    }
    if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
      startTracking();
    }
    AppMethodBeat.o(72184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker
 * JD-Core Version:    0.7.0.1
 */