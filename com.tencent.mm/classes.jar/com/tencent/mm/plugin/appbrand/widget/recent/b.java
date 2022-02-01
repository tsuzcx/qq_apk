package com.tencent.mm.plugin.appbrand.widget.recent;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ag.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "username", "versionType", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a<List<? extends LocalUsageInfo>, ag>
  implements ag
{
  public static final b.a rEx;
  
  static
  {
    AppMethodBeat.i(270357);
    rEx = new b.a((byte)0);
    AppMethodBeat.o(270357);
  }
  
  public b(ag paramag)
  {
    super(paramag);
    AppMethodBeat.i(270356);
    this.rEy = paramag;
    AppMethodBeat.o(270356);
  }
  
  public final List<LocalUsageInfo> a(int paramInt, ag.a parama)
  {
    AppMethodBeat.i(270349);
    parama = (List)l(new Object[] { Integer.valueOf(paramInt), parama });
    AppMethodBeat.o(270349);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, ag.a parama, int paramInt2)
  {
    AppMethodBeat.i(270376);
    parama = this.rEy.a(paramInt1, parama, paramInt2);
    AppMethodBeat.o(270376);
    return parama;
  }
  
  public final void add(com.tencent.e.j.a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(270362);
    this.rEy.add(parama, paramIOnStorageChange);
    AppMethodBeat.o(270362);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(270354);
    if (paramIOnStorageChange != null) {
      e(paramIOnStorageChange);
    }
    AppMethodBeat.o(270354);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(270359);
    this.rEy.add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(270359);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(270364);
    this.rEy.add(paramString, paramIOnStorageChange);
    AppMethodBeat.o(270364);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(270365);
    this.rEy.addLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(270365);
  }
  
  public final boolean bA(String paramString, int paramInt)
  {
    AppMethodBeat.i(270377);
    boolean bool = this.rEy.bA(paramString, paramInt);
    AppMethodBeat.o(270377);
    return bool;
  }
  
  public final int bIW()
  {
    AppMethodBeat.i(270371);
    int i = this.rEy.bIW();
    AppMethodBeat.o(270371);
    return i;
  }
  
  public final boolean by(String paramString, int paramInt)
  {
    AppMethodBeat.i(270373);
    boolean bool = this.rEy.by(paramString, paramInt);
    AppMethodBeat.o(270373);
    return bool;
  }
  
  public final int bz(String paramString, int paramInt)
  {
    AppMethodBeat.i(270347);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(270347);
      return -1;
    }
    if (by(paramString, paramInt))
    {
      Log.i("MicroMsg.AppBrandCollectionStorageWithCache", "isCollection reorder");
      localObject = kotlin.a.j.t((Collection)a(h.rEJ.count, h.rEJ.nQx));
      Iterator localIterator = ((List)localObject).iterator();
      i = 0;
      int j;
      if (localIterator.hasNext())
      {
        LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
        if ((p.h(localLocalUsageInfo.username, paramString)) && (localLocalUsageInfo.cBU == paramInt))
        {
          j = 1;
          label141:
          if (j == 0) {
            break label163;
          }
        }
      }
      for (;;)
      {
        if (i >= 0) {
          break label175;
        }
        AppMethodBeat.o(270347);
        return -1;
        j = 0;
        break label141;
        label163:
        i += 1;
        break;
        i = -1;
      }
      label175:
      Log.i("MicroMsg.AppBrandCollectionStorageWithCache", "addCollection exist, remove and insert: " + paramString + " atPos:" + i);
      ((List)localObject).add(0, (LocalUsageInfo)((List)localObject).remove(i));
      if (g((List)localObject, 0))
      {
        AppMethodBeat.o(270347);
        return 0;
      }
      AppMethodBeat.o(270347);
      return -1;
    }
    paramInt = ((ag)cqd()).bz(paramString, paramInt);
    AppMethodBeat.o(270347);
    return paramInt;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(270366);
    this.rEy.doNotify();
    AppMethodBeat.o(270366);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(270367);
    this.rEy.doNotify(paramString);
    AppMethodBeat.o(270367);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(270368);
    this.rEy.doNotify(paramString, paramInt, paramObject);
    AppMethodBeat.o(270368);
  }
  
  protected final void g(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(270351);
    p.k(paramIOnStorageChange, "listener");
    ((ag)cqd()).add(paramIOnStorageChange);
    AppMethodBeat.o(270351);
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(270379);
    boolean bool = this.rEy.g(paramList, paramInt);
    AppMethodBeat.o(270379);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(270369);
    int i = this.rEy.getCount();
    AppMethodBeat.o(270369);
    return i;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(270374);
    this.rEy.lock();
    AppMethodBeat.o(270374);
  }
  
  public final int lockCount()
  {
    AppMethodBeat.i(270375);
    int i = this.rEy.lockCount();
    AppMethodBeat.o(270375);
    return i;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(270353);
    if (paramIOnStorageChange != null) {
      f(paramIOnStorageChange);
    }
    AppMethodBeat.o(270353);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(270378);
    this.rEy.removeLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(270378);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(270380);
    this.rEy.unlock();
    AppMethodBeat.o(270380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.b
 * JD-Core Version:    0.7.0.1
 */