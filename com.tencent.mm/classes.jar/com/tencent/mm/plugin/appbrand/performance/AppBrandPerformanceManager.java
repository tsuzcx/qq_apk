package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager
{
  protected static final SparseArray<a> lHs;
  
  static
  {
    AppMethodBeat.i(147593);
    lHs = new SparseArray();
    AppMethodBeat.o(147593);
  }
  
  public static void Qg(String paramString)
  {
    AppMethodBeat.i(147582);
    ac.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (a)lHs.get(i);
    if (paramString != null)
    {
      lHs.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(147582);
  }
  
  public static void Qh(String paramString)
  {
    AppMethodBeat.i(147583);
    ac.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147583);
  }
  
  public static void Qi(String paramString)
  {
    AppMethodBeat.i(147584);
    ac.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
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
    paramc = paramc.ceY;
    if (paramc == null)
    {
      y.ayq().F(str.hashCode() + "performance_data", true).l(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(147587);
      return;
    }
    paramc.as(paramInt, paramString);
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
    paramc = paramc.ceY;
    if (paramc == null)
    {
      y.ayq().F(str.hashCode() + "performance_custom_data", true).l(paramString1, paramString2);
      AppMethodBeat.o(147588);
      return;
    }
    paramc.eh(paramString1, paramString2);
    AppMethodBeat.o(147588);
  }
  
  public static void c(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147581);
    String str = paramc.mAppId;
    ac.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    a locala2 = (a)lHs.get(str.hashCode());
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramc);
      lHs.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(147581);
  }
  
  public static boolean d(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147585);
    paramc = (a)paramc.ar(a.class);
    if ((paramc != null) && (paramc.lHp))
    {
      AppMethodBeat.o(147585);
      return true;
    }
    AppMethodBeat.o(147585);
    return false;
  }
  
  public static void e(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147589);
    Object localObject = paramc.mAppId;
    o localo = paramc.ceY;
    localObject = y.ayq().xI(((String)localObject).hashCode() + "performance_data");
    if (localo == null) {
      ac.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      f(paramc);
      AppMethodBeat.o(147589);
      return;
      if (localObject == null)
      {
        ac.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
      }
      else
      {
        Iterator localIterator = ((y.b)localObject).getKeySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)((y.b)localObject).get(str1);
          if (str2 != null) {
            localo.as(bs.getInt(str1, 0), str2);
          }
        }
      }
    }
  }
  
  private static void f(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147590);
    Object localObject = paramc.mAppId;
    paramc = paramc.ceY;
    localObject = y.ayq().xI(((String)localObject).hashCode() + "performance_custom_data");
    if (paramc == null)
    {
      ac.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
      AppMethodBeat.o(147590);
      return;
    }
    if (localObject == null)
    {
      ac.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
      AppMethodBeat.o(147590);
      return;
    }
    Iterator localIterator = ((y.b)localObject).getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((y.b)localObject).get(str1);
      if (str2 != null) {
        paramc.eh(str1, str2);
      }
    }
    AppMethodBeat.o(147590);
  }
  
  public static boolean g(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147592);
    if (!d(paramc))
    {
      AppMethodBeat.o(147592);
      return false;
    }
    boolean bool = c.Qj(paramc.mAppId);
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
    
    public final void aLq()
    {
      AppMethodBeat.i(147577);
      d locald = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).CK();
      String str2 = this.mAppId + "_PerformancePanelEnabled";
      if (this.mEnable) {}
      for (String str1 = "1";; str1 = "0")
      {
        locald.cv(str2, str1);
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
    volatile boolean AC;
    protected final com.tencent.luggage.sdk.d.c ceP;
    private g.c lHA;
    private volatile double lHt;
    private volatile int lHu;
    private volatile boolean lHv;
    protected volatile boolean lHw;
    private e lHx;
    f lHy;
    f.a lHz;
    protected final String mAppId;
    private volatile boolean mEnabled;
    
    public a(com.tencent.luggage.sdk.d.c paramc)
    {
      AppMethodBeat.i(147570);
      this.lHt = 0.0D;
      this.lHu = 4;
      this.mEnabled = true;
      this.AC = false;
      this.lHv = false;
      this.lHw = false;
      this.lHz = new f.a()
      {
        public final void s(double paramAnonymousDouble)
        {
          AppMethodBeat.i(147566);
          if (Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) != Math.round(paramAnonymousDouble))
          {
            AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this, paramAnonymousDouble);
            String str = Math.round(AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this)) + " fps";
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.ceP, 303, str);
            c.a(AppBrandPerformanceManager.a.this.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(AppBrandPerformanceManager.a.this));
          }
          AppMethodBeat.o(147566);
        }
      };
      this.lHA = new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(147568);
          super.a(paramAnonymousd);
          paramAnonymousd = AppBrandPerformanceManager.a.this;
          paramAnonymousd.AC = true;
          if ((AppBrandPerformanceManager.a.brG()) && (paramAnonymousd.lHy != null)) {
            paramAnonymousd.lHy.stop();
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
          locala.AC = false;
          if ((AppBrandPerformanceManager.a.brG()) && (locala.lHy != null)) {
            locala.lHy.start();
          }
          AppMethodBeat.o(147569);
        }
      };
      this.ceP = paramc;
      this.mAppId = paramc.mAppId;
      this.lHx = new e(Process.myPid());
      this.lHw = false;
      if (brG())
      {
        this.lHy = new f();
        this.lHy.mInterval = 100L;
        this.lHy.lHz = this.lHz;
      }
      AppMethodBeat.o(147570);
    }
    
    static boolean brG()
    {
      return Build.VERSION.SDK_INT >= 16;
    }
    
    private void brN()
    {
      AppMethodBeat.i(147574);
      Object localObject = this.ceP.DB();
      if (localObject == null)
      {
        AppMethodBeat.o(147574);
        return;
      }
      if (((AppBrandSysConfigLU)localObject).jEh == 1)
      {
        localObject = new GetStorageSizeTask();
        ((GetStorageSizeTask)localObject).appId = this.mAppId;
        ((GetStorageSizeTask)localObject).jWP = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147565);
            AppBrandPerformanceManager.a(AppBrandPerformanceManager.a.this.ceP, 401, bs.qz(this.lHB.size));
            this.lHB.bek();
            AppMethodBeat.o(147565);
          }
        };
        ((GetStorageSizeTask)localObject).bej();
        AppBrandMainProcessService.a((MainProcessTask)localObject);
        AppMethodBeat.o(147574);
        return;
      }
      AppBrandPerformanceManager.a(this.ceP, 401, bs.qz(((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).ch(this.mAppId).IH(this.mAppId)));
      AppMethodBeat.o(147574);
    }
    
    protected void brH()
    {
      AppMethodBeat.i(147573);
      int i = bs.je(ai.getContext());
      AppBrandPerformanceManager.a(this.ceP, 102, i + "m");
      c.a(this.mAppId, "Hardware", "MEMORY", i);
      AppMethodBeat.o(147573);
    }
    
    protected void brI()
    {
      if (!this.lHw) {}
    }
    
    protected void brJ()
    {
      if (!this.lHw) {}
    }
    
    protected void brK() {}
    
    protected void brL() {}
    
    protected void brM() {}
    
    public void run()
    {
      AppMethodBeat.i(147575);
      if (this.ceP.isDestroyed())
      {
        AppMethodBeat.o(147575);
        return;
      }
      if ((this.mEnabled) && (!this.AC))
      {
        double d = this.lHx.brQ();
        AppBrandPerformanceManager.a(this.ceP, 101, (int)d + "%");
        c.a(this.mAppId, "Hardware", "CPU", d);
        brH();
        brI();
        brJ();
        brK();
        brL();
        brM();
        this.lHu += 1;
        if (this.lHu >= 4)
        {
          this.lHu = 0;
          brN();
        }
      }
      if (this.mEnabled) {
        l.bxj().j(this, 1000L);
      }
      AppMethodBeat.o(147575);
    }
    
    public final void start()
    {
      AppMethodBeat.i(147571);
      this.mEnabled = true;
      l.bxj().postToWorker(this);
      g.a(this.mAppId, this.lHA);
      if ((brG()) && (this.lHy != null)) {
        this.lHy.start();
      }
      AppMethodBeat.o(147571);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(147572);
      this.mEnabled = false;
      g.b(this.mAppId, this.lHA);
      if ((brG()) && (this.lHy != null)) {
        this.lHy.stop();
      }
      if (this.lHx != null) {
        this.lHx.close();
      }
      AppMethodBeat.o(147572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */