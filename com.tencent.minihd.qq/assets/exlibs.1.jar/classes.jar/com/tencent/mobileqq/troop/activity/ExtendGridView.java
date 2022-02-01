package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.minihd.qq.R.styleable;

public class ExtendGridView
  extends GridView
{
  protected int a;
  protected boolean a;
  protected int b;
  protected boolean b;
  private int c;
  private int d;
  private int e;
  
  public ExtendGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.y);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(0, false);
    this.jdField_b_of_type_Boolean = paramContext.getBoolean(1, false);
    paramContext.recycle();
    a();
  }
  
  private void a()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    this.jdField_a_of_type_Int = localDisplay.getWidth();
    this.jdField_b_of_type_Int = localDisplay.getHeight();
  }
  
  public int a()
  {
    if (getWidth() > 0) {}
    for (int i = getWidth();; i = getMeasuredWidth())
    {
      int j = i;
      if (i <= 0) {
        j = this.jdField_a_of_type_Int;
      }
      i = getHorizontalSpacing();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      int n = getNumColumns();
      j = (j - (k + m) - i * (n - 1)) / n;
      i = j;
      if (j < 0) {
        i = -2;
      }
      return i;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int getHorizontalSpacing()
  {
    return this.c;
  }
  
  public int getNumColumns()
  {
    return this.e;
  }
  
  public int getVerticalSpacing()
  {
    return this.d;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((this.jdField_b_of_type_Boolean) && (i < 0)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    super.setHorizontalSpacing(paramInt);
    this.c = paramInt;
  }
  
  public void setNumColumns(int paramInt)
  {
    super.setNumColumns(paramInt);
    this.e = paramInt;
  }
  
  public void setPenetrateTouch(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setStretchable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      requestLayout();
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    super.setVerticalSpacing(paramInt);
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.ExtendGridView
 * JD-Core Version:    0.7.0.1
 */