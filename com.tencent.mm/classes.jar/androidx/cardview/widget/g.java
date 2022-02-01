package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import androidx.cardview.a.b;
import androidx.cardview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
  extends Drawable
{
  private static final double Rr;
  static g.a Rt;
  private float RA;
  float RB;
  boolean RC;
  private final int RD;
  private final int RE;
  private boolean RF;
  private boolean RG;
  ColorStateList Ro;
  private final int Rs;
  private Paint Ru;
  private Paint Rv;
  private final RectF Rw;
  float Rx;
  private Path Ry;
  float Rz;
  private Paint mPaint;
  
  static
  {
    AppMethodBeat.i(192472);
    Rr = Math.cos(Math.toRadians(45.0D));
    AppMethodBeat.o(192472);
  }
  
  g(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(192431);
    this.RC = true;
    this.RF = true;
    this.RG = false;
    this.RD = paramResources.getColor(a.b.cardview_shadow_start_color);
    this.RE = paramResources.getColor(a.b.cardview_shadow_end_color);
    this.Rs = paramResources.getDimensionPixelSize(a.c.cardview_compat_inset_shadow);
    this.mPaint = new Paint(5);
    b(paramColorStateList);
    this.Ru = new Paint(5);
    this.Ru.setStyle(Paint.Style.FILL);
    this.Rx = ((int)(0.5F + paramFloat1));
    this.Rw = new RectF();
    this.Rv = new Paint(this.Ru);
    this.Rv.setAntiAlias(false);
    p(paramFloat2, paramFloat3);
    AppMethodBeat.o(192431);
  }
  
  static float d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - Rr) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - Rr) * paramFloat2);
    }
    return f;
  }
  
  private static int k(float paramFloat)
  {
    int j = (int)(0.5F + paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  final void af(boolean paramBoolean)
  {
    AppMethodBeat.i(192498);
    this.RF = paramBoolean;
    invalidateSelf();
    AppMethodBeat.o(192498);
  }
  
  final void b(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192484);
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.Ro = localColorStateList;
    this.mPaint.setColor(this.Ro.getColorForState(getState(), this.Ro.getDefaultColor()));
    AppMethodBeat.o(192484);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    AppMethodBeat.i(192605);
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    float f4;
    if (this.RC)
    {
      Object localObject1 = getBounds();
      f1 = this.Rz * 1.5F;
      this.Rw.set(((Rect)localObject1).left + this.Rz, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.Rz, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.Rx, -this.Rx, this.Rx, this.Rx);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.RA, -this.RA);
      if (this.Ry == null)
      {
        this.Ry = new Path();
        this.Ry.setFillType(Path.FillType.EVEN_ODD);
        this.Ry.moveTo(-this.Rx, 0.0F);
        this.Ry.rLineTo(-this.RA, 0.0F);
        this.Ry.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.Ry.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.Ry.close();
        f1 = this.Rx / (this.Rx + this.RA);
        localObject1 = this.Ru;
        f2 = this.Rx;
        f3 = this.RA;
        i = this.RD;
        k = this.RD;
        int m = this.RE;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.Rv;
        f1 = -this.Rx;
        f2 = this.RA;
        f3 = -this.Rx;
        f4 = this.RA;
        i = this.RD;
        k = this.RD;
        m = this.RE;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.Rv.setAntiAlias(false);
        this.RC = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.RB / 2.0F);
      f1 = -this.Rx - this.RA;
      f2 = this.Rx + this.Rs + this.RB / 2.0F;
      if (this.Rw.width() - 2.0F * f2 <= 0.0F) {
        break label913;
      }
      i = 1;
      label509:
      if (this.Rw.height() - 2.0F * f2 <= 0.0F) {
        break label919;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.Rw.left + f2, this.Rw.top + f2);
      paramCanvas.drawPath(this.Ry, this.Ru);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.Rw.width() - 2.0F * f2, -this.Rx, this.Rv);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.Rw.right - f2, this.Rw.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.Ry, this.Ru);
      if (i != 0)
      {
        f3 = this.Rw.width();
        f4 = -this.Rx;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.RA + f4, this.Rv);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.Rw.left + f2, this.Rw.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.Ry, this.Ru);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.Rw.height() - 2.0F * f2, -this.Rx, this.Rv);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.Rw.right - f2, this.Rw.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.Ry, this.Ru);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.Rw.height() - 2.0F * f2, -this.Rx, this.Rv);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.RB / 2.0F);
      Rt.a(paramCanvas, this.Rw, this.Rx, this.mPaint);
      AppMethodBeat.o(192605);
      return;
      this.Ry.reset();
      break;
      label913:
      i = 0;
      break label509;
      label919:
      j = 0;
    }
  }
  
  final float getMinHeight()
  {
    AppMethodBeat.i(192630);
    float f1 = Math.max(this.Rz, this.Rx + this.Rs + this.Rz * 1.5F / 2.0F);
    float f2 = this.Rz;
    float f3 = this.Rs;
    AppMethodBeat.o(192630);
    return f1 * 2.0F + (f2 * 1.5F + f3) * 2.0F;
  }
  
  final float getMinWidth()
  {
    AppMethodBeat.i(192614);
    float f1 = Math.max(this.Rz, this.Rx + this.Rs + this.Rz / 2.0F);
    float f2 = this.Rz;
    float f3 = this.Rs;
    AppMethodBeat.o(192614);
    return f1 * 2.0F + (f2 + f3) * 2.0F;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(192555);
    int i = (int)Math.ceil(d(this.Rz, this.Rx, this.RF));
    int j = (int)Math.ceil(e(this.Rz, this.Rx, this.RF));
    paramRect.set(j, i, j, i);
    AppMethodBeat.o(192555);
    return true;
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(192583);
    if (((this.Ro != null) && (this.Ro.isStateful())) || (super.isStateful()))
    {
      AppMethodBeat.o(192583);
      return true;
    }
    AppMethodBeat.o(192583);
    return false;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(192527);
    super.onBoundsChange(paramRect);
    this.RC = true;
    AppMethodBeat.o(192527);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192571);
    int i = this.Ro.getColorForState(paramArrayOfInt, this.Ro.getDefaultColor());
    if (this.mPaint.getColor() == i)
    {
      AppMethodBeat.o(192571);
      return false;
    }
    this.mPaint.setColor(i);
    this.RC = true;
    invalidateSelf();
    AppMethodBeat.o(192571);
    return true;
  }
  
  final void p(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192542);
    IllegalArgumentException localIllegalArgumentException;
    if (paramFloat1 < 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid shadow size " + paramFloat1 + ". Must be >= 0");
      AppMethodBeat.o(192542);
      throw localIllegalArgumentException;
    }
    if (paramFloat2 < 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid max shadow size " + paramFloat2 + ". Must be >= 0");
      AppMethodBeat.o(192542);
      throw localIllegalArgumentException;
    }
    float f = k(paramFloat1);
    paramFloat2 = k(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.RG) {
        this.RG = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.RB == paramFloat1) && (this.Rz == paramFloat2))
    {
      AppMethodBeat.o(192542);
      return;
    }
    this.RB = paramFloat1;
    this.Rz = paramFloat2;
    this.RA = ((int)(paramFloat1 * 1.5F + this.Rs + 0.5F));
    this.RC = true;
    invalidateSelf();
    AppMethodBeat.o(192542);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(192512);
    this.mPaint.setAlpha(paramInt);
    this.Ru.setAlpha(paramInt);
    this.Rv.setAlpha(paramInt);
    AppMethodBeat.o(192512);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(192590);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(192590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.cardview.widget.g
 * JD-Core Version:    0.7.0.1
 */