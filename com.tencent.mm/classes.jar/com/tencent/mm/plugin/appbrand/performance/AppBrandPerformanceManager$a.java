package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class AppBrandPerformanceManager$a
  implements Runnable
{
  protected final com.tencent.luggage.sdk.d.b bEZ;
  private volatile double iAI;
  private volatile int iAJ;
  private volatile boolean iAK;
  protected volatile boolean iAL;
  private e iAM;
  f iAN;
  f.a iAO;
  private e.c ifl;
  protected final String mAppId;
  private volatile boolean mEnabled;
  volatile boolean mPaused;
  
  public AppBrandPerformanceManager$a(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(102219);
    this.iAI = 0.0D;
    this.iAJ = 4;
    this.mEnabled = true;
    this.mPaused = false;
    this.iAK = false;
    this.iAL = false;
    this.iAO = new AppBrandPerformanceManager.a.2(this);
    this.ifl = new AppBrandPerformanceManager.a.3(this);
    this.bEZ = paramb;
    this.mAppId = paramb.mAppId;
    this.iAM = new e(Process.myPid());
    this.iAL = false;
    if (aKh())
    {
      this.iAN = new f();
      this.iAN.mInterval = 100L;
      this.iAN.iAO = this.iAO;
    }
    AppMethodBeat.o(102219);
  }
  
  static boolean aKh()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  private void aKo()
  {
    AppMethodBeat.i(140977);
    Object localObject = this.bEZ.wR();
    if (localObject == null)
    {
      AppMethodBeat.o(140977);
      return;
    }
    if (((AppBrandSysConfigLU)localObject).hiY == 1)
    {
      localObject = new GetStorageSizeTask();
      ((GetStorageSizeTask)localObject).appId = this.mAppId;
      ((GetStorageSizeTask)localObject).hxp = new AppBrandPerformanceManager.a.1(this, (GetStorageSizeTask)localObject);
      ((GetStorageSizeTask)localObject).aBj();
      AppBrandMainProcessService.a((MainProcessTask)localObject);
      AppMethodBeat.o(140977);
      return;
    }
    AppBrandPerformanceManager.a(this.bEZ, 401, bo.hk(((com.tencent.luggage.sdk.customize.b)com.tencent.luggage.a.e.q(com.tencent.luggage.sdk.customize.b.class)).cc(this.mAppId).yT(this.mAppId)));
    AppMethodBeat.o(140977);
  }
  
  protected void aKi()
  {
    AppMethodBeat.i(102222);
    int i = bo.hp(ah.getContext());
    AppBrandPerformanceManager.a(this.bEZ, 102, i + "m");
    c.a(this.mAppId, "Hardware", "MEMORY", i);
    AppMethodBeat.o(102222);
  }
  
  protected void aKj()
  {
    if (!this.iAL) {}
  }
  
  protected void aKk()
  {
    if (!this.iAL) {}
  }
  
  protected void aKl() {}
  
  protected void aKm() {}
  
  protected void aKn() {}
  
  public void run()
  {
    AppMethodBeat.i(102223);
    if (this.bEZ.mFinished)
    {
      AppMethodBeat.o(102223);
      return;
    }
    if ((this.mEnabled) && (!this.mPaused))
    {
      double d = this.iAM.aKr();
      AppBrandPerformanceManager.a(this.bEZ, 101, (int)d + "%");
      c.a(this.mAppId, "Hardware", "CPU", d);
      aKi();
      aKj();
      aKk();
      aKl();
      aKm();
      aKn();
      this.iAJ += 1;
      if (this.iAJ >= 4)
      {
        this.iAJ = 0;
        aKo();
      }
    }
    if (this.mEnabled) {
      m.aNS().o(this, 3000L);
    }
    AppMethodBeat.o(102223);
  }
  
  public final void start()
  {
    AppMethodBeat.i(102220);
    this.mEnabled = true;
    m.aNS().ac(this);
    com.tencent.mm.plugin.appbrand.e.a(this.mAppId, this.ifl);
    if ((aKh()) && (this.iAN != null)) {
      this.iAN.start();
    }
    AppMethodBeat.o(102220);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(102221);
    this.mEnabled = false;
    com.tencent.mm.plugin.appbrand.e.b(this.mAppId, this.ifl);
    if ((aKh()) && (this.iAN != null)) {
      this.iAN.stop();
    }
    if (this.iAM != null) {
      this.iAM.close();
    }
    AppMethodBeat.o(102221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
 * JD-Core Version:    0.7.0.1
 */