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
  float auN;
  private final RectF auO;
  private final Rect auP;
  float auQ;
  private boolean auR = false;
  private boolean auS = true;
  ColorStateList auT;
  private final Paint mPaint;
  private PorterDuffColorFilter xg;
  private ColorStateList ye;
  private PorterDuff.Mode yf = PorterDuff.Mode.SRC_IN;
  
  an(ColorStateList paramColorStateList, float paramFloat)
  {
    this.auN = paramFloat;
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.auO = new RectF();
    this.auP = new Rect();
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
    if ((paramFloat == this.auQ) && (this.auR == paramBoolean1) && (this.auS == paramBoolean2)) {
      return;
    }
    this.auQ = paramFloat;
    this.auR = paramBoolean1;
    this.auS = paramBoolean2;
    h(null);
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.mPaint;
    if ((this.xg != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.xg);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.auO, this.auN, this.auN, localPaint);
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
    this.auT = localColorStateList;
    this.mPaint.setColor(this.auT.getColorForState(getState(), this.auT.getDefaultColor()));
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.auP, this.auN);
  }
  
  final void h(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.auO.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.auP.set(localRect);
    if (this.auR)
    {
      float f1 = ao.a(this.auQ, this.auN, this.auS);
      float f2 = ao.b(this.auQ, this.auN, this.auS);
      this.auP.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.auO.set(this.auP);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.ye != null) && (this.ye.isStateful())) || ((this.auT != null) && (this.auT.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    h(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.auT.getColorForState(paramArrayOfInt, this.auT.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.ye == null) || (this.yf == null)) {
        break;
      }
      this.xg = b(this.ye, this.yf);
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
    this.ye = paramColorStateList;
    this.xg = b(this.ye, this.yf);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.yf = paramMode;
    this.xg = b(this.ye, this.yf);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */