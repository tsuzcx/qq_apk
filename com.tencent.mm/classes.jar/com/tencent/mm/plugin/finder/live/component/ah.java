package com.tencent.mm.plugin.finder.live.component;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;)V", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rViewCallback", "Ljava/lang/ref/WeakReference;", "getRViewCallback", "()Ljava/lang/ref/WeakReference;", "setRViewCallback", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder_release"})
public final class ah
  implements PAGView.PAGViewListener
{
  a<x> ycT;
  private WeakReference<o> ycf;
  
  public ah(o paramo)
  {
    AppMethodBeat.i(224563);
    this.ycf = new WeakReference(paramo);
    AppMethodBeat.o(224563);
  }
  
  public final void onAnimationCancel(PAGView paramPAGView)
  {
    AppMethodBeat.i(224558);
    if ((o)this.ycf.get() == null) {}
    for (boolean bool = true;; bool = false)
    {
      paramPAGView = o.yaD;
      Log.i(o.access$getTAG$cp(), "showPrepareLottery onAnimationCancel emptyViewCallback:".concat(String.valueOf(bool)));
      paramPAGView = this.ycT;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(224558);
      return;
    }
    AppMethodBeat.o(224558);
  }
  
  public final void onAnimationEnd(PAGView paramPAGView)
  {
    AppMethodBeat.i(224554);
    paramPAGView = (o)this.ycf.get();
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      o.a locala = o.yaD;
      Log.i(o.access$getTAG$cp(), "showPrepareLottery onAnimationEnd emptyViewCallback:".concat(String.valueOf(bool)));
      if (paramPAGView != null)
      {
        paramPAGView = paramPAGView.yax;
        if (paramPAGView != null) {
          paramPAGView.setVisibility(0);
        }
      }
      paramPAGView = this.ycT;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(224554);
      return;
    }
    AppMethodBeat.o(224554);
  }
  
  public final void onAnimationRepeat(PAGView paramPAGView) {}
  
  public final void onAnimationStart(PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ah
 * JD-Core Version:    0.7.0.1
 */