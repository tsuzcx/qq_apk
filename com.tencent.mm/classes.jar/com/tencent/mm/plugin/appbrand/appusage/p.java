package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.Collections;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "versionType", "remove", "removeUsage", "", "username", "plugin-appbrand-integration_release"})
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
    n.buJ().add(paramIOnStorageChange, paramLooper);
    n.buC().add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(50279);
  }
  
  public final boolean bi(String paramString, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(50275);
    an.t(paramString, null, paramInt);
    if (!n.buJ().bp(paramString, paramInt)) {}
    for (;;)
    {
      try
      {
        boolean bool2 = n.buJ().bq(paramString, paramInt);
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
  
  public final List<? extends LocalUsageInfo> dP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50277);
    if (paramInt1 <= 0)
    {
      localObject = Collections.emptyList();
      kotlin.g.b.p.g(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50277);
      return localObject;
    }
    Object localObject = x.d(n.buJ().a(null, paramInt1, 0, paramInt2));
    kotlin.g.b.p.g(localObject, "obtainHistoryList(SubCor…, count, 0, versionType))");
    localObject = (List)localObject;
    AppMethodBeat.o(50277);
    return localObject;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50280);
    n.buJ().remove(paramIOnStorageChange);
    n.buC().remove(paramIOnStorageChange);
    AppMethodBeat.o(50280);
  }
  
  public final List<? extends LocalUsageInfo> vW(int paramInt)
  {
    AppMethodBeat.i(50276);
    if (paramInt <= 0)
    {
      localObject = Collections.emptyList();
      kotlin.g.b.p.g(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50276);
      return localObject;
    }
    Object localObject = x.d(n.buJ().a(null, paramInt, 0));
    kotlin.g.b.p.g(localObject, "obtainHistoryList(SubCor…istories(null, count, 0))");
    localObject = (List)localObject;
    AppMethodBeat.o(50276);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.p
 * JD-Core Version:    0.7.0.1
 */