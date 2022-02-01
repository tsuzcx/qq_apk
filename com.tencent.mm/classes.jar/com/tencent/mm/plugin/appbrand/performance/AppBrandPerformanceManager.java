package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ui.q;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager
{
  protected static final SparseArray<a> mmd;
  
  static
  {
    AppMethodBeat.i(147593);
    mmd = new SparseArray();
    AppMethodBeat.o(147593);
  }
  
  public static void Uu(String paramString)
  {
    AppMethodBeat.i(147582);
    ae.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (a)mmd.get(i);
    if (paramString != null)
    {
      mmd.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(147582);
  }
  
  public static void Uv(String paramString)
  {
    AppMethodBeat.i(147583);
    ae.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147583);
  }
  
  public static void Uw(String paramString)
  {
    AppMethodBeat.i(147584);
    ae.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147584);
  }
  
  public static void a(com.tencent.luggage.sdk.d.d paramd, int paramInt, long paramLong)
  {
    AppMethodBeat.i(147586);
    a(paramd, paramInt, String.format("%d ms", new Object[] { Long.valueOf(paramLong) }));
    AppMethodBeat.o(147586);
  }
  
  public static void a(com.tencent.luggage.sdk.d.d paramd, int paramInt, String paramString)
  {
    AppMethodBeat.i(147587);
    String str = paramd.mAppId;
    paramd = paramd.cpS;
    if (paramd == null)
    {
      z.aBG().F(str.hashCode() + "performance_data", true).k(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(147587);
      return;
    }
    paramd.at(paramInt, paramString);
    AppMethodBeat.o(147587);
  }
  
  public static void a(com.tencent.luggage.sdk.d.d paramd, long paramLong)
  {
    AppMethodBeat.i(147591);
    a(paramd, 201, paramLong);
    AppMethodBeat.o(147591);
  }
  
  public static void a(com.tencent.luggage.sdk.d.d paramd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147588);
    String str = paramd.mAppId;
    paramd = paramd.cpS;
    if (paramd == null)
    {
      z.aBG().F(str.hashCode() + "performance_custom_data", true).k(paramString1, paramString2);
      AppMethodBeat.o(147588);
      return;
    }
    paramd.et(paramString1, paramString2);
    AppMethodBeat.o(147588);
  }
  
  public static void d(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(147581);
    String str = paramd.mAppId;
    ae.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    a locala2 = (a)mmd.get(str.hashCode());
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramd);
      mmd.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(147581);
  }
  
  public static boolean e(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(147585);
    paramd = (a)paramd.ar(a.class);
    if ((paramd != null) && (paramd.mma))
    {
      AppMethodBeat.o(147585);
      return true;
    }
    AppMethodBeat.o(147585);
    return false;
  }
  
  public static void f(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(147589);
    Object localObject = paramd.mAppId;
    q localq = paramd.cpS;
    localObject = z.aBG().Bq(((String)localObject).hashCode() + "performance_data");
    if (localq == null) {
      ae.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      g(paramd);
      AppMethodBeat.o(147589);
      return;
      if (localObject == null)
      {
        ae.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
      }
      else
      {
        Iterator localIterator = ((z.b)localObject).getKeySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)((z.b)localObject).get(str1);
          if (str2 != null) {
            localq.at(bu.getInt(str1, 0), str2);
          }
        }
      }
    }
  }
  
  private static void g(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(147590);
    Object localObject = paramd.mAppId;
    paramd = paramd.cpS;
    localObject = z.aBG().Bq(((String)localObject).hashCode() + "performance_custom_data");
    if (paramd == null)
    {
      ae.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
      AppMethodBeat.o(147590);
      return;
    }
    if (localObject == null)
    {
      ae.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
      AppMethodBeat.o(147590);
      return;
    }
    Iterator localIterator = ((z.b)localObject).getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((z.b)localObject).get(str1);
      if (str2 != null) {
        paramd.et(str1, str2);
      }
    }
    AppMethodBeat.o(147590);
  }
  
  public static boolean h(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(147592);
    if (!e(paramd))
    {
      AppMethodBeat.o(147592);
      return false;
    }
    boolean bool = c.Ux(paramd.mAppId);
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
    
    public final void aOX()
    {
      AppMethodBeat.i(147577);
      com.tencent.mm.plugin.appbrand.config.d locald = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).Em();
      String str2 = this.mAppId + "_PerformancePanelEnabled";
      if (this.mEnable) {}
      for (String str1 = "1";; str1 = "0")
      {
        locald.cz(str2, str1);
        AppMethodBeat.o(147577);
        return;
      }
    }
    
    public final void e(Parcel paramParcel)
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
    volatile boolean Ct;
    protected final com.tencent.luggage.sdk.d.d cpk;
    protected final String mAppId;
    private volatile boolean mEnabled;
    private volatile double mme;
    private volatile int mmf;
    private volatile boolean mmg;
    protected volatile boolean mmh;
    private e mmi;
    f mmj;
    f.a mmk;
    private h.c mml;
    
    public a(com.tencent.luggage.sdk.d.d paramd)
    {
      AppMethodBeat.i(147570);
      this.mme = 0.0D;
      this.mmf = 4;
      this.mEnabled = true;
      this.Ct = false;
      this.mmg = false;
      this.mmh = false;
      this.mmk = new f.a()
      {
        public final void s(double paramAnonymousDouble)
        {
          AppMethodBeat.i(147566);
          if (Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) != Math.round(paramAnonymousDouble))
          {
            AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this, paramAnonymousDouble);
            String str = Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) + " fps";
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cpk, 303, str);
            c.a(AppBrandPerformanceManager.a.this.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this));
          }
          AppMethodBeat.o(147566);
        }
      };
      this.mml = new h.c()
      {
        public final void a(h.d paramAnonymousd)
        {
          AppMethodBeat.i(147568);
          super.a(paramAnonymousd);
          paramAnonymousd = AppBrandPerformanceManager.a.this;
          paramAnonymousd.Ct = true;
          if ((AppBrandPerformanceManager.a.bwB()) && (paramAnonymousd.mmj != null)) {
            paramAnonymousd.mmj.stop();
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
          if ((AppBrandPerformanceManager.a.bwB()) && (locala.mmj != null)) {
            locala.mmj.start();
          }
          AppMethodBeat.o(147569);
        }
      };
      this.cpk = paramd;
      this.mAppId = paramd.mAppId;
      this.mmi = new e(Process.myPid());
      this.mmh = false;
      if (bwB())
      {
        this.mmj = new f();
        this.mmj.mInterval = 100L;
        this.mmj.mmk = this.mmk;
      }
      AppMethodBeat.o(147570);
    }
    
    static boolean bwB()
    {
      return Build.VERSION.SDK_INT >= 16;
    }
    
    private void bwI()
    {
      AppMethodBeat.i(147574);
      Object localObject = this.cpk.Ff();
      if (localObject == null)
      {
        AppMethodBeat.o(147574);
        return;
      }
      if (((AppBrandSysConfigLU)localObject).kbx == 1)
      {
        localObject = new GetStorageSizeTask();
        ((GetStorageSizeTask)localObject).appId = this.mAppId;
        ((GetStorageSizeTask)localObject).kuv = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147565);
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.cpk, 401, bu.sL(this.mmm.size));
            this.mmm.bix();
            AppMethodBeat.o(147565);
          }
        };
        ((GetStorageSizeTask)localObject).biw();
        AppBrandMainProcessService.a((MainProcessTask)localObject);
        AppMethodBeat.o(147574);
        return;
      }
      AppBrandPerformanceManager.a(this.cpk, 401, bu.sL(((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dl(this.mAppId).MC(this.mAppId)));
      AppMethodBeat.o(147574);
    }
    
    protected void bwC()
    {
      AppMethodBeat.i(147573);
      int i = bu.ju(ak.getContext());
      AppBrandPerformanceManager.a(this.cpk, 102, i + "m");
      c.a(this.mAppId, "Hardware", "MEMORY", i);
      AppMethodBeat.o(147573);
    }
    
    protected void bwD()
    {
      if (!this.mmh) {}
    }
    
    protected void bwE()
    {
      if (!this.mmh) {}
    }
    
    protected void bwF() {}
    
    protected void bwG() {}
    
    protected void bwH() {}
    
    public void run()
    {
      AppMethodBeat.i(147575);
      if (this.cpk.isDestroyed())
      {
        AppMethodBeat.o(147575);
        return;
      }
      if ((this.mEnabled) && (!this.Ct))
      {
        double d = this.mmi.bwL();
        AppBrandPerformanceManager.a(this.cpk, 101, (int)d + "%");
        c.a(this.mAppId, "Hardware", "CPU", d);
        bwC();
        bwD();
        bwE();
        bwF();
        bwG();
        bwH();
        this.mmf += 1;
        if (this.mmf >= 4)
        {
          this.mmf = 0;
          bwI();
        }
      }
      if (this.mEnabled) {
        m.bCj().k(this, 1000L);
      }
      AppMethodBeat.o(147575);
    }
    
    public final void start()
    {
      AppMethodBeat.i(147571);
      this.mEnabled = true;
      m.bCj().postToWorker(this);
      com.tencent.mm.plugin.appbrand.h.a(this.mAppId, this.mml);
      if ((bwB()) && (this.mmj != null)) {
        this.mmj.start();
      }
      AppMethodBeat.o(147571);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(147572);
      this.mEnabled = false;
      com.tencent.mm.plugin.appbrand.h.b(this.mAppId, this.mml);
      if ((bwB()) && (this.mmj != null)) {
        this.mmj.stop();
      }
      if (this.mmi != null) {
        this.mmi.close();
      }
      AppMethodBeat.o(147572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */