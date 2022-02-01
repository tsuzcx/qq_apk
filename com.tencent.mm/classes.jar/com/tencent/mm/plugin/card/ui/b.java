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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private int nyf = 0;
  
  public static Application bod()
  {
    AppMethodBeat.i(113172);
    Application localApplication = (Application)aj.getContext().getApplicationContext();
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
    if (this.nyf < 0)
    {
      if ((paramActivity == null) || (!(paramActivity instanceof CardDetailUI))) {
        break label90;
      }
      paramActivity = (CardDetailUI)paramActivity;
      if (paramActivity.nyr != null)
      {
        com.tencent.mm.plugin.card.ui.view.g localg = paramActivity.nyr.nyP;
        if ((localg != null) && ((localg instanceof m)))
        {
          ad.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
          paramActivity.nyr.nyP.d(c.nJb);
        }
      }
    }
    for (;;)
    {
      this.nyf += 1;
      AppMethodBeat.o(113173);
      return;
      label90:
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113171);
          ad.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
          com.tencent.mm.plugin.card.b.g localg = am.bJl();
          if (localg != null) {
            localg.a(r.nJq);
          }
          AppMethodBeat.o(113171);
        }
      });
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    this.nyf -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.b
 * JD-Core Version:    0.7.0.1
 */