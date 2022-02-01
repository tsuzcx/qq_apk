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
  static a auT;
  private static final double tn = Math.cos(Math.toRadians(45.0D));
  float Kx;
  ColorStateList auR;
  private final int auS;
  private Paint auU;
  private Paint auV;
  private final RectF auW;
  private Path auX;
  float auY;
  private float auZ;
  float ava;
  boolean avb = true;
  private final int avc;
  private final int avd;
  private boolean ave = true;
  private boolean avf = false;
  private Paint mPaint;
  
  ao(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.avc = paramResources.getColor(2131100152);
    this.avd = paramResources.getColor(2131100151);
    this.auS = paramResources.getDimensionPixelSize(2131166034);
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.auU = new Paint(5);
    this.auU.setStyle(Paint.Style.FILL);
    this.Kx = ((int)(0.5F + paramFloat1));
    this.auW = new RectF();
    this.auV = new Paint(this.auU);
    this.auV.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - tn) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - tn) * paramFloat2);
    }
    return f;
  }
  
  private static int s(float paramFloat)
  {
    int j = (int)(0.5F + paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  final void aw(boolean paramBoolean)
  {
    this.ave = paramBoolean;
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
    if (this.avb)
    {
      Object localObject1 = getBounds();
      f1 = this.auY * 1.5F;
      this.auW.set(((Rect)localObject1).left + this.auY, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.auY, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.Kx, -this.Kx, this.Kx, this.Kx);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.auZ, -this.auZ);
      if (this.auX == null)
      {
        this.auX = new Path();
        this.auX.setFillType(Path.FillType.EVEN_ODD);
        this.auX.moveTo(-this.Kx, 0.0F);
        this.auX.rLineTo(-this.auZ, 0.0F);
        this.auX.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.auX.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.auX.close();
        f1 = this.Kx / (this.Kx + this.auZ);
        localObject1 = this.auU;
        f2 = this.Kx;
        f3 = this.auZ;
        i = this.avc;
        k = this.avc;
        int m = this.avd;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.auV;
        f1 = -this.Kx;
        f2 = this.auZ;
        f3 = -this.Kx;
        f4 = this.auZ;
        i = this.avc;
        k = this.avc;
        m = this.avd;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.auV.setAntiAlias(false);
        this.avb = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.ava / 2.0F);
      f1 = -this.Kx - this.auZ;
      f2 = this.Kx + this.auS + this.ava / 2.0F;
      if (this.auW.width() - 2.0F * f2 <= 0.0F) {
        break label903;
      }
      i = 1;
      label504:
      if (this.auW.height() - 2.0F * f2 <= 0.0F) {
        break label909;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.auW.left + f2, this.auW.top + f2);
      paramCanvas.drawPath(this.auX, this.auU);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.auW.width() - 2.0F * f2, -this.Kx, this.auV);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.auW.right - f2, this.auW.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.auX, this.auU);
      if (i != 0)
      {
        f3 = this.auW.width();
        f4 = -this.Kx;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.auZ + f4, this.auV);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.auW.left + f2, this.auW.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.auX, this.auU);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.auW.height() - 2.0F * f2, -this.Kx, this.auV);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.auW.right - f2, this.auW.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.auX, this.auU);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.auW.height() - 2.0F * f2, -this.Kx, this.auV);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.ava / 2.0F);
      auT.a(paramCanvas, this.auW, this.Kx, this.mPaint);
      return;
      this.auX.reset();
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
    float f = s(paramFloat1);
    paramFloat2 = s(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.avf) {
        this.avf = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.ava == paramFloat1) && (this.auY == paramFloat2)) {
      return;
    }
    this.ava = paramFloat1;
    this.auY = paramFloat2;
    this.auZ = ((int)(paramFloat1 * 1.5F + this.auS + 0.5F));
    this.avb = true;
    invalidateSelf();
  }
  
  final void g(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.auR = localColorStateList;
    this.mPaint.setColor(this.auR.getColorForState(getState(), this.auR.getDefaultColor()));
  }
  
  final float getMinHeight()
  {
    return Math.max(this.auY, this.Kx + this.auS + this.auY * 1.5F / 2.0F) * 2.0F + (this.auY * 1.5F + this.auS) * 2.0F;
  }
  
  final float getMinWidth()
  {
    return Math.max(this.auY, this.Kx + this.auS + this.auY / 2.0F) * 2.0F + (this.auY + this.auS) * 2.0F;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.auY, this.Kx, this.ave));
    int j = (int)Math.ceil(b(this.auY, this.Kx, this.ave));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final boolean isStateful()
  {
    return ((this.auR != null) && (this.auR.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.avb = true;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.auR.getColorForState(paramArrayOfInt, this.auR.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.avb = true;
    invalidateSelf();
    return true;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.auU.setAlpha(paramInt);
    this.auV.setAlpha(paramInt);
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