package com.tencent.mm.loader.e.b;

import com.tencent.mm.loader.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/impr/target/EmptyTarget;", "R", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "()V", "onResourceReadyUI", "", "resource", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", "", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public final class a<R>
  extends d<R>
{
  private static final String TAG = "MicroMsg.Loader.EmptyTarget";
  public static final a kOT = new a((byte)0);
  
  public a()
  {
    super(new g(null));
  }
  
  public final void a(g<?> paramg, f<?, ?> paramf)
  {
    p.k(paramg, "viewWeakHolder");
    p.k(paramf, "request");
  }
  
  protected final boolean a(R paramR, g<?> paramg)
  {
    p.k(paramg, "viewWeakHolder");
    return true;
  }
  
  public final int aRV()
  {
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/impr/target/EmptyTarget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.a
 * JD-Core Version:    0.7.0.1
 */