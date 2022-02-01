package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ReturnCopyUrlWatcherRegister;", "", "()V", "watchers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/CopyType;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IReturnCopyUrlWatcher;", "Lkotlin/collections/HashSet;", "notify", "", "type", "url", "", "register", "delayUnregisterAutomaticallyInMs", "", "watcher", "unregister", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dl
{
  public static final dl rBE;
  private static final Map<ad, HashSet<ak>> rBF;
  
  static
  {
    AppMethodBeat.i(325958);
    rBE = new dl();
    rBF = (Map)new LinkedHashMap();
    AppMethodBeat.o(325958);
  }
  
  public static void a(ad paramad, final ak paramak)
  {
    AppMethodBeat.i(325946);
    s.u(paramad, "type");
    s.u(paramak, "watcher");
    synchronized (rBF)
    {
      Map localMap2 = rBF;
      Object localObject2 = localMap2.get(paramad);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localMap2.put(paramad, localObject1);
      }
      ((HashSet)localObject1).add(paramak);
      c.a(10000L, (a)new a(paramad, paramak));
      AppMethodBeat.o(325946);
      return;
    }
  }
  
  public static void a(ad paramad, String paramString)
  {
    AppMethodBeat.i(325954);
    s.u(paramad, "type");
    s.u(paramString, "url");
    synchronized (rBF)
    {
      HashSet localHashSet = new HashSet();
      Map localMap2 = rBF;
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
        ((ak)paramad.next()).ZS(paramString);
      }
    }
    AppMethodBeat.o(325954);
  }
  
  public static void b(ad paramad, ak paramak)
  {
    AppMethodBeat.i(325950);
    s.u(paramad, "type");
    s.u(paramak, "watcher");
    synchronized (rBF)
    {
      paramad = (HashSet)rBF.get(paramad);
      if (paramad != null) {
        paramad.remove(paramak);
      }
      AppMethodBeat.o(325950);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(ad paramad, ak paramak)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dl
 * JD-Core Version:    0.7.0.1
 */