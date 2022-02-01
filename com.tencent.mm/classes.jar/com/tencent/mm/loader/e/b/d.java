package com.tencent.mm.loader.e.b;

import android.os.Looper;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "R", "", "weakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getWeakHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setWeakHolder", "onResourceReady", "", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "onResourceReadyUI", "", "viewWeakHolder", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public abstract class d<R>
{
  private static final String TAG = "MicroMsg.Loader.ResourceShowTarget";
  public static final a gkg = new a((byte)0);
  public g<?> gkf;
  
  public d(g<?> paramg)
  {
    this.gkf = paramg;
  }
  
  public abstract void a(g<?> paramg, f<?, ?> paramf);
  
  public final void a(final R paramR, final b paramb)
  {
    k.h(paramb, "waitUI");
    if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE)) {
      ad.i(TAG, "onResourceReady " + paramR + " and this " + this);
    }
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    k.g(localLooper, "Looper.getMainLooper()");
    if (localThread == localLooper.getThread())
    {
      paramb.dB(a(paramR, this.gkf));
      return;
    }
    aq.f((Runnable)new b(this, paramb, paramR));
  }
  
  protected abstract boolean a(R paramR, g<?> paramg);
  
  public abstract int aht();
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "R", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, b paramb, Object paramObject) {}
    
    public final void run()
    {
      paramb.dB(this.gkh.a(paramR, this.gkh.gkf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.d
 * JD-Core Version:    0.7.0.1
 */