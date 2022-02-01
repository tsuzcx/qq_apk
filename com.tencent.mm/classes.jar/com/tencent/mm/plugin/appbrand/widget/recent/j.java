package com.tencent.mm.plugin.appbrand.widget.recent;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", "query", "count", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class j
  extends a<List<? extends LocalUsageInfo>, ah>
  implements ah
{
  public static final a oCV;
  
  static
  {
    AppMethodBeat.i(229668);
    oCV = new a((byte)0);
    AppMethodBeat.o(229668);
  }
  
  public j(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(229667);
    this.oCW = paramah;
    AppMethodBeat.o(229667);
  }
  
  public final void add(com.tencent.f.j.a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229670);
    this.oCW.add(parama, paramIOnStorageChange);
    AppMethodBeat.o(229670);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229666);
    if (paramIOnStorageChange != null) {
      e(paramIOnStorageChange);
    }
    AppMethodBeat.o(229666);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(229669);
    this.oCW.add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(229669);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229671);
    this.oCW.add(paramString, paramIOnStorageChange);
    AppMethodBeat.o(229671);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(229672);
    this.oCW.addLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(229672);
  }
  
  public final boolean bi(String paramString, int paramInt)
  {
    AppMethodBeat.i(229680);
    boolean bool = this.oCW.bi(paramString, paramInt);
    AppMethodBeat.o(229680);
    return bool;
  }
  
  public final n ccO()
  {
    return (n)i.oCT;
  }
  
  public final List<LocalUsageInfo> dP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229678);
    List localList = this.oCW.dP(paramInt1, paramInt2);
    AppMethodBeat.o(229678);
    return localList;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(229673);
    this.oCW.doNotify();
    AppMethodBeat.o(229673);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(229674);
    this.oCW.doNotify(paramString);
    AppMethodBeat.o(229674);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(229675);
    this.oCW.doNotify(paramString, paramInt, paramObject);
    AppMethodBeat.o(229675);
  }
  
  protected final void g(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229664);
    p.h(paramIOnStorageChange, "listener");
    ((ah)this.oBJ).add(paramIOnStorageChange);
    AppMethodBeat.o(229664);
  }
  
  public final void lock()
  {
    AppMethodBeat.i(229676);
    this.oCW.lock();
    AppMethodBeat.o(229676);
  }
  
  public final int lockCount()
  {
    AppMethodBeat.i(229677);
    int i = this.oCW.lockCount();
    AppMethodBeat.o(229677);
    return i;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(229665);
    if (paramIOnStorageChange != null) {
      f(paramIOnStorageChange);
    }
    AppMethodBeat.o(229665);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(229679);
    this.oCW.removeLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(229679);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(229681);
    this.oCW.unlock();
    AppMethodBeat.o(229681);
  }
  
  public final List<LocalUsageInfo> vW(int paramInt)
  {
    AppMethodBeat.i(229662);
    List localList = (List)m(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(229662);
    return localList;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.j
 * JD-Core Version:    0.7.0.1
 */