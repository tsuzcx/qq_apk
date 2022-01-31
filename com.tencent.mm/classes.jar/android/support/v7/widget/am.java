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

final class am
  extends Drawable
{
  float aiA;
  boolean aiB = false;
  boolean aiC = true;
  ColorStateList aiD;
  float aix;
  private final RectF aiy;
  private final Rect aiz;
  private final Paint mPaint;
  private PorterDuffColorFilter mQ;
  private ColorStateList nM;
  private PorterDuff.Mode nN = PorterDuff.Mode.SRC_IN;
  
  am(ColorStateList paramColorStateList, float paramFloat)
  {
    this.aix = paramFloat;
    this.mPaint = new Paint(5);
    e(paramColorStateList);
    this.aiy = new RectF();
    this.aiz = new Rect();
  }
  
  private PorterDuffColorFilter b(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.mPaint;
    if ((this.mQ != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.mQ);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.aiy, this.aix, this.aix, localPaint);
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
    this.aiD = localColorStateList;
    this.mPaint.setColor(this.aiD.getColorForState(getState(), this.aiD.getDefaultColor()));
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.aiz, this.aix);
  }
  
  final void h(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.aiy.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.aiz.set(localRect);
    if (this.aiB)
    {
      float f1 = an.c(this.aiA, this.aix, this.aiC);
      float f2 = an.d(this.aiA, this.aix, this.aiC);
      this.aiz.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.aiy.set(this.aiz);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.nM != null) && (this.nM.isStateful())) || ((this.aiD != null) && (this.aiD.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    h(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.aiD.getColorForState(paramArrayOfInt, this.aiD.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.nM == null) || (this.nN == null)) {
        break;
      }
      this.mQ = b(this.nM, this.nN);
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
    this.nM = paramColorStateList;
    this.mQ = b(this.nM, this.nN);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.nN = paramMode;
    this.mQ = b(this.nM, this.nN);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.am
 * JD-Core Version:    0.7.0.1
 */