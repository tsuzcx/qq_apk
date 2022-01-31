package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.cb.a;
import com.tencent.mm.cd.e;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.y;

final class AppBrandSmileyGrid$a
  extends BaseAdapter
{
  private AppBrandSmileyGrid$a(AppBrandSmileyGrid paramAppBrandSmileyGrid) {}
  
  public final int getCount()
  {
    return AppBrandSmileyGrid.d(this.hxL);
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = y.gt(this.hxL.getContext()).inflate(y.h.appbrand_smiley_grid_item, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (AppBrandSmileyGrid.b(this.hxL).hxU - a.aa(this.hxL.getContext(), y.e.LittlePadding) - a.aa(this.hxL.getContext(), y.e.emoji_panel_tab_height)) / AppBrandSmileyGrid.f(this.hxL)));
      paramViewGroup = new AppBrandSmileyGrid.b(paramView);
      paramView.setTag(paramViewGroup);
    }
    while (paramInt == getCount() - 1)
    {
      paramViewGroup.gSx.setImageResource(y.f.del_btn);
      paramViewGroup.gSx.setContentDescription(this.hxL.getContext().getString(y.j.delete_btn));
      return paramView;
      paramViewGroup = (AppBrandSmileyGrid.b)paramView.getTag();
    }
    paramInt = (AppBrandSmileyGrid.d(this.hxL) - 1) * AppBrandSmileyGrid.c(this.hxL) + paramInt;
    if (paramInt > AppBrandSmileyGrid.e(this.hxL) - 1)
    {
      paramViewGroup.gSx.setImageDrawable(null);
      return paramView;
    }
    Drawable localDrawable = AppBrandSmileyGrid.b(this.hxL).asu().mW(paramInt);
    paramViewGroup.gSx.setImageDrawable(localDrawable);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid.a
 * JD-Core Version:    0.7.0.1
 */