package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.au.d;

final class AppBrandProfileUI$22
  extends RecyclerView.h
{
  AppBrandProfileUI$22(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(246947);
    int i = a.aY(this.qXA, au.d.app_brand_profile_section_padding_horizontal);
    int j = a.aY(this.qXA, au.d.app_brand_profile_preview_item_gap);
    if (RecyclerView.bh(paramView) == 0) {}
    for (paramRect.left = i;; paramRect.left = 0)
    {
      paramRect.right = j;
      AppMethodBeat.o(246947);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.22
 * JD-Core Version:    0.7.0.1
 */