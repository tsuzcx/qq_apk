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
  static final double ti = Math.cos(Math.toRadians(45.0D));
  private boolean dirty = true;
  float rotation;
  final Paint tj;
  final Paint tk;
  final RectF tl;
  float tm;
  Path tn;
  float to;
  float tp;
  float tq;
  float tr;
  private final int ts;
  private final int tt;
  private final int tu;
  boolean tv = true;
  private boolean tw = false;
  
  public l(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.ts = b.n(paramContext, 2131100219);
    this.tt = b.n(paramContext, 2131100218);
    this.tu = b.n(paramContext, 2131100217);
    this.tj = new Paint(5);
    this.tj.setStyle(Paint.Style.FILL);
    this.tm = Math.round(paramFloat1);
    this.tl = new RectF();
    this.tk = new Paint(this.tj);
    this.tk.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - ti) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - ti) * paramFloat2);
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
      f1 = this.tp * 1.5F;
      this.tl.set(((Rect)localObject).left + this.tp, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.tp, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.tl.left, (int)this.tl.top, (int)this.tl.right, (int)this.tl.bottom);
      localObject = new RectF(-this.tm, -this.tm, this.tm, this.tm);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.tq, -this.tq);
      if (this.tn == null)
      {
        this.tn = new Path();
        this.tn.setFillType(Path.FillType.EVEN_ODD);
        this.tn.moveTo(-this.tm, 0.0F);
        this.tn.rLineTo(-this.tq, 0.0F);
        this.tn.arcTo(localRectF, 180.0F, 90.0F, false);
        this.tn.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.tn.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.tm / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.tj;
          i = this.ts;
          j = this.tt;
          k = this.tu;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.tk;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.ts;
        j = this.tt;
        k = this.tu;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.tk.setAntiAlias(false);
        this.dirty = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.rotation, this.tl.centerX(), this.tl.centerY());
      f1 = -this.tm - this.tq;
      f2 = this.tm;
      if (this.tl.width() - 2.0F * f2 <= 0.0F) {
        break label1060;
      }
      i = 1;
      label535:
      if (this.tl.height() - 2.0F * f2 <= 0.0F) {
        break label1066;
      }
    }
    label1060:
    label1066:
    for (int j = 1;; j = 0)
    {
      float f6 = this.tr;
      float f7 = this.tr;
      f3 = this.tr;
      float f8 = this.tr;
      float f4 = this.tr;
      float f5 = this.tr;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.tl.left + f2, this.tl.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.tn, this.tj);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.tl.width() - 2.0F * f2, -this.tm, this.tk);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.tl.right - f2, this.tl.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.tn, this.tj);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.tl.width();
        f7 = -this.tm;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.tq + f7, this.tk);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.tl.left + f2, this.tl.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.tn, this.tj);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.tl.height() - 2.0F * f2, -this.tm, this.tk);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.tl.right - f2, this.tl.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.tn, this.tj);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.tl.height() - 2.0F * f2, -this.tm, this.tk);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      return;
      this.tn.reset();
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
      if (!this.tw) {
        this.tw = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.tr == paramFloat1) && (this.tp == paramFloat2)) {
      return;
    }
    this.tr = paramFloat1;
    this.tp = paramFloat2;
    this.tq = Math.round(paramFloat1 * 1.5F);
    this.to = paramFloat2;
    this.dirty = true;
    invalidateSelf();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.tp, this.tm, this.tv));
    int j = (int)Math.ceil(b(this.tp, this.tm, this.tv));
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
    this.tj.setAlpha(paramInt);
    this.tk.setAlpha(paramInt);
  }
  
  public final void t(float paramFloat)
  {
    f(paramFloat, this.tp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.l
 * JD-Core Version:    0.7.0.1
 */