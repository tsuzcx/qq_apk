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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;)V", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rViewCallback", "Ljava/lang/ref/WeakReference;", "getRViewCallback", "()Ljava/lang/ref/WeakReference;", "setRViewCallback", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder_release"})
public final class h
  implements PAGView.PAGViewListener
{
  private WeakReference<c> uhG;
  a<x> uhH;
  
  public h(c paramc)
  {
    AppMethodBeat.i(245976);
    this.uhG = new WeakReference(paramc);
    AppMethodBeat.o(245976);
  }
  
  public final void onAnimationCancel(PAGView paramPAGView)
  {
    AppMethodBeat.i(245975);
    if ((c)this.uhG.get() == null) {}
    for (boolean bool = true;; bool = false)
    {
      paramPAGView = c.ugB;
      Log.i(c.access$getTAG$cp(), "showPrepareLottery onAnimationCancel emptyViewCallback:".concat(String.valueOf(bool)));
      paramPAGView = this.uhH;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(245975);
      return;
    }
    AppMethodBeat.o(245975);
  }
  
  public final void onAnimationEnd(PAGView paramPAGView)
  {
    AppMethodBeat.i(245974);
    paramPAGView = (c)this.uhG.get();
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      c.a locala = c.ugB;
      Log.i(c.access$getTAG$cp(), "showPrepareLottery onAnimationEnd emptyViewCallback:".concat(String.valueOf(bool)));
      if (paramPAGView != null)
      {
        paramPAGView = paramPAGView.ugv;
        if (paramPAGView != null) {
          paramPAGView.setVisibility(0);
        }
      }
      paramPAGView = this.uhH;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(245974);
      return;
    }
    AppMethodBeat.o(245974);
  }
  
  public final void onAnimationRepeat(PAGView paramPAGView) {}
  
  public final void onAnimationStart(PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.h
 * JD-Core Version:    0.7.0.1
 */