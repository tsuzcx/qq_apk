package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager
{
  protected static final SparseArray<a> nwB;
  
  static
  {
    AppMethodBeat.i(147593);
    nwB = new SparseArray();
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
    paramd = paramd.cCl;
    if (paramd == null)
    {
      ad.aVe().G(str.hashCode() + "performance_data", true).l(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(147587);
      return;
    }
    paramd.aw(paramInt, paramString);
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
    paramd = paramd.cCl;
    if (paramd == null)
    {
      ad.aVe().G(str.hashCode() + "performance_custom_data", true).l(paramString1, paramString2);
      AppMethodBeat.o(147588);
      return;
    }
    paramd.eL(paramString1, paramString2);
    AppMethodBeat.o(147588);
  }
  
  public static void aei(String paramString)
  {
    AppMethodBeat.i(147582);
    Log.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (a)nwB.get(i);
    if (paramString != null)
    {
      nwB.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(147582);
  }
  
  public static void aej(String paramString)
  {
    AppMethodBeat.i(147583);
    Log.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147583);
  }
  
  public static void aek(String paramString)
  {
    AppMethodBeat.i(147584);
    Log.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147584);
  }
  
  public static void d(d paramd)
  {
    AppMethodBeat.i(147581);
    String str = paramd.mAppId;
    Log.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    a locala2 = (a)nwB.get(str.hashCode());
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramd);
      nwB.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(147581);
  }
  
  public static boolean e(d paramd)
  {
    AppMethodBeat.i(147585);
    paramd = (a)paramd.av(a.class);
    if ((paramd != null) && (paramd.nwy))
    {
      AppMethodBeat.o(147585);
      return true;
    }
    AppMethodBeat.o(147585);
    return false;
  }
  
  public static void f(d paramd)
  {
    AppMethodBeat.i(147589);
    Object localObject = paramd.mAppId;
    v localv = paramd.cCl;
    localObject = ad.aVe().JW(((String)localObject).hashCode() + "performance_data");
    if (localv == null) {
      Log.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      g(paramd);
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
            localv.aw(Util.getInt(str1, 0), str2);
          }
        }
      }
    }
  }
  
  private static void g(d paramd)
  {
    AppMethodBeat.i(147590);
    Object localObject = paramd.mAppId;
    paramd = paramd.cCl;
    localObject = ad.aVe().JW(((String)localObject).hashCode() + "performance_custom_data");
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
        paramd.eL(str1, str2);
      }
    }
    AppMethodBeat.o(147590);
  }
  
  public static boolean h(d paramd)
  {
    AppMethodBeat.i(147592);
    if (!e(paramd))
    {
      AppMethodBeat.o(147592);
      return false;
    }
    boolean bool = c.ael(paramd.mAppId);
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
    
    public final void bjj()
    {
      AppMethodBeat.i(147577);
      com.tencent.mm.plugin.appbrand.config.e locale = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.M(com.tencent.luggage.sdk.customize.a.class)).NL();
      String str2 = this.mAppId + "_PerformancePanelEnabled";
      if (this.mEnable) {}
      for (String str1 = "1";; str1 = "0")
      {
        locale.cN(str2, str1);
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
    volatile boolean CA;
    protected final d cBE;
    protected final String mAppId;
    private volatile boolean mEnabled;
    private volatile double nwC;
    private volatile int nwD;
    private volatile boolean nwE;
    protected volatile boolean nwF;
    private e nwG;
    f nwH;
    f.a nwI;
    private h.c nwJ;
    
    public a(d paramd)
    {
      AppMethodBeat.i(147570);
      this.nwC = 0.0D;
      this.nwD = 4;
      this.mEnabled = true;
      this.CA = false;
      this.nwE = false;
      this.nwF = false;
      this.nwI = new f.a()
      {
        public final void t(double paramAnonymousDouble)
        {
          AppMethodBeat.i(147566);
          if (Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) != Math.round(paramAnonymousDouble))
          {
            AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this, paramAnonymousDouble);
            String str = Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) + " fps";
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cBE, 303, str);
            c.a(AppBrandPerformanceManager.a.this.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this));
          }
          AppMethodBeat.o(147566);
        }
      };
      this.nwJ = new h.c()
      {
        public final void a(h.d paramAnonymousd)
        {
          AppMethodBeat.i(147568);
          super.a(paramAnonymousd);
          paramAnonymousd = AppBrandPerformanceManager.a.this;
          paramAnonymousd.CA = true;
          if ((AppBrandPerformanceManager.a.bSJ()) && (paramAnonymousd.nwH != null)) {
            paramAnonymousd.nwH.stop();
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
          locala.CA = false;
          if ((AppBrandPerformanceManager.a.bSJ()) && (locala.nwH != null)) {
            locala.nwH.start();
          }
          AppMethodBeat.o(147569);
        }
      };
      this.cBE = paramd;
      this.mAppId = paramd.mAppId;
      this.nwG = new e(Process.myPid());
      this.nwF = false;
      if (bSJ())
      {
        this.nwH = new f();
        this.nwH.mInterval = 100L;
        this.nwH.nwI = this.nwI;
      }
      AppMethodBeat.o(147570);
    }
    
    static boolean bSJ()
    {
      return Build.VERSION.SDK_INT >= 16;
    }
    
    private void bSQ()
    {
      AppMethodBeat.i(147574);
      Object localObject = this.cBE.OM();
      if (localObject == null)
      {
        AppMethodBeat.o(147574);
        return;
      }
      if (((AppBrandSysConfigLU)localObject).leF == 1)
      {
        localObject = new GetStorageSizeTask();
        ((GetStorageSizeTask)localObject).appId = this.mAppId;
        ((GetStorageSizeTask)localObject).lyv = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147565);
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cBE, 401, Util.getSizeKB(this.nwK.size));
            this.nwK.bDK();
            AppMethodBeat.o(147565);
          }
        };
        ((GetStorageSizeTask)localObject).bDJ();
        AppBrandMainProcessService.a((MainProcessTask)localObject);
        AppMethodBeat.o(147574);
        return;
      }
      AppBrandPerformanceManager.a(this.cBE, 401, Util.getSizeKB(((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.M(com.tencent.luggage.sdk.customize.a.class)).dD(this.mAppId).VL(this.mAppId)));
      AppMethodBeat.o(147574);
    }
    
    protected void bSK()
    {
      AppMethodBeat.i(147573);
      int i = Util.getSelfMemInMB(MMApplicationContext.getContext());
      AppBrandPerformanceManager.a(this.cBE, 102, i + "m");
      c.a(this.mAppId, "Hardware", "MEMORY", i);
      AppMethodBeat.o(147573);
    }
    
    protected void bSL()
    {
      if (!this.nwF) {}
    }
    
    protected void bSM()
    {
      if (!this.nwF) {}
    }
    
    protected void bSN() {}
    
    protected void bSO() {}
    
    protected void bSP() {}
    
    public void run()
    {
      AppMethodBeat.i(147575);
      if (this.cBE.isDestroyed())
      {
        AppMethodBeat.o(147575);
        return;
      }
      if ((this.mEnabled) && (!this.CA))
      {
        double d = this.nwG.bSU();
        AppBrandPerformanceManager.a(this.cBE, 101, (int)d + "%");
        c.a(this.mAppId, "Hardware", "CPU", d);
        bSK();
        bSL();
        bSM();
        bSN();
        bSO();
        bSP();
        this.nwD += 1;
        if (this.nwD >= 4)
        {
          this.nwD = 0;
          bSQ();
        }
      }
      if (this.mEnabled) {
        m.bZn().j(this, 1000L);
      }
      AppMethodBeat.o(147575);
    }
    
    public final void start()
    {
      AppMethodBeat.i(147571);
      this.mEnabled = true;
      m.bZn().postToWorker(this);
      com.tencent.mm.plugin.appbrand.h.a(this.mAppId, this.nwJ);
      if ((bSJ()) && (this.nwH != null)) {
        this.nwH.start();
      }
      AppMethodBeat.o(147571);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(147572);
      this.mEnabled = false;
      com.tencent.mm.plugin.appbrand.h.b(this.mAppId, this.nwJ);
      if ((bSJ()) && (this.nwH != null)) {
        this.nwH.stop();
      }
      if (this.nwG != null) {
        this.nwG.close();
      }
      AppMethodBeat.o(147572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */