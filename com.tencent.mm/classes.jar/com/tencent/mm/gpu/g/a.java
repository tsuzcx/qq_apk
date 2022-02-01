package com.tencent.mm.gpu.g;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.d.a.3;
import com.tencent.mm.gpu.d.c;
import com.tencent.mm.gpu.d.c.4;
import com.tencent.mm.gpu.e.e;
import com.tencent.mm.gpu.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static a gwP;
  private volatile String activity;
  public boolean gwQ;
  private long gwR;
  public List<a> mListeners;
  
  static
  {
    AppMethodBeat.i(209690);
    gwP = new a();
    AppMethodBeat.o(209690);
  }
  
  private a()
  {
    AppMethodBeat.i(209683);
    this.activity = "default";
    this.gwQ = false;
    this.mListeners = new ArrayList();
    this.gwR = 0L;
    ((Application)ak.getContext()).registerActivityLifecycleCallbacks(this);
    AppMethodBeat.o(209683);
  }
  
  public static a ahm()
  {
    return gwP;
  }
  
  private boolean ahn()
  {
    AppMethodBeat.i(209688);
    if (System.currentTimeMillis() - this.gwR > 10000L)
    {
      AppMethodBeat.o(209688);
      return true;
    }
    AppMethodBeat.o(209688);
    return false;
  }
  
  private void aho()
  {
    AppMethodBeat.i(209689);
    if (!ahn())
    {
      ae.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(209689);
      return;
    }
    ae.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    h.MqF.aO(this);
    AppMethodBeat.o(209689);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(209684);
    if (parama == null)
    {
      AppMethodBeat.o(209684);
      return;
    }
    synchronized (this.mListeners)
    {
      if (!this.mListeners.contains(parama))
      {
        AppMethodBeat.o(209684);
        return;
      }
      this.mListeners.remove(parama);
      AppMethodBeat.o(209684);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(209685);
    this.activity = paramActivity.getClass().getSimpleName();
    if (ahn()) {
      aho();
    }
    AppMethodBeat.o(209685);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(209686);
    if (ahn()) {
      aho();
    }
    AppMethodBeat.o(209686);
  }
  
  public final void run()
  {
    AppMethodBeat.i(209687);
    if (PluginGpuRes.isSkipModel())
    {
      ae.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      AppMethodBeat.o(209687);
      return;
    }
    ae.d("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
    if (!ahn())
    {
      ae.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(209687);
      return;
    }
    ae.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    this.gwR = System.currentTimeMillis();
    long l1 = this.gwR;
    ??? = new com.tencent.mm.gpu.f.a();
    long l2 = System.currentTimeMillis();
    Object localObject3 = ak.getProcessName();
    e locale = new e();
    locale.pid = Process.myPid();
    locale.processName = ((String)localObject3);
    locale.gwH = PluginGpuRes.getCurrSpend();
    locale.gwG = (l2 - l1);
    locale.gwF = ((com.tencent.mm.gpu.f.a)???).ahj();
    locale.gwD = ((com.tencent.mm.gpu.f.a)???).ahi();
    locale.gwE = ((com.tencent.mm.gpu.f.a)???).ahk();
    locale.activityName = this.activity;
    ae.e("MicroMsg.GpuMemoryWatchDog", locale.toString());
    ae.e("MicroMsg.GpuMemoryWatchDog.oomScore", b.ahl());
    ??? = c.ahb();
    ((c)???).gws.post(new c.4((c)???));
    ??? = com.tencent.mm.gpu.d.a.agZ();
    ((com.tencent.mm.gpu.d.a)???).gws.post(new a.3((com.tencent.mm.gpu.d.a)???));
    synchronized (this.mListeners)
    {
      if (this.mListeners.size() > 0)
      {
        localObject3 = this.mListeners.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          a locala = (a)((Iterator)localObject3).next();
          if (locala != null) {
            locala.a(locale);
          }
        }
      }
    }
    AppMethodBeat.o(209687);
  }
  
  static abstract interface a
  {
    public abstract void a(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.g.a
 * JD-Core Version:    0.7.0.1
 */