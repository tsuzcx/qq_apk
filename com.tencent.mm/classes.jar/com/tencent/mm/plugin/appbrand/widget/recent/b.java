package com.tencent.mm.plugin.appbrand.widget.recent;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ag.a;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a<List<? extends LocalUsageInfo>, ag>
  implements ag
{
  public static final a oBP;
  
  static
  {
    AppMethodBeat.i(229634);
    oBP = new a((byte)0);
    AppMethodBeat.o(229634);
  }
  
  public b(ag paramag)
  {
    super(paramag);
    AppMethodBeat.i(229633);
    this.oBQ = paramag;
    AppMethodBeat.o(229633);
  }
  
  public final List<LocalUsageInfo> a(int paramInt, ag.a parama)
  {
    AppMethodBeat.i(229628);
    parama = (List)m(new Object[] { Integer.valueOf(paramInt), parama });
    AppMethodBeat.o(229628);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, ag.a parama, int paramInt2)
  {
    AppMethodBeat.i(229648);
    parama = this.oBQ.a(paramInt1, parama, paramInt2);
    AppMethodBeat.o(229648);
    return parama;
  }
  
  public final void add(com.tencent.f.j.a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229636);
    this.oBQ.add(parama, paramIOnStorageChange);
    AppMethodBeat.o(229636);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229632);
    if (paramIOnStorageChange != null) {
      e(paramIOnStorageChange);
    }
    AppMethodBeat.o(229632);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(229635);
    this.oBQ.add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(229635);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229637);
    this.oBQ.add(paramString, paramIOnStorageChange);
    AppMethodBeat.o(229637);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(229639);
    this.oBQ.addLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(229639);
  }
  
  public final boolean bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(229645);
    boolean bool = this.oBQ.bf(paramString, paramInt);
    AppMethodBeat.o(229645);
    return bool;
  }
  
  public final int bg(String paramString, int paramInt)
  {
    AppMethodBeat.i(229638);
    paramInt = this.oBQ.bg(paramString, paramInt);
    AppMethodBeat.o(229638);
    return paramInt;
  }
  
  public final boolean bh(String paramString, int paramInt)
  {
    AppMethodBeat.i(229650);
    boolean bool = this.oBQ.bh(paramString, paramInt);
    AppMethodBeat.o(229650);
    return bool;
  }
  
  public final void bxG()
  {
    AppMethodBeat.i(229649);
    this.oBQ.bxG();
    AppMethodBeat.o(229649);
  }
  
  public final int bxH()
  {
    AppMethodBeat.i(229644);
    int i = this.oBQ.bxH();
    AppMethodBeat.o(229644);
    return i;
  }
  
  public final n ccO()
  {
    return (n)i.oCS;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(229640);
    this.oBQ.doNotify();
    AppMethodBeat.o(229640);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(229641);
    this.oBQ.doNotify(paramString);
    AppMethodBeat.o(229641);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(229642);
    this.oBQ.doNotify(paramString, paramInt, paramObject);
    AppMethodBeat.o(229642);
  }
  
  protected final void g(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229630);
    p.h(paramIOnStorageChange, "listener");
    ((ag)this.oBJ).add(paramIOnStorageChange);
    AppMethodBeat.o(229630);
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(229652);
    boolean bool = this.oBQ.g(paramList, paramInt);
    AppMethodBeat.o(229652);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(229643);
    int i = this.oBQ.getCount();
    AppMethodBeat.o(229643);
    return i;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(229646);
    this.oBQ.lock();
    AppMethodBeat.o(229646);
  }
  
  public final int lockCount()
  {
    AppMethodBeat.i(229647);
    int i = this.oBQ.lockCount();
    AppMethodBeat.o(229647);
    return i;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229631);
    if (paramIOnStorageChange != null) {
      f(paramIOnStorageChange);
    }
    AppMethodBeat.o(229631);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(229651);
    this.oBQ.removeLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(229651);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(229653);
    this.oBQ.unlock();
    AppMethodBeat.o(229653);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.b
 * JD-Core Version:    0.7.0.1
 */