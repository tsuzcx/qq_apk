package com.tencent.mm.plugin.finder.view.builder;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
public final class b$d
  implements View.OnLayoutChangeListener
{
  b$d(View paramView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(178495);
    this.saF.cFp().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
    paramView = this.rWb.getLayoutParams();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(178495);
      throw paramView;
    }
    paramView = (FrameLayout.LayoutParams)paramView;
    paramView.height = (this.rWb.getHeight() - this.saF.cFo().getCommentEditTextLayout().getHeight());
    this.rWb.requestLayout();
    ac.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.saF.cFo().getCommentEditTextLayout().getHeight() + " BodyHeight=" + paramView.height);
    AppMethodBeat.o(178495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b.d
 * JD-Core Version:    0.7.0.1
 */