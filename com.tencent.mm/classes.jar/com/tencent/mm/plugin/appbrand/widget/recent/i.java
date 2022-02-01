package com.tencent.mm.plugin.appbrand.widget.recent;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", "query", "count", "", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a<List<? extends LocalUsageInfo>, ag>
  implements ag
{
  public static final i.a uPY;
  
  static
  {
    AppMethodBeat.i(324042);
    uPY = new i.a((byte)0);
    AppMethodBeat.o(324042);
  }
  
  public i(ag paramag)
  {
    super(paramag);
    AppMethodBeat.i(324038);
    this.uPZ = paramag;
    AppMethodBeat.o(324038);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324118);
    if (paramIOnStorageChange != null) {
      e(paramIOnStorageChange);
    }
    AppMethodBeat.o(324118);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(324056);
    this.uPZ.add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(324056);
  }
  
  public final void add(com.tencent.threadpool.j.a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324061);
    this.uPZ.add(parama, paramIOnStorageChange);
    AppMethodBeat.o(324061);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324069);
    this.uPZ.add(paramString, paramIOnStorageChange);
    AppMethodBeat.o(324069);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(324073);
    this.uPZ.addLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(324073);
  }
  
  public final boolean bT(String paramString, int paramInt)
  {
    AppMethodBeat.i(324098);
    boolean bool = this.uPZ.bT(paramString, paramInt);
    AppMethodBeat.o(324098);
    return bool;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(324077);
    this.uPZ.doNotify();
    AppMethodBeat.o(324077);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(324082);
    this.uPZ.doNotify(paramString);
    AppMethodBeat.o(324082);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(324086);
    this.uPZ.doNotify(paramString, paramInt, paramObject);
    AppMethodBeat.o(324086);
  }
  
  public final List<LocalUsageInfo> fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324046);
    List localList = this.uPZ.fg(paramInt1, paramInt2);
    AppMethodBeat.o(324046);
    return localList;
  }
  
  protected final void g(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324110);
    s.u(paramIOnStorageChange, "listener");
    ((ag)cSI()).add(paramIOnStorageChange);
    AppMethodBeat.o(324110);
  }
  
  public final void lock()
  {
    AppMethodBeat.i(324089);
    this.uPZ.lock();
    AppMethodBeat.o(324089);
  }
  
  public final int lockCount()
  {
    AppMethodBeat.i(324091);
    int i = this.uPZ.lockCount();
    AppMethodBeat.o(324091);
    return i;
  }
  
  public final List<LocalUsageInfo> r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(324050);
    List localList = this.uPZ.r(paramLong, paramInt);
    AppMethodBeat.o(324050);
    return localList;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324114);
    if (paramIOnStorageChange != null) {
      f(paramIOnStorageChange);
    }
    AppMethodBeat.o(324114);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(324094);
    this.uPZ.removeLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(324094);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(324103);
    this.uPZ.unlock();
    AppMethodBeat.o(324103);
  }
  
  public final List<LocalUsageInfo> zu(int paramInt)
  {
    AppMethodBeat.i(324107);
    List localList = (List)n(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(324107);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.i
 * JD-Core Version:    0.7.0.1
 */