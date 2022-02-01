package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ah.a;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a<List<? extends LocalUsageInfo>, ah>
  implements ah
{
  public static final a mzB;
  
  static
  {
    AppMethodBeat.i(187467);
    mzB = new a((byte)0);
    AppMethodBeat.o(187467);
  }
  
  public b(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(187466);
    this.mzC = paramah;
    AppMethodBeat.o(187466);
  }
  
  public final List<LocalUsageInfo> a(int paramInt, ah.a parama)
  {
    AppMethodBeat.i(187461);
    parama = (List)n(new Object[] { Integer.valueOf(paramInt), parama });
    AppMethodBeat.o(187461);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, ah.a parama, int paramInt2)
  {
    AppMethodBeat.i(187475);
    parama = this.mzC.a(paramInt1, parama, paramInt2);
    AppMethodBeat.o(187475);
    return parama;
  }
  
  public final boolean aV(String paramString, int paramInt)
  {
    AppMethodBeat.i(187474);
    boolean bool = this.mzC.aV(paramString, paramInt);
    AppMethodBeat.o(187474);
    return bool;
  }
  
  public final int aW(String paramString, int paramInt)
  {
    AppMethodBeat.i(187470);
    paramInt = this.mzC.aW(paramString, paramInt);
    AppMethodBeat.o(187470);
    return paramInt;
  }
  
  public final boolean aX(String paramString, int paramInt)
  {
    AppMethodBeat.i(187477);
    boolean bool = this.mzC.aX(paramString, paramInt);
    AppMethodBeat.o(187477);
    return bool;
  }
  
  public final void aYp()
  {
    AppMethodBeat.i(187476);
    this.mzC.aYp();
    AppMethodBeat.o(187476);
  }
  
  public final int aYq()
  {
    AppMethodBeat.i(187473);
    int i = this.mzC.aYq();
    AppMethodBeat.o(187473);
    return i;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(187465);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(187465);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(187468);
    this.mzC.add(parama, paramLooper);
    AppMethodBeat.o(187468);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(187469);
    this.mzC.add(paramString, parama);
    AppMethodBeat.o(187469);
  }
  
  public final n bzw()
  {
    return (n)d.mzH;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(187471);
    this.mzC.doNotify(paramString);
    AppMethodBeat.o(187471);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(187463);
    k.h(parama, "listener");
    ((ah)this.mzv).add(parama);
    AppMethodBeat.o(187463);
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(187478);
    boolean bool = this.mzC.g(paramList, paramInt);
    AppMethodBeat.o(187478);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(187472);
    int i = this.mzC.getCount();
    AppMethodBeat.o(187472);
    return i;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(187464);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(187464);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.b
 * JD-Core Version:    0.7.0.1
 */