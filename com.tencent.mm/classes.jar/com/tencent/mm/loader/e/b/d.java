package com.tencent.mm.loader.e.b;

import android.os.Looper;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "R", "", "weakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getWeakHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setWeakHolder", "onResourceReady", "", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "onResourceReadyUI", "", "viewWeakHolder", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public abstract class d<R>
{
  private static final String TAG = "MicroMsg.Loader.ResourceShowTarget";
  public static final d.a hhw = new d.a((byte)0);
  public g<?> hhv;
  
  public d(g<?> paramg)
  {
    this.hhv = paramg;
  }
  
  public abstract void a(g<?> paramg, f<?, ?> paramf);
  
  public final void a(final R paramR, final b paramb)
  {
    p.h(paramb, "waitUI");
    if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
      ae.i(TAG, "onResourceReady " + paramR + " and this " + this);
    }
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if (localThread == localLooper.getThread())
    {
      paramb.ea(a(paramR, this.hhv));
      return;
    }
    ar.f((Runnable)new b(this, paramb, paramR));
  }
  
  protected abstract boolean a(R paramR, g<?> paramg);
  
  public abstract int arw();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "R", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, b paramb, Object paramObject) {}
    
    public final void run()
    {
      paramb.ea(this.hhx.a(paramR, this.hhx.hhv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.d
 * JD-Core Version:    0.7.0.1
 */