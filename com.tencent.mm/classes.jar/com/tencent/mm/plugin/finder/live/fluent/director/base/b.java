package com.tencent.mm.plugin.finder.live.fluent.director.base;

import android.animation.Animator;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.finder.live.fluent.h;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchInDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/ISwitchInDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fluentSwitchInParams", "Lcom/tencent/mm/plugin/finder/live/fluent/params/FinderFluentSwitchInParams;", "getFluentSwitchInParams", "()Lcom/tencent/mm/plugin/finder/live/fluent/params/FinderFluentSwitchInParams;", "setFluentSwitchInParams", "(Lcom/tencent/mm/plugin/finder/live/fluent/params/FinderFluentSwitchInParams;)V", "outParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "getOutParams", "()Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "setOutParams", "(Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;)V", "parentView", "Landroid/view/ViewGroup;", "getParentView", "()Landroid/view/ViewGroup;", "setParentView", "(Landroid/view/ViewGroup;)V", "onAnimationEnd", "", "p0", "Landroid/animation/Animator;", "saveOutParams", "switchParams", "setInParams", "params", "switchIn", "onAnimationEndCallback", "Lkotlin/Function0;", "switchInLiveFinish", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends a
  implements com.tencent.mm.plugin.finder.live.fluent.director.a
{
  private h CCU;
  private com.tencent.mm.plugin.finder.live.fluent.params.a CCV;
  public ViewGroup parentView;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(com.tencent.mm.plugin.finder.live.fluent.params.a parama)
  {
    s.u(parama, "params");
    this.parentView = parama.parentView;
    this.CCV = parama;
    ejG();
  }
  
  public final void aY(kotlin.g.a.a<ah> parama)
  {
    s.u(parama, "onAnimationEndCallback");
    aZ(parama);
  }
  
  public final void b(h paramh)
  {
    s.u(paramh, "switchParams");
    this.CCU = paramh;
  }
  
  public final h ejK()
  {
    return this.CCU;
  }
  
  public final com.tencent.mm.plugin.finder.live.fluent.params.a ejL()
  {
    return this.CCV;
  }
  
  public void ejM() {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    ejD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.base.b
 * JD-Core Version:    0.7.0.1
 */