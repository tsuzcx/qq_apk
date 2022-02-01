package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.Collections;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "versionType", "remove", "removeUsage", "", "username", "plugin-appbrand-integration_release"})
public final class p
  extends k
  implements ai
{
  private final String TAG = "MicroMsg.AppBrandLocalUsageStorageNewImpl";
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(50278);
    add(parama, Looper.getMainLooper());
    AppMethodBeat.o(50278);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(50279);
    j.aYV().add(parama, paramLooper);
    j.aYP().add(parama, paramLooper);
    AppMethodBeat.o(50279);
  }
  
  public final boolean ba(String paramString, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(50275);
    an.u(paramString, null, paramInt);
    if (!j.aYV().bh(paramString, paramInt)) {}
    for (;;)
    {
      try
      {
        boolean bool2 = j.aYV().bi(paramString, paramInt);
        if (bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramString, "removeUsage", new Object[0]);
        continue;
      }
      AppMethodBeat.o(50275);
      return bool1;
      bool1 = false;
    }
  }
  
  public final List<? extends LocalUsageInfo> dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50277);
    if (paramInt1 <= 0)
    {
      localObject = Collections.emptyList();
      d.g.b.p.g(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50277);
      return localObject;
    }
    Object localObject = y.d(j.aYV().a(null, paramInt1, 0, paramInt2));
    d.g.b.p.g(localObject, "obtainHistoryList(SubCor…, count, 0, versionType))");
    localObject = (List)localObject;
    AppMethodBeat.o(50277);
    return localObject;
  }
  
  public final List<? extends LocalUsageInfo> rY(int paramInt)
  {
    AppMethodBeat.i(50276);
    if (paramInt <= 0)
    {
      localObject = Collections.emptyList();
      d.g.b.p.g(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50276);
      return localObject;
    }
    Object localObject = y.d(j.aYV().a(null, paramInt, 0));
    d.g.b.p.g(localObject, "obtainHistoryList(SubCor…istories(null, count, 0))");
    localObject = (List)localObject;
    AppMethodBeat.o(50276);
    return localObject;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(50280);
    j.aYV().remove(parama);
    j.aYP().remove(parama);
    AppMethodBeat.o(50280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.p
 * JD-Core Version:    0.7.0.1
 */