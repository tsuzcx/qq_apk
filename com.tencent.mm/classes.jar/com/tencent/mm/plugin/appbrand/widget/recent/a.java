package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/recent/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", "listener", "addStorageChangedListenerToDelegate", "queryAndCache", "cacheConfig", "(Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;)Ljava/lang/Object;", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<DATA, DELEGATE_INTERFACE>
{
  public static final a uPG = new a((byte)0);
  private final Map<l, DATA> ctm;
  private DELEGATE_INTERFACE uPH;
  private final Set<MStorage.IOnStorageChange> uPI;
  private final MStorage.IOnStorageChange uPJ;
  
  public a(DELEGATE_INTERFACE paramDELEGATE_INTERFACE)
  {
    this.uPH = paramDELEGATE_INTERFACE;
    this.ctm = ((Map)new LinkedHashMap());
    this.uPI = ((Set)new LinkedHashSet());
    this.uPJ = new a..ExternalSyntheticLambda0(this);
    g(this.uPJ);
  }
  
  private static final void a(a parama, String paramString, MStorageEventData paramMStorageEventData)
  {
    s.u(parama, "this$0");
    Log.i("MicroMsg.AbsAppBrandStorageWithCache", s.X("storage change eventId=", Integer.valueOf(paramMStorageEventData.eventId)));
    s.s(paramMStorageEventData, "eventData");
    if (paramMStorageEventData.eventId != -1) {
      h.ahAA.bn(new a..ExternalSyntheticLambda1(parama, paramString, paramMStorageEventData));
    }
  }
  
  private static final void b(a arg0, String paramString, MStorageEventData paramMStorageEventData)
  {
    s.u(???, "this$0");
    s.u(paramMStorageEventData, "$eventData");
    Log.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
    synchronized ((Iterable)???.uPI)
    {
      Iterator localIterator = ???.iterator();
      if (localIterator.hasNext()) {
        ((MStorage.IOnStorageChange)localIterator.next()).onNotifyChange(paramString, paramMStorageEventData);
      }
    }
    paramString = ah.aiuX;
  }
  
  private static final void c(a parama, String paramString, MStorageEventData paramMStorageEventData)
  {
    s.u(parama, "this$0");
    s.u(paramMStorageEventData, "$eventData");
    Iterator localIterator = ((Iterable)parama.ctm.keySet()).iterator();
    while (localIterator.hasNext()) {
      parama.a((l)localIterator.next());
    }
    h.ahAA.bk(new a..ExternalSyntheticLambda2(parama, paramString, paramMStorageEventData));
  }
  
  public final DATA a(l paraml)
  {
    s.u(paraml, "cacheConfig");
    Object localObject = o(paraml.args);
    synchronized (this.ctm)
    {
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + paraml + ']');
      this.ctm.put(paraml, localObject);
      paraml = ah.aiuX;
      return localObject;
    }
  }
  
  protected final DELEGATE_INTERFACE cSI()
  {
    return this.uPH;
  }
  
  public final void e(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    s.u(paramIOnStorageChange, "listener");
    synchronized (this.uPI)
    {
      this.uPI.add(paramIOnStorageChange);
      return;
    }
  }
  
  public final void f(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    s.u(paramIOnStorageChange, "listener");
    synchronized (this.uPI)
    {
      this.uPI.remove(paramIOnStorageChange);
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", s.X("removed: ", Integer.valueOf(this.uPI.size())));
      paramIOnStorageChange = ah.aiuX;
      return;
    }
  }
  
  protected abstract void g(MStorage.IOnStorageChange paramIOnStorageChange);
  
  protected final DATA n(Object... paramVarArgs)
  {
    s.u(paramVarArgs, "args");
    l locall = new l(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    for (;;)
    {
      synchronized (this.ctm)
      {
        paramVarArgs = this.ctm.get(locall);
        if (paramVarArgs == null)
        {
          paramVarArgs = null;
          ??? = paramVarArgs;
          if (paramVarArgs == null)
          {
            ??? = a(locall);
            Log.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + locall + "], do query through delegate");
          }
          return ???;
        }
      }
      Log.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + locall + ']');
    }
  }
  
  public abstract DATA o(Object[] paramArrayOfObject);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.a
 * JD-Core Version:    0.7.0.1
 */