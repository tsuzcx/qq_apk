package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.Collections;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "versionType", "maxUpdateTime", "", "remove", "removeUsage", "", "username", "plugin-appbrand-integration_release"})
public final class p
  extends MStorage
  implements ah
{
  private final String TAG = "MicroMsg.AppBrandLocalUsageStorageNewImpl";
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50278);
    add(paramIOnStorageChange, Looper.getMainLooper());
    AppMethodBeat.o(50278);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(50279);
    m.bFN().add(paramIOnStorageChange, paramLooper);
    m.bFF().add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(50279);
  }
  
  public final boolean bB(String paramString, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(50275);
    an.w(paramString, null, paramInt);
    if (!m.bFN().bI(paramString, paramInt)) {}
    for (;;)
    {
      try
      {
        boolean bool2 = m.bFN().bJ(paramString, paramInt);
        if (bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "removeUsage", new Object[0]);
        continue;
      }
      AppMethodBeat.o(50275);
      return bool1;
      bool1 = false;
    }
  }
  
  public final List<? extends LocalUsageInfo> en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50277);
    if (paramInt1 <= 0)
    {
      localObject = Collections.emptyList();
      kotlin.g.b.p.j(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50277);
      return localObject;
    }
    Object localObject = x.f(m.bFN().a(null, paramInt1, 0, paramInt2));
    kotlin.g.b.p.j(localObject, "obtainHistoryList(SubCor…, count, 0, versionType))");
    localObject = (List)localObject;
    AppMethodBeat.o(50277);
    return localObject;
  }
  
  public final List<? extends LocalUsageInfo> i(long paramLong, int paramInt)
  {
    AppMethodBeat.i(247500);
    Object localObject = m.bFN().bJD().j(paramLong, paramInt);
    kotlin.g.b.p.j(localObject, "SubCoreAppBrand.getUsage…ive(maxUpdateTime, count)");
    localObject = (List)localObject;
    AppMethodBeat.o(247500);
    return localObject;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50280);
    m.bFN().remove(paramIOnStorageChange);
    m.bFF().remove(paramIOnStorageChange);
    AppMethodBeat.o(50280);
  }
  
  public final List<? extends LocalUsageInfo> zh(int paramInt)
  {
    AppMethodBeat.i(50276);
    if (paramInt <= 0)
    {
      localObject = Collections.emptyList();
      kotlin.g.b.p.j(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50276);
      return localObject;
    }
    Object localObject = x.f(m.bFN().a(null, paramInt, 0));
    kotlin.g.b.p.j(localObject, "obtainHistoryList(SubCor…istories(null, count, 0))");
    localObject = (List)localObject;
    AppMethodBeat.o(50276);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.p
 * JD-Core Version:    0.7.0.1
 */