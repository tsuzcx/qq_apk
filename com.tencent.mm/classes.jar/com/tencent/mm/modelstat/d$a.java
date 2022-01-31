package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class d$a
  implements Application.ActivityLifecycleCallbacks
{
  private int fSv;
  private int fSw;
  int fSx;
  int fSy;
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(78702);
    d.a(d.aky(), 1, paramActivity);
    AppMethodBeat.o(78702);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(78707);
    d.a(d.aky(), 6, paramActivity);
    AppMethodBeat.o(78707);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(78705);
    this.fSw += 1;
    ab.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[] { Integer.valueOf(this.fSw) });
    d.a(d.aky(), 4, paramActivity);
    f localf = f.akB();
    if ((paramActivity != null) && ((paramActivity instanceof MMActivity)))
    {
      String str = paramActivity.getClass().getName();
      long l = ((MMActivity)paramActivity).getActivityBrowseTimeMs();
      localf.B(str, l);
      ab.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[] { str, Long.valueOf(l), Integer.valueOf(localf.fTl.size()) });
    }
    AppMethodBeat.o(78705);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(78704);
    this.fSv += 1;
    ab.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[] { Integer.valueOf(this.fSv) });
    d.a(d.aky(), 3, paramActivity);
    AppMethodBeat.o(78704);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(78703);
    this.fSx += 1;
    ab.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[] { Integer.valueOf(this.fSx) });
    d.a(d.aky(), 2, paramActivity);
    AppMethodBeat.o(78703);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(78706);
    this.fSy += 1;
    ab.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[] { Integer.valueOf(this.fSy) });
    d.a(d.aky(), 5, paramActivity);
    AppMethodBeat.o(78706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.d.a
 * JD-Core Version:    0.7.0.1
 */