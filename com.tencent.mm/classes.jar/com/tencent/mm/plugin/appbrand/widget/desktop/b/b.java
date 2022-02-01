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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a<List<? extends LocalUsageInfo>, ah>
  implements ah
{
  public static final a lXz;
  
  static
  {
    AppMethodBeat.i(196506);
    lXz = new a((byte)0);
    AppMethodBeat.o(196506);
  }
  
  public b(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(196505);
    this.lXA = paramah;
    AppMethodBeat.o(196505);
  }
  
  public final List<LocalUsageInfo> a(int paramInt, ah.a parama)
  {
    AppMethodBeat.i(196500);
    parama = (List)m(new Object[] { Integer.valueOf(paramInt), parama });
    AppMethodBeat.o(196500);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, ah.a parama, int paramInt2)
  {
    AppMethodBeat.i(196514);
    parama = this.lXA.a(paramInt1, parama, paramInt2);
    AppMethodBeat.o(196514);
    return parama;
  }
  
  public final boolean aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(196513);
    boolean bool = this.lXA.aR(paramString, paramInt);
    AppMethodBeat.o(196513);
    return bool;
  }
  
  public final void aRu()
  {
    AppMethodBeat.i(196515);
    this.lXA.aRu();
    AppMethodBeat.o(196515);
  }
  
  public final int aRv()
  {
    AppMethodBeat.i(196512);
    int i = this.lXA.aRv();
    AppMethodBeat.o(196512);
    return i;
  }
  
  public final int aS(String paramString, int paramInt)
  {
    AppMethodBeat.i(196509);
    paramInt = this.lXA.aS(paramString, paramInt);
    AppMethodBeat.o(196509);
    return paramInt;
  }
  
  public final boolean aT(String paramString, int paramInt)
  {
    AppMethodBeat.i(196516);
    boolean bool = this.lXA.aT(paramString, paramInt);
    AppMethodBeat.o(196516);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(196504);
    if (parama != null) {
      e(parama);
    }
    AppMethodBeat.o(196504);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(196507);
    this.lXA.add(parama, paramLooper);
    AppMethodBeat.o(196507);
  }
  
  public final void add(String paramString, k.a parama)
  {
    AppMethodBeat.i(196508);
    this.lXA.add(paramString, parama);
    AppMethodBeat.o(196508);
  }
  
  public final n bsw()
  {
    return (n)d.lXF;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(196510);
    this.lXA.doNotify(paramString);
    AppMethodBeat.o(196510);
  }
  
  protected final void g(k.a parama)
  {
    AppMethodBeat.i(196502);
    k.h(parama, "listener");
    ((ah)this.lXt).add(parama);
    AppMethodBeat.o(196502);
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(196517);
    boolean bool = this.lXA.g(paramList, paramInt);
    AppMethodBeat.o(196517);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(196511);
    int i = this.lXA.getCount();
    AppMethodBeat.o(196511);
    return i;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(196503);
    if (parama != null) {
      f(parama);
    }
    AppMethodBeat.o(196503);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.b
 * JD-Core Version:    0.7.0.1
 */