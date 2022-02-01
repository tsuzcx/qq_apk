package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager
{
  protected static final SparseArray<AppBrandPerformanceManager.a> lhz;
  
  static
  {
    AppMethodBeat.i(147593);
    lhz = new SparseArray();
    AppMethodBeat.o(147593);
  }
  
  public static void Ma(String paramString)
  {
    AppMethodBeat.i(147582);
    ad.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (AppBrandPerformanceManager.a)lhz.get(i);
    if (paramString != null)
    {
      lhz.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(147582);
  }
  
  public static void Mb(String paramString)
  {
    AppMethodBeat.i(147583);
    ad.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(147583);
  }
  
  public static void Mc(String paramString)
  {
    AppMethodBeat.i(147584);
    ad.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
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
    paramc = paramc.cid;
    if (paramc == null)
    {
      y.arz().E(str.hashCode() + "performance_data", true).m(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(147587);
      return;
    }
    paramc.ar(paramInt, paramString);
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
    paramc = paramc.cid;
    if (paramc == null)
    {
      y.arz().E(str.hashCode() + "performance_custom_data", true).m(paramString1, paramString2);
      AppMethodBeat.o(147588);
      return;
    }
    paramc.dV(paramString1, paramString2);
    AppMethodBeat.o(147588);
  }
  
  public static void c(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147581);
    String str = paramc.mAppId;
    ad.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala2 = (AppBrandPerformanceManager.a)lhz.get(str.hashCode());
    AppBrandPerformanceManager.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new AppBrandPerformanceManager.a(paramc);
      lhz.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(147581);
  }
  
  public static boolean d(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147585);
    paramc = (a)paramc.ar(a.class);
    if ((paramc != null) && (paramc.lhw))
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
    o localo = paramc.cid;
    localObject = y.arz().tC(((String)localObject).hashCode() + "performance_data");
    if (localo == null) {
      ad.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      f(paramc);
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
            localo.ar(bt.getInt(str1, 0), str2);
          }
        }
      }
    }
  }
  
  private static void f(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147590);
    Object localObject = paramc.mAppId;
    paramc = paramc.cid;
    localObject = y.arz().tC(((String)localObject).hashCode() + "performance_custom_data");
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
        paramc.dV(str1, str2);
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
    boolean bool = c.Md(paramc.mAppId);
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
    
    public final void aEz()
    {
      AppMethodBeat.i(147577);
      d locald = ((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).Dh();
      String str2 = this.mAppId + "_PerformancePanelEnabled";
      if (this.mEnable) {}
      for (String str1 = "1";; str1 = "0")
      {
        locald.cl(str2, str1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */