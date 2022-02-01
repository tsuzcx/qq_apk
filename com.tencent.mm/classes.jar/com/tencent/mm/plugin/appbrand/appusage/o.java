package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "versionType", "maxUpdateTime", "", "remove", "removeUsage", "", "username", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends MStorage
  implements ag
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
    n.cfk().add(paramIOnStorageChange, paramLooper);
    n.cfc().add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(50279);
  }
  
  public final boolean bT(String paramString, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(50275);
    am.C(paramString, null, paramInt);
    if (!n.cfk().ca(paramString, paramInt)) {}
    for (;;)
    {
      try
      {
        boolean bool2 = n.cfk().cb(paramString, paramInt);
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
  
  public final List<? extends LocalUsageInfo> fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50277);
    if (paramInt1 <= 0)
    {
      localObject = Collections.emptyList();
      s.s(localObject, "emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50277);
      return localObject;
    }
    Object localObject = w.g(n.cfk().a(null, paramInt1, 0, paramInt2));
    s.s(localObject, "obtainHistoryList(SubCor…, count, 0, versionType))");
    localObject = (List)localObject;
    AppMethodBeat.o(50277);
    return localObject;
  }
  
  public final List<? extends LocalUsageInfo> r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(319326);
    Object localObject = n.cfk().qPF.s(paramLong, paramInt);
    s.s(localObject, "getUsageStorage().paging…ive(maxUpdateTime, count)");
    localObject = (List)localObject;
    AppMethodBeat.o(319326);
    return localObject;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50280);
    n.cfk().remove(paramIOnStorageChange);
    n.cfc().remove(paramIOnStorageChange);
    AppMethodBeat.o(50280);
  }
  
  public final List<? extends LocalUsageInfo> zu(int paramInt)
  {
    AppMethodBeat.i(50276);
    if (paramInt <= 0)
    {
      localObject = Collections.emptyList();
      s.s(localObject, "emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50276);
      return localObject;
    }
    Object localObject = w.g(n.cfk().a(null, paramInt, 0));
    s.s(localObject, "obtainHistoryList(SubCor…istories(null, count, 0))");
    localObject = (List)localObject;
    AppMethodBeat.o(50276);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.o
 * JD-Core Version:    0.7.0.1
 */