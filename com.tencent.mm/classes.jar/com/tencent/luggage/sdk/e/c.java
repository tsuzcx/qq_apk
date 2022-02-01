package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"})
public final class c
{
  private static final ConcurrentHashMap<String, b> cfp;
  public static final c cfq;
  
  static
  {
    AppMethodBeat.i(206204);
    cfq = new c();
    cfp = new ConcurrentHashMap();
    AppMethodBeat.o(206204);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(206202);
    k.h(paramb, "collection");
    k.h(paramString, "id");
    if ((b)cfp.put(paramString, paramb) != null) {
      ac.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(206202);
  }
  
  public static b cm(String paramString)
  {
    AppMethodBeat.i(206201);
    k.h(paramString, "instanceId");
    if (cfp.get(paramString) == null)
    {
      b localb = new b();
      ((Map)cfp).put(paramString, localb);
    }
    paramString = cfp.get(paramString);
    if (paramString == null) {
      k.fOy();
    }
    paramString = (b)paramString;
    AppMethodBeat.o(206201);
    return paramString;
  }
  
  public static void cn(String paramString)
  {
    AppMethodBeat.i(206203);
    k.h(paramString, "instanceId");
    paramString = (b)cfp.remove(paramString);
    if (paramString != null)
    {
      ac.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
      Iterator localIterator = ((Map)paramString.cfm).entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (locala.DM()) {
          locala.cancel();
        }
      }
      paramString.cfm.clear();
      localIterator = ((Iterable)paramString.cfn).iterator();
      while (localIterator.hasNext()) {
        ((d.g.a.a)localIterator.next()).invoke();
      }
      paramString.cfn.clear();
      AppMethodBeat.o(206203);
      return;
    }
    AppMethodBeat.o(206203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.c
 * JD-Core Version:    0.7.0.1
 */