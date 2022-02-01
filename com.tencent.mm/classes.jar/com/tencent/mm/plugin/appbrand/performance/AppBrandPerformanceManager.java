package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ui.p;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager
{
  protected static final SparseArray<a> mhe;
  
  static
  {
    AppMethodBeat.i(147593);
    mhe = new SparseArray();
    AppMethodBeat.o(147593);
  }
  
  public static void TL(String paramString)
  {
    AppMethodBeat.i(147582);
    ad.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (a)mhe.get(i);
    if (paramString != null)
    {
      mhe.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(147582);
  }
  
  public static void TM(String paramString)
  {
    AppMethodBeat.i(147583);
    ad.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    AppBrandPerformanceManager.SetAppPerformanceModeTask localSetAppPerformanceModeTask = new AppBrandPerformanceManager.SetAppPerformanceModeTask((byte)0);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147583);
  }
  
  public static void TN(String paramString)
  {
    AppMethodBeat.i(147584);
    ad.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    AppBrandPerformanceManager.SetAppPerformanceModeTask localSetAppPerformanceModeTask = new AppBrandPerformanceManager.SetAppPerformanceModeTask((byte)0);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147584);
  }
  
  public static void a(com.tencent.luggage.sdk.d.c paramc, int paramInt, long paramLong)
  {
    AppMethodBeat.i(147586);
    a(paramc, paramInt, String.format("%d ms", new Object[] { Long.valueOf(paramLong) }));
    AppMethodBeat.o(147586);
  }
  
  public static void a(com.tencent.luggage.sdk.d.c paramc, int paramInt, String paramString)
  {
    AppMethodBeat.i(147587);
    String str = paramc.mAppId;
    paramc = paramc.cpp;
    if (paramc == null)
    {
      y.aBq().F(str.hashCode() + "performance_data", true).k(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(147587);
      return;
    }
    paramc.au(paramInt, paramString);
    AppMethodBeat.o(147587);
  }
  
  public static void a(com.tencent.luggage.sdk.d.c paramc, long paramLong)
  {
    AppMethodBeat.i(147591);
    a(paramc, 201, paramLong);
    AppMethodBeat.o(147591);
  }
  
  public static void a(com.tencent.luggage.sdk.d.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147588);
    String str = paramc.mAppId;
    paramc = paramc.cpp;
    if (paramc == null)
    {
      y.aBq().F(str.hashCode() + "performance_custom_data", true).k(paramString1, paramString2);
      AppMethodBeat.o(147588);
      return;
    }
    paramc.eq(paramString1, paramString2);
    AppMethodBeat.o(147588);
  }
  
  public static void d(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147581);
    String str = paramc.mAppId;
    ad.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    a locala2 = (a)mhe.get(str.hashCode());
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramc);
      mhe.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(147581);
  }
  
  public static boolean e(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147585);
    paramc = (a)paramc.ar(a.class);
    if ((paramc != null) && (paramc.mhb))
    {
      AppMethodBeat.o(147585);
      return true;
    }
    AppMethodBeat.o(147585);
    return false;
  }
  
  public static void f(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147589);
    Object localObject = paramc.mAppId;
    p localp = paramc.cpp;
    localObject = y.aBq().AG(((String)localObject).hashCode() + "performance_data");
    if (localp == null) {
      ad.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      g(paramc);
      AppMethodBeat.o(147589);
      return;
      if (localObject == null)
      {
        ad.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
      }
      else
      {
        Iterator localIterator = ((y.b)localObject).getKeySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)((y.b)localObject).get(str1);
          if (str2 != null) {
            localp.au(bt.getInt(str1, 0), str2);
          }
        }
      }
    }
  }
  
  private static void g(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147590);
    Object localObject = paramc.mAppId;
    paramc = paramc.cpp;
    localObject = y.aBq().AG(((String)localObject).hashCode() + "performance_custom_data");
    if (paramc == null)
    {
      ad.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
      AppMethodBeat.o(147590);
      return;
    }
    if (localObject == null)
    {
      ad.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
      AppMethodBeat.o(147590);
      return;
    }
    Iterator localIterator = ((y.b)localObject).getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((y.b)localObject).get(str1);
      if (str2 != null) {
        paramc.eq(str1, str2);
      }
    }
    AppMethodBeat.o(147590);
  }
  
  public static boolean h(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147592);
    if (!e(paramc))
    {
      AppMethodBeat.o(147592);
      return false;
    }
    boolean bool = c.TO(paramc.mAppId);
    AppMethodBeat.o(147592);
    return bool;
  }
  
  protected static class a
    implements Runnable
  {
    volatile boolean Ct;
    protected final com.tencent.luggage.sdk.d.c cpg;
    protected final String mAppId;
    private volatile boolean mEnabled;
    private volatile double mhf;
    private volatile int mhg;
    private volatile boolean mhh;
    protected volatile boolean mhi;
    private e mhj;
    f mhk;
    f.a mhl;
    private g.c mhm;
    
    public a(com.tencent.luggage.sdk.d.c paramc)
    {
      AppMethodBeat.i(147570);
      this.mhf = 0.0D;
      this.mhg = 4;
      this.mEnabled = true;
      this.Ct = false;
      this.mhh = false;
      this.mhi = false;
      this.mhl = new f.a()
      {
        public final void s(double paramAnonymousDouble)
        {
          AppMethodBeat.i(147566);
          if (Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) != Math.round(paramAnonymousDouble))
          {
            AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this, paramAnonymousDouble);
            String str = Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) + " fps";
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cpg, 303, str);
            c.a(AppBrandPerformanceManager.a.this.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this));
          }
          AppMethodBeat.o(147566);
        }
      };
      this.mhm = new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(147568);
          super.a(paramAnonymousd);
          paramAnonymousd = AppBrandPerformanceManager.a.this;
          paramAnonymousd.Ct = true;
          if ((AppBrandPerformanceManager.a.bvK()) && (paramAnonymousd.mhk != null)) {
            paramAnonymousd.mhk.stop();
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
          locala.Ct = false;
          if ((AppBrandPerformanceManager.a.bvK()) && (locala.mhk != null)) {
            locala.mhk.start();
          }
          AppMethodBeat.o(147569);
        }
      };
      this.cpg = paramc;
      this.mAppId = paramc.mAppId;
      this.mhj = new e(Process.myPid());
      this.mhi = false;
      if (bvK())
      {
        this.mhk = new f();
        this.mhk.mInterval = 100L;
        this.mhk.mhl = this.mhl;
      }
      AppMethodBeat.o(147570);
    }
    
    static boolean bvK()
    {
      return Build.VERSION.SDK_INT >= 16;
    }
    
    private void bvR()
    {
      AppMethodBeat.i(147574);
      Object localObject = this.cpg.Fa();
      if (localObject == null)
      {
        AppMethodBeat.o(147574);
        return;
      }
      if (((AppBrandSysConfigLU)localObject).jYi == 1)
      {
        localObject = new GetStorageSizeTask();
        ((GetStorageSizeTask)localObject).appId = this.mAppId;
        ((GetStorageSizeTask)localObject).krg = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147565);
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cpg, 401, bt.sy(this.mhn.size));
            this.mhn.bhO();
            AppMethodBeat.o(147565);
          }
        };
        ((GetStorageSizeTask)localObject).bhN();
        AppBrandMainProcessService.a((MainProcessTask)localObject);
        AppMethodBeat.o(147574);
        return;
      }
      AppBrandPerformanceManager.a(this.cpg, 401, bt.sy(((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dg(this.mAppId).LY(this.mAppId)));
      AppMethodBeat.o(147574);
    }
    
    protected void bvL()
    {
      AppMethodBeat.i(147573);
      int i = bt.jo(aj.getContext());
      AppBrandPerformanceManager.a(this.cpg, 102, i + "m");
      c.a(this.mAppId, "Hardware", "MEMORY", i);
      AppMethodBeat.o(147573);
    }
    
    protected void bvM()
    {
      if (!this.mhi) {}
    }
    
    protected void bvN()
    {
      if (!this.mhi) {}
    }
    
    protected void bvO() {}
    
    protected void bvP() {}
    
    protected void bvQ() {}
    
    public void run()
    {
      AppMethodBeat.i(147575);
      if (this.cpg.isDestroyed())
      {
        AppMethodBeat.o(147575);
        return;
      }
      if ((this.mEnabled) && (!this.Ct))
      {
        double d = this.mhj.bvU();
        AppBrandPerformanceManager.a(this.cpg, 101, (int)d + "%");
        c.a(this.mAppId, "Hardware", "CPU", d);
        bvL();
        bvM();
        bvN();
        bvO();
        bvP();
        bvQ();
        this.mhg += 1;
        if (this.mhg >= 4)
        {
          this.mhg = 0;
          bvR();
        }
      }
      if (this.mEnabled) {
        m.bBp().k(this, 1000L);
      }
      AppMethodBeat.o(147575);
    }
    
    public final void start()
    {
      AppMethodBeat.i(147571);
      this.mEnabled = true;
      m.bBp().postToWorker(this);
      g.a(this.mAppId, this.mhm);
      if ((bvK()) && (this.mhk != null)) {
        this.mhk.start();
      }
      AppMethodBeat.o(147571);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(147572);
      this.mEnabled = false;
      g.b(this.mAppId, this.mhm);
      if ((bvK()) && (this.mhk != null)) {
        this.mhk.stop();
      }
      if (this.mhj != null) {
        this.mhj.close();
      }
      AppMethodBeat.o(147572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */