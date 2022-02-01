package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
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
    AppMethodBeat.i(17627);
    TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    isTracking = new AtomicBoolean(false);
    hasBillingService = null;
    hasBiillingActivity = null;
    AppMethodBeat.o(17627);
  }
  
  /* Error */
  private static void initializeIfNotInitialized()
  {
    // Byte code:
    //   0: sipush 17621
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 59	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBillingService	Ljava/lang/Boolean;
    //   9: ifnull +10 -> 19
    //   12: sipush 17621
    //   15: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: ldc 19
    //   21: invokestatic 92	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   24: pop
    //   25: getstatic 97	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   28: putstatic 59	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBillingService	Ljava/lang/Boolean;
    //   31: ldc 16
    //   33: invokestatic 92	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: pop
    //   37: getstatic 97	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   40: putstatic 61	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBiillingActivity	Ljava/lang/Boolean;
    //   43: invokestatic 102	com/facebook/appevents/internal/InAppPurchaseEventManager:clearSkuDetailsCache	()V
    //   46: new 104	android/content/Intent
    //   49: dup
    //   50: ldc 106
    //   52: invokespecial 109	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   55: ldc 111
    //   57: invokevirtual 115	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   60: putstatic 117	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:intent	Landroid/content/Intent;
    //   63: new 6	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$1
    //   66: dup
    //   67: invokespecial 118	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$1:<init>	()V
    //   70: putstatic 120	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:serviceConnection	Landroid/content/ServiceConnection;
    //   73: new 8	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$2
    //   76: dup
    //   77: invokespecial 121	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker$2:<init>	()V
    //   80: putstatic 123	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:callbacks	Landroid/app/Application$ActivityLifecycleCallbacks;
    //   83: sipush 17621
    //   86: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: return
    //   90: astore_0
    //   91: getstatic 126	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   94: putstatic 59	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBillingService	Ljava/lang/Boolean;
    //   97: sipush 17621
    //   100: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: return
    //   104: astore_0
    //   105: getstatic 126	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   108: putstatic 61	com/facebook/appevents/internal/InAppPurchaseActivityLifecycleTracker:hasBiillingActivity	Ljava/lang/Boolean;
    //   111: goto -68 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   90	1	0	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   104	1	0	localClassNotFoundException2	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   19	31	90	java/lang/ClassNotFoundException
    //   31	43	104	java/lang/ClassNotFoundException
  }
  
  private static void logPurchaseInapp(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(17623);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(17623);
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
    AppMethodBeat.o(17623);
  }
  
  private static void logPurchaseSubs(Context paramContext, Map<String, SubscriptionType> paramMap)
  {
    AppMethodBeat.i(17624);
    if (paramMap.isEmpty())
    {
      AppMethodBeat.o(17624);
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
    AppMethodBeat.o(17624);
  }
  
  private static void startTracking()
  {
    AppMethodBeat.i(17622);
    if (!isTracking.compareAndSet(false, true))
    {
      AppMethodBeat.o(17622);
      return;
    }
    Context localContext = FacebookSdk.getApplicationContext();
    if ((localContext instanceof Application))
    {
      ((Application)localContext).registerActivityLifecycleCallbacks(callbacks);
      localContext.bindService(intent, serviceConnection, 1);
    }
    AppMethodBeat.o(17622);
  }
  
  public static void update()
  {
    AppMethodBeat.i(17620);
    initializeIfNotInitialized();
    if (!hasBillingService.booleanValue())
    {
      AppMethodBeat.o(17620);
      return;
    }
    if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
      startTracking();
    }
    AppMethodBeat.o(17620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker
 * JD-Core Version:    0.7.0.1
 */