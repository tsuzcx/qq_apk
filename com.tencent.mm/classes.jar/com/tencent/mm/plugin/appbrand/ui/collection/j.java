package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "deleteHandle", "kotlin.jvm.PlatformType", "getDeleteHandle", "()Landroid/view/View;", "rightExtraBottomLine", "getRightExtraBottomLine", "sortHandle", "getSortHandle", "setBottomLineVisibility", "", "visibility", "", "plugin-appbrand-integration_release"})
final class j
  extends m
{
  private final View mIX;
  final View mIY;
  final View mIZ;
  private final boolean mJa;
  
  public j(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51269);
    this.mIX = paramView.findViewById(2131296691);
    this.mIY = paramView.findViewById(2131296692);
    this.mIZ = paramView.findViewById(2131299635);
    ViewGroup.LayoutParams localLayoutParams = this.mJe.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.leftMargin = 0;
    }
    this.mJe.requestLayout();
    AppMethodBeat.o(51269);
  }
  
  public final boolean bAq()
  {
    return this.mJa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.j
 * JD-Core Version:    0.7.0.1
 */