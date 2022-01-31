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

final class ao
  extends Drawable
{
  static ao.a akV;
  private static final double km = Math.cos(Math.toRadians(45.0D));
  ColorStateList akT;
  private final int akU;
  private final RectF akW;
  private boolean kA = true;
  private boolean kB = false;
  private Paint kn;
  private Paint ko;
  float kq;
  private Path kr;
  float kt;
  private float ku;
  float kv;
  boolean kw = true;
  private final int kx;
  private final int kz;
  private Paint mPaint;
  
  ao(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.kx = paramResources.getColor(2131689860);
    this.kz = paramResources.getColor(2131689859);
    this.akU = paramResources.getDimensionPixelSize(2131428203);
    this.mPaint = new Paint(5);
    e(paramColorStateList);
    this.kn = new Paint(5);
    this.kn.setStyle(Paint.Style.FILL);
    this.kq = ((int)(0.5F + paramFloat1));
    this.akW = new RectF();
    this.ko = new Paint(this.kn);
    this.ko.setAntiAlias(false);
    p(paramFloat2, paramFloat3);
  }
  
  static float c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - km) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - km) * paramFloat2);
    }
    return f;
  }
  
  private static int m(float paramFloat)
  {
    int j = (int)(0.5F + paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  final void aq(boolean paramBoolean)
  {
    this.kA = paramBoolean;
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
    if (this.kw)
    {
      Object localObject1 = getBounds();
      f1 = this.kt * 1.5F;
      this.akW.set(((Rect)localObject1).left + this.kt, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.kt, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.kq, -this.kq, this.kq, this.kq);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.ku, -this.ku);
      if (this.kr == null)
      {
        this.kr = new Path();
        this.kr.setFillType(Path.FillType.EVEN_ODD);
        this.kr.moveTo(-this.kq, 0.0F);
        this.kr.rLineTo(-this.ku, 0.0F);
        this.kr.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.kr.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.kr.close();
        f1 = this.kq / (this.kq + this.ku);
        localObject1 = this.kn;
        f2 = this.kq;
        f3 = this.ku;
        i = this.kx;
        k = this.kx;
        int m = this.kz;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.ko;
        f1 = -this.kq;
        f2 = this.ku;
        f3 = -this.kq;
        f4 = this.ku;
        i = this.kx;
        k = this.kx;
        m = this.kz;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.ko.setAntiAlias(false);
        this.kw = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.kv / 2.0F);
      f1 = -this.kq - this.ku;
      f2 = this.kq + this.akU + this.kv / 2.0F;
      if (this.akW.width() - 2.0F * f2 <= 0.0F) {
        break label903;
      }
      i = 1;
      label504:
      if (this.akW.height() - 2.0F * f2 <= 0.0F) {
        break label909;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.akW.left + f2, this.akW.top + f2);
      paramCanvas.drawPath(this.kr, this.kn);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.akW.width() - 2.0F * f2, -this.kq, this.ko);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.akW.right - f2, this.akW.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.kr, this.kn);
      if (i != 0)
      {
        f3 = this.akW.width();
        f4 = -this.kq;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.ku + f4, this.ko);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.akW.left + f2, this.akW.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.kr, this.kn);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.akW.height() - 2.0F * f2, -this.kq, this.ko);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.akW.right - f2, this.akW.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.kr, this.kn);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.akW.height() - 2.0F * f2, -this.kq, this.ko);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.kv / 2.0F);
      akV.a(paramCanvas, this.akW, this.kq, this.mPaint);
      return;
      this.kr.reset();
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
    this.akT = localColorStateList;
    this.mPaint.setColor(this.akT.getColorForState(getState(), this.akT.getDefaultColor()));
  }
  
  final float getMinHeight()
  {
    return Math.max(this.kt, this.kq + this.akU + this.kt * 1.5F / 2.0F) * 2.0F + (this.kt * 1.5F + this.akU) * 2.0F;
  }
  
  final float getMinWidth()
  {
    return Math.max(this.kt, this.kq + this.akU + this.kt / 2.0F) * 2.0F + (this.kt + this.akU) * 2.0F;
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
  
  public final boolean isStateful()
  {
    return ((this.akT != null) && (this.akT.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.kw = true;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.akT.getColorForState(paramArrayOfInt, this.akT.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.kw = true;
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
    this.ku = ((int)(paramFloat1 * 1.5F + this.akU + 0.5F));
    this.kw = true;
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.kn.setAlpha(paramInt);
    this.ko.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.ao
 * JD-Core Version:    0.7.0.1
 */