package com.tencent.mm.loader.d.b;

import android.os.Looper;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "R", "", "weakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getWeakHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setWeakHolder", "onResourceReady", "", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "onResourceReadyUI", "", "viewWeakHolder", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<R>
{
  private static final String TAG = "MicroMsg.Loader.ResourceShowTarget";
  public static final d.a nqF = new d.a((byte)0);
  public g<?> nqG;
  
  public d(g<?> paramg)
  {
    this.nqG = paramg;
  }
  
  private static final void a(b paramb, d paramd, Object paramObject)
  {
    s.u(paramb, "$waitUI");
    s.u(paramd, "this$0");
    paramb.gg(paramd.a(paramObject, paramd.nqG));
  }
  
  public abstract void a(g<?> paramg, f<?, ?> paramf);
  
  public final void a(R paramR, b paramb)
  {
    s.u(paramb, "waitUI");
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      Log.i(TAG, "onResourceReady " + paramR + " and this " + this);
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramb.gg(a(paramR, this.nqG));
      return;
    }
    MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda0(paramb, this, paramR));
  }
  
  protected abstract boolean a(R paramR, g<?> paramg);
  
  public abstract int blK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.b.d
 * JD-Core Version:    0.7.0.1
 */