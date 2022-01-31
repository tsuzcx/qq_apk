package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class d$a
  implements Application.ActivityLifecycleCallbacks
{
  private int eCE;
  private int eCF;
  int eCG;
  int eCH;
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    d.a(d.Rp(), 1, paramActivity);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    d.a(d.Rp(), 6, paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    this.eCF += 1;
    y.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[] { Integer.valueOf(this.eCF) });
    d.a(d.Rp(), 4, paramActivity);
    f localf = f.Rs();
    if ((paramActivity != null) && ((paramActivity instanceof MMActivity)))
    {
      String str = paramActivity.getClass().getName();
      long l = ((MMActivity)paramActivity).czu();
      localf.s(str, l);
      y.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[] { str, Long.valueOf(l), Integer.valueOf(localf.eDu.size()) });
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    this.eCE += 1;
    y.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[] { Integer.valueOf(this.eCE) });
    d.a(d.Rp(), 3, paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    this.eCG += 1;
    y.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[] { Integer.valueOf(this.eCG) });
    d.a(d.Rp(), 2, paramActivity);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    this.eCH += 1;
    y.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[] { Integer.valueOf(this.eCH) });
    d.a(d.Rp(), 5, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelstat.d.a
 * JD-Core Version:    0.7.0.1
 */