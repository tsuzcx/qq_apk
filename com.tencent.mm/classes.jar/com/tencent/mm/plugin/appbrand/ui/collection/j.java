package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "deleteHandle", "kotlin.jvm.PlatformType", "getDeleteHandle", "()Landroid/view/View;", "rightExtraBottomLine", "getRightExtraBottomLine", "sortHandle", "getSortHandle", "setBottomLineVisibility", "", "visibility", "", "plugin-appbrand-integration_release"})
final class j
  extends m
{
  private final View lGB;
  final View lGC;
  final View lGD;
  private final boolean lGE;
  
  public j(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51269);
    this.lGB = paramView.findViewById(2131296691);
    this.lGC = paramView.findViewById(2131296692);
    this.lGD = paramView.findViewById(2131299635);
    ViewGroup.LayoutParams localLayoutParams = this.lGI.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.leftMargin = 0;
    }
    this.lGI.requestLayout();
    AppMethodBeat.o(51269);
  }
  
  public final boolean bpp()
  {
    return this.lGE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.j
 * JD-Core Version:    0.7.0.1
 */