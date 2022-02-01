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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a<List<? extends LocalUsageInfo>, ah>
  implements ah
{
  public static final a naj;
  
  static
  {
    AppMethodBeat.i(189698);
    naj = new a((byte)0);
    AppMethodBeat.o(189698);
  }
  
  public b(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(189697);
    this.nak = paramah;
    AppMethodBeat.o(189697);
  }
  
  public final List<LocalUsageInfo> a(int paramInt, ah.a parama)
  {
    AppMethodBeat.i(189692);
    parama = (List)n(new Object[] { Integer.valueOf(paramInt), parama });
    AppMethodBeat.o(189692);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, ah.a parama, int paramInt2)
  {
    AppMethodBeat.i(189706);
    parama = this.nak.a(paramInt1, parama, paramInt2);
    AppMethodBeat.o(189706);
    return parama;
  }
  
  public final boolean aX(String paramString, int paramInt)
  {
    AppMethodBeat.i(189705);
    boolean bool = this.nak.aX(paramString, paramInt);
    AppMethodBeat.o(189705);
    return bool;
  }
  
  public final int aY(String paramString, int paramInt)
  {
    AppMethodBeat.i(189701);
    paramInt = this.nak.aY(paramString, paramInt);
    AppMethodBeat.o(189701);
    return paramInt;
  }
  
  public final boolean aZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(189708);
    boolean bool = this.nak.aZ(paramString, paramInt);
    AppMethodBeat.o(189708);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(189696);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(189696);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(189699);
    this.nak.add(parama, paramLooper);
    AppMethodBeat.o(189699);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(189700);
    this.nak.add(paramString, parama);
    AppMethodBeat.o(189700);
  }
  
  public final n bDA()
  {
    return (n)d.nap;
  }
  
  public final void bbN()
  {
    AppMethodBeat.i(189707);
    this.nak.bbN();
    AppMethodBeat.o(189707);
  }
  
  public final int bbO()
  {
    AppMethodBeat.i(189704);
    int i = this.nak.bbO();
    AppMethodBeat.o(189704);
    return i;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(189702);
    this.nak.doNotify(paramString);
    AppMethodBeat.o(189702);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(189694);
    p.h(parama, "listener");
    ((ah)this.nad).add(parama);
    AppMethodBeat.o(189694);
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(189709);
    boolean bool = this.nak.g(paramList, paramInt);
    AppMethodBeat.o(189709);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(189703);
    int i = this.nak.getCount();
    AppMethodBeat.o(189703);
    return i;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(189695);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(189695);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.b
 * JD-Core Version:    0.7.0.1
 */