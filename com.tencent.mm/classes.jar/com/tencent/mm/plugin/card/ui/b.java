package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private int ksM = 0;
  
  public static Application aMc()
  {
    AppMethodBeat.i(88238);
    Application localApplication = (Application)ah.getContext().getApplicationContext();
    AppMethodBeat.o(88238);
    return localApplication;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(88239);
    if (this.ksM < 0)
    {
      if ((paramActivity == null) || (!(paramActivity instanceof CardDetailUI))) {
        break label90;
      }
      paramActivity = (CardDetailUI)paramActivity;
      if (paramActivity.ktb != null)
      {
        com.tencent.mm.plugin.card.ui.view.g localg = paramActivity.ktb.ktz;
        if ((localg != null) && ((localg instanceof m)))
        {
          ab.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
          paramActivity.ktb.ktz.d(c.kCc);
        }
      }
    }
    for (;;)
    {
      this.ksM += 1;
      AppMethodBeat.o(88239);
      return;
      label90:
      com.tencent.mm.kernel.g.RO().ac(new b.1(this));
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    this.ksM -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.b
 * JD-Core Version:    0.7.0.1
 */