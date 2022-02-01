package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.util.Collections;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "versionType", "remove", "removeUsage", "", "username", "plugin-appbrand-integration_release"})
public final class p
  extends com.tencent.mm.sdk.e.k
  implements ai
{
  private final String TAG = "MicroMsg.AppBrandLocalUsageStorageNewImpl";
  
  public final boolean aY(String paramString, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(50275);
    an.t(paramString, null, paramInt);
    if (!j.aVA().bf(paramString, paramInt)) {}
    for (;;)
    {
      try
      {
        boolean bool2 = j.aVA().bg(paramString, paramInt);
        if (bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)paramString, "removeUsage", new Object[0]);
        continue;
      }
      AppMethodBeat.o(50275);
      return bool1;
      bool1 = false;
    }
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(50278);
    add(parama, Looper.getMainLooper());
    AppMethodBeat.o(50278);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(50279);
    j.aVA().add(parama, paramLooper);
    j.aVu().add(parama, paramLooper);
    AppMethodBeat.o(50279);
  }
  
  public final List<? extends LocalUsageInfo> dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50277);
    if (paramInt1 <= 0)
    {
      localObject = Collections.emptyList();
      d.g.b.k.g(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50277);
      return localObject;
    }
    Object localObject = y.d(j.aVA().a(null, paramInt1, 0, paramInt2));
    d.g.b.k.g(localObject, "obtainHistoryList(SubCor…, count, 0, versionType))");
    localObject = (List)localObject;
    AppMethodBeat.o(50277);
    return localObject;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(50280);
    j.aVA().remove(parama);
    j.aVu().remove(parama);
    AppMethodBeat.o(50280);
  }
  
  public final List<? extends LocalUsageInfo> ry(int paramInt)
  {
    AppMethodBeat.i(50276);
    if (paramInt <= 0)
    {
      localObject = Collections.emptyList();
      d.g.b.k.g(localObject, "Collections.emptyList<LocalUsageInfo>()");
      AppMethodBeat.o(50276);
      return localObject;
    }
    Object localObject = y.d(j.aVA().a(null, paramInt, 0));
    d.g.b.k.g(localObject, "obtainHistoryList(SubCor…istories(null, count, 0))");
    localObject = (List)localObject;
    AppMethodBeat.o(50276);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.p
 * JD-Core Version:    0.7.0.1
 */