package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

final class InAppPurchaseActivityLifecycleTracker$2
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(72182);
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(72180);
        Context localContext = FacebookSdk.getApplicationContext();
        InAppPurchaseActivityLifecycleTracker.access$100(localContext, InAppPurchaseEventManager.getPurchasesInapp(localContext, InAppPurchaseActivityLifecycleTracker.access$000()));
        Map localMap = InAppPurchaseEventManager.getPurchasesSubs(localContext, InAppPurchaseActivityLifecycleTracker.access$000());
        Iterator localIterator = InAppPurchaseEventManager.getPurchasesSubsExpire(localContext, InAppPurchaseActivityLifecycleTracker.access$000()).iterator();
        while (localIterator.hasNext()) {
          localMap.put((String)localIterator.next(), SubscriptionType.EXPIRE);
        }
        InAppPurchaseActivityLifecycleTracker.access$200(localContext, localMap);
        AppMethodBeat.o(72180);
      }
    });
    AppMethodBeat.o(72182);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(72183);
    if ((InAppPurchaseActivityLifecycleTracker.access$300().booleanValue()) && (paramActivity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity"))) {
      FacebookSdk.getExecutor().execute(new InAppPurchaseActivityLifecycleTracker.2.2(this));
    }
    AppMethodBeat.o(72183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.2
 * JD-Core Version:    0.7.0.1
 */