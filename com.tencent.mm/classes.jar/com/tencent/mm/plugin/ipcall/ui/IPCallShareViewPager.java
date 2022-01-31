package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.ui.base.CustomViewPager;

public class IPCallShareViewPager
  extends CustomViewPager
{
  public IPCallShareViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    int j;
    for (int i = 0; paramInt2 < getChildCount(); i = j)
    {
      View localView = getChildAt(paramInt2);
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int k = localView.getMeasuredHeight();
      j = i;
      if (k > i) {
        j = k;
      }
      paramInt2 += 1;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareViewPager
 * JD-Core Version:    0.7.0.1
 */