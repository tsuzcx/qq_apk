package com.tencent.mm.loader.d.b;

import com.tencent.mm.loader.g.c;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "clean", "", "dispatch", "R", "target", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "isNeed", "", "url", "", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "reason", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final String TAG = "MicroMsg.Loader.TargetCenter";
  public static final a nqH = new a((byte)0);
  private static final j<e> nqI = k.cm((kotlin.g.a.a)b.nqJ);
  public ConcurrentHashMap<Integer, r<com.tencent.mm.loader.g.a.a<?>, d<Object>>> evG = new ConcurrentHashMap();
  
  public final void a(d<Object> paramd, com.tencent.mm.loader.g.a.a<?> parama, String paramString)
  {
    s.u(paramd, "target");
    s.u(parama, "data");
    s.u(paramString, "reason");
    paramString = (r)this.evG.get(Integer.valueOf(paramd.blK()));
    if ((paramString != null) && (s.p(paramString.bsC, parama))) {
      this.evG.remove(Integer.valueOf(paramd.blK()));
    }
  }
  
  public final <R> void a(final com.tencent.mm.loader.g.a.a<?> parama, final c<R> paramc)
  {
    s.u(parama, "data");
    s.u(paramc, "result");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, parama, paramc));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static e blM()
    {
      return (e)e.blL().getValue();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<e>
  {
    public static final b nqJ = new b();
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(e parame, com.tencent.mm.loader.g.a.a<?> parama, c<R> paramc)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$1$1$1", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b
    {
      a(e parame, Map.Entry<Integer, ? extends r<? extends com.tencent.mm.loader.g.a.a<?>, ? extends d<Object>>> paramEntry, com.tencent.mm.loader.g.a.a<?> parama) {}
      
      public final void gg(boolean paramBoolean)
      {
        if (paramBoolean) {
          this.nqK.a((d)((r)this.nqN.getValue()).bsD, this.nqL, "onDataItemLoadEnd");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.b.e
 * JD-Core Version:    0.7.0.1
 */