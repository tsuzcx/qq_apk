package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class GestureSelectGridView
  extends GridView
{
  public static final float a = 1.73F;
  private int jdField_a_of_type_Int;
  private GestureSelectGridView.OnSelectListener jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -1;
  
  public GestureSelectGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GestureSelectGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.jdField_a_of_type_Boolean)) {}
    boolean bool;
    do
    {
      for (;;)
      {
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        switch (i & 0xFF)
        {
        default: 
        case 2: 
        case 0: 
          while (!this.jdField_a_of_type_Boolean)
          {
            return super.onInterceptTouchEvent(paramMotionEvent);
            float f3 = Math.abs(f1 - this.jdField_b_of_type_Float);
            if ((f3 > Math.abs(f2 - this.jdField_c_of_type_Float) * 1.73F) && (f3 > this.jdField_a_of_type_Int))
            {
              this.jdField_a_of_type_Boolean = true;
              this.jdField_b_of_type_Float = f1;
              this.jdField_c_of_type_Float = f2;
              continue;
              this.jdField_b_of_type_Float = f1;
              this.jdField_c_of_type_Float = f2;
              i = a((int)f1, (int)f2);
              if (i != -1)
              {
                this.jdField_c_of_type_Int = i;
                this.jdField_b_of_type_Int = i;
              }
            }
          }
        }
      }
      bool = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
    } while (!bool);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    }
    while (this.jdField_a_of_type_Boolean)
    {
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        float f3 = Math.abs(f1 - this.jdField_b_of_type_Float);
        if ((f3 > Math.abs(f2 - this.jdField_c_of_type_Float) * 1.73F) && (f3 > this.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_Float = f1;
          this.jdField_c_of_type_Float = f2;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int != -1))
        {
          if (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener != null) {
            this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener.a(this.jdField_b_of_type_Int);
          }
          this.jdField_b_of_type_Boolean = true;
        }
        i = a((int)f1, (int)f2);
        if (i != -1) {
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_c_of_type_Int = i;
            this.jdField_b_of_type_Int = i;
            if (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener != null) {
              this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener.a(this.jdField_b_of_type_Int);
            }
            this.jdField_b_of_type_Boolean = true;
          }
          else if (this.jdField_c_of_type_Int != i)
          {
            this.jdField_c_of_type_Int = i;
            if (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener != null)
            {
              this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
              continue;
              this.jdField_b_of_type_Float = f1;
              this.jdField_c_of_type_Float = f2;
              continue;
              boolean bool = this.jdField_a_of_type_Boolean;
              this.jdField_b_of_type_Int = -1;
              this.jdField_c_of_type_Int = -1;
              this.jdField_a_of_type_Boolean = false;
              this.jdField_b_of_type_Boolean = false;
              if (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener != null) {
                this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener.a();
              }
              if (bool) {
                return true;
              }
            }
          }
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnIndexChangedListener(GestureSelectGridView.OnSelectListener paramOnSelectListener)
  {
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener = paramOnSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.GestureSelectGridView
 * JD-Core Version:    0.7.0.1
 */