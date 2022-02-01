package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.k.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/ReturnCopyUrlWatcherRegister;", "", "()V", "watchers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/CopyType;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IReturnCopyUrlWatcher;", "Lkotlin/collections/HashSet;", "notify", "", "type", "url", "", "register", "delayUnregisterAutomaticallyInMs", "", "watcher", "unregister", "luggage-wechat-full-sdk_release"})
public final class db
{
  private static final Map<ac, HashSet<ah>> oyh;
  public static final db oyi;
  
  static
  {
    AppMethodBeat.i(236501);
    oyi = new db();
    oyh = (Map)new LinkedHashMap();
    AppMethodBeat.o(236501);
  }
  
  public static void a(ac paramac, final ah paramah)
  {
    AppMethodBeat.i(236493);
    p.k(paramac, "type");
    p.k(paramah, "watcher");
    synchronized (oyh)
    {
      Map localMap2 = oyh;
      Object localObject2 = localMap2.get(paramac);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localMap2.put(paramac, localObject1);
      }
      ((HashSet)localObject1).add(paramah);
      paramac = (a)new a(paramac, paramah);
      p.k(paramac, "block");
      MMHandlerThread.postToMainThreadDelayed((Runnable)new d(paramac), 10000L);
      AppMethodBeat.o(236493);
      return;
    }
  }
  
  public static void a(ac paramac, String paramString)
  {
    AppMethodBeat.i(236500);
    p.k(paramac, "type");
    p.k(paramString, "url");
    synchronized (oyh)
    {
      HashSet localHashSet = new HashSet();
      Map localMap2 = oyh;
      Object localObject2 = localMap2.get(paramac);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localMap2.put(paramac, localObject1);
      }
      localHashSet.addAll((Collection)localObject1);
      paramac = ((Iterable)localHashSet).iterator();
      if (paramac.hasNext()) {
        ((ah)paramac.next()).agV(paramString);
      }
    }
    AppMethodBeat.o(236500);
  }
  
  public static void b(ac paramac, ah paramah)
  {
    AppMethodBeat.i(236497);
    p.k(paramac, "type");
    p.k(paramah, "watcher");
    synchronized (oyh)
    {
      paramac = (HashSet)oyh.get(paramac);
      if (paramac != null) {
        paramac.remove(paramah);
      }
      AppMethodBeat.o(236497);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(ac paramac, ah paramah)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.db
 * JD-Core Version:    0.7.0.1
 */