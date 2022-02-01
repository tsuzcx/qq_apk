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
  static final double rn = Math.cos(Math.toRadians(45.0D));
  private boolean dirty = true;
  private final int rA;
  boolean rB = true;
  private boolean rC = false;
  final Paint ro;
  float rotation;
  final Paint rp;
  final RectF rq;
  float rs;
  Path rt;
  float ru;
  float rv;
  float rw;
  float rx;
  private final int ry;
  private final int rz;
  
  public l(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.ry = b.n(paramContext, 2131100219);
    this.rz = b.n(paramContext, 2131100218);
    this.rA = b.n(paramContext, 2131100217);
    this.ro = new Paint(5);
    this.ro.setStyle(Paint.Style.FILL);
    this.rs = Math.round(paramFloat1);
    this.rq = new RectF();
    this.rp = new Paint(this.ro);
    this.rp.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - rn) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - rn) * paramFloat2);
    }
    return f;
  }
  
  private static int u(float paramFloat)
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
      f1 = this.rv * 1.5F;
      this.rq.set(((Rect)localObject).left + this.rv, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.rv, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.rq.left, (int)this.rq.top, (int)this.rq.right, (int)this.rq.bottom);
      localObject = new RectF(-this.rs, -this.rs, this.rs, this.rs);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.rw, -this.rw);
      if (this.rt == null)
      {
        this.rt = new Path();
        this.rt.setFillType(Path.FillType.EVEN_ODD);
        this.rt.moveTo(-this.rs, 0.0F);
        this.rt.rLineTo(-this.rw, 0.0F);
        this.rt.arcTo(localRectF, 180.0F, 90.0F, false);
        this.rt.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.rt.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.rs / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.ro;
          i = this.ry;
          j = this.rz;
          k = this.rA;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.rp;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.ry;
        j = this.rz;
        k = this.rA;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.rp.setAntiAlias(false);
        this.dirty = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.rotation, this.rq.centerX(), this.rq.centerY());
      f1 = -this.rs - this.rw;
      f2 = this.rs;
      if (this.rq.width() - 2.0F * f2 <= 0.0F) {
        break label1060;
      }
      i = 1;
      label535:
      if (this.rq.height() - 2.0F * f2 <= 0.0F) {
        break label1066;
      }
    }
    label1060:
    label1066:
    for (int j = 1;; j = 0)
    {
      float f6 = this.rx;
      float f7 = this.rx;
      f3 = this.rx;
      float f8 = this.rx;
      float f4 = this.rx;
      float f5 = this.rx;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.rq.left + f2, this.rq.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.rt, this.ro);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.rq.width() - 2.0F * f2, -this.rs, this.rp);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.rq.right - f2, this.rq.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.rt, this.ro);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.rq.width();
        f7 = -this.rs;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.rw + f7, this.rp);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.rq.left + f2, this.rq.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.rt, this.ro);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.rq.height() - 2.0F * f2, -this.rs, this.rp);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.rq.right - f2, this.rq.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.rt, this.ro);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.rq.height() - 2.0F * f2, -this.rs, this.rp);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      return;
      this.rt.reset();
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
    float f = u(paramFloat1);
    paramFloat2 = u(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.rC) {
        this.rC = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.rx == paramFloat1) && (this.rv == paramFloat2)) {
      return;
    }
    this.rx = paramFloat1;
    this.rv = paramFloat2;
    this.rw = Math.round(paramFloat1 * 1.5F);
    this.ru = paramFloat2;
    this.dirty = true;
    invalidateSelf();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.rv, this.rs, this.rB));
    int j = (int)Math.ceil(b(this.rv, this.rs, this.rB));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final void onBoundsChange(Rect paramRect)
  {
    this.dirty = true;
  }
  
  public final void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.ro.setAlpha(paramInt);
    this.rp.setAlpha(paramInt);
  }
  
  public final void v(float paramFloat)
  {
    f(paramFloat, this.rv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.l
 * JD-Core Version:    0.7.0.1
 */