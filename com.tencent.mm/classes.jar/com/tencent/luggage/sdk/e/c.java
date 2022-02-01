package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"})
public final class c
{
  private static final ConcurrentHashMap<String, b> cpF;
  public static final c cpG;
  
  static
  {
    AppMethodBeat.i(192336);
    cpG = new c();
    cpF = new ConcurrentHashMap();
    AppMethodBeat.o(192336);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(192334);
    p.h(paramb, "collection");
    p.h(paramString, "id");
    if ((b)cpF.put(paramString, paramb) != null) {
      ad.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(192334);
  }
  
  public static b jdMethod_do(String paramString)
  {
    AppMethodBeat.i(192333);
    p.h(paramString, "instanceId");
    if (cpF.get(paramString) == null)
    {
      b localb = new b();
      ((Map)cpF).put(paramString, localb);
    }
    paramString = cpF.get(paramString);
    if (paramString == null) {
      p.gfZ();
    }
    paramString = (b)paramString;
    AppMethodBeat.o(192333);
    return paramString;
  }
  
  public static void dp(String paramString)
  {
    AppMethodBeat.i(192335);
    p.h(paramString, "instanceId");
    paramString = (b)cpF.remove(paramString);
    if (paramString != null)
    {
      ad.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
      Iterator localIterator = ((Map)paramString.cpC).entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (locala.Fl()) {
          locala.cancel();
        }
      }
      paramString.cpC.clear();
      localIterator = ((Iterable)paramString.cpD).iterator();
      while (localIterator.hasNext()) {
        ((d.g.a.a)localIterator.next()).invoke();
      }
      paramString.cpD.clear();
      AppMethodBeat.o(192335);
      return;
    }
    AppMethodBeat.o(192335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.c
 * JD-Core Version:    0.7.0.1
 */