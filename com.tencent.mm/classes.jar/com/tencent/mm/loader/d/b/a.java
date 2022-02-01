package com.tencent.mm.loader.d.b;

import com.tencent.mm.loader.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/target/EmptyTarget;", "R", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "()V", "onResourceReadyUI", "", "resource", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", "", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<R>
  extends d<R>
{
  private static final String TAG = "MicroMsg.Loader.EmptyTarget";
  public static final a.a nqB = new a.a((byte)0);
  
  public a()
  {
    super(new g(null));
  }
  
  public final void a(g<?> paramg, f<?, ?> paramf)
  {
    s.u(paramg, "viewWeakHolder");
    s.u(paramf, "request");
  }
  
  protected final boolean a(R paramR, g<?> paramg)
  {
    s.u(paramg, "viewWeakHolder");
    return true;
  }
  
  public final int blK()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.b.a
 * JD-Core Version:    0.7.0.1
 */