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
  static a ate;
  private static final double rn = Math.cos(Math.toRadians(45.0D));
  float Iv;
  ColorStateList atc;
  private final int atd;
  private Paint atf;
  private Paint atg;
  private final RectF ath;
  private Path ati;
  float atj;
  private float atk;
  float atl;
  boolean atm = true;
  private final int atn;
  private final int ato;
  private boolean atp = true;
  private boolean atq = false;
  private Paint mPaint;
  
  ao(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.atn = paramResources.getColor(2131100121);
    this.ato = paramResources.getColor(2131100120);
    this.atd = paramResources.getDimensionPixelSize(2131166002);
    this.mPaint = new Paint(5);
    g(paramColorStateList);
    this.atf = new Paint(5);
    this.atf.setStyle(Paint.Style.FILL);
    this.Iv = ((int)(0.5F + paramFloat1));
    this.ath = new RectF();
    this.atg = new Paint(this.atf);
    this.atg.setAntiAlias(false);
    f(paramFloat2, paramFloat3);
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - rn) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - rn) * paramFloat2);
    }
    return f;
  }
  
  private static int u(float paramFloat)
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
    this.atp = paramBoolean;
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
    if (this.atm)
    {
      Object localObject1 = getBounds();
      f1 = this.atj * 1.5F;
      this.ath.set(((Rect)localObject1).left + this.atj, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.atj, ((Rect)localObject1).bottom - f1);
      localObject1 = new RectF(-this.Iv, -this.Iv, this.Iv, this.Iv);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-this.atk, -this.atk);
      if (this.ati == null)
      {
        this.ati = new Path();
        this.ati.setFillType(Path.FillType.EVEN_ODD);
        this.ati.moveTo(-this.Iv, 0.0F);
        this.ati.rLineTo(-this.atk, 0.0F);
        this.ati.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        this.ati.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        this.ati.close();
        f1 = this.Iv / (this.Iv + this.atk);
        localObject1 = this.atf;
        f2 = this.Iv;
        f3 = this.atk;
        i = this.atn;
        k = this.atn;
        int m = this.ato;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, k, m }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = this.atg;
        f1 = -this.Iv;
        f2 = this.atk;
        f3 = -this.Iv;
        f4 = this.atk;
        i = this.atn;
        k = this.atn;
        m = this.ato;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i, k, m }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        this.atg.setAntiAlias(false);
        this.atm = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, this.atl / 2.0F);
      f1 = -this.Iv - this.atk;
      f2 = this.Iv + this.atd + this.atl / 2.0F;
      if (this.ath.width() - 2.0F * f2 <= 0.0F) {
        break label903;
      }
      i = 1;
      label504:
      if (this.ath.height() - 2.0F * f2 <= 0.0F) {
        break label909;
      }
    }
    for (;;)
    {
      k = paramCanvas.save();
      paramCanvas.translate(this.ath.left + f2, this.ath.top + f2);
      paramCanvas.drawPath(this.ati, this.atf);
      if (i != 0) {
        paramCanvas.drawRect(0.0F, f1, this.ath.width() - 2.0F * f2, -this.Iv, this.atg);
      }
      paramCanvas.restoreToCount(k);
      k = paramCanvas.save();
      paramCanvas.translate(this.ath.right - f2, this.ath.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.ati, this.atf);
      if (i != 0)
      {
        f3 = this.ath.width();
        f4 = -this.Iv;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.atk + f4, this.atg);
      }
      paramCanvas.restoreToCount(k);
      i = paramCanvas.save();
      paramCanvas.translate(this.ath.left + f2, this.ath.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.ati, this.atf);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.ath.height() - 2.0F * f2, -this.Iv, this.atg);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.ath.right - f2, this.ath.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.ati, this.atf);
      if (j != 0) {
        paramCanvas.drawRect(0.0F, f1, this.ath.height() - 2.0F * f2, -this.Iv, this.atg);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.translate(0.0F, -this.atl / 2.0F);
      ate.a(paramCanvas, this.ath, this.Iv, this.mPaint);
      return;
      this.ati.reset();
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
    float f = u(paramFloat1);
    paramFloat2 = u(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.atq) {
        this.atq = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.atl == paramFloat1) && (this.atj == paramFloat2)) {
      return;
    }
    this.atl = paramFloat1;
    this.atj = paramFloat2;
    this.atk = ((int)(paramFloat1 * 1.5F + this.atd + 0.5F));
    this.atm = true;
    invalidateSelf();
  }
  
  final void g(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.atc = localColorStateList;
    this.mPaint.setColor(this.atc.getColorForState(getState(), this.atc.getDefaultColor()));
  }
  
  final float getMinHeight()
  {
    return Math.max(this.atj, this.Iv + this.atd + this.atj * 1.5F / 2.0F) * 2.0F + (this.atj * 1.5F + this.atd) * 2.0F;
  }
  
  final float getMinWidth()
  {
    return Math.max(this.atj, this.Iv + this.atd + this.atj / 2.0F) * 2.0F + (this.atj + this.atd) * 2.0F;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.atj, this.Iv, this.atp));
    int j = (int)Math.ceil(b(this.atj, this.Iv, this.atp));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public final boolean isStateful()
  {
    return ((this.atc != null) && (this.atc.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.atm = true;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.atc.getColorForState(paramArrayOfInt, this.atc.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.atm = true;
    invalidateSelf();
    return true;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.atf.setAlpha(paramInt);
    this.atg.setAlpha(paramInt);
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