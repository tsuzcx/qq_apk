package com.tencent.mm.gpu.g;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.d.a.3;
import com.tencent.mm.gpu.d.c;
import com.tencent.mm.gpu.d.c.4;
import com.tencent.mm.gpu.e.e;
import com.tencent.mm.gpu.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static a hjD;
  private volatile String activity;
  public boolean hjE;
  private long hjF;
  public List<a> mListeners;
  
  static
  {
    AppMethodBeat.i(186222);
    hjD = new a();
    AppMethodBeat.o(186222);
  }
  
  private a()
  {
    AppMethodBeat.i(186215);
    this.activity = "default";
    this.hjE = false;
    this.mListeners = new ArrayList();
    this.hjF = 0L;
    ((Application)MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(this);
    AppMethodBeat.o(186215);
  }
  
  private void axA()
  {
    AppMethodBeat.i(186221);
    if (!axz())
    {
      Log.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(186221);
      return;
    }
    Log.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    h.RTc.aX(this);
    AppMethodBeat.o(186221);
  }
  
  public static a axy()
  {
    return hjD;
  }
  
  private boolean axz()
  {
    AppMethodBeat.i(186220);
    if (System.currentTimeMillis() - this.hjF > 10000L)
    {
      AppMethodBeat.o(186220);
      return true;
    }
    AppMethodBeat.o(186220);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(186216);
    if (parama == null)
    {
      AppMethodBeat.o(186216);
      return;
    }
    synchronized (this.mListeners)
    {
      if (!this.mListeners.contains(parama))
      {
        AppMethodBeat.o(186216);
        return;
      }
      this.mListeners.remove(parama);
      AppMethodBeat.o(186216);
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
    AppMethodBeat.i(186217);
    this.activity = paramActivity.getClass().getSimpleName();
    if (axz()) {
      axA();
    }
    AppMethodBeat.o(186217);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(186218);
    if (axz()) {
      axA();
    }
    AppMethodBeat.o(186218);
  }
  
  public final void run()
  {
    AppMethodBeat.i(186219);
    if (PluginGpuRes.isSkipModel())
    {
      Log.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      AppMethodBeat.o(186219);
      return;
    }
    Log.d("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
    if (!axz())
    {
      Log.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(186219);
      return;
    }
    Log.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    this.hjF = System.currentTimeMillis();
    long l1 = this.hjF;
    ??? = new com.tencent.mm.gpu.f.a();
    long l2 = System.currentTimeMillis();
    Object localObject3 = MMApplicationContext.getProcessName();
    e locale = new e();
    locale.pid = Process.myPid();
    locale.processName = ((String)localObject3);
    locale.hjv = PluginGpuRes.getCurrSpend();
    locale.hju = (l2 - l1);
    locale.hjt = ((com.tencent.mm.gpu.f.a)???).axv();
    locale.hjr = ((com.tencent.mm.gpu.f.a)???).axu();
    locale.hjs = ((com.tencent.mm.gpu.f.a)???).axw();
    locale.activityName = this.activity;
    Log.e("MicroMsg.GpuMemoryWatchDog", locale.toString());
    Log.e("MicroMsg.GpuMemoryWatchDog.oomScore", b.axx());
    ??? = c.axn();
    ((c)???).hjg.post(new c.4((c)???));
    ??? = com.tencent.mm.gpu.d.a.axl();
    ((com.tencent.mm.gpu.d.a)???).hjg.post(new a.3((com.tencent.mm.gpu.d.a)???));
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
    AppMethodBeat.o(186219);
  }
  
  static abstract interface a
  {
    public abstract void a(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.g.a
 * JD-Core Version:    0.7.0.1
 */