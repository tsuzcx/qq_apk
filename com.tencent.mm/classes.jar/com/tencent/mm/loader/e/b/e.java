package com.tencent.mm.loader.e.b;

import a.f;
import a.f.b.j;
import a.g;
import a.l;
import a.o;
import a.v;
import com.tencent.mm.loader.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "clean", "", "dispatch", "R", "target", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "isNeed", "", "url", "", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "reason", "Companion", "libimageloader_release"})
public final class e
{
  public static final String TAG = "MicroMsg.Loader.TargetCenter";
  private static final f eOH;
  public static final e.a eOI = new e.a((byte)0);
  public ConcurrentHashMap<Integer, o<com.tencent.mm.loader.h.a.a<?>, d<Object>>> map = new ConcurrentHashMap();
  
  static
  {
    eOH = g.j((a.f.a.a)e.b.eOK);
  }
  
  public final void a(d<Object> paramd, com.tencent.mm.loader.h.a.a<?> parama, String paramString)
  {
    j.q(paramd, "target");
    j.q(parama, "data");
    j.q(paramString, "reason");
    o localo = (o)this.map.get(Integer.valueOf(paramd.TJ()));
    if (localo != null)
    {
      if (j.e((com.tencent.mm.loader.h.a.a)localo.first, parama))
      {
        this.map.remove(Integer.valueOf(paramd.TJ()));
        ab.i(TAG, "unregister " + paramd + " and code " + paramd.TJ() + " data " + parama + " and remove done " + paramString);
      }
    }
    else {
      return;
    }
    ab.i(TAG, "unregister " + paramd + " and code " + paramd.TJ() + " data " + parama + " no need remove " + paramString);
  }
  
  public final <R> void a(com.tencent.mm.loader.h.a.a<?> parama, c<R> paramc)
  {
    j.q(parama, "data");
    j.q(paramc, "result");
    Object localObject2 = (Map)this.map;
    Object localObject1 = new LinkedHashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (j.e((com.tencent.mm.loader.h.a.a)((o)((Map.Entry)localObject3).getValue()).first, parama)) {
        ((LinkedHashMap)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
      }
    }
    localObject1 = (Map)localObject1;
    if (((Map)localObject1).isEmpty()) {
      ab.i(TAG, "onDataItemLoadEnd can not found ".concat(String.valueOf(parama)));
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = paramc.value;
      if (localObject3 != null)
      {
        d locald = (d)((o)((Map.Entry)localObject2).getValue()).second;
        localObject2 = (b)new e.c((Map.Entry)localObject2, this, paramc, parama);
        ab.i(TAG, "dispatch " + locald + " resource " + localObject3);
        if (localObject3 == null) {}
        try
        {
          throw new v("null cannot be cast to non-null type kotlin.Any");
        }
        catch (Exception localException)
        {
          ab.i(TAG, "exception " + localException.getMessage());
          ((b)localObject2).Ta();
          continue;
          locald.a(localException, (b)localObject2);
          ((b)localObject2).Ta();
        }
        finally
        {
          ((b)localObject2).Ta();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.e
 * JD-Core Version:    0.7.0.1
 */