package com.tencent.mm.plugin.finder.live.plugin;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rPlugin", "Ljava/lang/ref/WeakReference;", "getRPlugin", "()Ljava/lang/ref/WeakReference;", "setRPlugin", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder_release"})
public final class a
  implements PAGView.PAGViewListener
{
  private final String TAG;
  private kotlin.g.a.a<x> ycT;
  private WeakReference<bm> ykD;
  
  public a(bm parambm)
  {
    AppMethodBeat.i(279280);
    this.TAG = "FinderLiveLotteryCardPlugin";
    this.ykD = new WeakReference(parambm);
    AppMethodBeat.o(279280);
  }
  
  public final void M(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(279276);
    p.k(parama, "callback");
    this.ycT = parama;
    AppMethodBeat.o(279276);
  }
  
  public final void onAnimationCancel(PAGView paramPAGView)
  {
    AppMethodBeat.i(279278);
    paramPAGView = (bm)this.ykD.get();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("BigAnimListener onAnimationCancel ViewCallback is null:");
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      if (paramPAGView != null)
      {
        localObject = paramPAGView.yua;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(8);
        }
      }
      if (paramPAGView != null)
      {
        paramPAGView = paramPAGView.yub;
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
      }
      paramPAGView = this.ycT;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(279278);
      return;
    }
    AppMethodBeat.o(279278);
  }
  
  public final void onAnimationEnd(PAGView paramPAGView)
  {
    AppMethodBeat.i(279277);
    paramPAGView = (bm)this.ykD.get();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("BigAnimListener onAnimationEnd ViewCallback is null:");
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      if (paramPAGView != null)
      {
        localObject = paramPAGView.yua;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(8);
        }
      }
      if (paramPAGView != null)
      {
        paramPAGView = paramPAGView.yub;
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
      }
      paramPAGView = this.ycT;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(279277);
      return;
    }
    AppMethodBeat.o(279277);
  }
  
  public final void onAnimationRepeat(PAGView paramPAGView) {}
  
  public final void onAnimationStart(PAGView paramPAGView)
  {
    AppMethodBeat.i(279279);
    paramPAGView = (bm)this.ykD.get();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("BigAnimListener onAnimationStart ViewCallback is null:");
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      if (paramPAGView != null)
      {
        localObject = paramPAGView.yua;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(0);
        }
      }
      if (paramPAGView != null)
      {
        localObject = paramPAGView.yub;
        if (localObject != null) {
          ((PAGView)localObject).setVisibility(0);
        }
      }
      if (paramPAGView == null) {
        break;
      }
      paramPAGView = paramPAGView.yub;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.flush();
      AppMethodBeat.o(279279);
      return;
    }
    AppMethodBeat.o(279279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.a
 * JD-Core Version:    0.7.0.1
 */