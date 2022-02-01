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
  static a asj;
  private static final double qn = Math.cos(Math.toRadians(45.0D));
  float Hx;
  ColorStateList ash;
  private final int asi;
  private Paint ask;
  private Paint asl;
  private final RectF asm;
  private Path asn;
  float aso;
  private float asp;
  float asq;
  boolean asr = true;
  private final int ass;
  private final int ast;
  private boolean asu = true;
  private boolean asv = false;
  private Paint mPaint;
  
  ao(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.ass = paramResources.getColor(2131100121);
    this.ast = paramResources.getColor(2131100120);
    this.asi = paramResources.getDimensionPixelSize(2131166002);
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.ask = new Paint(5);
    this.ask.setStyle(Paint.Style.FILL);
    this.Hx = ((int)(0.5F + paramFloat1));
    this.asm = new RectF();
    this.asl = new Paint(this.ask);
    this.asl.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - qn) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - qn) * paramFloat2);
    }
    return f;
  }
  
  private static int q(float paramFloat)
  {
    int j = (int)(0.5F + paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  final void ay(boolean paramBoolean)
  {
    this.asu = paramBoolean;
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
    if (this.asr)
    {
      Object localObject1 = getBounds();
      f1 = this.aso * 1.5F;
      this.asm.set(((Rect)localObject1).left + this.aso, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.aso, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.Hx, -this.Hx, this.Hx, this.Hx);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.asp, -this.asp);
      if (this.asn == null)
      {
        this.asn = new Path();
        this.asn.setFillType(Path.FillType.EVEN_ODD);
        this.asn.moveTo(-this.Hx, 0.0F);
        this.asn.rLineTo(-this.asp, 0.0F);
        this.asn.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.asn.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.asn.close();
        f1 = this.Hx / (this.Hx + this.asp);
        localObject1 = this.ask;
        f2 = this.Hx;
        f3 = this.asp;
        i = this.ass;
        k = this.ass;
        int m = this.ast;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.asl;
        f1 = -this.Hx;
        f2 = this.asp;
        f3 = -this.Hx;
        f4 = this.asp;
        i = this.ass;
        k = this.ass;
        m = this.ast;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.asl.setAntiAlias(false);
        this.asr = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.asq / 2.0F);
      f1 = -this.Hx - this.asp;
      f2 = this.Hx + this.asi + this.asq / 2.0F;
      if (this.asm.width() - 2.0F * f2 <= 0.0F) {
        break label903;
      }
      i = 1;
      label504:
      if (this.asm.height() - 2.0F * f2 <= 0.0F) {
        break label909;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.asm.left + f2, this.asm.top + f2);
      paramCanvas.drawPath(this.asn, this.ask);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.asm.width() - 2.0F * f2, -this.Hx, this.asl);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.asm.right - f2, this.asm.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.asn, this.ask);
      if (i != 0)
      {
        f3 = this.asm.width();
        f4 = -this.Hx;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.asp + f4, this.asl);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.asm.left + f2, this.asm.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.asn, this.ask);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.asm.height() - 2.0F * f2, -this.Hx, this.asl);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.asm.right - f2, this.asm.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.asn, this.ask);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.asm.height() - 2.0F * f2, -this.Hx, this.asl);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.asq / 2.0F);
      asj.a(paramCanvas, this.asm, this.Hx, this.mPaint);
      return;
      this.asn.reset();
      break;
      label903:
      i = 0;
      break label504;
      label909:
      j = 0;
    }
  }
  
  final void f(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < 0.0F) {
      throw new IllegalArgumentException("Invalid shadow size " + paramFloat1 + ". Must be >= 0");
    }
    if (paramFloat2 < 0.0F) {
      throw new IllegalArgumentException("Invalid max shadow size " + paramFloat2 + ". Must be >= 0");
    }
    float f = q(paramFloat1);
    paramFloat2 = q(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.asv) {
        this.asv = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.asq == paramFloat1) && (this.aso == paramFloat2)) {
      return;
    }
    this.asq = paramFloat1;
    this.aso = paramFloat2;
    this.asp = ((int)(paramFloat1 * 1.5F + this.asi + 0.5F));
    this.asr = true;
    invalidateSelf();
  }
  
  final void g(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.ash = localColorStateList;
    this.mPaint.setColor(this.ash.getColorForState(getState(), this.ash.getDefaultColor()));
  }
  
  final float getMinHeight()
  {
    return Math.max(this.aso, this.Hx + this.asi + this.aso * 1.5F / 2.0F) * 2.0F + (this.aso * 1.5F + this.asi) * 2.0F;
  }
  
  final float getMinWidth()
  {
    return Math.max(this.aso, this.Hx + this.asi + this.aso / 2.0F) * 2.0F + (this.aso + this.asi) * 2.0F;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.aso, this.Hx, this.asu));
    int j = (int)Math.ceil(b(this.aso, this.Hx, this.asu));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final boolean isStateful()
  {
    return ((this.ash != null) && (this.ash.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.asr = true;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.ash.getColorForState(paramArrayOfInt, this.ash.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.asr = true;
    invalidateSelf();
    return true;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.ask.setAlpha(paramInt);
    this.asl.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  static abstract interface a
  {
    public abstract void a(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.ao
 * JD-Core Version:    0.7.0.1
 */