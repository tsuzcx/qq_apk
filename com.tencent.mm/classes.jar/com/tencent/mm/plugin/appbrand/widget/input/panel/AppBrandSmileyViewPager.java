package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class AppBrandSmileyViewPager
  extends CustomViewPager
{
  private c mHC;
  private int mHY;
  private int mHZ;
  private b mIa;
  
  public AppBrandSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49963);
    this.mHY = 0;
    this.mHZ = 0;
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
    AppMethodBeat.o(49963);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49964);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mHC != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.mHY)) || ((paramInt1 > 0) && (paramInt1 != this.mHZ))))))
    {
      this.mHC.mHV = paramInt2;
      this.mHC.mHW = paramInt1;
      if (this.mIa != null) {
        this.mIa.bAZ();
      }
    }
    if (paramInt2 > 0) {
      this.mHY = paramInt2;
    }
    if (paramInt1 > 0) {
      this.mHZ = paramInt1;
    }
    AppMethodBeat.o(49964);
  }
  
  public void setOnSizeChangedListener(b paramb)
  {
    this.mIa = paramb;
  }
  
  public void setPanelManager(c paramc)
  {
    this.mHC = paramc;
  }
  
  static final class a
    extends q
  {
    c mHC;
    SparseArray<SoftReference<View>> mIb;
    private boolean mIc;
    
    a()
    {
      AppMethodBeat.i(49957);
      this.mIb = new SparseArray();
      this.mIc = false;
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
      int i = this.mHC.bBe().getPageCount();
      AppMethodBeat.o(49960);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(49958);
      if (this.mIc)
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
      if (this.mIb.get(paramInt) != null) {
        localView = (View)((SoftReference)this.mIb.get(paramInt)).get();
      }
      if (localView == null)
      {
        localView = this.mHC.bBe().vX(paramInt);
        if (localView != null)
        {
          paramViewGroup.addView(localView, 0);
          this.mIb.put(paramInt, new SoftReference(localView));
        }
        for (;;)
        {
          AppMethodBeat.o(49962);
          return localView;
          ac.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
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
      this.mIc = true;
      super.notifyDataSetChanged();
      this.mIc = false;
      AppMethodBeat.o(49959);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bAZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */