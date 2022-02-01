package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class an
  extends Drawable
{
  float asW;
  private final RectF asX;
  private final Rect asY;
  float asZ;
  private boolean ata = false;
  private boolean atb = true;
  ColorStateList atc;
  private final Paint mPaint;
  private PorterDuffColorFilter vn;
  private ColorStateList wm;
  private PorterDuff.Mode wn = PorterDuff.Mode.SRC_IN;
  
  an(ColorStateList paramColorStateList, float paramFloat)
  {
    this.asW = paramFloat;
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.asX = new RectF();
    this.asY = new Rect();
  }
  
  private PorterDuffColorFilter b(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  final void a(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramFloat == this.asZ) && (this.ata == paramBoolean1) && (this.atb == paramBoolean2)) {
      return;
    }
    this.asZ = paramFloat;
    this.ata = paramBoolean1;
    this.atb = paramBoolean2;
    h(null);
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.mPaint;
    if ((this.vn != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.vn);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.asX, this.asW, this.asW, localPaint);
      if (i != 0) {
        localPaint.setColorFilter(null);
      }
      return;
    }
  }
  
  final void g(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.atc = localColorStateList;
    this.mPaint.setColor(this.atc.getColorForState(getState(), this.atc.getDefaultColor()));
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.asY, this.asW);
  }
  
  final void h(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.asX.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.asY.set(localRect);
    if (this.ata)
    {
      float f1 = ao.a(this.asZ, this.asW, this.atb);
      float f2 = ao.b(this.asZ, this.asW, this.atb);
      this.asY.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.asX.set(this.asY);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.wm != null) && (this.wm.isStateful())) || ((this.atc != null) && (this.atc.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    h(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.atc.getColorForState(paramArrayOfInt, this.atc.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.wm == null) || (this.wn == null)) {
        break;
      }
      this.vn = b(this.wm, this.wn);
      return true;
    }
    return bool;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    this.wm = paramColorStateList;
    this.vn = b(this.wm, this.wn);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.wn = paramMode;
    this.vn = b(this.wm, this.wn);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */