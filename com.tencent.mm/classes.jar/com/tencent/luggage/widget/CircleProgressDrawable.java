package com.tencent.luggage.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public final class CircleProgressDrawable
  extends Drawable
{
  private static final RectF bjX = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
  private static final RectF bjY = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
  private int bjZ;
  private int bka;
  private boolean bkb;
  private int bkc;
  private CircleProgressDrawable.RingPathTransform bkd;
  private CircleProgressDrawable.RingRotation bke;
  private Paint mPaint;
  private int mZ;
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject = getBounds();
    if ((((Rect)localObject).width() == 0) || (((Rect)localObject).height() == 0)) {
      return;
    }
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.bka);
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setStrokeJoin(Paint.Join.MITER);
    }
    int i = paramCanvas.save();
    paramCanvas.translate(((Rect)localObject).left, ((Rect)localObject).top);
    int j = ((Rect)localObject).width();
    int k = ((Rect)localObject).height();
    localObject = this.mPaint;
    paramCanvas.scale(j / bjX.width(), k / bjX.height());
    paramCanvas.translate(bjX.width() / 2.0F, bjX.height() / 2.0F);
    if (this.bkb)
    {
      j = paramCanvas.save();
      ((Paint)localObject).setColor(this.bkc);
      paramCanvas.drawArc(bjY, 0.0F, 360.0F, false, (Paint)localObject);
      paramCanvas.restoreToCount(j);
    }
    j = paramCanvas.save();
    ((Paint)localObject).setColor(this.mZ);
    paramCanvas.rotate(CircleProgressDrawable.RingRotation.a(this.bke));
    float f1 = this.bkd.nh;
    float f2 = this.bkd.nf;
    float f3 = this.bkd.ng;
    float f4 = this.bkd.nf;
    paramCanvas.drawArc(bjY, -90.0F + (f1 + f2) * 360.0F, 360.0F * (f3 - f4), false, (Paint)localObject);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.bjZ;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.bjZ;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.widget.CircleProgressDrawable
 * JD-Core Version:    0.7.0.1
 */