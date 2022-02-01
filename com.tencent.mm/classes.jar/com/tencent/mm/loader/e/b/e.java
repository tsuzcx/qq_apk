package com.tencent.mm.loader.e.b;

import com.tencent.mm.loader.h.c;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "clean", "", "dispatch", "R", "target", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "isNeed", "", "url", "", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "reason", "Companion", "libimageloader_release"})
public final class e
{
  public static final String TAG = "MicroMsg.Loader.TargetCenter";
  private static final f kPd;
  public static final a kPe = new a((byte)0);
  public ConcurrentHashMap<Integer, o<com.tencent.mm.loader.h.a.a<?>, d<Object>>> cDe = new ConcurrentHashMap();
  
  static
  {
    kPd = g.ar((kotlin.g.a.a)b.kPf);
  }
  
  public final void a(d<Object> paramd, com.tencent.mm.loader.h.a.a<?> parama, String paramString)
  {
    p.k(paramd, "target");
    p.k(parama, "data");
    p.k(paramString, "reason");
    paramString = (o)this.cDe.get(Integer.valueOf(paramd.aRV()));
    if ((paramString != null) && (p.h((com.tencent.mm.loader.h.a.a)paramString.Mx, parama))) {
      this.cDe.remove(Integer.valueOf(paramd.aRV()));
    }
  }
  
  public final <R> void a(final com.tencent.mm.loader.h.a.a<?> parama, final c<R> paramc)
  {
    p.k(parama, "data");
    p.k(paramc, "result");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, parama, paramc));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"})
  public static final class a
  {
    public static e aRX()
    {
      f localf = e.aRW();
      a locala = e.kPe;
      return (e)localf.getValue();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<e>
  {
    public static final b kPf = new b();
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(e parame, com.tencent.mm.loader.h.a.a parama, c paramc)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$1$1$1", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release", "com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$$special$$inlined$let$lambda$1"})
    public static final class a
      implements b
    {
      a(Map.Entry paramEntry, e.c paramc) {}
      
      public final void fy(boolean paramBoolean)
      {
        if (paramBoolean) {
          this.kPk.kPg.a((d)((o)this.kPj.getValue()).My, this.kPk.kPh, "onDataItemLoadEnd");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.e
 * JD-Core Version:    0.7.0.1
 */