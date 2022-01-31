package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class InAppPurchaseActivityLifecycleTracker$2$2
  implements Runnable
{
  InAppPurchaseActivityLifecycleTracker$2$2(InAppPurchaseActivityLifecycleTracker.2 param2) {}
  
  public void run()
  {
    AppMethodBeat.i(72181);
    Context localContext = FacebookSdk.getApplicationContext();
    ArrayList localArrayList2 = InAppPurchaseEventManager.getPurchasesInapp(localContext, InAppPurchaseActivityLifecycleTracker.access$000());
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.isEmpty()) {
      localArrayList1 = InAppPurchaseEventManager.getPurchaseHistoryInapp(localContext, InAppPurchaseActivityLifecycleTracker.access$000());
    }
    InAppPurchaseActivityLifecycleTracker.access$100(localContext, localArrayList1);
    AppMethodBeat.o(72181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.2.2
 * JD-Core Version:    0.7.0.1
 */