package com.tencent.luggage.sdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c evF;
  private static final ConcurrentHashMap<String, b> evG;
  
  static
  {
    AppMethodBeat.i(220232);
    evF = new c();
    evG = new ConcurrentHashMap();
    AppMethodBeat.o(220232);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(220224);
    s.u(paramb, "collection");
    s.u(paramString, "id");
    if ((b)evG.put(paramString, paramb) != null) {
      Log.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(220224);
  }
  
  public static b fC(String paramString)
  {
    AppMethodBeat.i(220221);
    s.u(paramString, "instanceId");
    if (evG.get(paramString) == null)
    {
      b localb = new b();
      ((Map)evG).put(paramString, localb);
    }
    paramString = evG.get(paramString);
    s.checkNotNull(paramString);
    s.s(paramString, "map[instanceId]!!");
    paramString = (b)paramString;
    AppMethodBeat.o(220221);
    return paramString;
  }
  
  public static void fD(String paramString)
  {
    AppMethodBeat.i(220227);
    s.u(paramString, "instanceId");
    paramString = (b)evG.remove(paramString);
    if (paramString != null)
    {
      Log.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
      Iterator localIterator = ((Map)paramString.evD).entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (locala.asN()) {
          locala.cancel();
        }
      }
      paramString.evD.clear();
      localIterator = ((Iterable)paramString.evE).iterator();
      while (localIterator.hasNext()) {
        ((kotlin.g.a.a)localIterator.next()).invoke();
      }
      paramString.evE.clear();
    }
    AppMethodBeat.o(220227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.c
 * JD-Core Version:    0.7.0.1
 */