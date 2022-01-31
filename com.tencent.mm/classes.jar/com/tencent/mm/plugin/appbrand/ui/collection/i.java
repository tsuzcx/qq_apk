package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "deleteHandle", "kotlin.jvm.PlatformType", "getDeleteHandle", "()Landroid/view/View;", "rightExtraBottomLine", "getRightExtraBottomLine", "sortHandle", "getSortHandle", "setBottomLineVisibility", "", "visibility", "", "plugin-appbrand-integration_release"})
final class i
  extends l
{
  private final View iSb;
  final View iSc;
  final View iSd;
  
  public i(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(135104);
    this.iSb = paramView.findViewById(2131820550);
    this.iSc = paramView.findViewById(2131821172);
    this.iSd = paramView.findViewById(2131821173);
    ViewGroup.LayoutParams localLayoutParams = this.iSh.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.leftMargin = 0;
    }
    this.iSh.requestLayout();
    AppMethodBeat.o(135104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.i
 * JD-Core Version:    0.7.0.1
 */