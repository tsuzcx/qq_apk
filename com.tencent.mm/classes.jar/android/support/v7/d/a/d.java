package android.support.v7.d.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;

public final class d
  extends Drawable
{
  private static final float acI = (float)Math.toRadians(45.0D);
  private float acJ;
  private float acK;
  private float acL;
  private float acM;
  private boolean acN;
  private boolean acO;
  private float acP;
  private int acQ;
  private final Paint mPaint;
  private float mProgress;
  private final int mSize;
  private final Path xN;
  
  public final void aa(boolean paramBoolean)
  {
    if (this.acO != paramBoolean)
    {
      this.acO = paramBoolean;
      invalidateSelf();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i;
    float f1;
    float f2;
    switch (this.acQ)
    {
    case 2: 
    default: 
      if (a.k(this) == 1)
      {
        i = 1;
        f1 = (float)Math.sqrt(this.acJ * this.acJ * 2.0F);
        f2 = this.acK;
        float f6 = f2 + (f1 - f2) * this.mProgress;
        f1 = this.acK;
        float f3 = f1 + (this.acL - f1) * this.mProgress;
        float f4 = Math.round(0.0F + (this.acP - 0.0F) * this.mProgress);
        float f7 = 0.0F + (acI - 0.0F) * this.mProgress;
        if (i == 0) {
          break label476;
        }
        f1 = 0.0F;
        label145:
        if (i == 0) {
          break label482;
        }
        f2 = 180.0F;
        label153:
        float f5 = this.mProgress;
        float f8 = (float)Math.round(f6 * Math.cos(f7));
        f6 = (float)Math.round(f6 * Math.sin(f7));
        this.xN.rewind();
        f7 = this.acM + this.mPaint.getStrokeWidth();
        f7 += (-this.acP - f7) * this.mProgress;
        float f9 = -f3 / 2.0F;
        this.xN.moveTo(f9 + f4, 0.0F);
        this.xN.rLineTo(f3 - f4 * 2.0F, 0.0F);
        this.xN.moveTo(f9, f7);
        this.xN.rLineTo(f8, f6);
        this.xN.moveTo(f9, -f7);
        this.xN.rLineTo(f8, -f6);
        this.xN.close();
        paramCanvas.save();
        f3 = this.mPaint.getStrokeWidth();
        f4 = (int)(localRect.height() - 3.0F * f3 - this.acM * 2.0F) / 4 * 2;
        f6 = this.acM;
        paramCanvas.translate(localRect.centerX(), f3 * 1.5F + f6 + f4);
        if (!this.acN) {
          break label493;
        }
        if ((i ^ this.acO) == 0) {
          break label487;
        }
        i = -1;
        label406:
        paramCanvas.rotate(i * ((f2 - f1) * f5 + f1));
      }
      break;
    }
    for (;;)
    {
      paramCanvas.drawPath(this.xN, this.mPaint);
      paramCanvas.restore();
      return;
      i = 0;
      break;
      i = 1;
      break;
      if (a.k(this) == 0)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
      break;
      label476:
      f1 = -180.0F;
      break label145;
      label482:
      f2 = 0.0F;
      break label153;
      label487:
      i = 1;
      break label406;
      label493:
      if (i != 0) {
        paramCanvas.rotate(180.0F);
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.mSize;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.mSize;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void setProgress(float paramFloat)
  {
    if (this.mProgress != paramFloat)
    {
      this.mProgress = paramFloat;
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.d.a.d
 * JD-Core Version:    0.7.0.1
 */