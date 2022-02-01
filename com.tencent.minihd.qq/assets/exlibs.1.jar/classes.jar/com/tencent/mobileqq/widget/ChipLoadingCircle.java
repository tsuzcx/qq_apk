package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class ChipLoadingCircle
  extends View
  implements Handler.Callback
{
  public static final int a = 33;
  public static final int b = 10;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 332;
  private float jdField_a_of_type_Float = 2.0F;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private float b;
  private float c;
  private int f = -8355712;
  
  public ChipLoadingCircle(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChipLoadingCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChipLoadingCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsRectF == null) || (this.jdField_a_of_type_AndroidGraphicsPaint == null))
    {
      int i = getWidth();
      int j = getHeight();
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Float / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (i - this.jdField_a_of_type_Float / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j - this.jdField_a_of_type_Float / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((getVisibility() == 0) && (paramMessage.what == 0))
    {
      if (this.c >= 332.0F) {
        break label57;
      }
      this.c += 10.0F;
      if (this.c > 332.0F) {
        this.c = 332.0F;
      }
    }
    for (;;)
    {
      postInvalidate();
      return true;
      label57:
      this.b += 10.0F;
      if (this.b > 360.0F) {
        this.b -= 360.0F;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a();
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.b, this.c, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 33L);
    }
  }
  
  public void requestLayout() {}
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt)
    {
      if (paramInt != 0) {
        break label55;
      }
      this.b = 0.0F;
      this.c = 10.0F;
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      }
      invalidate();
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      label55:
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChipLoadingCircle
 * JD-Core Version:    0.7.0.1
 */