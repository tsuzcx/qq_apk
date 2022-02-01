package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.f.h;
import com.tencent.f.i;
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
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/recent/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "queryCacheConfig", "getQueryCacheConfig", "()Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "queryCacheConfig$delegate", "Lkotlin/Lazy;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", "listener", "addStorageChangedListenerToDelegate", "queryAndCache", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"})
public abstract class a<DATA, DELEGATE_INTERFACE>
  implements m<DATA>
{
  public static final a oBK = new a((byte)0);
  private final Map<n, DATA> aNT;
  private final Set<MStorage.IOnStorageChange> oBG;
  private final MStorage.IOnStorageChange oBH;
  private final f oBI;
  DELEGATE_INTERFACE oBJ;
  
  public a(DELEGATE_INTERFACE paramDELEGATE_INTERFACE)
  {
    this.oBJ = paramDELEGATE_INTERFACE;
    this.aNT = ((Map)new LinkedHashMap());
    this.oBG = ((Set)new LinkedHashSet());
    this.oBH = ((MStorage.IOnStorageChange)new c(this));
    g(this.oBH);
    this.oBI = g.ah((kotlin.g.a.a)new b(this));
  }
  
  private final n ccM()
  {
    return (n)this.oBI.getValue();
  }
  
  public final DATA ccN()
  {
    Object localObject1 = n(ccM().args);
    synchronized (this.aNT)
    {
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + ccM() + ']');
      this.aNT.put(ccM(), localObject1);
      x localx = x.SXb;
      return localObject1;
    }
  }
  
  public final void e(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    p.h(paramIOnStorageChange, "listener");
    synchronized (this.oBG)
    {
      this.oBG.add(paramIOnStorageChange);
      return;
    }
  }
  
  public final void f(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    p.h(paramIOnStorageChange, "listener");
    synchronized (this.oBG)
    {
      this.oBG.remove(paramIOnStorageChange);
      return;
    }
  }
  
  protected abstract void g(MStorage.IOnStorageChange paramIOnStorageChange);
  
  protected final DATA m(Object... paramVarArgs)
  {
    p.h(paramVarArgs, "args");
    n localn = new n(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    synchronized (this.aNT)
    {
      paramVarArgs = this.aNT.get(localn);
      if (paramVarArgs != null)
      {
        Log.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + localn + ']');
        ??? = paramVarArgs;
        if (paramVarArgs != null) {}
      }
      else
      {
        ??? = ccN();
        Log.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + localn + "], do query through delegate");
      }
      return ???;
    }
  }
  
  protected abstract DATA n(Object[] paramArrayOfObject);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "DATA", "DELEGATE_INTERFACE", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<n>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class c
    implements MStorage.IOnStorageChange
  {
    c(a parama) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(229625);
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", "storage change eventId=" + paramMStorageEventData.eventId);
      a locala = this.oBL;
      p.g(paramMStorageEventData, "eventData");
      a.a(locala, paramMStorageEventData, paramString);
      AppMethodBeat.o(229625);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, String paramString, MStorageEventData paramMStorageEventData) {}
    
    public final void run()
    {
      AppMethodBeat.i(229627);
      this.oBL.ccN();
      h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(229626);
          Log.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
          synchronized ((Iterable)a.a(this.oBO.oBL))
          {
            Iterator localIterator = ???.iterator();
            if (localIterator.hasNext()) {
              ((MStorage.IOnStorageChange)localIterator.next()).onNotifyChange(this.oBO.oBM, this.oBO.oBN);
            }
          }
          x localx = x.SXb;
          AppMethodBeat.o(229626);
        }
      });
      AppMethodBeat.o(229627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.a
 * JD-Core Version:    0.7.0.1
 */