package com.tencent.luggage.sdk.e;

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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"})
public final class c
{
  private static final ConcurrentHashMap<String, b> cCB;
  public static final c cCC;
  
  static
  {
    AppMethodBeat.i(230048);
    cCC = new c();
    cCB = new ConcurrentHashMap();
    AppMethodBeat.o(230048);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(230046);
    p.h(paramb, "collection");
    p.h(paramString, "id");
    if ((b)cCB.put(paramString, paramb) != null) {
      Log.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(230046);
  }
  
  public static b dJ(String paramString)
  {
    AppMethodBeat.i(230045);
    p.h(paramString, "instanceId");
    if (cCB.get(paramString) == null)
    {
      b localb = new b();
      ((Map)cCB).put(paramString, localb);
    }
    paramString = cCB.get(paramString);
    if (paramString == null) {
      p.hyc();
    }
    paramString = (b)paramString;
    AppMethodBeat.o(230045);
    return paramString;
  }
  
  public static void dK(String paramString)
  {
    AppMethodBeat.i(230047);
    p.h(paramString, "instanceId");
    paramString = (b)cCB.remove(paramString);
    if (paramString != null)
    {
      Log.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
      Iterator localIterator = ((Map)paramString.cCy).entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (locala.OZ()) {
          locala.cancel();
        }
      }
      paramString.cCy.clear();
      localIterator = ((Iterable)paramString.cCz).iterator();
      while (localIterator.hasNext()) {
        ((kotlin.g.a.a)localIterator.next()).invoke();
      }
      paramString.cCz.clear();
      AppMethodBeat.o(230047);
      return;
    }
    AppMethodBeat.o(230047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.c
 * JD-Core Version:    0.7.0.1
 */