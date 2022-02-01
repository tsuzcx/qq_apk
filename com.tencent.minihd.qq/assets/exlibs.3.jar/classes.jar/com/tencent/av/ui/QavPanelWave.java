package com.tencent.av.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class QavPanelWave
{
  static final String jdField_a_of_type_JavaLangString = "QavPanelWave";
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  PointF jdField_a_of_type_AndroidGraphicsPointF;
  boolean jdField_a_of_type_Boolean;
  float b;
  float c;
  float d = 0.0F;
  final float e = 0.5F;
  final float f = 0.05F;
  float g;
  float h;
  
  public QavPanelWave(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, PointF paramPointF, boolean paramBoolean)
  {
    if (paramPaint == null) {}
    while (paramPointF == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void a()
  {
    this.h = 0.0F;
    this.d = 0.0F;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.h = paramFloat1;
    float f1 = this.d;
    getClass();
    if (f1 - paramFloat2 > 0.05F * 2.0F)
    {
      getClass();
      paramFloat1 = f1 - 0.05F * 2.0F;
    }
    for (;;)
    {
      getClass();
      this.d = Math.min(paramFloat1, 0.5F);
      return;
      getClass();
      paramFloat1 = paramFloat2;
      if (paramFloat2 - f1 > 0.05F * 2.0F)
      {
        getClass();
        paramFloat1 = f1 + 0.05F * 2.0F;
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!a()) {
      return;
    }
    float f4 = this.b * 0.5F;
    float f5 = this.jdField_a_of_type_Float * 0.5F;
    float f6 = this.jdField_a_of_type_Float;
    int i;
    float f1;
    float f2;
    label118:
    float f8;
    float f9;
    float f10;
    label193:
    float f3;
    if (!this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_a_of_type_Int;
      f1 = new float[] { 1.0F, 0.714F, 0.429F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }[i];
      f2 = this.d * f1;
      if (this.jdField_a_of_type_Boolean) {
        break label295;
      }
      f1 = f4 - 4.0F;
      this.jdField_a_of_type_AndroidGraphicsPath.rewind();
      i = (int)(f6 * 0.01D);
      float f7 = (float)(0.8D * f1 * f2);
      double d1 = f1;
      f8 = (float)(f2 * (1.0D * d1));
      f9 = (float)(6.283185307179586D * this.c) / f6;
      f10 = this.jdField_a_of_type_Int + this.h;
      f2 = 0.0F;
      if (f2 >= i + f6) {
        break label440;
      }
      if (this.jdField_a_of_type_Boolean) {
        break label305;
      }
      f3 = (float)(f7 * Math.sin(f2 * f9 + f10));
      label231:
      if (this.jdField_a_of_type_Boolean) {
        break label341;
      }
      f3 += f4;
      if (f2 != 0.0F) {
        break label327;
      }
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f2, f3);
    }
    for (;;)
    {
      f2 = i + f2;
      break label193;
      f1 = 1.5F * (1.0F - this.jdField_a_of_type_Int / 3.0F) - 0.5F;
      break;
      label295:
      f1 = f5 / 6.0F;
      break label118;
      label305:
      f3 = (float)(f8 * Math.sin(f2 * f9 + f10));
      break label231;
      label327:
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f2, f3);
      continue;
      label341:
      float f11 = (float)((f3 + f5 - f1) * Math.cos(f2 / f6 * 2.0F * 3.141592653589793D) + f5);
      f3 = (float)((f3 + f5 - f1) * Math.sin(f2 / f6 * 2.0F * 3.141592653589793D) + f4);
      if (f2 == 0.0F) {
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f11, f3);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f11, f3);
      }
    }
    label440:
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(Paint paramPaint)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
  }
  
  boolean a()
  {
    if ((this.jdField_a_of_type_Float <= 0.0F) || (this.b <= 0.0F)) {}
    while ((this.c <= 0.0F) || (this.jdField_a_of_type_AndroidGraphicsPaint == null) || (this.jdField_a_of_type_AndroidGraphicsPath == null) || (this.jdField_a_of_type_AndroidGraphicsPointF == null)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelWave
 * JD-Core Version:    0.7.0.1
 */