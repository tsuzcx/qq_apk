package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

public class AppBrandPerformanceManager
{
  protected static final SparseArray<AppBrandPerformanceManager.a> tDz;
  
  static
  {
    AppMethodBeat.i(147593);
    tDz = new SparseArray();
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
    paramd = paramd.evu;
    if (paramd == null)
    {
      ad.bCb().M(str.hashCode() + "performance_data", true).q(String.valueOf(paramInt), paramString);
      AppMethodBeat.o(147587);
      return;
    }
    paramd.aK(paramInt, paramString);
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
    paramd = paramd.evu;
    if (paramd == null)
    {
      ad.bCb().M(str.hashCode() + "performance_custom_data", true).q(paramString1, paramString2);
      AppMethodBeat.o(147588);
      return;
    }
    paramd.fq(paramString1, paramString2);
    AppMethodBeat.o(147588);
  }
  
  public static void afk(String paramString)
  {
    AppMethodBeat.i(147582);
    Log.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (AppBrandPerformanceManager.a)tDz.get(i);
    if (paramString != null)
    {
      tDz.remove(i);
      paramString.stop();
    }
    AppMethodBeat.o(147582);
  }
  
  public static void afl(String paramString)
  {
    AppMethodBeat.i(147583);
    Log.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    localSetAppPerformanceModeTask.bQt();
    AppMethodBeat.o(147583);
  }
  
  public static void afm(String paramString)
  {
    AppMethodBeat.i(147584);
    Log.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    SetAppPerformanceModeTask localSetAppPerformanceModeTask = new SetAppPerformanceModeTask((byte)0);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
    localSetAppPerformanceModeTask.bQt();
    AppMethodBeat.o(147584);
  }
  
  public static void j(d paramd)
  {
    AppMethodBeat.i(147581);
    String str = paramd.mAppId;
    Log.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala2 = (AppBrandPerformanceManager.a)tDz.get(str.hashCode());
    AppBrandPerformanceManager.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new AppBrandPerformanceManager.a(paramd);
      tDz.put(str.hashCode(), locala1);
    }
    locala1.start();
    AppMethodBeat.o(147581);
  }
  
  public static boolean k(d paramd)
  {
    AppMethodBeat.i(147585);
    paramd = (a)paramd.aN(a.class);
    if ((paramd != null) && (paramd.tDw))
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
    aa localaa = paramd.evu;
    localObject = ad.bCb().Jn(((String)localObject).hashCode() + "performance_data");
    if (localaa == null) {
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
        Iterator localIterator = ((ad.b)localObject).ln().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)((ad.b)localObject).get(str1);
          if (str2 != null) {
            localaa.aK(Util.getInt(str1, 0), str2);
          }
        }
      }
    }
  }
  
  private static void m(d paramd)
  {
    AppMethodBeat.i(147590);
    Object localObject = paramd.mAppId;
    paramd = paramd.evu;
    localObject = ad.bCb().Jn(((String)localObject).hashCode() + "performance_custom_data");
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
    Iterator localIterator = ((ad.b)localObject).ln().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((ad.b)localObject).get(str1);
      if (str2 != null) {
        paramd.fq(str1, str2);
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
    boolean bool = c.afn(paramd.mAppId);
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
    
    public final void asn()
    {
      AppMethodBeat.i(147577);
      com.tencent.mm.plugin.appbrand.config.e locale = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.T(com.tencent.luggage.sdk.customize.a.class)).aqS();
      String str2 = this.mAppId + "_PerformancePanelEnabled";
      if (this.mEnable) {}
      for (String str1 = "1";; str1 = "0")
      {
        locale.dn(str2, str1);
        AppMethodBeat.o(147577);
        return;
      }
    }
    
    public final void h(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */