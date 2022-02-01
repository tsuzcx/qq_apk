package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "queryCacheConfig", "getQueryCacheConfig", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "queryCacheConfig$delegate", "Lkotlin/Lazy;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", "listener", "addStorageChangedListenerToDelegate", "queryAndCache", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"})
public abstract class a<DATA, DELEGATE_INTERFACE>
  implements h<DATA>
{
  public static final a nfm = new a((byte)0);
  private final Map<n, DATA> aOa;
  private final Set<k.a> nfi;
  private final k.a nfj;
  private final f nfk;
  DELEGATE_INTERFACE nfl;
  
  public a(DELEGATE_INTERFACE paramDELEGATE_INTERFACE)
  {
    this.nfl = paramDELEGATE_INTERFACE;
    this.aOa = ((Map)new LinkedHashMap());
    this.nfi = ((Set)new LinkedHashSet());
    this.nfj = ((k.a)new c(this));
    g(this.nfj);
    this.nfk = g.O((d.g.a.a)new b(this));
  }
  
  private final n bEq()
  {
    return (n)this.nfk.getValue();
  }
  
  public final DATA bEr()
  {
    Object localObject1 = n(bEq().args);
    synchronized (this.aOa)
    {
      ae.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + bEq() + ']');
      this.aOa.put(bEq(), localObject1);
      z localz = z.Nhr;
      return localObject1;
    }
  }
  
  public final void e(k.a parama)
  {
    p.h(parama, "listener");
    synchronized (this.nfi)
    {
      this.nfi.add(parama);
      return;
    }
  }
  
  public final void f(k.a parama)
  {
    p.h(parama, "listener");
    synchronized (this.nfi)
    {
      this.nfi.remove(parama);
      return;
    }
  }
  
  protected abstract void g(k.a parama);
  
  protected final DATA m(Object... paramVarArgs)
  {
    p.h(paramVarArgs, "args");
    n localn = new n(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    synchronized (this.aOa)
    {
      paramVarArgs = this.aOa.get(localn);
      if (paramVarArgs != null)
      {
        ae.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + localn + ']');
        ??? = paramVarArgs;
        if (paramVarArgs != null) {}
      }
      else
      {
        ??? = bEr();
        ae.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + localn + "], do query through delegate");
      }
      return ???;
    }
  }
  
  protected abstract DATA n(Object[] paramArrayOfObject);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "DATA", "DELEGATE_INTERFACE", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<n>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class c
    implements k.a
  {
    c(a parama) {}
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(223961);
      ae.i("MicroMsg.AbsAppBrandStorageWithCache", "storage change eventId=" + paramm.duP);
      a locala = this.nfn;
      p.g(paramm, "eventData");
      a.a(locala, paramm, paramString);
      AppMethodBeat.o(223961);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, String paramString, m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(223963);
      this.nfn.bEr();
      com.tencent.e.h.MqF.aM((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(223962);
          ae.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
          synchronized ((Iterable)a.a(this.nfq.nfn))
          {
            Iterator localIterator = ???.iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).a(this.nfq.nfo, this.nfq.nfp);
            }
          }
          z localz = z.Nhr;
          AppMethodBeat.o(223962);
        }
      });
      AppMethodBeat.o(223963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */