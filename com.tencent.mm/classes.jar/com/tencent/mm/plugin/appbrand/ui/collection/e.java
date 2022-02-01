package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "deleteHandle", "kotlin.jvm.PlatformType", "getDeleteHandle", "()Landroid/view/View;", "rightExtraBottomLine", "getRightExtraBottomLine", "sortHandle", "getSortHandle", "setBottomLineVisibility", "", "visibility", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
  extends h
{
  private final View uio;
  final View uiq;
  final View uir;
  private final boolean uis;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51269);
    this.uio = paramView.findViewById(ba.f.app_brand_collection_drag_sort_item_handle);
    this.uiq = paramView.findViewById(ba.f.app_brand_collection_sort_delete_handle);
    this.uir = paramView.findViewById(ba.f.extra_bottom_line);
    paramView = cMn().getLayoutParams();
    if ((paramView instanceof ViewGroup.MarginLayoutParams)) {}
    for (paramView = (ViewGroup.MarginLayoutParams)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.leftMargin = 0;
      }
      cMn().requestLayout();
      this.uix.setVisibility(4);
      AppMethodBeat.o(51269);
      return;
    }
  }
  
  public final boolean cMl()
  {
    return this.uis;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.e
 * JD-Core Version:    0.7.0.1
 */