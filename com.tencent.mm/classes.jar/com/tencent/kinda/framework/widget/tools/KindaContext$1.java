package com.tencent.kinda.framework.widget.tools;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.kinda.framework.module.impl.PlatformUIRouterImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Stack;

final class KindaContext$1
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(145198);
    ab.d("KindaContext", "onActivityCreated：".concat(String.valueOf(paramActivity)));
    if ((KindaContext.access$000() != null) && (KindaContext.access$000().size() > 0) && (KindaContext.access$000().peek() != null) && (((WeakReference)KindaContext.access$000().peek()).get() != paramActivity))
    {
      KindaContext.access$000().push(new WeakReference(paramActivity));
      ab.d("KindaContext", "sContextStack.push：".concat(String.valueOf(paramActivity)));
    }
    AppMethodBeat.o(145198);
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(145199);
    ab.d("KindaContext", "onActivityPaused：".concat(String.valueOf(paramActivity)));
    WeakReference localWeakReference;
    if (paramActivity.isFinishing())
    {
      Iterator localIterator = KindaContext.access$000().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while (localWeakReference.get() != paramActivity);
    }
    for (;;)
    {
      if (localWeakReference != null)
      {
        KindaContext.access$000().remove(localWeakReference);
        ab.d("KindaContext", "sContextStack.remove：".concat(String.valueOf(paramActivity)));
      }
      PlatformUIRouterImpl.releaseContextRef(paramActivity);
      AppMethodBeat.o(145199);
      return;
      localWeakReference = null;
    }
  }
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaContext.1
 * JD-Core Version:    0.7.0.1
 */