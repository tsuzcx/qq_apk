package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import android.widget.ProgressBar;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "", "()V", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "getDialogRunnable", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setDialogRunnable", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "loadingWidget", "Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "getLoadingWidget", "()Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "setLoadingWidget", "(Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;)V", "begin", "", "end", "Companion", "finder-sdk_release"})
public class b
{
  public static final a Bvw;
  public f Bvv;
  public WeakReference<Context> context;
  public long delay = 500L;
  private com.tencent.e.i.d<?> dialogRunnable;
  
  static
  {
    AppMethodBeat.i(207733);
    Bvw = new a((byte)0);
    AppMethodBeat.o(207733);
  }
  
  protected final void b(com.tencent.e.i.d<?> paramd)
  {
    this.dialogRunnable = paramd;
  }
  
  public void begin()
  {
    try
    {
      AppMethodBeat.i(207730);
      com.tencent.e.i.d locald = this.dialogRunnable;
      if (locald != null) {
        locald.cancel(false);
      }
      this.dialogRunnable = h.ZvG.n((Runnable)new b(this), this.delay);
      AppMethodBeat.o(207730);
      return;
    }
    finally {}
  }
  
  public void end()
  {
    try
    {
      AppMethodBeat.i(207732);
      com.tencent.e.i.d locald = this.dialogRunnable;
      if (locald != null) {
        locald.cancel(false);
      }
      com.tencent.mm.ae.d.uiThread((a)new c(this));
      AppMethodBeat.o(207732);
      return;
    }
    finally {}
  }
  
  protected final com.tencent.e.i.d<?> enl()
  {
    return this.dialogRunnable;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent$Companion;", "", "()V", "createLoadingDialog", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "finder-sdk_release"})
  public static final class a
  {
    public static b a(ProgressBar paramProgressBar)
    {
      AppMethodBeat.i(208350);
      p.k(paramProgressBar, "progressBar");
      b localb = new b();
      localb.delay = 1000L;
      e locale = new e();
      locale.yyI = paramProgressBar;
      localb.Bvv = ((f)locale);
      AppMethodBeat.o(208350);
      return localb;
    }
    
    public static b d(Context paramContext, String paramString, long paramLong)
    {
      AppMethodBeat.i(208348);
      p.k(paramContext, "context");
      b localb = new b();
      localb.delay = paramLong;
      localb.context = new WeakReference(paramContext);
      d locald = new d();
      if (paramString != null) {
        locald.aDu(paramString);
      }
      locald.nbU = null;
      locald.context = new WeakReference(paramContext);
      localb.Bvv = ((f)locald);
      AppMethodBeat.o(208348);
      return localb;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(209829);
      f localf = this.Bvx.Bvv;
      if (localf != null) {
        localf.dismiss();
      }
      localf = this.Bvx.Bvv;
      if (localf != null)
      {
        localf.show();
        AppMethodBeat.o(209829);
        return;
      }
      AppMethodBeat.o(209829);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.b
 * JD-Core Version:    0.7.0.1
 */