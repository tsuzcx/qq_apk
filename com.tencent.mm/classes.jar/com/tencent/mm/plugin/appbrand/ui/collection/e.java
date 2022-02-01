package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "deleteHandle", "kotlin.jvm.PlatformType", "getDeleteHandle", "()Landroid/view/View;", "rightExtraBottomLine", "getRightExtraBottomLine", "sortHandle", "getSortHandle", "setBottomLineVisibility", "", "visibility", "", "plugin-appbrand-integration_release"})
final class e
  extends h
{
  private final View oba;
  final View obb;
  final View obc;
  private final boolean obd;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51269);
    this.oba = paramView.findViewById(2131296781);
    this.obb = paramView.findViewById(2131296782);
    this.obc = paramView.findViewById(2131300269);
    ViewGroup.LayoutParams localLayoutParams = this.obh.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.leftMargin = 0;
    }
    this.obh.requestLayout();
    AppMethodBeat.o(51269);
  }
  
  public final boolean bYl()
  {
    return this.obd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.e
 * JD-Core Version:    0.7.0.1
 */