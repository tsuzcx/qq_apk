package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.b.k;
import d.y;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "queryCacheConfig", "getQueryCacheConfig", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "queryCacheConfig$delegate", "Lkotlin/Lazy;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", "listener", "addStorageChangedListenerToDelegate", "queryAndCache", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"})
public abstract class a<DATA, DELEGATE_INTERFACE>
  implements h<DATA>
{
  public static final a lXu = new a((byte)0);
  private final Map<n, DATA> aLt;
  private final Set<k.a> lXq;
  private final k.a lXr;
  private final f lXs;
  DELEGATE_INTERFACE lXt;
  
  public a(DELEGATE_INTERFACE paramDELEGATE_INTERFACE)
  {
    this.lXt = paramDELEGATE_INTERFACE;
    this.aLt = ((Map)new LinkedHashMap());
    this.lXq = ((Set)new LinkedHashSet());
    this.lXr = ((k.a)new c(this));
    g(this.lXr);
    this.lXs = g.E((d.g.a.a)new b(this));
  }
  
  private final n bsu()
  {
    return (n)this.lXs.getValue();
  }
  
  public final DATA bsv()
  {
    Object localObject1 = n(bsu().args);
    synchronized (this.aLt)
    {
      ad.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + bsu() + ']');
      this.aLt.put(bsu(), localObject1);
      y localy = y.JfV;
      return localObject1;
    }
  }
  
  public final void e(k.a parama)
  {
    k.h(parama, "listener");
    synchronized (this.lXq)
    {
      this.lXq.add(parama);
      return;
    }
  }
  
  public final void f(k.a parama)
  {
    k.h(parama, "listener");
    synchronized (this.lXq)
    {
      this.lXq.remove(parama);
      return;
    }
  }
  
  protected abstract void g(k.a parama);
  
  protected final DATA m(Object... paramVarArgs)
  {
    k.h(paramVarArgs, "args");
    n localn = new n(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    synchronized (this.aLt)
    {
      paramVarArgs = this.aLt.get(localn);
      if (paramVarArgs != null)
      {
        ad.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + localn + ']');
        ??? = paramVarArgs;
        if (paramVarArgs != null) {}
      }
      else
      {
        ??? = bsv();
        ad.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + localn + "], do query through delegate");
      }
      return ???;
    }
  }
  
  protected abstract DATA n(Object[] paramArrayOfObject);
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "DATA", "DELEGATE_INTERFACE", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<n>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class c
    implements k.a
  {
    c(a parama) {}
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(196497);
      ad.i("MicroMsg.AbsAppBrandStorageWithCache", "storage change eventId=" + paramm.jqR);
      a locala = this.lXv;
      k.g(paramm, "eventData");
      a.a(locala, paramm, paramString);
      AppMethodBeat.o(196497);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, String paramString, m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(196499);
      this.lXv.bsv();
      com.tencent.e.h.Iye.aN((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196498);
          ad.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
          synchronized ((Iterable)a.a(this.lXy.lXv))
          {
            Iterator localIterator = ???.iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).a(this.lXy.lXw, this.lXy.lXx);
            }
          }
          y localy = y.JfV;
          AppMethodBeat.o(196498);
        }
      });
      AppMethodBeat.o(196499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */