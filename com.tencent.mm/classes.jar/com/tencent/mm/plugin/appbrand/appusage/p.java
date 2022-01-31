package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "remove", "removeUsage", "", "username", "versionType", "plugin-appbrand-integration_release"})
public final class p
  extends k
  implements ag
{
  private final String TAG = "MicroMsg.AppBrandLocalUsageStorageNewImpl";
  
  public final boolean aF(String paramString, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(134539);
    al.m(paramString, null, paramInt);
    if (!g.auK().aM(paramString, paramInt)) {}
    for (;;)
    {
      try
      {
        boolean bool2 = g.auK().aN(paramString, paramInt);
        if (bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)paramString, "removeUsage", new Object[0]);
        continue;
      }
      AppMethodBeat.o(134539);
      return bool1;
      bool1 = false;
    }
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(134541);
    add(parama, Looper.getMainLooper());
    AppMethodBeat.o(134541);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(134542);
    g.auK().add(parama, paramLooper);
    g.auF().add(parama, paramLooper);
    AppMethodBeat.o(134542);
  }
  
  public final List<? extends LocalUsageInfo> nu(int paramInt)
  {
    AppMethodBeat.i(134540);
    if (paramInt <= 0)
    {
      localObject = Collections.emptyList();
      j.p(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(134540);
      return localObject;
    }
    Object localObject = w.d(g.auK().a(null, paramInt, 0));
    j.p(localObject, "obtainHistoryList(SubCor…istories(null, count, 0))");
    localObject = (List)localObject;
    AppMethodBeat.o(134540);
    return localObject;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(134543);
    g.auK().remove(parama);
    g.auF().remove(parama);
    AppMethodBeat.o(134543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.p
 * JD-Core Version:    0.7.0.1
 */