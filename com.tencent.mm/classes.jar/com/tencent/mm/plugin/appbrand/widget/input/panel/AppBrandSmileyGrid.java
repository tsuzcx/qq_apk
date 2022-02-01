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
import com.tencent.mm.ui.z;

public class AppBrandSmileyGrid
  extends GridView
{
  AdapterView.OnItemClickListener awt;
  private c nni;
  a nnm;
  int nnn;
  int nno;
  int nnp;
  int nnq;
  int nnr;
  int nns;
  
  public AppBrandSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49933);
    this.nno = 0;
    this.nnq = 0;
    this.nnr = 0;
    this.nns = 0;
    this.awt = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(49929);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (paramAnonymousInt == AppBrandSmileyGrid.a(AppBrandSmileyGrid.this).getCount() - 1)
        {
          if (AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).nnA != null) {
            AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).nnA.apc();
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
        if (AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).nnA != null) {
          AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).nnA.append(AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).bFI().wF(i * (j - 1) + paramAnonymousInt));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(49929);
      }
    };
    AppMethodBeat.o(49933);
  }
  
  int getRowSpacing()
  {
    return this.nnq;
  }
  
  public void setPanelManager(c paramc)
  {
    this.nni = paramc;
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
        paramView = z.jV(new ContextThemeWrapper(AppBrandSmileyGrid.this.getContext(), 2131820870)).inflate(2131493105, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).nnB - com.tencent.mm.cb.a.ax(AppBrandSmileyGrid.this.getContext(), 2131165490) - com.tencent.mm.cb.a.ax(AppBrandSmileyGrid.this.getContext(), 2131166250)) / AppBrandSmileyGrid.f(AppBrandSmileyGrid.this)));
        paramViewGroup = new AppBrandSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label168;
        }
        paramViewGroup.mdt.setImageResource(2131231885);
        paramViewGroup.mdt.setContentDescription(AppBrandSmileyGrid.this.getContext().getString(2131758032));
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
          paramViewGroup.mdt.setImageDrawable(null);
        }
        else
        {
          Drawable localDrawable = AppBrandSmileyGrid.b(AppBrandSmileyGrid.this).bFI().wD(paramInt);
          paramViewGroup.mdt.setImageDrawable(localDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid
 * JD-Core Version:    0.7.0.1
 */