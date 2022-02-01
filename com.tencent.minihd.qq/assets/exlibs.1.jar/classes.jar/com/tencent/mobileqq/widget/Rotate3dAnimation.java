package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation
  extends Animation
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private final boolean jdField_a_of_type_Boolean;
  private final float b;
  private float c;
  private float d;
  private final float e;
  
  public Rotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    this(paramFloat1, paramFloat2, 0, paramFloat3, paramFloat4, paramFloat5, paramBoolean);
  }
  
  public Rotate3dAnimation(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    Camera localCamera = this.jdField_a_of_type_AndroidGraphicsCamera;
    paramTransformation = paramTransformation.getMatrix();
    localCamera.save();
    if (this.jdField_a_of_type_Boolean) {
      localCamera.translate(0.0F, 0.0F, this.e * paramFloat);
    }
    for (;;)
    {
      localCamera.rotateY(f1 + (f2 - f1) * paramFloat);
      localCamera.getMatrix(paramTransformation);
      localCamera.restore();
      paramTransformation.preTranslate(-f3, -f4);
      paramTransformation.postTranslate(f3, f4);
      return;
      localCamera.translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
    if (this.jdField_a_of_type_Int == 1)
    {
      this.c = (paramInt1 * this.c);
      this.d = (paramInt2 * this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Rotate3dAnimation
 * JD-Core Version:    0.7.0.1
 */