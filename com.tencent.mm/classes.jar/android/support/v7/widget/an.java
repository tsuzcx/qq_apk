package android.support.v7.widget;

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
import android.support.v7.b.a.b;
import android.support.v7.b.a.c;

final class an
  extends Drawable
{
  static an.a aiF;
  private static final double jo = Math.cos(Math.toRadians(45.0D));
  ColorStateList aiD;
  final int aiE;
  private final RectF aiG;
  private final int jB;
  private boolean jC = true;
  private boolean jD = false;
  private Paint jp;
  private Paint jq;
  float js;
  private Path jt;
  float jv;
  private float jw;
  float jx;
  boolean jy = true;
  private final int jz;
  private Paint mPaint;
  
  an(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jz = paramResources.getColor(a.b.cardview_shadow_start_color);
    this.jB = paramResources.getColor(a.b.cardview_shadow_end_color);
    this.aiE = paramResources.getDimensionPixelSize(a.c.cardview_compat_inset_shadow);
    this.mPaint = new Paint(5);
    e(paramColorStateList);
    this.jp = new Paint(5);
    this.jp.setStyle(Paint.Style.FILL);
    this.js = ((int)(0.5F + paramFloat1));
    this.aiG = new RectF();
    this.jq = new Paint(this.jp);
    this.jq.setAntiAlias(false);
    p(paramFloat2, paramFloat3);
  }
  
  static float c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - jo) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - jo) * paramFloat2);
    }
    return f;
  }
  
  private static int l(float paramFloat)
  {
    int j = (int)(0.5F + paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  final void ah(boolean paramBoolean)
  {
    this.jC = paramBoolean;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    float f4;
    if (this.jy)
    {
      Object localObject1 = getBounds();
      f1 = this.jv * 1.5F;
      this.aiG.set(((Rect)localObject1).left + this.jv, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.jv, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.js, -this.js, this.js, this.js);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.jw, -this.jw);
      if (this.jt == null)
      {
        this.jt = new Path();
        this.jt.setFillType(Path.FillType.EVEN_ODD);
        this.jt.moveTo(-this.js, 0.0F);
        this.jt.rLineTo(-this.jw, 0.0F);
        this.jt.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.jt.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.jt.close();
        f1 = this.js / (this.js + this.jw);
        localObject1 = this.jp;
        f2 = this.js;
        f3 = this.jw;
        i = this.jz;
        k = this.jz;
        int m = this.jB;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.jq;
        f1 = -this.js;
        f2 = this.jw;
        f3 = -this.js;
        f4 = this.jw;
        i = this.jz;
        k = this.jz;
        m = this.jB;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.jq.setAntiAlias(false);
        this.jy = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.jx / 2.0F);
      f1 = -this.js - this.jw;
      f2 = this.js + this.aiE + this.jx / 2.0F;
      if (this.aiG.width() - 2.0F * f2 <= 0.0F) {
        break label903;
      }
      i = 1;
      label504:
      if (this.aiG.height() - 2.0F * f2 <= 0.0F) {
        break label909;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.aiG.left + f2, this.aiG.top + f2);
      paramCanvas.drawPath(this.jt, this.jp);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.aiG.width() - 2.0F * f2, -this.js, this.jq);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.aiG.right - f2, this.aiG.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.jt, this.jp);
      if (i != 0)
      {
        f3 = this.aiG.width();
        f4 = -this.js;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.jw + f4, this.jq);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.aiG.left + f2, this.aiG.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.jt, this.jp);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.aiG.height() - 2.0F * f2, -this.js, this.jq);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.aiG.right - f2, this.aiG.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.jt, this.jp);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.aiG.height() - 2.0F * f2, -this.js, this.jq);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.jx / 2.0F);
      aiF.a(paramCanvas, this.aiG, this.js, this.mPaint);
      return;
      this.jt.reset();
      break;
      label903:
      i = 0;
      break label504;
      label909:
      j = 0;
    }
  }
  
  final void e(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.aiD = localColorStateList;
    this.mPaint.setColor(this.aiD.getColorForState(getState(), this.aiD.getDefaultColor()));
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
  
  public final boolean isStateful()
  {
    return ((this.aiD != null) && (this.aiD.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.jy = true;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.aiD.getColorForState(paramArrayOfInt, this.aiD.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.jy = true;
    invalidateSelf();
    return true;
  }
  
  final void p(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < 0.0F) {
      throw new IllegalArgumentException("Invalid shadow size " + paramFloat1 + ". Must be >= 0");
    }
    if (paramFloat2 < 0.0F) {
      throw new IllegalArgumentException("Invalid max shadow size " + paramFloat2 + ". Must be >= 0");
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
    this.jw = ((int)(paramFloat1 * 1.5F + this.aiE + 0.5F));
    this.jy = true;
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.jp.setAlpha(paramInt);
    this.jq.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */