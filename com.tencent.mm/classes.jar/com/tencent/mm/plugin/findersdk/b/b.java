package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "", "()V", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "getDialogRunnable", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setDialogRunnable", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "loadingWidget", "Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "getLoadingWidget", "()Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "setLoadingWidget", "(Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;)V", "begin", "", "end", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
{
  public static final a HcE;
  public g HcF;
  public WeakReference<Context> context;
  public long delay = 500L;
  private com.tencent.threadpool.i.d<?> dialogRunnable;
  
  static
  {
    AppMethodBeat.i(273914);
    HcE = new a((byte)0);
    AppMethodBeat.o(273914);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(273905);
    s.u(paramb, "this$0");
    g localg = paramb.HcF;
    if (localg != null) {
      localg.dismiss();
    }
    paramb = paramb.HcF;
    if (paramb != null) {
      paramb.show();
    }
    AppMethodBeat.o(273905);
  }
  
  protected final void b(com.tencent.threadpool.i.d<?> paramd)
  {
    this.dialogRunnable = paramd;
  }
  
  public void begin()
  {
    try
    {
      AppMethodBeat.i(273936);
      com.tencent.threadpool.i.d locald = this.dialogRunnable;
      if (locald != null) {
        locald.cancel(false);
      }
      this.dialogRunnable = h.ahAA.o(new b..ExternalSyntheticLambda0(this), this.delay);
      AppMethodBeat.o(273936);
      return;
    }
    finally {}
  }
  
  public void end()
  {
    try
    {
      AppMethodBeat.i(273942);
      com.tencent.threadpool.i.d locald = this.dialogRunnable;
      if (locald != null) {
        locald.cancel(false);
      }
      com.tencent.mm.ae.d.uiThread((a)new b(this));
      AppMethodBeat.o(273942);
      return;
    }
    finally {}
  }
  
  protected final com.tencent.threadpool.i.d<?> frU()
  {
    return this.dialogRunnable;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent$Companion;", "", "()V", "createLoadingDialog", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b a(ProgressBar paramProgressBar)
    {
      AppMethodBeat.i(273917);
      s.u(paramProgressBar, "progressBar");
      b localb = new b();
      localb.delay = 1000L;
      f localf = new f();
      localf.Dlp = paramProgressBar;
      paramProgressBar = ah.aiuX;
      localb.HcF = ((g)localf);
      AppMethodBeat.o(273917);
      return localb;
    }
    
    public static b d(Context paramContext, String paramString, long paramLong)
    {
      AppMethodBeat.i(273908);
      s.u(paramContext, "context");
      b localb = new b();
      localb.delay = paramLong;
      localb.context = new WeakReference(paramContext);
      e locale = new e();
      if (paramString != null) {
        locale.ayQ(paramString);
      }
      locale.qbI = null;
      locale.context = new WeakReference(paramContext);
      paramContext = ah.aiuX;
      localb.HcF = ((g)locale);
      AppMethodBeat.o(273908);
      return localb;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.b
 * JD-Core Version:    0.7.0.1
 */