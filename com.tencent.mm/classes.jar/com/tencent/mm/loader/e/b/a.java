package com.tencent.mm.loader.e.b;

import com.tencent.mm.loader.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/impr/target/EmptyTarget;", "R", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "()V", "onResourceReadyUI", "", "resource", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", "", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public final class a<R>
  extends d<R>
{
  private static final String TAG = "MicroMsg.Loader.EmptyTarget";
  public static final a.a heF = new a.a((byte)0);
  
  public a()
  {
    super(new g(null));
  }
  
  public final void a(g<?> paramg, f<?, ?> paramf)
  {
    p.h(paramg, "viewWeakHolder");
    p.h(paramf, "request");
  }
  
  protected final boolean a(R paramR, g<?> paramg)
  {
    p.h(paramg, "viewWeakHolder");
    return true;
  }
  
  public final int arh()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.a
 * JD-Core Version:    0.7.0.1
 */