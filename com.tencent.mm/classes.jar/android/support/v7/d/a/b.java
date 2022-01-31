package android.support.v7.d.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.a;

public final class b
  extends Drawable
{
  private static final float Sm = (float)Math.toRadians(45.0D);
  private float Sn;
  private float So;
  private float Sp;
  private float Sq;
  private boolean Sr;
  private boolean Ss;
  public float St;
  private float Su;
  private int Sv;
  private final Paint mPaint;
  private final int mSize;
  private final Path nw;
  
  public final void S(boolean paramBoolean)
  {
    if (this.Ss != paramBoolean)
    {
      this.Ss = paramBoolean;
      invalidateSelf();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i;
    float f1;
    float f2;
    switch (this.Sv)
    {
    case 2: 
    default: 
      if (a.g(this) == 1)
      {
        i = 1;
        f1 = (float)Math.sqrt(this.Sn * this.Sn * 2.0F);
        f2 = this.So;
        float f6 = f2 + (f1 - f2) * this.St;
        f1 = this.So;
        float f3 = f1 + (this.Sp - f1) * this.St;
        float f4 = Math.round(0.0F + (this.Su - 0.0F) * this.St);
        float f7 = 0.0F + (Sm - 0.0F) * this.St;
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
        float f5 = this.St;
        float f8 = (float)Math.round(f6 * Math.cos(f7));
        f6 = (float)Math.round(f6 * Math.sin(f7));
        this.nw.rewind();
        f7 = this.Sq + this.mPaint.getStrokeWidth();
        f7 += (-this.Su - f7) * this.St;
        float f9 = -f3 / 2.0F;
        this.nw.moveTo(f9 + f4, 0.0F);
        this.nw.rLineTo(f3 - f4 * 2.0F, 0.0F);
        this.nw.moveTo(f9, f7);
        this.nw.rLineTo(f8, f6);
        this.nw.moveTo(f9, -f7);
        this.nw.rLineTo(f8, -f6);
        this.nw.close();
        paramCanvas.save();
        f3 = this.mPaint.getStrokeWidth();
        f4 = (int)(localRect.height() - 3.0F * f3 - this.Sq * 2.0F) / 4 * 2;
        f6 = this.Sq;
        paramCanvas.translate(localRect.centerX(), f3 * 1.5F + f6 + f4);
        if (!this.Sr) {
          break label493;
        }
        if ((i ^ this.Ss) == 0) {
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
      paramCanvas.drawPath(this.nw, this.mPaint);
      paramCanvas.restore();
      return;
      i = 0;
      break;
      i = 1;
      break;
      if (a.g(this) == 0)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.b
 * JD-Core Version:    0.7.0.1
 */