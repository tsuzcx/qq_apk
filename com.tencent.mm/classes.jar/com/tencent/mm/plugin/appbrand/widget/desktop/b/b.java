package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ah.a;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a<List<? extends LocalUsageInfo>, ah>
  implements ah
{
  public static final a nfr;
  
  static
  {
    AppMethodBeat.i(223970);
    nfr = new a((byte)0);
    AppMethodBeat.o(223970);
  }
  
  public b(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(223969);
    this.nfs = paramah;
    AppMethodBeat.o(223969);
  }
  
  public final List<LocalUsageInfo> a(int paramInt, ah.a parama)
  {
    AppMethodBeat.i(223964);
    parama = (List)m(new Object[] { Integer.valueOf(paramInt), parama });
    AppMethodBeat.o(223964);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, ah.a parama, int paramInt2)
  {
    AppMethodBeat.i(223978);
    parama = this.nfs.a(paramInt1, parama, paramInt2);
    AppMethodBeat.o(223978);
    return parama;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(223968);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(223968);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(223971);
    this.nfs.add(parama, paramLooper);
    AppMethodBeat.o(223971);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(223972);
    this.nfs.add(paramString, parama);
    AppMethodBeat.o(223972);
  }
  
  public final n bEs()
  {
    return (n)d.nfx;
  }
  
  public final boolean ba(String paramString, int paramInt)
  {
    AppMethodBeat.i(223977);
    boolean bool = this.nfs.ba(paramString, paramInt);
    AppMethodBeat.o(223977);
    return bool;
  }
  
  public final int bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(223973);
    paramInt = this.nfs.bb(paramString, paramInt);
    AppMethodBeat.o(223973);
    return paramInt;
  }
  
  public final boolean bc(String paramString, int paramInt)
  {
    AppMethodBeat.i(223980);
    boolean bool = this.nfs.bc(paramString, paramInt);
    AppMethodBeat.o(223980);
    return bool;
  }
  
  public final void bcr()
  {
    AppMethodBeat.i(223979);
    this.nfs.bcr();
    AppMethodBeat.o(223979);
  }
  
  public final int bcs()
  {
    AppMethodBeat.i(223976);
    int i = this.nfs.bcs();
    AppMethodBeat.o(223976);
    return i;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(223974);
    this.nfs.doNotify(paramString);
    AppMethodBeat.o(223974);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(223966);
    p.h(parama, "listener");
    ((ah)this.nfl).add(parama);
    AppMethodBeat.o(223966);
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(223981);
    boolean bool = this.nfs.g(paramList, paramInt);
    AppMethodBeat.o(223981);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(223975);
    int i = this.nfs.getCount();
    AppMethodBeat.o(223975);
    return i;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(223967);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(223967);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.b
 * JD-Core Version:    0.7.0.1
 */