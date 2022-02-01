package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", "query", "count", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends a<List<? extends LocalUsageInfo>, ai>
  implements ai
{
  public static final a mzK;
  
  static
  {
    AppMethodBeat.i(187493);
    mzK = new a((byte)0);
    AppMethodBeat.o(187493);
  }
  
  public e(ai paramai)
  {
    super(paramai);
    AppMethodBeat.i(187492);
    this.mzL = paramai;
    AppMethodBeat.o(187492);
  }
  
  public final boolean aY(String paramString, int paramInt)
  {
    AppMethodBeat.i(187498);
    boolean bool = this.mzL.aY(paramString, paramInt);
    AppMethodBeat.o(187498);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(187491);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(187491);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(187494);
    this.mzL.add(parama, paramLooper);
    AppMethodBeat.o(187494);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(187495);
    this.mzL.add(paramString, parama);
    AppMethodBeat.o(187495);
  }
  
  public final n bzw()
  {
    return (n)d.mzI;
  }
  
  public final List<LocalUsageInfo> dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187497);
    List localList = this.mzL.dC(paramInt1, paramInt2);
    AppMethodBeat.o(187497);
    return localList;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(187496);
    this.mzL.doNotify(paramString);
    AppMethodBeat.o(187496);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(187489);
    k.h(parama, "listener");
    ((ai)this.mzv).add(parama);
    AppMethodBeat.o(187489);
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(187490);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(187490);
  }
  
  public final List<LocalUsageInfo> ry(int paramInt)
  {
    AppMethodBeat.i(187487);
    List localList = (List)n(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(187487);
    return localList;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.e
 * JD-Core Version:    0.7.0.1
 */