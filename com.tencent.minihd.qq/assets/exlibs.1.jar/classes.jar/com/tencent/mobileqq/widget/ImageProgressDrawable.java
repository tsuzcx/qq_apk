package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import com.tencent.minihd.qq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class ImageProgressDrawable
  extends Drawable
{
  float jdField_a_of_type_Float = 2.0F;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int;
  float jdField_d_of_type_Float = 0.0F;
  int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float = 0.2F;
  int jdField_e_of_type_Int = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  private int i;
  private int j = 1000;
  
  public ImageProgressDrawable(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.jdField_c_of_type_Float = paramFloat1;
    this.jdField_d_of_type_Float = paramFloat2;
    this.jdField_b_of_type_Float = paramInt4;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public ImageProgressDrawable(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.J);
    this.g = paramContext.getColor(0, 2131427375);
    this.f = paramContext.getColor(1, 2131427405);
    this.jdField_e_of_type_Int = paramContext.getColor(2, 2131427404);
    this.h = paramContext.getColor(3, 2131427404);
    this.jdField_c_of_type_Float = paramContext.getDimension(5, 8.0F);
    this.jdField_d_of_type_Float = paramContext.getDimension(6, 4.0F);
    this.jdField_b_of_type_Float = paramContext.getDimension(7, 20.0F);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 10000;
    float f1;
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (this.g != 0)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_d_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_Int - this.jdField_b_of_type_Float, this.jdField_d_of_type_Int - this.jdField_b_of_type_Float, this.jdField_c_of_type_Int + this.jdField_b_of_type_Float, this.jdField_d_of_type_Int + this.jdField_b_of_type_Float);
        f1 = 360.0F * this.jdField_a_of_type_Int / 10000.0F;
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      invalidateSelf();
      return;
    }
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    long l2 = l1 - this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_Boolean)
    {
      f1 = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_Int = ((int)((float)l2 * f1) + this.jdField_a_of_type_Int);
      label290:
      if (this.jdField_a_of_type_Int >= this.j) {
        this.jdField_a_of_type_Boolean = true;
      }
      int m = Math.max(this.i, this.j);
      if (this.jdField_a_of_type_Int > m) {
        this.jdField_a_of_type_Int = m;
      }
      if (this.jdField_a_of_type_Int < 10000) {
        break label381;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = k;
      this.jdField_b_of_type_Long = l1;
      break;
      f1 = this.jdField_e_of_type_Float;
      this.jdField_a_of_type_Int = ((int)((float)l2 * f1) + this.jdField_a_of_type_Int);
      break label290;
      label381:
      k = this.jdField_a_of_type_Int;
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_c_of_type_Int = paramRect.centerX();
    this.jdField_d_of_type_Int = paramRect.centerY();
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    super.onLevelChange(paramInt);
    this.i = paramInt;
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ImageProgressDrawable", 2, "level:" + paramInt);
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_b_of_type_Int = paramInt;
    }
    while ((paramInt <= 0) || (paramInt >= 10000)) {
      return true;
    }
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    float f1 = paramInt / (float)(l1 - l2);
    l1 = ((10000 - paramInt) / f1);
    this.jdField_a_of_type_Float = ((10000.0F - this.jdField_a_of_type_Int) / (float)l1);
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageProgressDrawable
 * JD-Core Version:    0.7.0.1
 */