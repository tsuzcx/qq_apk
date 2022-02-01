package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aa;

public class AppBrandSmileyGrid
  extends GridView
{
  AdapterView.OnItemClickListener awr;
  int gOF;
  private c owP;
  a owT;
  int owU;
  int owV;
  int owW;
  int owX;
  int owY;
  
  public AppBrandSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49933);
    this.owV = 0;
    this.owX = 0;
    this.owY = 0;
    this.gOF = 0;
    this.awr = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(49929);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt == AppBrandSmileyGrid.a(AppBrandSmileyGrid.this).getCount() - 1)
        {
          if (AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).oxg != null) {
            AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).oxg.aHC();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(49929);
          return;
        }
        if (AppBrandSmileyGrid.c(AppBrandSmileyGrid.this) * (AppBrandSmileyGrid.d(AppBrandSmileyGrid.this) - 1) + paramAnonymousInt >= AppBrandSmileyGrid.e(AppBrandSmileyGrid.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(49929);
          return;
        }
        int i = AppBrandSmileyGrid.c(AppBrandSmileyGrid.this);
        int j = AppBrandSmileyGrid.d(AppBrandSmileyGrid.this);
        if (AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).oxg != null) {
          AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).oxg.append(AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).cbY().An(i * (j - 1) + paramAnonymousInt));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(49929);
      }
    };
    AppMethodBeat.o(49933);
  }
  
  int getRowSpacing()
  {
    return this.owX;
  }
  
  public void setPanelManager(c paramc)
  {
    this.owP = paramc;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(49930);
      int i = AppBrandSmileyGrid.d(AppBrandSmileyGrid.this);
      AppMethodBeat.o(49930);
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
      AppMethodBeat.i(49931);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = aa.jQ(new ContextThemeWrapper(AppBrandSmileyGrid.this.getContext(), 2131820879)).inflate(2131493147, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).oxh - com.tencent.mm.cb.a.aG(AppBrandSmileyGrid.this.getContext(), 2131165508) - com.tencent.mm.cb.a.aG(AppBrandSmileyGrid.this.getContext(), 2131166293)) / AppBrandSmileyGrid.f(AppBrandSmileyGrid.this)));
        paramViewGroup = new AppBrandSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label168;
        }
        paramViewGroup.nnL.setImageResource(2131231968);
        paramViewGroup.nnL.setContentDescription(AppBrandSmileyGrid.this.getContext().getString(2131758284));
      }
      for (;;)
      {
        AppMethodBeat.o(49931);
        return paramView;
        paramViewGroup = (AppBrandSmileyGrid.b)paramView.getTag();
        break;
        label168:
        paramInt = (AppBrandSmileyGrid.d(AppBrandSmileyGrid.this) - 1) * AppBrandSmileyGrid.c(AppBrandSmileyGrid.this) + paramInt;
        if (paramInt > AppBrandSmileyGrid.e(AppBrandSmileyGrid.this) - 1)
        {
          paramViewGroup.nnL.setImageDrawable(null);
        }
        else
        {
          Drawable localDrawable = AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).cbY().Al(paramInt);
          paramViewGroup.nnL.setImageDrawable(localDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid
 * JD-Core Version:    0.7.0.1
 */