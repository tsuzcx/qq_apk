package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class MoveDistIndicateView
  extends ImageView
{
  private static final int d = -6710887;
  private static final int e = -1;
  private static final int f = -2763307;
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public int b;
  private Bitmap b;
  private int c;
  
  public MoveDistIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    paramContext = getResources();
    this.jdField_a_of_type_Int = AIOUtils.a(20.0F, paramContext);
    this.jdField_b_of_type_Int = AIOUtils.a(34.0F, paramContext);
    this.c = this.jdField_a_of_type_Int;
    Log.d("AIOAudioPanel", "init(), mRaidusMin:" + this.jdField_a_of_type_Int + ",mRaidusMax:" + this.jdField_b_of_type_Int);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    int m = i / 2;
    int n = j / 2;
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    float f1;
    if (this.c == this.jdField_b_of_type_Int) {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        f1 = this.jdField_b_of_type_Int / this.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        m = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
        n = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((i - m * f1) / 2.0F, (j - f1 * n) / 2.0F);
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, m, n);
        paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(k);
      super.onDraw(paramCanvas);
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-6710887);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      paramCanvas.drawCircle(m, n, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
      continue;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        f1 = this.c / this.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        m = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        float f2 = (i - m * f1) * 0.5F + 0.5F;
        float f3 = (j - n * f1) * 0.5F + 0.5F;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "dx is:" + f2 + ",dy is:" + f3);
        }
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, m, n);
        paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(m, n, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2763307);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
        paramCanvas.drawCircle(m, n, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void setAfterBitmap(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setLevel(int paramInt)
  {
    this.c = (this.jdField_a_of_type_Int + (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) * paramInt / 100);
    if (paramInt == 100) {
      setPressed(true);
    }
    for (;;)
    {
      invalidate();
      return;
      setPressed(false);
    }
  }
  
  public void setScaleBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.MoveDistIndicateView
 * JD-Core Version:    0.7.0.1
 */