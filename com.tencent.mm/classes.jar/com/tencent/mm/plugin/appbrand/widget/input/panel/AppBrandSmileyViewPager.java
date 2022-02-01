package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class AppBrandSmileyViewPager
  extends CustomViewPager
{
  private int nnE;
  private int nnF;
  private b nnG;
  private c nni;
  
  public AppBrandSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49963);
    this.nnE = 0;
    this.nnF = 0;
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
    AppMethodBeat.o(49963);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49964);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.nni != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.nnE)) || ((paramInt1 > 0) && (paramInt1 != this.nnF))))))
    {
      this.nni.nnB = paramInt2;
      this.nni.nnC = paramInt1;
      if (this.nnG != null) {
        this.nnG.bFT();
      }
    }
    if (paramInt2 > 0) {
      this.nnE = paramInt2;
    }
    if (paramInt1 > 0) {
      this.nnF = paramInt1;
    }
    AppMethodBeat.o(49964);
  }
  
  public void setOnSizeChangedListener(b paramb)
  {
    this.nnG = paramb;
  }
  
  public void setPanelManager(c paramc)
  {
    this.nni = paramc;
  }
  
  static final class a
    extends q
  {
    SparseArray<SoftReference<View>> nnH;
    private boolean nnI;
    c nni;
    
    a()
    {
      AppMethodBeat.i(49957);
      this.nnH = new SparseArray();
      this.nnI = false;
      AppMethodBeat.o(49957);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(49961);
      paramViewGroup.removeView((View)paramObject);
      AppMethodBeat.o(49961);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(49960);
      int i = this.nni.bFY().getPageCount();
      AppMethodBeat.o(49960);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(49958);
      if (this.nnI)
      {
        AppMethodBeat.o(49958);
        return -2;
      }
      int i = super.getItemPosition(paramObject);
      AppMethodBeat.o(49958);
      return i;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(49962);
      View localView = null;
      if (this.nnH.get(paramInt) != null) {
        localView = (View)((SoftReference)this.nnH.get(paramInt)).get();
      }
      if (localView == null)
      {
        localView = this.nni.bFY().wH(paramInt);
        if (localView != null)
        {
          paramViewGroup.addView(localView, 0);
          this.nnH.put(paramInt, new SoftReference(localView));
        }
        for (;;)
        {
          AppMethodBeat.o(49962);
          return localView;
          ae.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
        }
      }
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      paramViewGroup.addView(localView, 0);
      AppMethodBeat.o(49962);
      return localView;
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(49959);
      this.nnI = true;
      super.notifyDataSetChanged();
      this.nnI = false;
      AppMethodBeat.o(49959);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bFT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */