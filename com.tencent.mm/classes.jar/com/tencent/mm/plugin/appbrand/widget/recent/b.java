package com.tencent.mm.plugin.appbrand.widget.recent;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "listener", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "username", "versionType", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "isCollectionForAppId", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a<List<? extends LocalUsageInfo>, af>
  implements af
{
  public static final b.a uPK;
  
  static
  {
    AppMethodBeat.i(324066);
    uPK = new b.a((byte)0);
    AppMethodBeat.o(324066);
  }
  
  public b(af paramaf)
  {
    super(paramaf);
    AppMethodBeat.i(324060);
    this.uPL = paramaf;
    AppMethodBeat.o(324060);
  }
  
  public final List<LocalUsageInfo> a(int paramInt, af.a parama)
  {
    AppMethodBeat.i(324141);
    parama = (List)n(new Object[] { Integer.valueOf(paramInt), parama });
    AppMethodBeat.o(324141);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, af.a parama, int paramInt2)
  {
    AppMethodBeat.i(324071);
    parama = this.uPL.a(paramInt1, parama, paramInt2);
    AppMethodBeat.o(324071);
    return parama;
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324151);
    if (paramIOnStorageChange != null) {
      e(paramIOnStorageChange);
    }
    AppMethodBeat.o(324151);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(324075);
    this.uPL.add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(324075);
  }
  
  public final void add(com.tencent.threadpool.j.a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324081);
    this.uPL.add(parama, paramIOnStorageChange);
    AppMethodBeat.o(324081);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324085);
    this.uPL.add(paramString, paramIOnStorageChange);
    AppMethodBeat.o(324085);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(324090);
    this.uPL.addLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(324090);
  }
  
  public final boolean bP(String paramString, int paramInt)
  {
    AppMethodBeat.i(324112);
    boolean bool = this.uPL.bP(paramString, paramInt);
    AppMethodBeat.o(324112);
    return bool;
  }
  
  public final boolean bQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(324115);
    boolean bool = this.uPL.bQ(paramString, paramInt);
    AppMethodBeat.o(324115);
    return bool;
  }
  
  public final int bR(String paramString, int paramInt)
  {
    AppMethodBeat.i(324139);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(324139);
      return -1;
    }
    if (bP(paramString, paramInt))
    {
      Log.i("MicroMsg.AppBrandCollectionStorageWithCache", "isCollection reorder");
      localObject = p.J((Collection)a(h.uPW.count, h.uPW.qQm));
      Iterator localIterator = ((List)localObject).iterator();
      i = 0;
      int j;
      if (localIterator.hasNext())
      {
        LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
        if ((s.p(localLocalUsageInfo.username, paramString)) && (localLocalUsageInfo.euz == paramInt))
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
        AppMethodBeat.o(324139);
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
      ((List)localObject).add((LocalUsageInfo)((List)localObject).remove(i));
      if (p((List)localObject, 0))
      {
        AppMethodBeat.o(324139);
        return 0;
      }
      AppMethodBeat.o(324139);
      return -1;
    }
    paramInt = ((af)cSI()).bR(paramString, paramInt);
    AppMethodBeat.o(324139);
    return paramInt;
  }
  
  public final boolean bS(String paramString, int paramInt)
  {
    AppMethodBeat.i(324124);
    boolean bool = this.uPL.bS(paramString, paramInt);
    AppMethodBeat.o(324124);
    return bool;
  }
  
  public final int ciA()
  {
    AppMethodBeat.i(324109);
    int i = this.uPL.ciA();
    AppMethodBeat.o(324109);
    return i;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(324093);
    this.uPL.doNotify();
    AppMethodBeat.o(324093);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(324097);
    this.uPL.doNotify(paramString);
    AppMethodBeat.o(324097);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(324101);
    this.uPL.doNotify(paramString, paramInt, paramObject);
    AppMethodBeat.o(324101);
  }
  
  protected final void g(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324145);
    s.u(paramIOnStorageChange, "listener");
    ((af)cSI()).add(paramIOnStorageChange);
    AppMethodBeat.o(324145);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(324106);
    int i = this.uPL.getCount();
    AppMethodBeat.o(324106);
    return i;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(324119);
    this.uPL.lock();
    AppMethodBeat.o(324119);
  }
  
  public final int lockCount()
  {
    AppMethodBeat.i(324120);
    int i = this.uPL.lockCount();
    AppMethodBeat.o(324120);
    return i;
  }
  
  public final boolean p(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(324131);
    boolean bool = this.uPL.p(paramList, paramInt);
    AppMethodBeat.o(324131);
    return bool;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(324147);
    if (paramIOnStorageChange != null) {
      f(paramIOnStorageChange);
    }
    AppMethodBeat.o(324147);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(324130);
    this.uPL.removeLoadedListener(paramIOnStorageLoaded);
    AppMethodBeat.o(324130);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(324133);
    this.uPL.unlock();
    AppMethodBeat.o(324133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.b
 * JD-Core Version:    0.7.0.1
 */