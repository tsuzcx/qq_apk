package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"})
public final class c
{
  private static final ConcurrentHashMap<String, b> cit;
  public static final c ciu;
  
  static
  {
    AppMethodBeat.i(186850);
    ciu = new c();
    cit = new ConcurrentHashMap();
    AppMethodBeat.o(186850);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(186848);
    k.h(paramb, "collection");
    k.h(paramString, "id");
    if ((b)cit.put(paramString, paramb) != null) {
      ad.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(186848);
  }
  
  public static b cx(String paramString)
  {
    AppMethodBeat.i(186847);
    k.h(paramString, "instanceId");
    if (cit.get(paramString) == null)
    {
      b localb = new b();
      ((Map)cit).put(paramString, localb);
    }
    paramString = cit.get(paramString);
    if (paramString == null) {
      k.fvU();
    }
    paramString = (b)paramString;
    AppMethodBeat.o(186847);
    return paramString;
  }
  
  public static void cy(String paramString)
  {
    AppMethodBeat.i(186849);
    k.h(paramString, "instanceId");
    paramString = (b)cit.remove(paramString);
    if (paramString != null)
    {
      ad.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
      Iterator localIterator = ((Map)paramString.ciq).entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (locala.Ej()) {
          locala.cancel();
        }
      }
      paramString.ciq.clear();
      localIterator = ((Iterable)paramString.cir).iterator();
      while (localIterator.hasNext()) {
        ((d.g.a.a)localIterator.next()).invoke();
      }
      paramString.cir.clear();
      AppMethodBeat.o(186849);
      return;
    }
    AppMethodBeat.o(186849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.c
 * JD-Core Version:    0.7.0.1
 */