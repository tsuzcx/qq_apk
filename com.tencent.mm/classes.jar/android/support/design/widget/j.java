package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
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
import android.support.v4.content.b;
import android.support.v7.d.a.c;

final class j
  extends c
{
  static final double km = Math.cos(Math.toRadians(45.0D));
  float gV;
  boolean kA = true;
  private boolean kB = false;
  final Paint kn;
  final Paint ko;
  final RectF kp;
  float kq;
  Path kr;
  float ks;
  float kt;
  float ku;
  float kv;
  private boolean kw = true;
  private final int kx;
  private final int ky;
  private final int kz;
  
  public j(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.kx = b.m(paramContext, 2131689933);
    this.ky = b.m(paramContext, 2131689932);
    this.kz = b.m(paramContext, 2131689931);
    this.kn = new Paint(5);
    this.kn.setStyle(Paint.Style.FILL);
    this.kq = Math.round(paramFloat1);
    this.kp = new RectF();
    this.ko = new Paint(this.kn);
    this.ko.setAntiAlias(false);
    p(paramFloat2, paramFloat3);
  }
  
  public static float c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - km) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - km) * paramFloat2);
    }
    return f;
  }
  
  private static int m(float paramFloat)
  {
    int j = Math.round(paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    if (this.kw)
    {
      Object localObject = getBounds();
      f1 = this.kt * 1.5F;
      this.kp.set(((Rect)localObject).left + this.kt, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.kt, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.kp.left, (int)this.kp.top, (int)this.kp.right, (int)this.kp.bottom);
      localObject = new RectF(-this.kq, -this.kq, this.kq, this.kq);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.ku, -this.ku);
      if (this.kr == null)
      {
        this.kr = new Path();
        this.kr.setFillType(Path.FillType.EVEN_ODD);
        this.kr.moveTo(-this.kq, 0.0F);
        this.kr.rLineTo(-this.ku, 0.0F);
        this.kr.arcTo(localRectF, 180.0F, 90.0F, false);
        this.kr.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.kr.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.kq / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.kn;
          i = this.kx;
          j = this.ky;
          k = this.kz;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.ko;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.kx;
        j = this.ky;
        k = this.kz;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.ko.setAntiAlias(false);
        this.kw = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.gV, this.kp.centerX(), this.kp.centerY());
      f1 = -this.kq - this.ku;
      f2 = this.kq;
      if (this.kp.width() - 2.0F * f2 <= 0.0F) {
        break label1060;
      }
      i = 1;
      label535:
      if (this.kp.height() - 2.0F * f2 <= 0.0F) {
        break label1066;
      }
    }
    label1060:
    label1066:
    for (int j = 1;; j = 0)
    {
      float f6 = this.kv;
      float f7 = this.kv;
      f3 = this.kv;
      float f8 = this.kv;
      float f4 = this.kv;
      float f5 = this.kv;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.kp.left + f2, this.kp.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.kr, this.kn);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.kp.width() - 2.0F * f2, -this.kq, this.ko);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.kp.right - f2, this.kp.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.kr, this.kn);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.kp.width();
        f7 = -this.kq;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.ku + f7, this.ko);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.kp.left + f2, this.kp.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.kr, this.kn);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.kp.height() - 2.0F * f2, -this.kq, this.ko);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.kp.right - f2, this.kp.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.kr, this.kn);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.kp.height() - 2.0F * f2, -this.kq, this.ko);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      return;
      this.kr.reset();
      break;
      i = 0;
      break label535;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(c(this.kt, this.kq, this.kA));
    int j = (int)Math.ceil(d(this.kt, this.kq, this.kA));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final void n(float paramFloat)
  {
    p(paramFloat, this.kt);
  }
  
  public final void onBoundsChange(Rect paramRect)
  {
    this.kw = true;
  }
  
  final void p(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F)) {
      throw new IllegalArgumentException("invalid shadow size");
    }
    float f = m(paramFloat1);
    paramFloat2 = m(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.kB) {
        this.kB = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.kv == paramFloat1) && (this.kt == paramFloat2)) {
      return;
    }
    this.kv = paramFloat1;
    this.kt = paramFloat2;
    this.ku = Math.round(paramFloat1 * 1.5F);
    this.ks = paramFloat2;
    this.kw = true;
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.kn.setAlpha(paramInt);
    this.ko.setAlpha(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.j
 * JD-Core Version:    0.7.0.1
 */