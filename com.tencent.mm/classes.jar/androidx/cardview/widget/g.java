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
  private static final double zc;
  static a ze;
  private Paint mPaint;
  ColorStateList yZ;
  private final int zd;
  private Paint zf;
  private Paint zg;
  private final RectF zi;
  float zj;
  private Path zk;
  float zl;
  private float zm;
  float zn;
  boolean zo;
  private final int zp;
  private final int zq;
  private boolean zr;
  private boolean zt;
  
  static
  {
    AppMethodBeat.i(188233);
    zc = Math.cos(Math.toRadians(45.0D));
    AppMethodBeat.o(188233);
  }
  
  g(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(188215);
    this.zo = true;
    this.zr = true;
    this.zt = false;
    this.zp = paramResources.getColor(a.b.cardview_shadow_start_color);
    this.zq = paramResources.getColor(a.b.cardview_shadow_end_color);
    this.zd = paramResources.getDimensionPixelSize(a.c.cardview_compat_inset_shadow);
    this.mPaint = new Paint(5);
    b(paramColorStateList);
    this.zf = new Paint(5);
    this.zf.setStyle(Paint.Style.FILL);
    this.zj = ((int)(0.5F + paramFloat1));
    this.zi = new RectF();
    this.zg = new Paint(this.zf);
    this.zg.setAntiAlias(false);
    b(paramFloat2, paramFloat3);
    AppMethodBeat.o(188215);
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - zc) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - zc) * paramFloat2);
    }
    return f;
  }
  
  private static int f(float paramFloat)
  {
    int j = (int)(0.5F + paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  final void U(boolean paramBoolean)
  {
    AppMethodBeat.i(188217);
    this.zr = paramBoolean;
    invalidateSelf();
    AppMethodBeat.o(188217);
  }
  
  final void b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(188221);
    IllegalArgumentException localIllegalArgumentException;
    if (paramFloat1 < 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid shadow size " + paramFloat1 + ". Must be >= 0");
      AppMethodBeat.o(188221);
      throw localIllegalArgumentException;
    }
    if (paramFloat2 < 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid max shadow size " + paramFloat2 + ". Must be >= 0");
      AppMethodBeat.o(188221);
      throw localIllegalArgumentException;
    }
    float f = f(paramFloat1);
    paramFloat2 = f(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.zt) {
        this.zt = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.zn == paramFloat1) && (this.zl == paramFloat2))
    {
      AppMethodBeat.o(188221);
      return;
    }
    this.zn = paramFloat1;
    this.zl = paramFloat2;
    this.zm = ((int)(paramFloat1 * 1.5F + this.zd + 0.5F));
    this.zo = true;
    invalidateSelf();
    AppMethodBeat.o(188221);
  }
  
  final void b(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(188216);
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.yZ = localColorStateList;
    this.mPaint.setColor(this.yZ.getColorForState(getState(), this.yZ.getDefaultColor()));
    AppMethodBeat.o(188216);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    AppMethodBeat.i(188228);
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    float f4;
    if (this.zo)
    {
      Object localObject1 = getBounds();
      f1 = this.zl * 1.5F;
      this.zi.set(((Rect)localObject1).left + this.zl, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.zl, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.zj, -this.zj, this.zj, this.zj);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.zm, -this.zm);
      if (this.zk == null)
      {
        this.zk = new Path();
        this.zk.setFillType(Path.FillType.EVEN_ODD);
        this.zk.moveTo(-this.zj, 0.0F);
        this.zk.rLineTo(-this.zm, 0.0F);
        this.zk.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.zk.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.zk.close();
        f1 = this.zj / (this.zj + this.zm);
        localObject1 = this.zf;
        f2 = this.zj;
        f3 = this.zm;
        i = this.zp;
        k = this.zp;
        int m = this.zq;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.zg;
        f1 = -this.zj;
        f2 = this.zm;
        f3 = -this.zj;
        f4 = this.zm;
        i = this.zp;
        k = this.zp;
        m = this.zq;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.zg.setAntiAlias(false);
        this.zo = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.zn / 2.0F);
      f1 = -this.zj - this.zm;
      f2 = this.zj + this.zd + this.zn / 2.0F;
      if (this.zi.width() - 2.0F * f2 <= 0.0F) {
        break label920;
      }
      i = 1;
      label513:
      if (this.zi.height() - 2.0F * f2 <= 0.0F) {
        break label926;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.zi.left + f2, this.zi.top + f2);
      paramCanvas.drawPath(this.zk, this.zf);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.zi.width() - 2.0F * f2, -this.zj, this.zg);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.zi.right - f2, this.zi.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.zk, this.zf);
      if (i != 0)
      {
        f3 = this.zi.width();
        f4 = -this.zj;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.zm + f4, this.zg);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.zi.left + f2, this.zi.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.zk, this.zf);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.zi.height() - 2.0F * f2, -this.zj, this.zg);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.zi.right - f2, this.zi.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.zk, this.zf);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.zi.height() - 2.0F * f2, -this.zj, this.zg);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.zn / 2.0F);
      ze.a(paramCanvas, this.zi, this.zj, this.mPaint);
      AppMethodBeat.o(188228);
      return;
      this.zk.reset();
      break;
      label920:
      i = 0;
      break label513;
      label926:
      j = 0;
    }
  }
  
  final float getMinHeight()
  {
    AppMethodBeat.i(188232);
    float f1 = Math.max(this.zl, this.zj + this.zd + this.zl * 1.5F / 2.0F);
    float f2 = this.zl;
    float f3 = this.zd;
    AppMethodBeat.o(188232);
    return f1 * 2.0F + (f2 * 1.5F + f3) * 2.0F;
  }
  
  final float getMinWidth()
  {
    AppMethodBeat.i(188229);
    float f1 = Math.max(this.zl, this.zj + this.zd + this.zl / 2.0F);
    float f2 = this.zl;
    float f3 = this.zd;
    AppMethodBeat.o(188229);
    return f1 * 2.0F + (f2 + f3) * 2.0F;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(188222);
    int i = (int)Math.ceil(a(this.zl, this.zj, this.zr));
    int j = (int)Math.ceil(b(this.zl, this.zj, this.zr));
    paramRect.set(j, i, j, i);
    AppMethodBeat.o(188222);
    return true;
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(188224);
    if (((this.yZ != null) && (this.yZ.isStateful())) || (super.isStateful()))
    {
      AppMethodBeat.o(188224);
      return true;
    }
    AppMethodBeat.o(188224);
    return false;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(188220);
    super.onBoundsChange(paramRect);
    this.zo = true;
    AppMethodBeat.o(188220);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(188223);
    int i = this.yZ.getColorForState(paramArrayOfInt, this.yZ.getDefaultColor());
    if (this.mPaint.getColor() == i)
    {
      AppMethodBeat.o(188223);
      return false;
    }
    this.mPaint.setColor(i);
    this.zo = true;
    invalidateSelf();
    AppMethodBeat.o(188223);
    return true;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(188219);
    this.mPaint.setAlpha(paramInt);
    this.zf.setAlpha(paramInt);
    this.zg.setAlpha(paramInt);
    AppMethodBeat.o(188219);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(188225);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(188225);
  }
  
  static abstract interface a
  {
    public abstract void a(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.cardview.widget.g
 * JD-Core Version:    0.7.0.1
 */