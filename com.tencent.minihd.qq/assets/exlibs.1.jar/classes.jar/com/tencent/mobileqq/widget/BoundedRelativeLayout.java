package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class BoundedRelativeLayout
  extends RelativeLayout
{
  private int a;
  private int b;
  
  public BoundedRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BoundedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BoundedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = paramInt1;
    if (this.a > 0)
    {
      i = paramInt1;
      if (this.a < j)
      {
        paramInt1 = View.MeasureSpec.getMode(paramInt1);
        i = View.MeasureSpec.makeMeasureSpec(this.a, paramInt1);
      }
    }
    j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = paramInt2;
    if (this.b > 0)
    {
      paramInt1 = paramInt2;
      if (this.b < j)
      {
        paramInt1 = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.b, paramInt1);
      }
    }
    super.onMeasure(i, paramInt1);
  }
  
  public void setBoundedHeight(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setBoundedWidth(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BoundedRelativeLayout
 * JD-Core Version:    0.7.0.1
 */