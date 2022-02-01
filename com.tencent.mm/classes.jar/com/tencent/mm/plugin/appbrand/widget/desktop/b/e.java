package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", "query", "count", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends a<List<? extends LocalUsageInfo>, ai>
  implements ai
{
  public static final a lXI;
  
  static
  {
    AppMethodBeat.i(196532);
    lXI = new a((byte)0);
    AppMethodBeat.o(196532);
  }
  
  public e(ai paramai)
  {
    super(paramai);
    AppMethodBeat.i(196531);
    this.lXJ = paramai;
    AppMethodBeat.o(196531);
  }
  
  public final boolean aU(String paramString, int paramInt)
  {
    AppMethodBeat.i(196537);
    boolean bool = this.lXJ.aU(paramString, paramInt);
    AppMethodBeat.o(196537);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(196530);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(196530);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(196533);
    this.lXJ.add(parama, paramLooper);
    AppMethodBeat.o(196533);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(196534);
    this.lXJ.add(paramString, parama);
    AppMethodBeat.o(196534);
  }
  
  public final n bsw()
  {
    return (n)d.lXG;
  }
  
  public final List<LocalUsageInfo> dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196536);
    List localList = this.lXJ.dC(paramInt1, paramInt2);
    AppMethodBeat.o(196536);
    return localList;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(196535);
    this.lXJ.doNotify(paramString);
    AppMethodBeat.o(196535);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(196528);
    k.h(parama, "listener");
    ((ai)this.lXt).add(parama);
    AppMethodBeat.o(196528);
  }
  
  public final List<LocalUsageInfo> qL(int paramInt)
  {
    AppMethodBeat.i(196526);
    List localList = (List)m(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(196526);
    return localList;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(196529);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(196529);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.e
 * JD-Core Version:    0.7.0.1
 */