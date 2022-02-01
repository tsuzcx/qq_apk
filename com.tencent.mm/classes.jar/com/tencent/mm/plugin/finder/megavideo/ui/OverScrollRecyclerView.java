package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "overScrollBehavior", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "getOverScrollBehavior", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "overScrollBehavior$delegate", "Lkotlin/Lazy;", "getBehavior", "plugin-finder_release"})
public final class OverScrollRecyclerView
  extends WxRecyclerView
  implements CoordinatorLayout.a
{
  private final f zyD;
  
  public OverScrollRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282231);
    this.zyD = g.ar((a)a.zyE);
    AppMethodBeat.o(282231);
  }
  
  public OverScrollRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(282232);
    this.zyD = g.ar((a)a.zyE);
    AppMethodBeat.o(282232);
  }
  
  public final OverScrollVerticalBehavior getBehavior()
  {
    AppMethodBeat.i(282229);
    OverScrollVerticalBehavior localOverScrollVerticalBehavior = getOverScrollBehavior();
    AppMethodBeat.o(282229);
    return localOverScrollVerticalBehavior;
  }
  
  public final OverScrollVerticalBehavior getOverScrollBehavior()
  {
    AppMethodBeat.i(282228);
    OverScrollVerticalBehavior localOverScrollVerticalBehavior = (OverScrollVerticalBehavior)this.zyD.getValue();
    AppMethodBeat.o(282228);
    return localOverScrollVerticalBehavior;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "invoke"})
  static final class a
    extends q
    implements a<OverScrollVerticalBehavior>
  {
    public static final a zyE;
    
    static
    {
      AppMethodBeat.i(287647);
      zyE = new a();
      AppMethodBeat.o(287647);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.OverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */