package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "overScrollBehavior", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "getOverScrollBehavior", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "overScrollBehavior$delegate", "Lkotlin/Lazy;", "getBehavior", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OverScrollRecyclerView
  extends WxRecyclerView
  implements CoordinatorLayout.a
{
  private final j EBv;
  
  public OverScrollRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(341970);
    this.EBv = k.cm((a)a.EBw);
    AppMethodBeat.o(341970);
  }
  
  public OverScrollRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(341979);
    this.EBv = k.cm((a)a.EBw);
    AppMethodBeat.o(341979);
  }
  
  public final OverScrollVerticalBehavior getBehavior()
  {
    AppMethodBeat.i(341992);
    OverScrollVerticalBehavior localOverScrollVerticalBehavior = getOverScrollBehavior();
    AppMethodBeat.o(341992);
    return localOverScrollVerticalBehavior;
  }
  
  public final OverScrollVerticalBehavior getOverScrollBehavior()
  {
    AppMethodBeat.i(341985);
    OverScrollVerticalBehavior localOverScrollVerticalBehavior = (OverScrollVerticalBehavior)this.EBv.getValue();
    AppMethodBeat.o(341985);
    return localOverScrollVerticalBehavior;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<OverScrollVerticalBehavior>
  {
    public static final a EBw;
    
    static
    {
      AppMethodBeat.i(341967);
      EBw = new a();
      AppMethodBeat.o(341967);
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