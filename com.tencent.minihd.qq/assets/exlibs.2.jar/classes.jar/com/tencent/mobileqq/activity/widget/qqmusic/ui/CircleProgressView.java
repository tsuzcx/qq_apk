package com.tencent.mobileqq.activity.widget.qqmusic.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.minihd.qq.R.styleable;

public class CircleProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private int f;
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 100;
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 100;
    a(paramContext, paramAttributeSet);
    a();
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 100;
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Float);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setARGB(255, 255, 255, 255);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float / 2.0F);
    Paint.FontMetrics localFontMetrics = this.jdField_c_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.jdField_e_of_type_Float = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.E, 0, 0);
    this.jdField_a_of_type_Float = paramContext.getDimension(0, 80.0F);
    this.jdField_c_of_type_Float = paramContext.getDimension(1, 10.0F);
    this.jdField_b_of_type_Int = paramContext.getColor(2, -1);
    this.jdField_c_of_type_Int = paramContext.getColor(3, -1);
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + this.jdField_c_of_type_Float / 2.0F);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.d = (getWidth() / 2);
    this.jdField_e_of_type_Int = (getHeight() / 2);
    paramCanvas.drawCircle(this.d, this.jdField_e_of_type_Int, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.f > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.d - this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_e_of_type_Int - this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_b_of_type_Float * 2.0F + (this.d - this.jdField_b_of_type_Float));
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Float * 2.0F + (this.jdField_e_of_type_Int - this.jdField_b_of_type_Float));
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F * (this.f / this.jdField_a_of_type_Int), false, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.f = paramInt;
    postInvalidate();
  }
  
  public void setProgress(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    postInvalidate();
  }
  
  public void setRadius(int paramInt)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + this.jdField_c_of_type_Float / 2.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.ui.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */