package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", "query", "count", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends a<List<? extends LocalUsageInfo>, ai>
  implements ai
{
  public static final a nfA;
  
  static
  {
    AppMethodBeat.i(223996);
    nfA = new a((byte)0);
    AppMethodBeat.o(223996);
  }
  
  public e(ai paramai)
  {
    super(paramai);
    AppMethodBeat.i(223995);
    this.nfB = paramai;
    AppMethodBeat.o(223995);
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(223994);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(223994);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(223997);
    this.nfB.add(parama, paramLooper);
    AppMethodBeat.o(223997);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(223998);
    this.nfB.add(paramString, parama);
    AppMethodBeat.o(223998);
  }
  
  public final n bEs()
  {
    return (n)d.nfy;
  }
  
  public final boolean bd(String paramString, int paramInt)
  {
    AppMethodBeat.i(224001);
    boolean bool = this.nfB.bd(paramString, paramInt);
    AppMethodBeat.o(224001);
    return bool;
  }
  
  public final List<LocalUsageInfo> dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224000);
    List localList = this.nfB.dE(paramInt1, paramInt2);
    AppMethodBeat.o(224000);
    return localList;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(223999);
    this.nfB.doNotify(paramString);
    AppMethodBeat.o(223999);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(223992);
    p.h(parama, "listener");
    ((ai)this.nfl).add(parama);
    AppMethodBeat.o(223992);
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(223993);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(223993);
  }
  
  public final List<LocalUsageInfo> sb(int paramInt)
  {
    AppMethodBeat.i(223990);
    List localList = (List)m(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(223990);
    return localList;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.e
 * JD-Core Version:    0.7.0.1
 */