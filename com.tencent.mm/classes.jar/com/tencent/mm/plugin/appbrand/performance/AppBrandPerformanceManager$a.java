package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppBrandPerformanceManager$a
  implements Runnable
{
  volatile boolean cgD;
  protected final d etN;
  protected final String mAppId;
  private volatile boolean mEnabled;
  private volatile double tDA;
  private volatile int tDB;
  private volatile boolean tDC;
  protected volatile boolean tDD;
  private e tDE;
  f tDF;
  private k.c tDG;
  
  public AppBrandPerformanceManager$a(d paramd)
  {
    AppMethodBeat.i(147570);
    this.tDA = 0.0D;
    this.tDB = 4;
    this.mEnabled = true;
    this.cgD = false;
    this.tDC = false;
    this.tDD = false;
    this.tDG = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(147568);
        super.a(paramAnonymousd);
        paramAnonymousd = AppBrandPerformanceManager.a.this;
        paramAnonymousd.cgD = true;
        if ((AppBrandPerformanceManager.a.cGz()) && (paramAnonymousd.tDF != null)) {
          paramAnonymousd.tDF.stop();
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
        locala.cgD = false;
        if ((AppBrandPerformanceManager.a.cGz()) && (locala.tDF != null)) {
          locala.tDF.start();
        }
        AppMethodBeat.o(147569);
      }
    };
    this.etN = paramd;
    this.mAppId = paramd.mAppId;
    this.tDE = new e(Process.myPid());
    this.tDD = false;
    AppMethodBeat.o(147570);
  }
  
  static boolean cGz()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  protected void cGA()
  {
    AppMethodBeat.i(147573);
    int i = Util.getSelfMemInMB(MMApplicationContext.getContext());
    AppBrandPerformanceManager.a(this.etN, 102, i + "m");
    c.a(this.mAppId, "Hardware", "MEMORY", i);
    AppMethodBeat.o(147573);
  }
  
  protected void cGB()
  {
    if (!this.tDD) {}
  }
  
  protected void cGC()
  {
    if (!this.tDD) {}
  }
  
  protected void cGD() {}
  
  protected void cGE() {}
  
  protected void cGF() {}
  
  public void run()
  {
    AppMethodBeat.i(147574);
    if (this.etN.qsE.get())
    {
      AppMethodBeat.o(147574);
      return;
    }
    Object localObject;
    if ((this.mEnabled) && (!this.cgD))
    {
      double d = this.tDE.cGJ();
      AppBrandPerformanceManager.a(this.etN, 101, (int)d + "%");
      c.a(this.mAppId, "Hardware", "CPU", d);
      cGA();
      cGB();
      cGC();
      cGD();
      cGE();
      cGF();
      this.tDB += 1;
      if (this.tDB >= 4)
      {
        this.tDB = 0;
        localObject = this.etN.asz();
        if (localObject != null)
        {
          if (((AppBrandSysConfigLU)localObject).qYZ != 1) {
            break label211;
          }
          localObject = new GetStorageSizeTask();
          ((GetStorageSizeTask)localObject).appId = this.mAppId;
          ((GetStorageSizeTask)localObject).rxj = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(317246);
              AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.etN, 401, Util.getSizeKB(this.tDI.size));
              this.tDI.cpx();
              AppMethodBeat.o(317246);
            }
          };
          ((GetStorageSizeTask)localObject).bQt();
        }
      }
    }
    for (;;)
    {
      if (this.mEnabled) {
        o.cNm().j(this, 1000L);
      }
      AppMethodBeat.o(147574);
      return;
      label211:
      AppBrandPerformanceManager.a(this.etN, 401, Util.getSizeKB(((a)com.tencent.luggage.a.e.T(a.class)).f(this.mAppId, ((AppBrandSysConfigLU)localObject).qYZ, ((AppBrandSysConfigLU)localObject).qLQ).VT(this.mAppId)));
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(147571);
    if ((!this.tDD) && (cGz()))
    {
      f.a local1 = new f.a()
      {
        public final void K(double paramAnonymousDouble)
        {
          AppMethodBeat.i(317245);
          if (Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) != Math.round(paramAnonymousDouble))
          {
            AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this, paramAnonymousDouble);
            String str = Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) + " fps";
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.etN, 303, str);
            c.a(AppBrandPerformanceManager.a.this.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this));
          }
          AppMethodBeat.o(317245);
        }
      };
      this.tDF = new f();
      this.tDF.mInterval = 100L;
      this.tDF.tDX = local1;
    }
    this.mEnabled = true;
    o.cNm().postToWorker(this);
    k.a(this.mAppId, this.tDG);
    if ((cGz()) && (this.tDF != null)) {
      this.tDF.start();
    }
    AppMethodBeat.o(147571);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(147572);
    this.mEnabled = false;
    k.b(this.mAppId, this.tDG);
    if ((cGz()) && (this.tDF != null)) {
      this.tDF.stop();
    }
    if (this.tDE != null) {
      this.tDE.close();
    }
    AppMethodBeat.o(147572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
 * JD-Core Version:    0.7.0.1
 */