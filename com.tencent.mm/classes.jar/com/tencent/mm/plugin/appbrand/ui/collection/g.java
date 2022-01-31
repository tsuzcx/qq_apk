package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.y.g;

final class g
  extends j
{
  private final View hgB;
  final View hgC;
  final View hgD;
  
  public g(View paramView)
  {
    super(paramView);
    this.hgB = paramView.findViewById(y.g.app_brand_collection_drag_sort_item_handle);
    this.hgC = paramView.findViewById(y.g.app_brand_collection_sort_delete_handle);
    this.hgD = paramView.findViewById(y.g.extra_bottom_line);
    ViewGroup.LayoutParams localLayoutParams = this.hgG.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.leftMargin = 0;
    }
    this.hgG.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.g
 * JD-Core Version:    0.7.0.1
 */