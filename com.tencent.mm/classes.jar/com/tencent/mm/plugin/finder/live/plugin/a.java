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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rPlugin", "Ljava/lang/ref/WeakReference;", "getRPlugin", "()Ljava/lang/ref/WeakReference;", "setRPlugin", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder_release"})
public final class a
  implements PAGView.PAGViewListener
{
  private final String TAG;
  private kotlin.g.a.a<x> uhH;
  private WeakReference<an> ulz;
  
  public a(an paraman)
  {
    AppMethodBeat.i(246367);
    this.TAG = "FinderLiveLotteryCardPlugin";
    this.ulz = new WeakReference(paraman);
    AppMethodBeat.o(246367);
  }
  
  public final void N(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(246363);
    p.h(parama, "callback");
    this.uhH = parama;
    AppMethodBeat.o(246363);
  }
  
  public final void onAnimationCancel(PAGView paramPAGView)
  {
    AppMethodBeat.i(246365);
    paramPAGView = (an)this.ulz.get();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("BigAnimListener onAnimationCancel ViewCallback is null:");
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      if (paramPAGView != null)
      {
        localObject = paramPAGView.urR;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(8);
        }
      }
      if (paramPAGView != null)
      {
        paramPAGView = paramPAGView.urS;
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
      }
      paramPAGView = this.uhH;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(246365);
      return;
    }
    AppMethodBeat.o(246365);
  }
  
  public final void onAnimationEnd(PAGView paramPAGView)
  {
    AppMethodBeat.i(246364);
    paramPAGView = (an)this.ulz.get();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("BigAnimListener onAnimationEnd ViewCallback is null:");
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      if (paramPAGView != null)
      {
        localObject = paramPAGView.urR;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(8);
        }
      }
      if (paramPAGView != null)
      {
        paramPAGView = paramPAGView.urS;
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
      }
      paramPAGView = this.uhH;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.invoke();
      AppMethodBeat.o(246364);
      return;
    }
    AppMethodBeat.o(246364);
  }
  
  public final void onAnimationRepeat(PAGView paramPAGView) {}
  
  public final void onAnimationStart(PAGView paramPAGView)
  {
    AppMethodBeat.i(246366);
    paramPAGView = (an)this.ulz.get();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("BigAnimListener onAnimationStart ViewCallback is null:");
    if (paramPAGView == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      if (paramPAGView != null)
      {
        localObject = paramPAGView.urR;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(0);
        }
      }
      if (paramPAGView != null)
      {
        localObject = paramPAGView.urS;
        if (localObject != null) {
          ((PAGView)localObject).setVisibility(0);
        }
      }
      if (paramPAGView == null) {
        break;
      }
      paramPAGView = paramPAGView.urS;
      if (paramPAGView == null) {
        break;
      }
      paramPAGView.flush();
      AppMethodBeat.o(246366);
      return;
    }
    AppMethodBeat.o(246366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.a
 * JD-Core Version:    0.7.0.1
 */