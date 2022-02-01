package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class RatioLayout
  extends ViewGroup
{
  boolean a = false;
  
  public RatioLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView, (int)(getWidth() * paramFloat1), (int)(getHeight() * paramFloat2));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    RatioLayout.LayoutParams localLayoutParams;
    if ((paramView != null) && (paramView.getParent() == this))
    {
      localLayoutParams = (RatioLayout.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label100;
      }
      f2 = localLayoutParams.c;
    }
    label100:
    for (float f1 = localLayoutParams.d;; f1 = 0.0F)
    {
      int j = paramView.getWidth();
      int i = paramView.getHeight();
      j = (int)(f2 * j);
      i = (int)(f1 * i);
      paramView.offsetLeftAndRight(paramInt1 - j - paramView.getLeft());
      paramView.offsetTopAndBottom(paramInt2 - i - paramView.getTop());
      return;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof RatioLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new RatioLayout.LayoutParams(-2, -2, 0.0F, 0.0F);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new RatioLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)localView.getLayoutParams();
        paramInt3 = localView.getMeasuredWidth();
        paramInt4 = localView.getMeasuredHeight();
        int i = this.mPaddingLeft + (int)(localLayoutParams.a * getMeasuredWidth()) - (int)(localLayoutParams.c * paramInt3);
        int j = this.mPaddingTop + (int)(localLayoutParams.b * getMeasuredHeight()) - (int)(localLayoutParams.d * paramInt4);
        localView.layout(i, j, paramInt3 + i, paramInt4 + j);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = getChildCount();
    if (this.a)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    measureChildren(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    if (k < n)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8) {
        break label258;
      }
      RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)localView.getLayoutParams();
      m = localView.getMeasuredWidth();
      int i3 = localView.getMeasuredHeight();
      int i6 = (int)(localLayoutParams.a * i1);
      int i7 = (int)(localLayoutParams.c * m);
      int i4 = (int)(localLayoutParams.b * i2);
      int i5 = (int)(localLayoutParams.d * i3);
      m = Math.max(j, m + (i6 - i7));
      j = Math.max(i, i3 + (i4 - i5));
      i = m;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      k = this.mPaddingLeft;
      m = this.mPaddingRight;
      i = Math.max(this.mPaddingTop + this.mPaddingBottom + i, getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(k + m + j, getSuggestedMinimumWidth()), paramInt1), resolveSize(i, paramInt2));
      return;
      label258:
      m = i;
      i = j;
      j = m;
    }
  }
  
  public void setSkipMeasure(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RatioLayout
 * JD-Core Version:    0.7.0.1
 */