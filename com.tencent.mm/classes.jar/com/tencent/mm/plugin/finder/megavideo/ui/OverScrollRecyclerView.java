package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.a;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/design/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getBehavior", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "plugin-finder_release"})
public final class OverScrollRecyclerView
  extends WxRecyclerView
  implements CoordinatorLayout.a
{
  public OverScrollRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248610);
    AppMethodBeat.o(248610);
  }
  
  public OverScrollRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248611);
    AppMethodBeat.o(248611);
  }
  
  public final OverScrollVerticalBehavior getBehavior()
  {
    AppMethodBeat.i(248608);
    OverScrollVerticalBehavior localOverScrollVerticalBehavior = new OverScrollVerticalBehavior();
    AppMethodBeat.o(248608);
    return localOverScrollVerticalBehavior;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.OverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */