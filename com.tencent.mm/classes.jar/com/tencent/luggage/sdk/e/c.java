package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"})
public final class c
{
  private static final ConcurrentHashMap<String, b> cqi;
  public static final c cqj;
  
  static
  {
    AppMethodBeat.i(220938);
    cqj = new c();
    cqi = new ConcurrentHashMap();
    AppMethodBeat.o(220938);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(220936);
    p.h(paramb, "collection");
    p.h(paramString, "id");
    if ((b)cqi.put(paramString, paramb) != null) {
      ae.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(220936);
  }
  
  public static b dq(String paramString)
  {
    AppMethodBeat.i(220935);
    p.h(paramString, "instanceId");
    if (cqi.get(paramString) == null)
    {
      b localb = new b();
      ((Map)cqi).put(paramString, localb);
    }
    paramString = cqi.get(paramString);
    if (paramString == null) {
      p.gkB();
    }
    paramString = (b)paramString;
    AppMethodBeat.o(220935);
    return paramString;
  }
  
  public static void dr(String paramString)
  {
    AppMethodBeat.i(220937);
    p.h(paramString, "instanceId");
    paramString = (b)cqi.remove(paramString);
    if (paramString != null)
    {
      ae.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
      Iterator localIterator = ((Map)paramString.cqf).entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (locala.Fq()) {
          locala.cancel();
        }
      }
      paramString.cqf.clear();
      localIterator = ((Iterable)paramString.cqg).iterator();
      while (localIterator.hasNext()) {
        ((d.g.a.a)localIterator.next()).invoke();
      }
      paramString.cqg.clear();
      AppMethodBeat.o(220937);
      return;
    }
    AppMethodBeat.o(220937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.c
 * JD-Core Version:    0.7.0.1
 */