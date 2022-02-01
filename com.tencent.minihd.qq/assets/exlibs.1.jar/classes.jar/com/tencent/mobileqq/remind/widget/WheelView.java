package com.tencent.mobileqq.remind.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Transformation;
import com.tencent.widget.VerticalGallery;

public class WheelView
  extends VerticalGallery
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { -15658735, 11184810, 11184810 };
  private float jdField_a_of_type_Float = -0.1F;
  private int jdField_a_of_type_Int = 0;
  private Camera jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = null;
  private float jdField_b_of_type_Float = 0.8F;
  private int jdField_b_of_type_Int = 80;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private GradientDrawable jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable = null;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = -25.0F;
  private int jdField_c_of_type_Int = -80;
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(View paramView)
  {
    int i = d(paramView);
    float f2 = (this.jdField_a_of_type_Int - i) / this.jdField_a_of_type_Int * this.jdField_b_of_type_Int;
    float f1;
    if (f2 > this.jdField_b_of_type_Int) {
      f1 = this.jdField_b_of_type_Int;
    }
    do
    {
      return f1;
      f1 = f2;
    } while (f2 >= -this.jdField_b_of_type_Int);
    return -this.jdField_b_of_type_Int;
  }
  
  private int a()
  {
    return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
  }
  
  private void a(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    setSlotInCenter(true);
    setOrientation(2);
    setGravity(1);
    setUnselectedAlpha(0.5F);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, jdField_a_of_type_ArrayOfInt);
    this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, jdField_a_of_type_ArrayOfInt);
    setSoundEffectsEnabled(true);
    setStaticTransformationsEnabled(true);
    setChildrenDrawingOrderEnabled(true);
    if (getResources().getDisplayMetrics().densityDpi <= 160) {
      this.jdField_c_of_type_Int = -40;
    }
  }
  
  private void a(View paramView, Transformation paramTransformation, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramTransformation.clear();
    paramTransformation.setTransformationType(3);
    Matrix localMatrix = paramTransformation.getMatrix();
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    this.jdField_a_of_type_AndroidGraphicsCamera.save();
    this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, 100.0F);
    paramTransformation.setAlpha(paramFloat4);
    if ((!Build.MODEL.equals("HUAWEI Y325-T00")) && (!Build.MODEL.equals("Lenovo A318t")) && (!Build.MODEL.equals("Lenovo A308t")) && (!Build.MODEL.equals("Lenovo A269"))) {
      this.jdField_a_of_type_AndroidGraphicsCamera.rotateX(paramFloat1);
    }
    this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(localMatrix);
    localMatrix.preSkew(paramFloat3, 0.0F);
    localMatrix.preTranslate(paramFloat5, 0.0F);
    localMatrix.preTranslate(-i / 2, -j / 2);
    localMatrix.postTranslate(i / 2, j / 2);
    this.jdField_a_of_type_AndroidGraphicsCamera.restore();
  }
  
  private float b(View paramView)
  {
    int i = d(paramView);
    if (i < this.jdField_a_of_type_Int) {
      return i / this.jdField_a_of_type_Int * this.jdField_c_of_type_Int;
    }
    if (i > this.jdField_a_of_type_Int) {
      return (this.jdField_a_of_type_Int * 2 - i) / this.jdField_a_of_type_Int * this.jdField_c_of_type_Int;
    }
    return this.jdField_c_of_type_Int;
  }
  
  private float c(View paramView)
  {
    float f = this.jdField_b_of_type_Float;
    return (1.0F - Math.abs(d(paramView) - this.jdField_a_of_type_Int) / this.jdField_a_of_type_Int) * this.jdField_b_of_type_Float;
  }
  
  private float d(View paramView)
  {
    int i = d(paramView);
    if (this.jdField_a_of_type_Float == -0.1F) {
      return (this.jdField_a_of_type_Int - i) / this.jdField_a_of_type_Int * this.jdField_a_of_type_Float;
    }
    return (this.jdField_a_of_type_Int - i) / this.jdField_a_of_type_Int * this.jdField_a_of_type_Float;
  }
  
  private int d(View paramView)
  {
    return paramView.getTop() + paramView.getHeight() / 2;
  }
  
  private float e(View paramView)
  {
    float f = 0.0F;
    int i = d(paramView);
    if (this.jdField_b_of_type_Boolean) {
      f = Math.abs(this.jdField_a_of_type_Int - i) / this.jdField_a_of_type_Int * this.jdField_c_of_type_Float;
    }
    return f;
  }
  
  protected void d_()
  {
    super.d_();
    playSoundEffect(0);
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    float f1 = a(paramView);
    float f2 = b(paramView);
    float f3 = d(paramView);
    float f4 = e(paramView);
    a(paramView, paramTransformation, f1, f2, f3, c(paramView), f4);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = a();
    paramInt2 = c();
    View localView = getChildAt(0);
    if (localView != null) {}
    for (paramInt1 = localView.getMeasuredHeight();; paramInt1 = 50)
    {
      paramInt2 -= paramInt1 / 2;
      this.jdField_b_of_type_AndroidGraphicsRect.set(getPaddingLeft(), paramInt2, getWidth() - getPaddingRight(), paramInt1 + paramInt2);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = a();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      getParent().requestDisallowInterceptTouchEvent(false);
    }
  }
  
  public void setNeedTranslate(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setmMaxRotationAngle(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setmMaxSkew(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.WheelView
 * JD-Core Version:    0.7.0.1
 */