package com.tencent.mm.loader.e.b;

import com.tencent.mm.loader.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "clean", "", "dispatch", "R", "target", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "isNeed", "", "url", "", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "reason", "Companion", "libimageloader_release"})
public final class e
{
  private static final String TAG = "MicroMsg.Loader.TargetCenter";
  private static final f iax;
  public static final a iay = new a((byte)0);
  private ConcurrentHashMap<Integer, o<com.tencent.mm.loader.h.a.a<?>, d<Object>>> cCB = new ConcurrentHashMap();
  
  static
  {
    iax = g.ah((kotlin.g.a.a)b.iaz);
  }
  
  public final void a(d<Object> paramd, com.tencent.mm.loader.h.a.a<?> parama)
  {
    p.h(paramd, "target");
    p.h(parama, "data");
    int i = paramd.aJV();
    Log.i(TAG, "register code " + i + " data " + parama);
    this.cCB.put(Integer.valueOf(i), new o(parama, paramd));
  }
  
  public final void a(d<Object> paramd, com.tencent.mm.loader.h.a.a<?> parama, String paramString)
  {
    p.h(paramd, "target");
    p.h(parama, "data");
    p.h(paramString, "reason");
    paramString = (o)this.cCB.get(Integer.valueOf(paramd.aJV()));
    if ((paramString != null) && (p.j((com.tencent.mm.loader.h.a.a)paramString.first, parama))) {
      this.cCB.remove(Integer.valueOf(paramd.aJV()));
    }
  }
  
  public final <R> void a(final com.tencent.mm.loader.h.a.a<?> parama, final c<R> paramc)
  {
    p.h(parama, "data");
    p.h(paramc, "result");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, parama, paramc));
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"})
  public static final class a
  {
    public static e aJX()
    {
      f localf = e.aJW();
      a locala = e.iay;
      return (e)localf.getValue();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<e>
  {
    public static final b iaz = new b();
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(e parame, com.tencent.mm.loader.h.a.a parama, c paramc)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$1$1$1", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release", "com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$$special$$inlined$let$lambda$1"})
    public static final class a
      implements b
    {
      a(Map.Entry paramEntry, e.c paramc) {}
      
      public final void eR(boolean paramBoolean)
      {
        if (paramBoolean) {
          this.iaE.iaA.a((d)((o)this.iaD.getValue()).second, this.iaE.iaB, "onDataItemLoadEnd");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.e
 * JD-Core Version:    0.7.0.1
 */