package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.c.c;
import com.tencent.mm.plugin.card.c.r;
import com.tencent.mm.plugin.card.mgr.f;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.g;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private int wzi = 0;
  
  public static Application cKQ()
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
    if (this.wzi < 0)
    {
      if ((paramActivity == null) || (!(paramActivity instanceof CardDetailUI))) {
        break label90;
      }
      paramActivity = (CardDetailUI)paramActivity;
      if (paramActivity.wzu != null)
      {
        g localg = paramActivity.wzu.wzT;
        if ((localg != null) && ((localg instanceof m)))
        {
          Log.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
          paramActivity.wzu.wzT.d(c.wKn);
        }
      }
    }
    for (;;)
    {
      this.wzi += 1;
      AppMethodBeat.o(113173);
      return;
      label90:
      h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113171);
          Log.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
          f localf = am.dkZ();
          if (localf != null) {
            localf.a(r.wKE);
          }
          AppMethodBeat.o(113171);
        }
      });
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    this.wzi -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.b
 * JD-Core Version:    0.7.0.1
 */