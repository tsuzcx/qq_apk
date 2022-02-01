package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class AppBrandPerformanceManager$a
  implements Runnable
{
  protected final com.tencent.luggage.sdk.d.c chU;
  private volatile double lhA;
  private volatile int lhB;
  private volatile boolean lhC;
  protected volatile boolean lhD;
  private e lhE;
  f lhF;
  f.a lhG;
  private g.c lhH;
  protected final String mAppId;
  private volatile boolean mEnabled;
  volatile boolean zE;
  
  public AppBrandPerformanceManager$a(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147570);
    this.lhA = 0.0D;
    this.lhB = 4;
    this.mEnabled = true;
    this.zE = false;
    this.lhC = false;
    this.lhD = false;
    this.lhG = new f.a()
    {
      public final void t(double paramAnonymousDouble)
      {
        AppMethodBeat.i(147566);
        if (Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) != Math.round(paramAnonymousDouble))
        {
          AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this, paramAnonymousDouble);
          String str = Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) + " fps";
          AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.chU, 303, str);
          c.a(AppBrandPerformanceManager.a.this.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this));
        }
        AppMethodBeat.o(147566);
      }
    };
    this.lhH = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(147568);
        super.a(paramAnonymousd);
        paramAnonymousd = AppBrandPerformanceManager.a.this;
        paramAnonymousd.zE = true;
        if ((AppBrandPerformanceManager.a.bkR()) && (paramAnonymousd.lhF != null)) {
          paramAnonymousd.lhF.stop();
        }
        AppMethodBeat.o(147568);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(147567);
        super.onDestroy();
        AppBrandPerformanceManager.a.this.stop();
        AppMethodBeat.o(147567);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(147569);
        super.onResume();
        AppBrandPerformanceManager.a locala = AppBrandPerformanceManager.a.this;
        locala.zE = false;
        if ((AppBrandPerformanceManager.a.bkR()) && (locala.lhF != null)) {
          locala.lhF.start();
        }
        AppMethodBeat.o(147569);
      }
    };
    this.chU = paramc;
    this.mAppId = paramc.mAppId;
    this.lhE = new e(Process.myPid());
    this.lhD = false;
    if (bkR())
    {
      this.lhF = new f();
      this.lhF.mInterval = 100L;
      this.lhF.lhG = this.lhG;
    }
    AppMethodBeat.o(147570);
  }
  
  static boolean bkR()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  private void bkY()
  {
    AppMethodBeat.i(147574);
    Object localObject = this.chU.DY();
    if (localObject == null)
    {
      AppMethodBeat.o(147574);
      return;
    }
    if (((AppBrandSysConfigLU)localObject).jdT == 1)
    {
      localObject = new GetStorageSizeTask();
      ((GetStorageSizeTask)localObject).appId = this.mAppId;
      ((GetStorageSizeTask)localObject).jwt = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147565);
          AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.chU, 401, bt.mK(this.lhI.size));
          this.lhI.aXn();
          AppMethodBeat.o(147565);
        }
      };
      ((GetStorageSizeTask)localObject).aXm();
      AppBrandMainProcessService.a((MainProcessTask)localObject);
      AppMethodBeat.o(147574);
      return;
    }
    AppBrandPerformanceManager.a(this.chU, 401, bt.mK(((a)com.tencent.luggage.a.e.K(a.class)).cs(this.mAppId).EE(this.mAppId)));
    AppMethodBeat.o(147574);
  }
  
  protected void bkS()
  {
    AppMethodBeat.i(147573);
    int i = bt.iT(aj.getContext());
    AppBrandPerformanceManager.a(this.chU, 102, i + "m");
    c.a(this.mAppId, "Hardware", "MEMORY", i);
    AppMethodBeat.o(147573);
  }
  
  protected void bkT()
  {
    if (!this.lhD) {}
  }
  
  protected void bkU()
  {
    if (!this.lhD) {}
  }
  
  protected void bkV() {}
  
  protected void bkW() {}
  
  protected void bkX() {}
  
  public void run()
  {
    AppMethodBeat.i(147575);
    if (this.chU.isDestroyed())
    {
      AppMethodBeat.o(147575);
      return;
    }
    if ((this.mEnabled) && (!this.zE))
    {
      double d = this.lhE.blb();
      AppBrandPerformanceManager.a(this.chU, 101, (int)d + "%");
      c.a(this.mAppId, "Hardware", "CPU", d);
      bkS();
      bkT();
      bkU();
      bkV();
      bkW();
      bkX();
      this.lhB += 1;
      if (this.lhB >= 4)
      {
        this.lhB = 0;
        bkY();
      }
    }
    if (this.mEnabled) {
      l.bqm().j(this, 1000L);
    }
    AppMethodBeat.o(147575);
  }
  
  public final void start()
  {
    AppMethodBeat.i(147571);
    this.mEnabled = true;
    l.bqm().postToWorker(this);
    g.a(this.mAppId, this.lhH);
    if ((bkR()) && (this.lhF != null)) {
      this.lhF.start();
    }
    AppMethodBeat.o(147571);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(147572);
    this.mEnabled = false;
    g.b(this.mAppId, this.lhH);
    if ((bkR()) && (this.lhF != null)) {
      this.lhF.stop();
    }
    if (this.lhE != null) {
      this.lhE.close();
    }
    AppMethodBeat.o(147572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
 * JD-Core Version:    0.7.0.1
 */