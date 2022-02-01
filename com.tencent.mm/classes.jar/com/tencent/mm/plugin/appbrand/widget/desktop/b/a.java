package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "queryCacheConfig", "getQueryCacheConfig", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "queryCacheConfig$delegate", "Lkotlin/Lazy;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", "listener", "addStorageChangedListenerToDelegate", "queryAndCache", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"})
public abstract class a<DATA, DELEGATE_INTERFACE>
  implements h<DATA>
{
  public static final a mzw = new a((byte)0);
  private final Map<n, DATA> aMj;
  private final Set<k.a> mzs;
  private final k.a mzt;
  private final f mzu;
  DELEGATE_INTERFACE mzv;
  
  public a(DELEGATE_INTERFACE paramDELEGATE_INTERFACE)
  {
    this.mzv = paramDELEGATE_INTERFACE;
    this.aMj = ((Map)new LinkedHashMap());
    this.mzs = ((Set)new LinkedHashSet());
    this.mzt = ((k.a)new c(this));
    g(this.mzt);
    this.mzu = g.K((d.g.a.a)new b(this));
  }
  
  private final n bzu()
  {
    return (n)this.mzu.getValue();
  }
  
  public final DATA bzv()
  {
    Object localObject1 = o(bzu().args);
    synchronized (this.aMj)
    {
      ac.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + bzu() + ']');
      this.aMj.put(bzu(), localObject1);
      y localy = y.KTp;
      return localObject1;
    }
  }
  
  public final void e(k.a parama)
  {
    k.h(parama, "listener");
    synchronized (this.mzs)
    {
      this.mzs.add(parama);
      return;
    }
  }
  
  public final void f(k.a parama)
  {
    k.h(parama, "listener");
    synchronized (this.mzs)
    {
      this.mzs.remove(parama);
      return;
    }
  }
  
  protected abstract void g(k.a parama);
  
  protected final DATA n(Object... paramVarArgs)
  {
    k.h(paramVarArgs, "args");
    n localn = new n(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    synchronized (this.aMj)
    {
      paramVarArgs = this.aMj.get(localn);
      if (paramVarArgs != null)
      {
        ac.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + localn + ']');
        ??? = paramVarArgs;
        if (paramVarArgs != null) {}
      }
      else
      {
        ??? = bzv();
        ac.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + localn + "], do query through delegate");
      }
      return ???;
    }
  }
  
  protected abstract DATA o(Object[] paramArrayOfObject);
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AbsAppBrandDesktopViewStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "DATA", "DELEGATE_INTERFACE", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<n>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class c
    implements k.a
  {
    c(a parama) {}
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(187458);
      ac.i("MicroMsg.AbsAppBrandStorageWithCache", "storage change eventId=" + paramm.jRj);
      a locala = this.mzx;
      k.g(paramm, "eventData");
      a.a(locala, paramm, paramString);
      AppMethodBeat.o(187458);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, String paramString, m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(187460);
      this.mzx.bzv();
      com.tencent.e.h.JZN.aQ((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187459);
          ac.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
          synchronized ((Iterable)a.a(this.mzA.mzx))
          {
            Iterator localIterator = ???.iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).a(this.mzA.mzy, this.mzA.mzz);
            }
          }
          y localy = y.KTp;
          AppMethodBeat.o(187459);
        }
      });
      AppMethodBeat.o(187460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */