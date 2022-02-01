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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", "query", "count", "", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class i
  extends a<List<? extends LocalUsageInfo>, ah>
  implements ah
{
  public static final i.a rEM;
  
  static
  {
    AppMethodBeat.i(280581);
    rEM = new i.a((byte)0);
    AppMethodBeat.o(280581);
  }
  
  public i(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(280579);
    this.rEN = paramah;
    AppMethodBeat.o(280579);
  }
  
  public final void add(com.tencent.e.j.a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(280583);
    this.rEN.add(parama, paramIOnStorageChange);
    AppMethodBeat.o(280583);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(280578);
    if (paramIOnStorageChange != null) {
      e(paramIOnStorageChange);
    }
    AppMethodBeat.o(280578);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(280582);
    this.rEN.add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(280582);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(280584);
    this.rEN.add(paramString, paramIOnStorageChange);
    AppMethodBeat.o(280584);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(280586);
    this.rEN.addLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(280586);
  }
  
  public final boolean bB(String paramString, int paramInt)
  {
    AppMethodBeat.i(280597);
    boolean bool = this.rEN.bB(paramString, paramInt);
    AppMethodBeat.o(280597);
    return bool;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(280587);
    this.rEN.doNotify();
    AppMethodBeat.o(280587);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(280588);
    this.rEN.doNotify(paramString);
    AppMethodBeat.o(280588);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(280589);
    this.rEN.doNotify(paramString, paramInt, paramObject);
    AppMethodBeat.o(280589);
  }
  
  public final List<LocalUsageInfo> en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(280593);
    List localList = this.rEN.en(paramInt1, paramInt2);
    AppMethodBeat.o(280593);
    return localList;
  }
  
  protected final void g(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(280576);
    p.k(paramIOnStorageChange, "listener");
    ((ah)cqd()).add(paramIOnStorageChange);
    AppMethodBeat.o(280576);
  }
  
  public final List<LocalUsageInfo> i(long paramLong, int paramInt)
  {
    AppMethodBeat.i(280594);
    List localList = this.rEN.i(paramLong, paramInt);
    AppMethodBeat.o(280594);
    return localList;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(280591);
    this.rEN.lock();
    AppMethodBeat.o(280591);
  }
  
  public final int lockCount()
  {
    AppMethodBeat.i(280592);
    int i = this.rEN.lockCount();
    AppMethodBeat.o(280592);
    return i;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(280577);
    if (paramIOnStorageChange != null) {
      f(paramIOnStorageChange);
    }
    AppMethodBeat.o(280577);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(280595);
    this.rEN.removeLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(280595);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(280598);
    this.rEN.unlock();
    AppMethodBeat.o(280598);
  }
  
  public final List<LocalUsageInfo> zh(int paramInt)
  {
    AppMethodBeat.i(280573);
    List localList = (List)l(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(280573);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.i
 * JD-Core Version:    0.7.0.1
 */