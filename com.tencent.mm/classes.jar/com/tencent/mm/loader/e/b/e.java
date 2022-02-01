package com.tencent.mm.loader.e.b;

import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.z;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "clean", "", "dispatch", "R", "target", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "isNeed", "", "url", "", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "reason", "Companion", "libimageloader_release"})
public final class e
{
  public static final String TAG = "MicroMsg.Loader.TargetCenter";
  private static final f hhA;
  public static final a hhB = new a((byte)0);
  public ConcurrentHashMap<Integer, o<com.tencent.mm.loader.h.a.a<?>, d<Object>>> cqi = new ConcurrentHashMap();
  
  static
  {
    hhA = g.O((d.g.a.a)b.hhC);
  }
  
  public final void a(d<Object> paramd, com.tencent.mm.loader.h.a.a<?> parama, String paramString)
  {
    p.h(paramd, "target");
    p.h(parama, "data");
    p.h(paramString, "reason");
    paramString = (o)this.cqi.get(Integer.valueOf(paramd.arw()));
    if ((paramString != null) && (p.i((com.tencent.mm.loader.h.a.a)paramString.first, parama))) {
      this.cqi.remove(Integer.valueOf(paramd.arw()));
    }
  }
  
  public final <R> void a(final com.tencent.mm.loader.h.a.a<?> parama, final com.tencent.mm.loader.h.c<R> paramc)
  {
    p.h(parama, "data");
    p.h(paramc, "result");
    com.tencent.mm.ac.c.h((d.g.a.a)new c(this, parama, paramc));
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"})
  public static final class a
  {
    public static e ary()
    {
      f localf = e.arx();
      a locala = e.hhB;
      return (e)localf.getValue();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<e>
  {
    public static final b hhC = new b();
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "R", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(e parame, com.tencent.mm.loader.h.a.a parama, com.tencent.mm.loader.h.c paramc)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$1$1$1", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release", "com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$$special$$inlined$let$lambda$1"})
    public static final class a
      implements b
    {
      a(Map.Entry paramEntry, e.c paramc) {}
      
      public final void ea(boolean paramBoolean)
      {
        if (paramBoolean) {
          this.hhH.hhD.a((d)((o)this.hhG.getValue()).second, this.hhH.hhE, "onDataItemLoadEnd");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.e
 * JD-Core Version:    0.7.0.1
 */