package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.cd.e;
import com.tencent.mm.ui.w;

final class AppBrandSmileyGrid$a
  extends BaseAdapter
{
  private AppBrandSmileyGrid$a(AppBrandSmileyGrid paramAppBrandSmileyGrid) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(134308);
    int i = AppBrandSmileyGrid.d(this.jpV);
    AppMethodBeat.o(134308);
    return i;
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
    AppMethodBeat.i(134309);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = w.hM(new ContextThemeWrapper(this.jpV.getContext(), 2131493194)).inflate(2130968776, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (AppBrandSmileyGrid.b(this.jpV).jqe - a.ao(this.jpV.getContext(), 2131427782) - a.ao(this.jpV.getContext(), 2131428385)) / AppBrandSmileyGrid.f(this.jpV)));
      paramViewGroup = new AppBrandSmileyGrid.b(paramView);
      paramView.setTag(paramViewGroup);
      if (paramInt != getCount() - 1) {
        break label168;
      }
      paramViewGroup.ivs.setImageResource(2130838499);
      paramViewGroup.ivs.setContentDescription(this.jpV.getContext().getString(2131298947));
    }
    for (;;)
    {
      AppMethodBeat.o(134309);
      return paramView;
      paramViewGroup = (AppBrandSmileyGrid.b)paramView.getTag();
      break;
      label168:
      paramInt = (AppBrandSmileyGrid.d(this.jpV) - 1) * AppBrandSmileyGrid.c(this.jpV) + paramInt;
      if (paramInt > AppBrandSmileyGrid.e(this.jpV) - 1)
      {
        paramViewGroup.ivs.setImageDrawable(null);
      }
      else
      {
        Drawable localDrawable = AppBrandSmileyGrid.b(this.jpV).aRy().qA(paramInt);
        paramViewGroup.ivs.setImageDrawable(localDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid.a
 * JD-Core Version:    0.7.0.1
 */