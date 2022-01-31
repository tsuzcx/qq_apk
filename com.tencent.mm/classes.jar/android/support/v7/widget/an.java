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
  float akN;
  private final RectF akO;
  private final Rect akP;
  float akQ;
  private boolean akR = false;
  private boolean akS = true;
  ColorStateList akT;
  private final Paint mPaint;
  private PorterDuffColorFilter nN;
  private ColorStateList oL;
  private PorterDuff.Mode oM = PorterDuff.Mode.SRC_IN;
  
  an(ColorStateList paramColorStateList, float paramFloat)
  {
    this.akN = paramFloat;
    this.mPaint = new Paint(5);
    e(paramColorStateList);
    this.akO = new RectF();
    this.akP = new Rect();
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
    if ((paramFloat == this.akQ) && (this.akR == paramBoolean1) && (this.akS == paramBoolean2)) {
      return;
    }
    this.akQ = paramFloat;
    this.akR = paramBoolean1;
    this.akS = paramBoolean2;
    h(null);
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.mPaint;
    if ((this.nN != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.nN);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.akO, this.akN, this.akN, localPaint);
      if (i != 0) {
        localPaint.setColorFilter(null);
      }
      return;
    }
  }
  
  final void e(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.akT = localColorStateList;
    this.mPaint.setColor(this.akT.getColorForState(getState(), this.akT.getDefaultColor()));
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.akP, this.akN);
  }
  
  final void h(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.akO.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.akP.set(localRect);
    if (this.akR)
    {
      float f1 = ao.c(this.akQ, this.akN, this.akS);
      float f2 = ao.d(this.akQ, this.akN, this.akS);
      this.akP.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.akO.set(this.akP);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.oL != null) && (this.oL.isStateful())) || ((this.akT != null) && (this.akT.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    h(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.akT.getColorForState(paramArrayOfInt, this.akT.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.oL == null) || (this.oM == null)) {
        break;
      }
      this.nN = b(this.oL, this.oM);
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
    this.oL = paramColorStateList;
    this.nN = b(this.oL, this.oM);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.oM = paramMode;
    this.nN = b(this.oL, this.oM);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */