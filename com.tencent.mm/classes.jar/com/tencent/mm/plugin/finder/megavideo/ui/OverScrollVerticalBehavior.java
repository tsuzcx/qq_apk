package com.tencent.mm.plugin.finder.megavideo.ui;

import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "()V", "deltaX", "", "getDeltaX", "()I", "setDeltaX", "(I)V", "deltaY", "getDeltaY", "setDeltaY", "pullDownListener", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "getPullDownListener", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "setPullDownListener", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;)V", "scrollThreshold", "getScrollThreshold", "setScrollThreshold", "onNestedScroll", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "onStopNestedScroll", "Companion", "PullDownListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OverScrollVerticalBehavior
  extends CoordinatorLayout.Behavior<WxRecyclerView>
{
  public static final a EBx;
  private int EBA;
  b EBB;
  private int EBy;
  private int EBz;
  
  static
  {
    AppMethodBeat.i(342045);
    EBx = new a((byte)0);
    AppMethodBeat.o(342045);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "", "onPullDown", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void cDL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.OverScrollVerticalBehavior
 * JD-Core Version:    0.7.0.1
 */