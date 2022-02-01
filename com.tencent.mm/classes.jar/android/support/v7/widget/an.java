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
  float auL;
  private final RectF auM;
  private final Rect auN;
  float auO;
  private boolean auP = false;
  private boolean auQ = true;
  ColorStateList auR;
  private final Paint mPaint;
  private PorterDuffColorFilter xn;
  private ColorStateList yk;
  private PorterDuff.Mode yl = PorterDuff.Mode.SRC_IN;
  
  an(ColorStateList paramColorStateList, float paramFloat)
  {
    this.auL = paramFloat;
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.auM = new RectF();
    this.auN = new Rect();
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
    if ((paramFloat == this.auO) && (this.auP == paramBoolean1) && (this.auQ == paramBoolean2)) {
      return;
    }
    this.auO = paramFloat;
    this.auP = paramBoolean1;
    this.auQ = paramBoolean2;
    h(null);
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.mPaint;
    if ((this.xn != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.xn);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.auM, this.auL, this.auL, localPaint);
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
    this.auR = localColorStateList;
    this.mPaint.setColor(this.auR.getColorForState(getState(), this.auR.getDefaultColor()));
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.auN, this.auL);
  }
  
  final void h(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.auM.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.auN.set(localRect);
    if (this.auP)
    {
      float f1 = ao.a(this.auO, this.auL, this.auQ);
      float f2 = ao.b(this.auO, this.auL, this.auQ);
      this.auN.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.auM.set(this.auN);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.yk != null) && (this.yk.isStateful())) || ((this.auR != null) && (this.auR.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    h(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.auR.getColorForState(paramArrayOfInt, this.auR.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.yk == null) || (this.yl == null)) {
        break;
      }
      this.xn = b(this.yk, this.yl);
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
    this.yk = paramColorStateList;
    this.xn = b(this.yk, this.yl);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.yl = paramMode;
    this.xn = b(this.yk, this.yl);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */