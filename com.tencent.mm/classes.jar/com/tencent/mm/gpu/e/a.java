package com.tencent.mm.gpu.e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static a gar;
  private volatile String activity;
  public boolean gas;
  private long gat;
  
  static
  {
    AppMethodBeat.i(209429);
    gar = new a();
    AppMethodBeat.o(209429);
  }
  
  private a()
  {
    AppMethodBeat.i(209423);
    this.activity = "default";
    this.gas = false;
    this.gat = 0L;
    ((Application)ai.getContext()).registerActivityLifecycleCallbacks(this);
    AppMethodBeat.o(209423);
  }
  
  public static a aei()
  {
    return gar;
  }
  
  private boolean aej()
  {
    AppMethodBeat.i(209427);
    if (System.currentTimeMillis() - this.gat > 10000L)
    {
      AppMethodBeat.o(209427);
      return true;
    }
    AppMethodBeat.o(209427);
    return false;
  }
  
  private void aek()
  {
    AppMethodBeat.i(209428);
    if (!aej())
    {
      ac.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(209428);
      return;
    }
    ac.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    h.JZN.aS(this);
    AppMethodBeat.o(209428);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(209424);
    this.activity = paramActivity.getClass().getSimpleName();
    if (aej()) {
      aek();
    }
    AppMethodBeat.o(209424);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(209425);
    if (aej()) {
      aek();
    }
    AppMethodBeat.o(209425);
  }
  
  public final void run()
  {
    AppMethodBeat.i(209426);
    if (PluginGpuRes.isSkipModel())
    {
      ac.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      AppMethodBeat.o(209426);
      return;
    }
    ac.d("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
    if (!aej())
    {
      ac.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(209426);
      return;
    }
    ac.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    this.gat = System.currentTimeMillis();
    long l1 = this.gat;
    com.tencent.mm.gpu.f.a locala = new com.tencent.mm.gpu.f.a();
    long l2 = System.currentTimeMillis();
    String str = ai.getProcessName();
    f localf = new f();
    localf.pid = Process.myPid();
    localf.processName = str;
    localf.gaB = PluginGpuRes.getCurrSpend();
    localf.gaA = (l2 - l1);
    localf.gaz = locala.aen();
    localf.gax = locala.aem();
    localf.gay = locala.aeo();
    localf.activityName = this.activity;
    ac.i("MicroMsg.GpuMemoryWatchDog", localf.toString());
    ac.i("MicroMsg.GpuMemoryWatchDog.oomScore", b.aep());
    AppMethodBeat.o(209426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.e.a
 * JD-Core Version:    0.7.0.1
 */