package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", "query", "count", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends a<List<? extends LocalUsageInfo>, ai>
  implements ai
{
  public static final a nas;
  
  static
  {
    AppMethodBeat.i(189724);
    nas = new a((byte)0);
    AppMethodBeat.o(189724);
  }
  
  public e(ai paramai)
  {
    super(paramai);
    AppMethodBeat.i(189723);
    this.nat = paramai;
    AppMethodBeat.o(189723);
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(189722);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(189722);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(189725);
    this.nat.add(parama, paramLooper);
    AppMethodBeat.o(189725);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(189726);
    this.nat.add(paramString, parama);
    AppMethodBeat.o(189726);
  }
  
  public final n bDA()
  {
    return (n)d.naq;
  }
  
  public final boolean ba(String paramString, int paramInt)
  {
    AppMethodBeat.i(189729);
    boolean bool = this.nat.ba(paramString, paramInt);
    AppMethodBeat.o(189729);
    return bool;
  }
  
  public final List<LocalUsageInfo> dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189728);
    List localList = this.nat.dE(paramInt1, paramInt2);
    AppMethodBeat.o(189728);
    return localList;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(189727);
    this.nat.doNotify(paramString);
    AppMethodBeat.o(189727);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(189720);
    p.h(parama, "listener");
    ((ai)this.nad).add(parama);
    AppMethodBeat.o(189720);
  }
  
  public final List<LocalUsageInfo> rY(int paramInt)
  {
    AppMethodBeat.i(189718);
    List localList = (List)n(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(189718);
    return localList;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(189721);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(189721);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.e
 * JD-Core Version:    0.7.0.1
 */