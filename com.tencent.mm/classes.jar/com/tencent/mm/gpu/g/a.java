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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static a gui;
  private volatile String activity;
  public boolean guj;
  private long guk;
  public List<a> mListeners;
  
  static
  {
    AppMethodBeat.i(219568);
    gui = new a();
    AppMethodBeat.o(219568);
  }
  
  private a()
  {
    AppMethodBeat.i(219561);
    this.activity = "default";
    this.guj = false;
    this.mListeners = new ArrayList();
    this.guk = 0L;
    ((Application)aj.getContext()).registerActivityLifecycleCallbacks(this);
    AppMethodBeat.o(219561);
  }
  
  public static a agX()
  {
    return gui;
  }
  
  private boolean agY()
  {
    AppMethodBeat.i(219566);
    if (System.currentTimeMillis() - this.guk > 10000L)
    {
      AppMethodBeat.o(219566);
      return true;
    }
    AppMethodBeat.o(219566);
    return false;
  }
  
  private void agZ()
  {
    AppMethodBeat.i(219567);
    if (!agY())
    {
      ad.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(219567);
      return;
    }
    ad.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    h.LTJ.aR(this);
    AppMethodBeat.o(219567);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(219562);
    if (parama == null)
    {
      AppMethodBeat.o(219562);
      return;
    }
    synchronized (this.mListeners)
    {
      if (!this.mListeners.contains(parama))
      {
        AppMethodBeat.o(219562);
        return;
      }
      this.mListeners.remove(parama);
      AppMethodBeat.o(219562);
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
    AppMethodBeat.i(219563);
    this.activity = paramActivity.getClass().getSimpleName();
    if (agY()) {
      agZ();
    }
    AppMethodBeat.o(219563);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(219564);
    if (agY()) {
      agZ();
    }
    AppMethodBeat.o(219564);
  }
  
  public final void run()
  {
    AppMethodBeat.i(219565);
    if (PluginGpuRes.isSkipModel())
    {
      ad.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      AppMethodBeat.o(219565);
      return;
    }
    ad.d("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
    if (!agY())
    {
      ad.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(219565);
      return;
    }
    ad.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    this.guk = System.currentTimeMillis();
    long l1 = this.guk;
    ??? = new com.tencent.mm.gpu.f.a();
    long l2 = System.currentTimeMillis();
    Object localObject3 = aj.getProcessName();
    e locale = new e();
    locale.pid = Process.myPid();
    locale.processName = ((String)localObject3);
    locale.gua = PluginGpuRes.getCurrSpend();
    locale.gtZ = (l2 - l1);
    locale.gtY = ((com.tencent.mm.gpu.f.a)???).agU();
    locale.gtW = ((com.tencent.mm.gpu.f.a)???).agT();
    locale.gtX = ((com.tencent.mm.gpu.f.a)???).agV();
    locale.activityName = this.activity;
    ad.e("MicroMsg.GpuMemoryWatchDog", locale.toString());
    ad.e("MicroMsg.GpuMemoryWatchDog.oomScore", b.agW());
    ??? = c.agM();
    ((c)???).gtL.post(new c.4((c)???));
    ??? = com.tencent.mm.gpu.d.a.agK();
    ((com.tencent.mm.gpu.d.a)???).gtL.post(new a.3((com.tencent.mm.gpu.d.a)???));
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
    AppMethodBeat.o(219565);
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