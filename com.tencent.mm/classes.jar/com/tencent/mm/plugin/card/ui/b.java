package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private int pYP = 0;
  
  public static Application bWY()
  {
    AppMethodBeat.i(113172);
    Application localApplication = (Application)MMApplicationContext.getContext().getApplicationContext();
    AppMethodBeat.o(113172);
    return localApplication;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(113173);
    if (this.pYP < 0)
    {
      if ((paramActivity == null) || (!(paramActivity instanceof CardDetailUI))) {
        break label90;
      }
      paramActivity = (CardDetailUI)paramActivity;
      if (paramActivity.pZb != null)
      {
        com.tencent.mm.plugin.card.ui.view.g localg = paramActivity.pZb.pZz;
        if ((localg != null) && ((localg instanceof m)))
        {
          Log.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
          paramActivity.pZb.pZz.d(c.qkS);
        }
      }
    }
    for (;;)
    {
      this.pYP += 1;
      AppMethodBeat.o(113173);
      return;
      label90:
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113171);
          Log.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
          com.tencent.mm.plugin.card.b.g localg = am.cug();
          if (localg != null) {
            localg.a(r.qlh);
          }
          AppMethodBeat.o(113171);
        }
      });
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    this.pYP -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.b
 * JD-Core Version:    0.7.0.1
 */