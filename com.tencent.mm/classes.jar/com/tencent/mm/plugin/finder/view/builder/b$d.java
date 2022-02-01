package com.tencent.mm.plugin.finder.view.builder;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$d
  implements View.OnLayoutChangeListener
{
  b$d(b paramb, View paramView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(178495);
    this.GGL.flR().getFooterLayout().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
    this.Gaa.setPadding(this.Gaa.getPaddingLeft(), this.Gaa.getPaddingTop(), this.Gaa.getPaddingRight(), this.GGL.flQ().getCommentEditTextLayout().getHeight());
    this.Gaa.requestLayout();
    Log.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.GGL.flQ().getCommentEditTextLayout().getHeight() + " paddingBottom=" + this.Gaa.getPaddingBottom());
    AppMethodBeat.o(178495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b.d
 * JD-Core Version:    0.7.0.1
 */