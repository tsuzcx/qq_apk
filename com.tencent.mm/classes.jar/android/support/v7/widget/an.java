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
  float asb;
  private final RectF asc;
  private final Rect asd;
  float ase;
  private boolean asf = false;
  private boolean asg = true;
  ColorStateList ash;
  private final Paint mPaint;
  private PorterDuffColorFilter uo;
  private ColorStateList vn;
  private PorterDuff.Mode vo = PorterDuff.Mode.SRC_IN;
  
  an(ColorStateList paramColorStateList, float paramFloat)
  {
    this.asb = paramFloat;
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.asc = new RectF();
    this.asd = new Rect();
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
    if ((paramFloat == this.ase) && (this.asf == paramBoolean1) && (this.asg == paramBoolean2)) {
      return;
    }
    this.ase = paramFloat;
    this.asf = paramBoolean1;
    this.asg = paramBoolean2;
    h(null);
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.mPaint;
    if ((this.uo != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.uo);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.asc, this.asb, this.asb, localPaint);
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
    this.ash = localColorStateList;
    this.mPaint.setColor(this.ash.getColorForState(getState(), this.ash.getDefaultColor()));
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.asd, this.asb);
  }
  
  final void h(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.asc.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.asd.set(localRect);
    if (this.asf)
    {
      float f1 = ao.a(this.ase, this.asb, this.asg);
      float f2 = ao.b(this.ase, this.asb, this.asg);
      this.asd.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.asc.set(this.asd);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.vn != null) && (this.vn.isStateful())) || ((this.ash != null) && (this.ash.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    h(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.ash.getColorForState(paramArrayOfInt, this.ash.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.vn == null) || (this.vo == null)) {
        break;
      }
      this.uo = b(this.vn, this.vo);
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
    this.vn = paramColorStateList;
    this.uo = b(this.vn, this.vo);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.vo = paramMode;
    this.uo = b(this.vn, this.vo);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */