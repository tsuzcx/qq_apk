package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.widget.XListView;

public class MaxHeightListView
  extends XListView
{
  private int a = 0;
  
  public MaxHeightListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaxHeightListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public MaxHeightListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = paramContext.getResources().getConfiguration().orientation;
    int i = paramContext.getResources().getDimensionPixelSize(2131493497);
    if (paramInt == 1) {}
    for (paramInt = i * 4;; paramInt = i * 3)
    {
      this.a = paramInt;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.a, -2147483648));
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MaxHeightListView
 * JD-Core Version:    0.7.0.1
 */