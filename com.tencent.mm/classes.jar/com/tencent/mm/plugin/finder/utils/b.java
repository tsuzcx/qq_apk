package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "", "()V", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "getDialogRunnable", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setDialogRunnable", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "loadingWidget", "Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "getLoadingWidget", "()Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "setLoadingWidget", "(Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;)V", "begin", "", "end", "Companion", "plugin-finder_release"})
public class b
{
  public static final a vVa;
  com.tencent.f.i.d<?> dialogRunnable;
  public long gY = 500L;
  public WeakReference<Context> lAM;
  public ai vUZ;
  
  static
  {
    AppMethodBeat.i(253353);
    vVa = new a((byte)0);
    AppMethodBeat.o(253353);
  }
  
  public void begin()
  {
    try
    {
      AppMethodBeat.i(253351);
      com.tencent.f.i.d locald = this.dialogRunnable;
      if (locald != null) {
        locald.cancel(false);
      }
      this.dialogRunnable = h.RTc.n((Runnable)new b(this), this.gY);
      AppMethodBeat.o(253351);
      return;
    }
    finally {}
  }
  
  public void end()
  {
    try
    {
      AppMethodBeat.i(253352);
      com.tencent.f.i.d locald = this.dialogRunnable;
      if (locald != null) {
        locald.cancel(false);
      }
      com.tencent.mm.ac.d.h((a)new c(this));
      AppMethodBeat.o(253352);
      return;
    }
    finally {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent$Companion;", "", "()V", "createLoadingDialog", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "plugin-finder_release"})
  public static final class a
  {
    public static b e(Context paramContext, String paramString, long paramLong)
    {
      AppMethodBeat.i(253348);
      p.h(paramContext, "context");
      b localb = new b();
      localb.gY = paramLong;
      localb.lAM = new WeakReference(paramContext);
      ag localag = new ag();
      if (paramString != null) {
        localag.awz(paramString);
      }
      localag.kke = null;
      localag.lAM = new WeakReference(paramContext);
      localb.vUZ = ((ai)localag);
      AppMethodBeat.o(253348);
      return localb;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(253349);
      ai localai = this.vVb.vUZ;
      if (localai != null) {
        localai.dismiss();
      }
      localai = this.vVb.vUZ;
      if (localai != null)
      {
        localai.show();
        AppMethodBeat.o(253349);
        return;
      }
      AppMethodBeat.o(253349);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.b
 * JD-Core Version:    0.7.0.1
 */