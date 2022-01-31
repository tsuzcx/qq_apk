package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.CustomViewPager;

public class AppBrandSmileyViewPager
  extends CustomViewPager
{
  private c hxA;
  private int hxX = 0;
  private int hxY = 0;
  private AppBrandSmileyViewPager.b hxZ;
  
  public AppBrandSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.hxA != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.hxX)) || ((paramInt1 > 0) && (paramInt1 != this.hxY))))))
    {
      this.hxA.hxU = paramInt2;
      this.hxA.hxV = paramInt1;
      if (this.hxZ != null) {
        this.hxZ.asF();
      }
    }
    if (paramInt2 > 0) {
      this.hxX = paramInt2;
    }
    if (paramInt1 > 0) {
      this.hxY = paramInt1;
    }
  }
  
  public void setOnSizeChangedListener(AppBrandSmileyViewPager.b paramb)
  {
    this.hxZ = paramb;
  }
  
  public void setPanelManager(c paramc)
  {
    this.hxA = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */