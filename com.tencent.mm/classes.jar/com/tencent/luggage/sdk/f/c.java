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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"})
public final class c
{
  private static final ConcurrentHashMap<String, b> cDe;
  public static final c cDf;
  
  static
  {
    AppMethodBeat.i(241590);
    cDf = new c();
    cDe = new ConcurrentHashMap();
    AppMethodBeat.o(241590);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(241583);
    p.k(paramb, "collection");
    p.k(paramString, "id");
    if ((b)cDe.put(paramString, paramb) != null) {
      Log.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(241583);
  }
  
  public static b ej(String paramString)
  {
    AppMethodBeat.i(241580);
    p.k(paramString, "instanceId");
    if (cDe.get(paramString) == null)
    {
      b localb = new b();
      ((Map)cDe).put(paramString, localb);
    }
    paramString = cDe.get(paramString);
    if (paramString == null) {
      p.iCn();
    }
    paramString = (b)paramString;
    AppMethodBeat.o(241580);
    return paramString;
  }
  
  public static void ek(String paramString)
  {
    AppMethodBeat.i(241587);
    p.k(paramString, "instanceId");
    paramString = (b)cDe.remove(paramString);
    if (paramString != null)
    {
      Log.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
      Iterator localIterator = ((Map)paramString.cDb).entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (locala.Sx()) {
          locala.cancel();
        }
      }
      paramString.cDb.clear();
      localIterator = ((Iterable)paramString.cDc).iterator();
      while (localIterator.hasNext()) {
        ((kotlin.g.a.a)localIterator.next()).invoke();
      }
      paramString.cDc.clear();
      AppMethodBeat.o(241587);
      return;
    }
    AppMethodBeat.o(241587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.c
 * JD-Core Version:    0.7.0.1
 */