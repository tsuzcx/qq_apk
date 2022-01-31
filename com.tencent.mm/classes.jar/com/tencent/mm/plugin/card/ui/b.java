package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private int irF = 0;
  
  public static Application aoU()
  {
    return (Application)ae.getContext().getApplicationContext();
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    if (this.irF < 0)
    {
      if ((paramActivity == null) || (!(paramActivity instanceof CardDetailUI))) {
        break label80;
      }
      paramActivity = (CardDetailUI)paramActivity;
      if (paramActivity.irU != null)
      {
        com.tencent.mm.plugin.card.ui.view.g localg = paramActivity.irU.iss;
        if ((localg != null) && ((localg instanceof m)))
        {
          y.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
          paramActivity.irU.iss.d(c.iyV);
        }
      }
    }
    for (;;)
    {
      this.irF += 1;
      return;
      label80:
      com.tencent.mm.kernel.g.DS().O(new b.1(this));
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    this.irF -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.b
 * JD-Core Version:    0.7.0.1
 */