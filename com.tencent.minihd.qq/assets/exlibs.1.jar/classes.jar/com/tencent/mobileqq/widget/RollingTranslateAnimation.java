package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RollingTranslateAnimation
  extends Animation
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int = 0;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 0;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 0;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k = 0.0F;
  private float l = 0.0F;
  private float m;
  private float n;
  
  public RollingTranslateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.jdField_d_of_type_Float = paramFloat4;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.i = paramFloat5;
    this.j = paramFloat6;
    this.k = 0.5F;
    this.jdField_e_of_type_Int = 1;
    this.l = 0.5F;
    this.jdField_f_of_type_Int = 1;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.i + (this.j - this.i) * paramFloat;
    if ((this.m == 0.0F) && (this.n == 0.0F)) {
      paramTransformation.getMatrix().setRotate(f1);
    }
    for (;;)
    {
      f1 = this.jdField_e_of_type_Float;
      float f2 = this.g;
      if (this.jdField_e_of_type_Float != this.jdField_f_of_type_Float) {
        f1 = this.jdField_e_of_type_Float + (this.jdField_f_of_type_Float - this.jdField_e_of_type_Float) * paramFloat;
      }
      if (this.g != this.h) {
        f2 = this.g + (this.h - this.g) * paramFloat;
      }
      paramTransformation.getMatrix().postTranslate(f1, f2);
      return;
      paramTransformation.getMatrix().setRotate(f1, this.m, this.n);
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_e_of_type_Float = resolveSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, paramInt1, paramInt3);
    this.jdField_f_of_type_Float = resolveSize(this.jdField_b_of_type_Int, this.jdField_b_of_type_Float, paramInt1, paramInt3);
    this.g = resolveSize(this.jdField_c_of_type_Int, this.jdField_c_of_type_Float, paramInt2, paramInt4);
    this.h = resolveSize(this.jdField_d_of_type_Int, this.jdField_d_of_type_Float, paramInt2, paramInt4);
    this.m = resolveSize(this.jdField_e_of_type_Int, this.k, paramInt1, paramInt3);
    this.n = resolveSize(this.jdField_f_of_type_Int, this.l, paramInt2, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RollingTranslateAnimation
 * JD-Core Version:    0.7.0.1
 */