package androidx.cardview.widget;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
  extends Drawable
{
  float Ri;
  private final RectF Rj;
  private final Rect Rk;
  float Rl;
  private boolean Rm;
  private boolean Rn;
  ColorStateList Ro;
  private PorterDuffColorFilter Rp;
  private ColorStateList Rq;
  private PorterDuff.Mode kA;
  private final Paint mPaint;
  
  f(ColorStateList paramColorStateList, float paramFloat)
  {
    AppMethodBeat.i(192426);
    this.Rm = false;
    this.Rn = true;
    this.kA = PorterDuff.Mode.SRC_IN;
    this.Ri = paramFloat;
    this.mPaint = new Paint(5);
    b(paramColorStateList);
    this.Rj = new RectF();
    this.Rk = new Rect();
    AppMethodBeat.o(192426);
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(192433);
    if ((paramColorStateList == null) || (paramMode == null))
    {
      AppMethodBeat.o(192433);
      return null;
    }
    paramColorStateList = new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    AppMethodBeat.o(192433);
    return paramColorStateList;
  }
  
  final void a(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192453);
    if ((paramFloat == this.Rl) && (this.Rm == paramBoolean1) && (this.Rn == paramBoolean2))
    {
      AppMethodBeat.o(192453);
      return;
    }
    this.Rl = paramFloat;
    this.Rm = paramBoolean1;
    this.Rn = paramBoolean2;
    g(null);
    invalidateSelf();
    AppMethodBeat.o(192453);
  }
  
  final void b(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192444);
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.Ro = localColorStateList;
    this.mPaint.setColor(this.Ro.getColorForState(getState(), this.Ro.getDefaultColor()));
    AppMethodBeat.o(192444);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192458);
    Paint localPaint = this.mPaint;
    if ((this.Rp != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.Rp);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.Rj, this.Ri, this.Ri, localPaint);
      if (i != 0) {
        localPaint.setColorFilter(null);
      }
      AppMethodBeat.o(192458);
      return;
    }
  }
  
  final void g(Rect paramRect)
  {
    AppMethodBeat.i(192466);
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.Rj.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.Rk.set(localRect);
    if (this.Rm)
    {
      float f1 = g.d(this.Rl, this.Ri, this.Rn);
      float f2 = g.e(this.Rl, this.Ri, this.Rn);
      this.Rk.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.Rj.set(this.Rk);
    }
    AppMethodBeat.o(192466);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(192485);
    paramOutline.setRoundRect(this.Rk, this.Ri);
    AppMethodBeat.o(192485);
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(192567);
    if (((this.Rq != null) && (this.Rq.isStateful())) || ((this.Ro != null) && (this.Ro.isStateful())) || (super.isStateful()))
    {
      AppMethodBeat.o(192567);
      return true;
    }
    AppMethodBeat.o(192567);
    return false;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(192476);
    super.onBoundsChange(paramRect);
    g(paramRect);
    AppMethodBeat.o(192476);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192554);
    int i = this.Ro.getColorForState(paramArrayOfInt, this.Ro.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.Rq == null) || (this.kA == null)) {
        break;
      }
      this.Rp = a(this.Rq, this.kA);
      AppMethodBeat.o(192554);
      return true;
    }
    AppMethodBeat.o(192554);
    return bool;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(192494);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(192494);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(192507);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(192507);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192529);
    this.Rq = paramColorStateList;
    this.Rp = a(this.Rq, this.kA);
    invalidateSelf();
    AppMethodBeat.o(192529);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(192543);
    this.kA = paramMode;
    this.Rp = a(this.Rq, this.kA);
    invalidateSelf();
    AppMethodBeat.o(192543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.cardview.widget.f
 * JD-Core Version:    0.7.0.1
 */