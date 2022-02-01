package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ScaleTxtAnimation
  extends Animation
{
  public static final int a = 600;
  private float jdField_a_of_type_Float;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private float b;
  private float c;
  
  public ScaleTxtAnimation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    setDuration(600L);
    setFillAfter(true);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat > 0.5F) {}
    for (paramFloat = (paramFloat - 0.5F) / 0.5F * (this.c - this.b) + this.b;; paramFloat = this.jdField_a_of_type_Float - paramFloat / 0.5F * (this.jdField_a_of_type_Float - this.b))
    {
      paramTransformation = paramTransformation.getMatrix();
      this.jdField_a_of_type_AndroidGraphicsCamera.save();
      this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(paramTransformation);
      paramTransformation.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsCamera.restore();
      return;
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScaleTxtAnimation
 * JD-Core Version:    0.7.0.1
 */