package com.tencent.mm.plugin.finder.live.component;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;)V", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rViewCallback", "Ljava/lang/ref/WeakReference;", "getRViewCallback", "()Ljava/lang/ref/WeakReference;", "setRViewCallback", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  implements PAGView.PAGViewListener
{
  private WeakReference<ab> CAu;
  a<ah> CBk;
  
  public aw(ab paramab)
  {
    AppMethodBeat.i(352727);
    this.CAu = new WeakReference(paramab);
    AppMethodBeat.o(352727);
  }
  
  public final void onAnimationCancel(PAGView paramPAGView)
  {
    int i = 0;
    AppMethodBeat.i(352752);
    if ((ab)this.CAu.get() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = ab.CyP;
      localObject = ab.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("showPrepareLottery onAnimationCancel,view:");
      if (paramPAGView != null) {
        i = paramPAGView.hashCode();
      }
      Log.i((String)localObject, i + " emptyViewCallback:" + bool);
      paramPAGView = this.CBk;
      if (paramPAGView != null) {
        paramPAGView.invoke();
      }
      AppMethodBeat.o(352752);
      return;
    }
  }
  
  public final void onAnimationEnd(PAGView paramPAGView)
  {
    AppMethodBeat.i(352745);
    ab localab = (ab)this.CAu.get();
    boolean bool;
    int i;
    if (localab == null)
    {
      bool = true;
      Object localObject = ab.CyP;
      localObject = ab.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("showPrepareLottery onAnimationEnd,view:");
      if (paramPAGView == null) {
        break label120;
      }
      i = paramPAGView.hashCode();
      label54:
      Log.i((String)localObject, i + " emptyViewCallback:" + bool);
      if (localab != null) {
        break label125;
      }
    }
    label120:
    label125:
    for (paramPAGView = null;; paramPAGView = localab.CyS)
    {
      if (paramPAGView != null) {
        paramPAGView.setVisibility(0);
      }
      paramPAGView = this.CBk;
      if (paramPAGView != null) {
        paramPAGView.invoke();
      }
      AppMethodBeat.o(352745);
      return;
      bool = false;
      break;
      i = 0;
      break label54;
    }
  }
  
  public final void onAnimationRepeat(PAGView paramPAGView)
  {
    AppMethodBeat.i(352737);
    Object localObject = ab.CyP;
    localObject = ab.access$getTAG$cp();
    if (paramPAGView != null) {}
    for (int i = paramPAGView.hashCode();; i = 0)
    {
      Log.i((String)localObject, s.X("onAnimationRepeat:$", Integer.valueOf(i)));
      AppMethodBeat.o(352737);
      return;
    }
  }
  
  public final void onAnimationStart(PAGView paramPAGView)
  {
    AppMethodBeat.i(352759);
    Object localObject = ab.CyP;
    localObject = ab.access$getTAG$cp();
    if (paramPAGView != null) {}
    for (int i = paramPAGView.hashCode();; i = 0)
    {
      Log.i((String)localObject, s.X("onAnimationStart:$", Integer.valueOf(i)));
      AppMethodBeat.o(352759);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.aw
 * JD-Core Version:    0.7.0.1
 */