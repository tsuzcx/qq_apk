package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "deleteHandle", "kotlin.jvm.PlatformType", "getDeleteHandle", "()Landroid/view/View;", "rightExtraBottomLine", "getRightExtraBottomLine", "sortHandle", "getSortHandle", "setBottomLineVisibility", "", "visibility", "", "plugin-appbrand-integration_release"})
final class j
  extends m
{
  private final View mNZ;
  final View mOa;
  final View mOb;
  private final boolean mOc;
  
  public j(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51269);
    this.mNZ = paramView.findViewById(2131296691);
    this.mOa = paramView.findViewById(2131296692);
    this.mOb = paramView.findViewById(2131299635);
    ViewGroup.LayoutParams localLayoutParams = this.mOg.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.leftMargin = 0;
    }
    this.mOg.requestLayout();
    AppMethodBeat.o(51269);
  }
  
  public final boolean bBl()
  {
    return this.mOc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.j
 * JD-Core Version:    0.7.0.1
 */