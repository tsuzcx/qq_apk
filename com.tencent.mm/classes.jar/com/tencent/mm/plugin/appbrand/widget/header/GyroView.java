package com.tencent.mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class GyroView
  extends View
{
  private float aiA;
  private float hsH = 0.0F;
  private float hsI = 0.0F;
  private float hsJ;
  private float hsK;
  private float hsL;
  private float hsM;
  private boolean hsN = false;
  private Paint mPaint;
  
  public GyroView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.hsK = (40.0F * getResources().getDisplayMetrics().density);
    this.hsJ = (100.0F * getResources().getDisplayMetrics().density);
    this.aiA = (20.0F * getResources().getDisplayMetrics().density);
    this.hsL = (10.0F * getResources().getDisplayMetrics().density);
    this.hsM = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
  }
  
  public final void b(float paramFloat, int paramInt)
  {
    float f2 = (paramFloat - this.hsK) / (paramInt - this.hsK);
    float f1 = f2;
    if (this.hsN) {
      f1 = 1.0F - f2;
    }
    this.hsI = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.hsK;
    paramFloat = f1;
    if (this.hsN) {
      paramFloat = 1.0F - f1;
    }
    this.hsH = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.hsI > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.hsL / 2.0F - this.hsI * (this.hsL - this.hsM) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.hsI * this.aiA, f2, this.hsM / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.hsI * this.aiA, f2, this.hsM / 2.0F, this.mPaint);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.hsH * this.hsL / 2.0F, this.mPaint);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    float f2 = (paramFloat - this.hsK) / (this.hsJ - this.hsK);
    float f1 = f2;
    if (this.hsN) {
      f1 = 1.0F - f2;
    }
    this.hsI = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.hsK;
    paramFloat = f1;
    if (this.hsN) {
      paramFloat = 1.0F - f1;
    }
    this.hsH = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.GyroView
 * JD-Core Version:    0.7.0.1
 */