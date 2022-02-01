package com.tencent.mm.plugin.finder.megavideo.ui;

import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "()V", "deltaX", "", "getDeltaX", "()I", "setDeltaX", "(I)V", "deltaY", "getDeltaY", "setDeltaY", "pullDownListener", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "getPullDownListener", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "setPullDownListener", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;)V", "scrollThreshold", "getScrollThreshold", "setScrollThreshold", "onNestedScroll", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "onStopNestedScroll", "Companion", "PullDownListener", "plugin-finder_release"})
public final class OverScrollVerticalBehavior
  extends CoordinatorLayout.Behavior<WxRecyclerView>
{
  public static final a zyJ;
  private int zyF;
  private int zyG;
  private int zyH;
  b zyI;
  
  static
  {
    AppMethodBeat.i(284188);
    zyJ = new a((byte)0);
    AppMethodBeat.o(284188);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "", "onPullDown", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void cdo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.OverScrollVerticalBehavior
 * JD-Core Version:    0.7.0.1
 */