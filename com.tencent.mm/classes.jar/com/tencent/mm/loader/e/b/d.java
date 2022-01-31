package com.tencent.mm.loader.e.b;

import a.f.b.j;
import a.l;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "R", "", "weakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getWeakHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setWeakHolder", "onResourceReady", "", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "onResourceReadyUI", "viewWeakHolder", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "uniqueCode", "", "updateBackgroundUI", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public abstract class d<R>
{
  private static final String TAG = "MicroMsg.ResourceShowTarget";
  public static final d.a eOD = new d.a((byte)0);
  public g<?> eOC;
  
  public d(g<?> paramg)
  {
    this.eOC = paramg;
  }
  
  public abstract int TJ();
  
  public abstract void a(g<?> paramg, com.tencent.mm.loader.f<?, ?> paramf);
  
  public final void a(R paramR, b paramb)
  {
    j.q(paramb, "waitUI");
    if ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE)) {
      ab.i(TAG, "onResourceReady " + paramR + " and this " + this);
    }
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    j.p(localLooper, "Looper.getMainLooper()");
    if (localThread == localLooper.getThread())
    {
      a(paramR, this.eOC);
      paramb.Ta();
      return;
    }
    al.d((Runnable)new d.b(this, paramR, paramb));
  }
  
  protected abstract void a(R paramR, g<?> paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.d
 * JD-Core Version:    0.7.0.1
 */