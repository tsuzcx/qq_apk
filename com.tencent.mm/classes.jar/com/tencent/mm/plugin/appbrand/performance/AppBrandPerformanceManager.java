package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager
{
  protected static final SparseArray<a> qyE;
  
  static
  {
    AppMethodBeat.i(147593);
    qyE = new SparseArray();
    AppMethodBeat.o(147593);
  }
  
  public static void a(d paramd, int paramInt, long paramLong)
  {
    AppMethodBeat.i(147586);
    a(paramd, paramInt, String.format("%d ms", new Object[] { Long.valueOf(paramLong) }));
    AppMethodBeat.o(147586);
  }
  
  public static void a(d paramd, int paramInt, String paramString)
  {
    AppMethodBeat.i(147587);
    String str = paramd.mAppId;
    paramd = paramd.cCO;
    if (paramd == null)
    {
      ad.beh().I(str.hashCode() + "performance_data", true).k(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(147587);
      return;
    }
    paramd.ay(paramInt, paramString);
    AppMethodBeat.o(147587);
  }
  
  public static void a(d paramd, long paramLong)
  {
    AppMethodBeat.i(147591);
    a(paramd, 201, paramLong);
    AppMethodBeat.o(147591);
  }
  
  public static void a(d paramd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147588);
    String str = paramd.mAppId;
    paramd = paramd.cCO;
    if (paramd == null)
    {
      ad.beh().I(str.hashCode() + "performance_custom_data", true).k(paramString1, paramString2);
      AppMethodBeat.o(147588);
      return;
    }
    paramd.eZ(paramString1, paramString2);
    AppMethodBeat.o(147588);
  }
  
  public static void amc(String paramString)
  {
    AppMethodBeat.i(147582);
    Log.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (a)qyE.get(i);
    if (paramString != null)
    {
      qyE.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(147582);
  }
  
  public static void amd(String paramString)
  {
    AppMethodBeat.i(147583);
    Log.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    localSetAppPerformanceModeTask.bsM();
    AppMethodBeat.o(147583);
  }
  
  public static void ame(String paramString)
  {
    AppMethodBeat.i(147584);
    Log.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
    localSetAppPerformanceModeTask.bsM();
    AppMethodBeat.o(147584);
  }
  
  public static void j(d paramd)
  {
    AppMethodBeat.i(147581);
    String str = paramd.mAppId;
    Log.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    a locala2 = (a)qyE.get(str.hashCode());
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramd);
      qyE.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(147581);
  }
  
  public static boolean k(d paramd)
  {
    AppMethodBeat.i(147585);
    paramd = (a)paramd.au(a.class);
    if ((paramd != null) && (paramd.qyB))
    {
      AppMethodBeat.o(147585);
      return true;
    }
    AppMethodBeat.o(147585);
    return false;
  }
  
  public static void l(d paramd)
  {
    AppMethodBeat.i(147589);
    Object localObject = paramd.mAppId;
    u localu = paramd.cCO;
    localObject = ad.beh().Ro(((String)localObject).hashCode() + "performance_data");
    if (localu == null) {
      Log.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      m(paramd);
      AppMethodBeat.o(147589);
      return;
      if (localObject == null)
      {
        Log.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
      }
      else
      {
        Iterator localIterator = ((ad.b)localObject).getKeySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)((ad.b)localObject).get(str1);
          if (str2 != null) {
            localu.ay(Util.getInt(str1, 0), str2);
          }
        }
      }
    }
  }
  
  private static void m(d paramd)
  {
    AppMethodBeat.i(147590);
    Object localObject = paramd.mAppId;
    paramd = paramd.cCO;
    localObject = ad.beh().Ro(((String)localObject).hashCode() + "performance_custom_data");
    if (paramd == null)
    {
      Log.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
      AppMethodBeat.o(147590);
      return;
    }
    if (localObject == null)
    {
      Log.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
      AppMethodBeat.o(147590);
      return;
    }
    Iterator localIterator = ((ad.b)localObject).getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((ad.b)localObject).get(str1);
      if (str2 != null) {
        paramd.eZ(str1, str2);
      }
    }
    AppMethodBeat.o(147590);
  }
  
  public static boolean n(d paramd)
  {
    AppMethodBeat.i(147592);
    if (!k(paramd))
    {
      AppMethodBeat.o(147592);
      return false;
    }
    boolean bool = c.amf(paramd.mAppId);
    AppMethodBeat.o(147592);
    return bool;
  }
  
  static class SetAppPerformanceModeTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SetAppPerformanceModeTask> CREATOR;
    private String mAppId;
    private boolean mEnable;
    
    static
    {
      AppMethodBeat.i(147580);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(147580);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(147577);
      com.tencent.mm.plugin.appbrand.config.e locale = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).QG();
      String str2 = this.mAppId + "_PerformancePanelEnabled";
      if (this.mEnable) {}
      for (String str1 = "1";; str1 = "0")
      {
        locale.cW(str2, str1);
        AppMethodBeat.o(147577);
        return;
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(147578);
      this.mAppId = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.mEnable = bool;
        AppMethodBeat.o(147578);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(147579);
      paramParcel.writeString(this.mAppId);
      if (this.mEnable) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(147579);
        return;
      }
    }
  }
  
  protected static class a
    implements Runnable
  {
    volatile boolean arU;
    protected final d cBh;
    protected final String mAppId;
    private volatile boolean mEnabled;
    private volatile double qyF;
    private volatile int qyG;
    private volatile boolean qyH;
    protected volatile boolean qyI;
    private e qyJ;
    f qyK;
    private k.c qyL;
    
    public a(d paramd)
    {
      AppMethodBeat.i(147570);
      this.qyF = 0.0D;
      this.qyG = 4;
      this.mEnabled = true;
      this.arU = false;
      this.qyH = false;
      this.qyI = false;
      this.qyL = new k.c()
      {
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(147568);
          super.a(paramAnonymousd);
          paramAnonymousd = AppBrandPerformanceManager.a.this;
          paramAnonymousd.arU = true;
          if ((AppBrandPerformanceManager.a.cfM()) && (paramAnonymousd.qyK != null)) {
            paramAnonymousd.qyK.stop();
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
          locala.arU = false;
          if ((AppBrandPerformanceManager.a.cfM()) && (locala.qyK != null)) {
            locala.qyK.start();
          }
          AppMethodBeat.o(147569);
        }
      };
      this.cBh = paramd;
      this.mAppId = paramd.mAppId;
      this.qyJ = new e(Process.myPid());
      this.qyI = false;
      AppMethodBeat.o(147570);
    }
    
    static boolean cfM()
    {
      return Build.VERSION.SDK_INT >= 16;
    }
    
    private void cfT()
    {
      AppMethodBeat.i(147574);
      Object localObject = this.cBh.Sj();
      if (localObject == null)
      {
        AppMethodBeat.o(147574);
        return;
      }
      if (((AppBrandSysConfigLU)localObject).nYS == 1)
      {
        localObject = new GetStorageSizeTask();
        ((GetStorageSizeTask)localObject).appId = this.mAppId;
        ((GetStorageSizeTask)localObject).otv = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(247029);
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cBh, 401, Util.getSizeKB(this.qyN.size));
            this.qyN.bPk();
            AppMethodBeat.o(247029);
          }
        };
        ((GetStorageSizeTask)localObject).bsM();
        AppMethodBeat.o(147574);
        return;
      }
      AppBrandPerformanceManager.a(this.cBh, 401, Util.getSizeKB(((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dX(this.mAppId).adw(this.mAppId)));
      AppMethodBeat.o(147574);
    }
    
    protected void cfN()
    {
      AppMethodBeat.i(147573);
      int i = Util.getSelfMemInMB(MMApplicationContext.getContext());
      AppBrandPerformanceManager.a(this.cBh, 102, i + "m");
      c.a(this.mAppId, "Hardware", "MEMORY", i);
      AppMethodBeat.o(147573);
    }
    
    protected void cfO()
    {
      if (!this.qyI) {}
    }
    
    protected void cfP()
    {
      if (!this.qyI) {}
    }
    
    protected void cfQ() {}
    
    protected void cfR() {}
    
    protected void cfS() {}
    
    public void run()
    {
      AppMethodBeat.i(147575);
      if (this.cBh.ntU.get())
      {
        AppMethodBeat.o(147575);
        return;
      }
      if ((this.mEnabled) && (!this.arU))
      {
        double d = this.qyJ.cfX();
        AppBrandPerformanceManager.a(this.cBh, 101, (int)d + "%");
        c.a(this.mAppId, "Hardware", "CPU", d);
        cfN();
        cfO();
        cfP();
        cfQ();
        cfR();
        cfS();
        this.qyG += 1;
        if (this.qyG >= 4)
        {
          this.qyG = 0;
          cfT();
        }
      }
      if (this.mEnabled) {
        m.clV().i(this, 1000L);
      }
      AppMethodBeat.o(147575);
    }
    
    public final void start()
    {
      AppMethodBeat.i(147571);
      if ((!this.qyI) && (cfM()))
      {
        f.a local1 = new f.a()
        {
          public final void t(double paramAnonymousDouble)
          {
            AppMethodBeat.i(244069);
            if (Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) != Math.round(paramAnonymousDouble))
            {
              AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this, paramAnonymousDouble);
              String str = Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) + " fps";
              AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cBh, 303, str);
              c.a(AppBrandPerformanceManager.a.this.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this));
            }
            AppMethodBeat.o(244069);
          }
        };
        this.qyK = new f();
        this.qyK.mInterval = 100L;
        this.qyK.qzc = local1;
      }
      this.mEnabled = true;
      m.clV().postToWorker(this);
      k.a(this.mAppId, this.qyL);
      if ((cfM()) && (this.qyK != null)) {
        this.qyK.start();
      }
      AppMethodBeat.o(147571);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(147572);
      this.mEnabled = false;
      k.b(this.mAppId, this.qyL);
      if ((cfM()) && (this.qyK != null)) {
        this.qyK.stop();
      }
      if (this.qyJ != null) {
        this.qyJ.close();
      }
      AppMethodBeat.o(147572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */