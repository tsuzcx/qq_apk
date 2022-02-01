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
  private PorterDuff.Mode jF;
  private final Paint mPaint;
  float yT;
  private final RectF yU;
  private final Rect yV;
  float yW;
  private boolean yX;
  private boolean yY;
  ColorStateList yZ;
  private PorterDuffColorFilter za;
  private ColorStateList zb;
  
  f(ColorStateList paramColorStateList, float paramFloat)
  {
    AppMethodBeat.i(188187);
    this.yX = false;
    this.yY = true;
    this.jF = PorterDuff.Mode.SRC_IN;
    this.yT = paramFloat;
    this.mPaint = new Paint(5);
    b(paramColorStateList);
    this.yU = new RectF();
    this.yV = new Rect();
    AppMethodBeat.o(188187);
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(188211);
    if ((paramColorStateList == null) || (paramMode == null))
    {
      AppMethodBeat.o(188211);
      return null;
    }
    paramColorStateList = new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    AppMethodBeat.o(188211);
    return paramColorStateList;
  }
  
  final void a(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188189);
    if ((paramFloat == this.yW) && (this.yX == paramBoolean1) && (this.yY == paramBoolean2))
    {
      AppMethodBeat.o(188189);
      return;
    }
    this.yW = paramFloat;
    this.yX = paramBoolean1;
    this.yY = paramBoolean2;
    c(null);
    invalidateSelf();
    AppMethodBeat.o(188189);
  }
  
  final void b(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(188188);
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.yZ = localColorStateList;
    this.mPaint.setColor(this.yZ.getColorForState(getState(), this.yZ.getDefaultColor()));
    AppMethodBeat.o(188188);
  }
  
  final void c(Rect paramRect)
  {
    AppMethodBeat.i(188193);
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.yU.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.yV.set(localRect);
    if (this.yX)
    {
      float f1 = g.a(this.yW, this.yT, this.yY);
      float f2 = g.b(this.yW, this.yT, this.yY);
      this.yV.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.yU.set(this.yV);
    }
    AppMethodBeat.o(188193);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(188191);
    Paint localPaint = this.mPaint;
    if ((this.za != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(this.za);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(this.yU, this.yT, this.yT, localPaint);
      if (i != 0) {
        localPaint.setColorFilter(null);
      }
      AppMethodBeat.o(188191);
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(188196);
    paramOutline.setRoundRect(this.yV, this.yT);
    AppMethodBeat.o(188196);
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(188208);
    if (((this.zb != null) && (this.zb.isStateful())) || ((this.yZ != null) && (this.yZ.isStateful())) || (super.isStateful()))
    {
      AppMethodBeat.o(188208);
      return true;
    }
    AppMethodBeat.o(188208);
    return false;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(188194);
    super.onBoundsChange(paramRect);
    c(paramRect);
    AppMethodBeat.o(188194);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(188206);
    int i = this.yZ.getColorForState(paramArrayOfInt, this.yZ.getDefaultColor());
    if (i != this.mPaint.getColor()) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPaint.setColor(i);
      }
      if ((this.zb == null) || (this.jF == null)) {
        break;
      }
      this.za = a(this.zb, this.jF);
      AppMethodBeat.o(188206);
      return true;
    }
    AppMethodBeat.o(188206);
    return bool;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(188198);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(188198);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(188199);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(188199);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(188202);
    this.zb = paramColorStateList;
    this.za = a(this.zb, this.jF);
    invalidateSelf();
    AppMethodBeat.o(188202);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(188205);
    this.jF = paramMode;
    this.za = a(this.zb, this.jF);
    invalidateSelf();
    AppMethodBeat.o(188205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.cardview.widget.f
 * JD-Core Version:    0.7.0.1
 */