package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager
{
  protected static final SparseArray<AppBrandPerformanceManager.a> iAH;
  
  static
  {
    AppMethodBeat.i(102241);
    iAH = new SparseArray();
    AppMethodBeat.o(102241);
  }
  
  public static void Eu(String paramString)
  {
    AppMethodBeat.i(102230);
    ab.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (AppBrandPerformanceManager.a)iAH.get(i);
    if (paramString != null)
    {
      iAH.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(102230);
  }
  
  public static void Ev(String paramString)
  {
    AppMethodBeat.i(102231);
    ab.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(102231);
  }
  
  public static void Ew(String paramString)
  {
    AppMethodBeat.i(102232);
    ab.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
    AppMethodBeat.o(102232);
  }
  
  public static void a(com.tencent.luggage.sdk.d.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(102234);
    a(paramb, paramInt, String.format("%d ms", new Object[] { Long.valueOf(paramLong) }));
    AppMethodBeat.o(102234);
  }
  
  public static void a(com.tencent.luggage.sdk.d.b paramb, int paramInt, String paramString)
  {
    AppMethodBeat.i(102235);
    String str = paramb.mAppId;
    paramb = paramb.bFj;
    if (paramb == null)
    {
      v.aae().z(str.hashCode() + "performance_data", true).i(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(102235);
      return;
    }
    paramb.ae(paramInt, paramString);
    AppMethodBeat.o(102235);
  }
  
  public static void a(com.tencent.luggage.sdk.d.b paramb, long paramLong)
  {
    AppMethodBeat.i(102239);
    a(paramb, 201, paramLong);
    AppMethodBeat.o(102239);
  }
  
  public static void a(com.tencent.luggage.sdk.d.b paramb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102236);
    String str = paramb.mAppId;
    paramb = paramb.bFj;
    if (paramb == null)
    {
      v.aae().z(str.hashCode() + "performance_custom_data", true).i(paramString1, paramString2);
      AppMethodBeat.o(102236);
      return;
    }
    paramb.cU(paramString1, paramString2);
    AppMethodBeat.o(102236);
  }
  
  public static void c(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(102229);
    String str = paramb.mAppId;
    ab.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala2 = (AppBrandPerformanceManager.a)iAH.get(str.hashCode());
    AppBrandPerformanceManager.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new AppBrandPerformanceManager.a(paramb);
      iAH.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(102229);
  }
  
  public static boolean d(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(102233);
    paramb = (a)paramb.U(a.class);
    if ((paramb != null) && (paramb.iAE))
    {
      AppMethodBeat.o(102233);
      return true;
    }
    AppMethodBeat.o(102233);
    return false;
  }
  
  public static void e(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(102237);
    Object localObject = paramb.mAppId;
    l locall = paramb.bFj;
    localObject = v.aae().oP(((String)localObject).hashCode() + "performance_data");
    if (locall == null) {
      ab.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      f(paramb);
      AppMethodBeat.o(102237);
      return;
      if (localObject == null)
      {
        ab.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
      }
      else
      {
        Iterator localIterator = ((v.b)localObject).getKeySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)((v.b)localObject).get(str1);
          if (str2 != null) {
            locall.ae(Integer.valueOf(str1).intValue(), str2);
          }
        }
      }
    }
  }
  
  private static void f(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(102238);
    Object localObject = paramb.mAppId;
    paramb = paramb.bFj;
    localObject = v.aae().oP(((String)localObject).hashCode() + "performance_custom_data");
    if (paramb == null)
    {
      ab.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
      AppMethodBeat.o(102238);
      return;
    }
    if (localObject == null)
    {
      ab.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
      AppMethodBeat.o(102238);
      return;
    }
    Iterator localIterator = ((v.b)localObject).getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((v.b)localObject).get(str1);
      if (str2 != null) {
        paramb.cU(str1, str2);
      }
    }
    AppMethodBeat.o(102238);
  }
  
  public static boolean g(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(102240);
    if (!d(paramb))
    {
      AppMethodBeat.o(102240);
      return false;
    }
    boolean bool = c.Ex(paramb.mAppId);
    AppMethodBeat.o(102240);
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
      AppMethodBeat.i(102228);
      CREATOR = new AppBrandPerformanceManager.SetAppPerformanceModeTask.1();
      AppMethodBeat.o(102228);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(102225);
      com.tencent.mm.plugin.appbrand.config.c localc = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).wg();
      String str2 = this.mAppId + "_PerformancePanelEnabled";
      if (this.mEnable) {}
      for (String str1 = "1";; str1 = "0")
      {
        localc.bG(str2, str1);
        AppMethodBeat.o(102225);
        return;
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(102226);
      this.mAppId = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.mEnable = bool;
        AppMethodBeat.o(102226);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(102227);
      paramParcel.writeString(this.mAppId);
      if (this.mEnable) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(102227);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */