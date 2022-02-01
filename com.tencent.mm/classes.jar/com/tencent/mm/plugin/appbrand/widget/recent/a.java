package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/recent/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", "listener", "addStorageChangedListenerToDelegate", "queryAndCache", "cacheConfig", "(Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;)Ljava/lang/Object;", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"})
public abstract class a<DATA, DELEGATE_INTERFACE>
{
  public static final a.a rEs = new a.a((byte)0);
  private final Map<l, DATA> axy;
  private final Set<MStorage.IOnStorageChange> rEp;
  private final MStorage.IOnStorageChange rEq;
  private DELEGATE_INTERFACE rEr;
  
  public a(DELEGATE_INTERFACE paramDELEGATE_INTERFACE)
  {
    this.rEr = paramDELEGATE_INTERFACE;
    this.axy = ((Map)new LinkedHashMap());
    this.rEp = ((Set)new LinkedHashSet());
    this.rEq = ((MStorage.IOnStorageChange)new b(this));
    g(this.rEq);
  }
  
  public final DATA a(l paraml)
  {
    p.k(paraml, "cacheConfig");
    Object localObject = m(paraml.args);
    synchronized (this.axy)
    {
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + paraml + ']');
      this.axy.put(paraml, localObject);
      paraml = x.aazN;
      return localObject;
    }
  }
  
  protected final DELEGATE_INTERFACE cqd()
  {
    return this.rEr;
  }
  
  public final void e(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    p.k(paramIOnStorageChange, "listener");
    synchronized (this.rEp)
    {
      this.rEp.add(paramIOnStorageChange);
      return;
    }
  }
  
  public final void f(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    p.k(paramIOnStorageChange, "listener");
    synchronized (this.rEp)
    {
      this.rEp.remove(paramIOnStorageChange);
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", "removed: " + this.rEp.size());
      paramIOnStorageChange = x.aazN;
      return;
    }
  }
  
  protected abstract void g(MStorage.IOnStorageChange paramIOnStorageChange);
  
  protected final DATA l(Object... paramVarArgs)
  {
    p.k(paramVarArgs, "args");
    l locall = new l(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    synchronized (this.axy)
    {
      paramVarArgs = this.axy.get(locall);
      if (paramVarArgs != null)
      {
        Log.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + locall + ']');
        ??? = paramVarArgs;
        if (paramVarArgs != null) {}
      }
      else
      {
        ??? = a(locall);
        Log.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + locall + "], do query through delegate");
      }
      return ???;
    }
  }
  
  public abstract DATA m(Object[] paramArrayOfObject);
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class b
    implements MStorage.IOnStorageChange
  {
    b(a parama) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(281119);
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", "storage change eventId=" + paramMStorageEventData.eventId);
      a locala = this.rEt;
      p.j(paramMStorageEventData, "eventData");
      a.a(locala, paramMStorageEventData, paramString);
      AppMethodBeat.o(281119);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, String paramString, MStorageEventData paramMStorageEventData) {}
    
    public final void run()
    {
      AppMethodBeat.i(272381);
      Iterator localIterator = ((Iterable)a.a(this.rEt).keySet()).iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        this.rEt.a(locall);
      }
      h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268283);
          Log.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
          synchronized ((Iterable)a.b(this.rEw.rEt))
          {
            Iterator localIterator = ???.iterator();
            if (localIterator.hasNext()) {
              ((MStorage.IOnStorageChange)localIterator.next()).onNotifyChange(this.rEw.rEu, this.rEw.rEv);
            }
          }
          x localx = x.aazN;
          AppMethodBeat.o(268283);
        }
      });
      AppMethodBeat.o(272381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.a
 * JD-Core Version:    0.7.0.1
 */