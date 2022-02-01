package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

public class ProgressButton
  extends Button
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 100;
  
  public ProgressButton(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    int i = getResources().getColor(2131427957);
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = (getWidth() / this.jdField_b_of_type_Int);
    }
    paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Float * this.jdField_b_of_type_Float, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    super.onDraw(paramCanvas);
  }
  
  public void setMacProgress(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_b_of_type_Float = paramInt;
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressButton
 * JD-Core Version:    0.7.0.1
 */