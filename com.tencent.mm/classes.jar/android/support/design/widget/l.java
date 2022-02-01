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

public final class l
  extends c
{
  static final double qn = Math.cos(Math.toRadians(45.0D));
  private boolean dirty = true;
  private final int qA;
  boolean qB = true;
  private boolean qC = false;
  final Paint qo;
  final Paint qp;
  final RectF qr;
  float qs;
  Path qt;
  float qu;
  float qv;
  float qw;
  float qx;
  private final int qy;
  private final int qz;
  float rotation;
  
  public l(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.qy = b.n(paramContext, 2131100219);
    this.qz = b.n(paramContext, 2131100218);
    this.qA = b.n(paramContext, 2131100217);
    this.qo = new Paint(5);
    this.qo.setStyle(Paint.Style.FILL);
    this.qs = Math.round(paramFloat1);
    this.qr = new RectF();
    this.qp = new Paint(this.qo);
    this.qp.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - qn) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - qn) * paramFloat2);
    }
    return f;
  }
  
  private static int q(float paramFloat)
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
    if (this.dirty)
    {
      Object localObject = getBounds();
      f1 = this.qv * 1.5F;
      this.qr.set(((Rect)localObject).left + this.qv, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.qv, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.qr.left, (int)this.qr.top, (int)this.qr.right, (int)this.qr.bottom);
      localObject = new RectF(-this.qs, -this.qs, this.qs, this.qs);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.qw, -this.qw);
      if (this.qt == null)
      {
        this.qt = new Path();
        this.qt.setFillType(Path.FillType.EVEN_ODD);
        this.qt.moveTo(-this.qs, 0.0F);
        this.qt.rLineTo(-this.qw, 0.0F);
        this.qt.arcTo(localRectF, 180.0F, 90.0F, false);
        this.qt.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.qt.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.qs / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.qo;
          i = this.qy;
          j = this.qz;
          k = this.qA;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.qp;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.qy;
        j = this.qz;
        k = this.qA;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.qp.setAntiAlias(false);
        this.dirty = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.rotation, this.qr.centerX(), this.qr.centerY());
      f1 = -this.qs - this.qw;
      f2 = this.qs;
      if (this.qr.width() - 2.0F * f2 <= 0.0F) {
        break label1060;
      }
      i = 1;
      label535:
      if (this.qr.height() - 2.0F * f2 <= 0.0F) {
        break label1066;
      }
    }
    label1060:
    label1066:
    for (int j = 1;; j = 0)
    {
      float f6 = this.qx;
      float f7 = this.qx;
      f3 = this.qx;
      float f8 = this.qx;
      float f4 = this.qx;
      float f5 = this.qx;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.qr.left + f2, this.qr.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.qt, this.qo);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.qr.width() - 2.0F * f2, -this.qs, this.qp);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.qr.right - f2, this.qr.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.qt, this.qo);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.qr.width();
        f7 = -this.qs;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.qw + f7, this.qp);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.qr.left + f2, this.qr.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.qt, this.qo);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.qr.height() - 2.0F * f2, -this.qs, this.qp);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.qr.right - f2, this.qr.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.qt, this.qo);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.qr.height() - 2.0F * f2, -this.qs, this.qp);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      return;
      this.qt.reset();
      break;
      i = 0;
      break label535;
    }
  }
  
  public final void f(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F)) {
      throw new IllegalArgumentException("invalid shadow size");
    }
    float f = q(paramFloat1);
    paramFloat2 = q(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.qC) {
        this.qC = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.qx == paramFloat1) && (this.qv == paramFloat2)) {
      return;
    }
    this.qx = paramFloat1;
    this.qv = paramFloat2;
    this.qw = Math.round(paramFloat1 * 1.5F);
    this.qu = paramFloat2;
    this.dirty = true;
    invalidateSelf();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.qv, this.qs, this.qB));
    int j = (int)Math.ceil(b(this.qv, this.qs, this.qB));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final void onBoundsChange(Rect paramRect)
  {
    this.dirty = true;
  }
  
  public final void r(float paramFloat)
  {
    f(paramFloat, this.qv);
  }
  
  public final void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.qo.setAlpha(paramInt);
    this.qp.setAlpha(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.l
 * JD-Core Version:    0.7.0.1
 */