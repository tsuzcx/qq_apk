package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ReturnCopyUrlWatcherRegister;", "", "()V", "watchers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/CopyType;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IReturnCopyUrlWatcher;", "Lkotlin/collections/HashSet;", "notify", "", "type", "url", "", "register", "delayUnregisterAutomaticallyInMs", "", "watcher", "unregister", "luggage-wechat-full-sdk_release"})
public final class da
{
  private static final Map<ad, HashSet<ah>> lCH;
  public static final da lCI;
  
  static
  {
    AppMethodBeat.i(230067);
    lCI = new da();
    lCH = (Map)new LinkedHashMap();
    AppMethodBeat.o(230067);
  }
  
  public static void a(ad paramad, final ah paramah)
  {
    AppMethodBeat.i(230064);
    p.h(paramad, "type");
    p.h(paramah, "watcher");
    synchronized (lCH)
    {
      Map localMap2 = lCH;
      Object localObject2 = localMap2.get(paramad);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localMap2.put(paramad, localObject1);
      }
      ((HashSet)localObject1).add(paramah);
      paramad = (a)new a(paramad, paramah);
      p.h(paramad, "block");
      MMHandlerThread.postToMainThreadDelayed((Runnable)new d(paramad), 10000L);
      AppMethodBeat.o(230064);
      return;
    }
  }
  
  public static void a(ad paramad, String paramString)
  {
    AppMethodBeat.i(230066);
    p.h(paramad, "type");
    p.h(paramString, "url");
    synchronized (lCH)
    {
      HashSet localHashSet = new HashSet();
      Map localMap2 = lCH;
      Object localObject2 = localMap2.get(paramad);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localMap2.put(paramad, localObject1);
      }
      localHashSet.addAll((Collection)localObject1);
      paramad = ((Iterable)localHashSet).iterator();
      if (paramad.hasNext()) {
        ((ah)paramad.next()).Zi(paramString);
      }
    }
    AppMethodBeat.o(230066);
  }
  
  public static void b(ad paramad, ah paramah)
  {
    AppMethodBeat.i(230065);
    p.h(paramad, "type");
    p.h(paramah, "watcher");
    synchronized (lCH)
    {
      paramad = (HashSet)lCH.get(paramad);
      if (paramad != null) {
        paramad.remove(paramah);
      }
      AppMethodBeat.o(230065);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(ad paramad, ah paramah)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.da
 * JD-Core Version:    0.7.0.1
 */