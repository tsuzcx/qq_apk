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
  static final double tn = Math.cos(Math.toRadians(45.0D));
  private boolean dirty = true;
  float rotation;
  private final int tA;
  private final int tB;
  boolean tC = true;
  private boolean tD = false;
  final Paint tp;
  final Paint tq;
  final RectF tr;
  float tt;
  Path tu;
  float tv;
  float tw;
  float tx;
  float ty;
  private final int tz;
  
  public l(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.tz = b.n(paramContext, 2131100253);
    this.tA = b.n(paramContext, 2131100252);
    this.tB = b.n(paramContext, 2131100251);
    this.tp = new Paint(5);
    this.tp.setStyle(Paint.Style.FILL);
    this.tt = Math.round(paramFloat1);
    this.tr = new RectF();
    this.tq = new Paint(this.tp);
    this.tq.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - tn) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - tn) * paramFloat2);
    }
    return f;
  }
  
  private static int s(float paramFloat)
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
      f1 = this.tw * 1.5F;
      this.tr.set(((Rect)localObject).left + this.tw, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.tw, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.tr.left, (int)this.tr.top, (int)this.tr.right, (int)this.tr.bottom);
      localObject = new RectF(-this.tt, -this.tt, this.tt, this.tt);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.tx, -this.tx);
      if (this.tu == null)
      {
        this.tu = new Path();
        this.tu.setFillType(Path.FillType.EVEN_ODD);
        this.tu.moveTo(-this.tt, 0.0F);
        this.tu.rLineTo(-this.tx, 0.0F);
        this.tu.arcTo(localRectF, 180.0F, 90.0F, false);
        this.tu.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.tu.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.tt / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.tp;
          i = this.tz;
          j = this.tA;
          k = this.tB;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.tq;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.tz;
        j = this.tA;
        k = this.tB;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.tq.setAntiAlias(false);
        this.dirty = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.rotation, this.tr.centerX(), this.tr.centerY());
      f1 = -this.tt - this.tx;
      f2 = this.tt;
      if (this.tr.width() - 2.0F * f2 <= 0.0F) {
        break label1060;
      }
      i = 1;
      label535:
      if (this.tr.height() - 2.0F * f2 <= 0.0F) {
        break label1066;
      }
    }
    label1060:
    label1066:
    for (int j = 1;; j = 0)
    {
      float f6 = this.ty;
      float f7 = this.ty;
      f3 = this.ty;
      float f8 = this.ty;
      float f4 = this.ty;
      float f5 = this.ty;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.tr.left + f2, this.tr.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.tu, this.tp);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.tr.width() - 2.0F * f2, -this.tt, this.tq);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.tr.right - f2, this.tr.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.tu, this.tp);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.tr.width();
        f7 = -this.tt;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.tx + f7, this.tq);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.tr.left + f2, this.tr.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.tu, this.tp);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.tr.height() - 2.0F * f2, -this.tt, this.tq);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.tr.right - f2, this.tr.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.tu, this.tp);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.tr.height() - 2.0F * f2, -this.tt, this.tq);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      return;
      this.tu.reset();
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
    float f = s(paramFloat1);
    paramFloat2 = s(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.tD) {
        this.tD = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.ty == paramFloat1) && (this.tw == paramFloat2)) {
      return;
    }
    this.ty = paramFloat1;
    this.tw = paramFloat2;
    this.tx = Math.round(paramFloat1 * 1.5F);
    this.tv = paramFloat2;
    this.dirty = true;
    invalidateSelf();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.tw, this.tt, this.tC));
    int j = (int)Math.ceil(b(this.tw, this.tt, this.tC));
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
    this.tp.setAlpha(paramInt);
    this.tq.setAlpha(paramInt);
  }
  
  public final void t(float paramFloat)
  {
    f(paramFloat, this.tw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.l
 * JD-Core Version:    0.7.0.1
 */