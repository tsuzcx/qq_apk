package com.tencent.mm.loader.e.b;

import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g.b.k;
import d.o;
import d.y;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "clean", "", "dispatch", "R", "target", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "isNeed", "", "url", "", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "reason", "Companion", "libimageloader_release"})
public final class e
{
  public static final String TAG = "MicroMsg.Loader.TargetCenter";
  private static final f gkk;
  public static final a gkl = new a((byte)0);
  public ConcurrentHashMap<Integer, o<com.tencent.mm.loader.h.a.a<?>, d<Object>>> cit = new ConcurrentHashMap();
  
  static
  {
    gkk = d.g.E((d.g.a.a)b.gkm);
  }
  
  public final void a(d<Object> paramd, com.tencent.mm.loader.h.a.a<?> parama, String paramString)
  {
    k.h(paramd, "target");
    k.h(parama, "data");
    k.h(paramString, "reason");
    o localo = (o)this.cit.get(Integer.valueOf(paramd.aht()));
    if (localo != null)
    {
      if (k.g((com.tencent.mm.loader.h.a.a)localo.first, parama))
      {
        this.cit.remove(Integer.valueOf(paramd.aht()));
        ad.i(TAG, "unregister " + paramd + " and code " + paramd.aht() + " data " + parama + " and remove done " + paramString + "  try get: " + paramd.gkf.get());
      }
    }
    else {
      return;
    }
    ad.i(TAG, "unregister " + paramd + " and code " + paramd.aht() + " data " + parama + " no need remove " + paramString + "  try get: " + paramd.gkf.get());
  }
  
  public final <R> void a(final com.tencent.mm.loader.h.a.a<?> parama, final com.tencent.mm.loader.h.c<R> paramc)
  {
    k.h(parama, "data");
    k.h(paramc, "result");
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, parama, paramc));
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"})
  public static final class a
  {
    public static e ahv()
    {
      f localf = e.ahu();
      a locala = e.gkl;
      return (e)localf.getValue();
    }
    
    public static String getTAG()
    {
      return e.access$getTAG$cp();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<e>
  {
    public static final b gkm = new b();
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "R", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(e parame, com.tencent.mm.loader.h.a.a parama, com.tencent.mm.loader.h.c paramc)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$1$1$1", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release", "com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$$special$$inlined$let$lambda$1"})
    public static final class a
      implements b
    {
      a(Map.Entry paramEntry, e.c paramc) {}
      
      public final void dB(boolean paramBoolean)
      {
        if (paramBoolean) {
          this.gkr.gkn.a((d)((o)this.gkq.getValue()).second, this.gkr.gko, "onDataItemLoadEnd");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.e
 * JD-Core Version:    0.7.0.1
 */