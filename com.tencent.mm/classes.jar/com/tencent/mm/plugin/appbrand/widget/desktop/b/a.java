package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "queryCacheConfig", "getQueryCacheConfig", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "queryCacheConfig$delegate", "Lkotlin/Lazy;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", "listener", "addStorageChangedListenerToDelegate", "queryAndCache", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"})
public abstract class a<DATA, DELEGATE_INTERFACE>
  implements h<DATA>
{
  public static final a nae = new a((byte)0);
  private final Map<n, DATA> aOa;
  private final Set<k.a> naa;
  private final k.a nab;
  private final f nac;
  DELEGATE_INTERFACE nad;
  
  public a(DELEGATE_INTERFACE paramDELEGATE_INTERFACE)
  {
    this.nad = paramDELEGATE_INTERFACE;
    this.aOa = ((Map)new LinkedHashMap());
    this.naa = ((Set)new LinkedHashSet());
    this.nab = ((k.a)new c(this));
    g(this.nab);
    this.nac = g.O((d.g.a.a)new b(this));
  }
  
  private final n bDy()
  {
    return (n)this.nac.getValue();
  }
  
  public final DATA bDz()
  {
    Object localObject1 = o(bDy().args);
    synchronized (this.aOa)
    {
      ad.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + bDy() + ']');
      this.aOa.put(bDy(), localObject1);
      z localz = z.MKo;
      return localObject1;
    }
  }
  
  public final void e(k.a parama)
  {
    p.h(parama, "listener");
    synchronized (this.naa)
    {
      this.naa.add(parama);
      return;
    }
  }
  
  public final void f(k.a parama)
  {
    p.h(parama, "listener");
    synchronized (this.naa)
    {
      this.naa.remove(parama);
      return;
    }
  }
  
  protected abstract void g(k.a parama);
  
  protected final DATA n(Object... paramVarArgs)
  {
    p.h(paramVarArgs, "args");
    n localn = new n(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    synchronized (this.aOa)
    {
      paramVarArgs = this.aOa.get(localn);
      if (paramVarArgs != null)
      {
        ad.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + localn + ']');
        ??? = paramVarArgs;
        if (paramVarArgs != null) {}
      }
      else
      {
        ??? = bDz();
        ad.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + localn + "], do query through delegate");
      }
      return ???;
    }
  }
  
  protected abstract DATA o(Object[] paramArrayOfObject);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "DATA", "DELEGATE_INTERFACE", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<n>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class c
    implements k.a
  {
    c(a parama) {}
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(189689);
      ad.i("MicroMsg.AbsAppBrandStorageWithCache", "storage change eventId=" + paramm.dtK);
      a locala = this.naf;
      p.g(paramm, "eventData");
      a.a(locala, paramm, paramString);
      AppMethodBeat.o(189689);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, String paramString, m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(189691);
      this.naf.bDz();
      com.tencent.e.h.LTJ.aP((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189690);
          ad.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
          synchronized ((Iterable)a.a(this.nai.naf))
          {
            Iterator localIterator = ???.iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).a(this.nai.nag, this.nai.nah);
            }
          }
          z localz = z.MKo;
          AppMethodBeat.o(189690);
        }
      });
      AppMethodBeat.o(189691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */