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
import android.support.design.a.c;
import android.support.v4.content.b;
import android.support.v7.d.a.a;

final class j
  extends a
{
  static final double jo = Math.cos(Math.toRadians(45.0D));
  float gb;
  private final int jA;
  private final int jB;
  boolean jC = true;
  private boolean jD = false;
  final Paint jp;
  final Paint jq;
  final RectF jr;
  float js;
  Path jt;
  float ju;
  float jv;
  float jw;
  float jx;
  private boolean jy = true;
  private final int jz;
  
  public j(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.jz = b.i(paramContext, a.c.design_fab_shadow_start_color);
    this.jA = b.i(paramContext, a.c.design_fab_shadow_mid_color);
    this.jB = b.i(paramContext, a.c.design_fab_shadow_end_color);
    this.jp = new Paint(5);
    this.jp.setStyle(Paint.Style.FILL);
    this.js = Math.round(paramFloat1);
    this.jr = new RectF();
    this.jq = new Paint(this.jp);
    this.jq.setAntiAlias(false);
    p(paramFloat2, paramFloat3);
  }
  
  public static float c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - jo) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - jo) * paramFloat2);
    }
    return f;
  }
  
  private static int l(float paramFloat)
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
    if (this.jy)
    {
      Object localObject = getBounds();
      f1 = this.jv * 1.5F;
      this.jr.set(((Rect)localObject).left + this.jv, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.jv, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.jr.left, (int)this.jr.top, (int)this.jr.right, (int)this.jr.bottom);
      localObject = new RectF(-this.js, -this.js, this.js, this.js);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.jw, -this.jw);
      if (this.jt == null)
      {
        this.jt = new Path();
        this.jt.setFillType(Path.FillType.EVEN_ODD);
        this.jt.moveTo(-this.js, 0.0F);
        this.jt.rLineTo(-this.jw, 0.0F);
        this.jt.arcTo(localRectF, 180.0F, 90.0F, false);
        this.jt.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.jt.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.js / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.jp;
          i = this.jz;
          j = this.jA;
          k = this.jB;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.jq;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.jz;
        j = this.jA;
        k = this.jB;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.jq.setAntiAlias(false);
        this.jy = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.gb, this.jr.centerX(), this.jr.centerY());
      f1 = -this.js - this.jw;
      f2 = this.js;
      if (this.jr.width() - 2.0F * f2 <= 0.0F) {
        break label1061;
      }
      i = 1;
      label535:
      if (this.jr.height() - 2.0F * f2 <= 0.0F) {
        break label1067;
      }
    }
    label1061:
    label1067:
    for (int j = 1;; j = 0)
    {
      float f6 = this.jx;
      float f7 = this.jx;
      f3 = this.jx;
      float f8 = this.jx;
      float f4 = this.jx;
      float f5 = this.jx;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.jr.left + f2, this.jr.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.jt, this.jp);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.jr.width() - 2.0F * f2, -this.js, this.jq);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.jr.right - f2, this.jr.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.jt, this.jp);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.jr.width();
        f7 = -this.js;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.jw + f7, this.jq);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.jr.left + f2, this.jr.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.jt, this.jp);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.jr.height() - 2.0F * f2, -this.js, this.jq);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.jr.right - f2, this.jr.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.jt, this.jp);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.jr.height() - 2.0F * f2, -this.js, this.jq);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      return;
      this.jt.reset();
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
    int i = (int)Math.ceil(c(this.jv, this.js, this.jC));
    int j = (int)Math.ceil(d(this.jv, this.js, this.jC));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final void m(float paramFloat)
  {
    p(paramFloat, this.jv);
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    this.jy = true;
  }
  
  final void p(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F)) {
      throw new IllegalArgumentException("invalid shadow size");
    }
    float f = l(paramFloat1);
    paramFloat2 = l(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.jD) {
        this.jD = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.jx == paramFloat1) && (this.jv == paramFloat2)) {
      return;
    }
    this.jx = paramFloat1;
    this.jv = paramFloat2;
    this.jw = Math.round(paramFloat1 * 1.5F);
    this.ju = paramFloat2;
    this.jy = true;
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.jp.setAlpha(paramInt);
    this.jq.setAlpha(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.j
 * JD-Core Version:    0.7.0.1
 */