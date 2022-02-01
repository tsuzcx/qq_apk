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
  static a auV;
  private static final double ti = Math.cos(Math.toRadians(45.0D));
  float Kn;
  ColorStateList auT;
  private final int auU;
  private Paint auW;
  private Paint auX;
  private final RectF auY;
  private Path auZ;
  float ava;
  private float avb;
  float avc;
  boolean avd = true;
  private final int ave;
  private final int avf;
  private boolean avh = true;
  private boolean avi = false;
  private Paint mPaint;
  
  ao(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.ave = paramResources.getColor(2131100121);
    this.avf = paramResources.getColor(2131100120);
    this.auU = paramResources.getDimensionPixelSize(2131166002);
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.auW = new Paint(5);
    this.auW.setStyle(Paint.Style.FILL);
    this.Kn = ((int)(0.5F + paramFloat1));
    this.auY = new RectF();
    this.auX = new Paint(this.auW);
    this.auX.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - ti) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - ti) * paramFloat2);
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
  
  final void ay(boolean paramBoolean)
  {
    this.avh = paramBoolean;
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
    if (this.avd)
    {
      Object localObject1 = getBounds();
      f1 = this.ava * 1.5F;
      this.auY.set(((Rect)localObject1).left + this.ava, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.ava, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.Kn, -this.Kn, this.Kn, this.Kn);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.avb, -this.avb);
      if (this.auZ == null)
      {
        this.auZ = new Path();
        this.auZ.setFillType(Path.FillType.EVEN_ODD);
        this.auZ.moveTo(-this.Kn, 0.0F);
        this.auZ.rLineTo(-this.avb, 0.0F);
        this.auZ.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.auZ.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.auZ.close();
        f1 = this.Kn / (this.Kn + this.avb);
        localObject1 = this.auW;
        f2 = this.Kn;
        f3 = this.avb;
        i = this.ave;
        k = this.ave;
        int m = this.avf;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.auX;
        f1 = -this.Kn;
        f2 = this.avb;
        f3 = -this.Kn;
        f4 = this.avb;
        i = this.ave;
        k = this.ave;
        m = this.avf;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.auX.setAntiAlias(false);
        this.avd = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.avc / 2.0F);
      f1 = -this.Kn - this.avb;
      f2 = this.Kn + this.auU + this.avc / 2.0F;
      if (this.auY.width() - 2.0F * f2 <= 0.0F) {
        break label903;
      }
      i = 1;
      label504:
      if (this.auY.height() - 2.0F * f2 <= 0.0F) {
        break label909;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.auY.left + f2, this.auY.top + f2);
      paramCanvas.drawPath(this.auZ, this.auW);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.auY.width() - 2.0F * f2, -this.Kn, this.auX);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.auY.right - f2, this.auY.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.auZ, this.auW);
      if (i != 0)
      {
        f3 = this.auY.width();
        f4 = -this.Kn;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.avb + f4, this.auX);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.auY.left + f2, this.auY.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.auZ, this.auW);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.auY.height() - 2.0F * f2, -this.Kn, this.auX);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.auY.right - f2, this.auY.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.auZ, this.auW);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.auY.height() - 2.0F * f2, -this.Kn, this.auX);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.avc / 2.0F);
      auV.a(paramCanvas, this.auY, this.Kn, this.mPaint);
      return;
      this.auZ.reset();
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
      if (!this.avi) {
        this.avi = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.avc == paramFloat1) && (this.ava == paramFloat2)) {
      return;
    }
    this.avc = paramFloat1;
    this.ava = paramFloat2;
    this.avb = ((int)(paramFloat1 * 1.5F + this.auU + 0.5F));
    this.avd = true;
    invalidateSelf();
  }
  
  final void g(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.auT = localColorStateList;
    this.mPaint.setColor(this.auT.getColorForState(getState(), this.auT.getDefaultColor()));
  }
  
  final float getMinHeight()
  {
    return Math.max(this.ava, this.Kn + this.auU + this.ava * 1.5F / 2.0F) * 2.0F + (this.ava * 1.5F + this.auU) * 2.0F;
  }
  
  final float getMinWidth()
  {
    return Math.max(this.ava, this.Kn + this.auU + this.ava / 2.0F) * 2.0F + (this.ava + this.auU) * 2.0F;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.ava, this.Kn, this.avh));
    int j = (int)Math.ceil(b(this.ava, this.Kn, this.avh));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final boolean isStateful()
  {
    return ((this.auT != null) && (this.auT.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.avd = true;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.auT.getColorForState(paramArrayOfInt, this.auT.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.avd = true;
    invalidateSelf();
    return true;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.auW.setAlpha(paramInt);
    this.auX.setAlpha(paramInt);
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