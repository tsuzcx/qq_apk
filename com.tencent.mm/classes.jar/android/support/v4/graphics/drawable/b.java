package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public abstract class b
  extends Drawable
{
  private boolean KA = true;
  private boolean KB;
  private int Kt = 160;
  private int Ku = 119;
  private final BitmapShader Kv;
  private final Matrix Kw = new Matrix();
  float Kx;
  final Rect Ky = new Rect();
  private final RectF Kz = new RectF();
  public final Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private final Paint mPaint = new Paint(3);
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.Kt = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.mBitmapWidth = this.mBitmap.getScaledWidth(this.Kt);
      this.mBitmapHeight = this.mBitmap.getScaledHeight(this.Kt);
      paramResources = this.mBitmap;
      paramBitmap = Shader.TileMode.CLAMP;
      this.Kv = new BitmapShader(paramResources, paramBitmap, paramBitmap);
      return;
    }
    this.mBitmapHeight = -1;
    this.mBitmapWidth = -1;
    this.Kv = null;
  }
  
  private void eE()
  {
    this.Kx = (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
  }
  
  private static boolean x(float paramFloat)
  {
    return paramFloat > 0.05F;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    if (localBitmap == null) {
      return;
    }
    eC();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.Ky, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.Kz, this.Kx, this.Kx, this.mPaint);
  }
  
  final void eC()
  {
    if (this.KA)
    {
      if (!this.KB) {
        break label220;
      }
      int i = Math.min(this.mBitmapWidth, this.mBitmapHeight);
      a(this.Ku, i, i, getBounds(), this.Ky);
      i = Math.min(this.Ky.width(), this.Ky.height());
      int j = Math.max(0, (this.Ky.width() - i) / 2);
      int k = Math.max(0, (this.Ky.height() - i) / 2);
      this.Ky.inset(j, k);
      this.Kx = (i * 0.5F);
    }
    for (;;)
    {
      this.Kz.set(this.Ky);
      if (this.Kv != null)
      {
        this.Kw.setTranslate(this.Kz.left, this.Kz.top);
        this.Kw.preScale(this.Kz.width() / this.mBitmap.getWidth(), this.Kz.height() / this.mBitmap.getHeight());
        this.Kv.setLocalMatrix(this.Kw);
        this.mPaint.setShader(this.Kv);
      }
      this.KA = false;
      return;
      label220:
      a(this.Ku, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.Ky);
    }
  }
  
  public final void eD()
  {
    this.KB = true;
    this.KA = true;
    eE();
    this.mPaint.setShader(this.Kv);
    invalidateSelf();
  }
  
  public int getAlpha()
  {
    return this.mPaint.getAlpha();
  }
  
  public final Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mPaint.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmapWidth;
  }
  
  public int getOpacity()
  {
    if ((this.Ku != 119) || (this.KB)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (x(this.Kx)));
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.KB) {
      eE();
    }
    this.KA = true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void setCornerRadius(float paramFloat)
  {
    if (this.Kx == paramFloat) {
      return;
    }
    this.KB = false;
    if (x(paramFloat)) {
      this.mPaint.setShader(this.Kv);
    }
    for (;;)
    {
      this.Kx = paramFloat;
      invalidateSelf();
      return;
      this.mPaint.setShader(null);
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.graphics.drawable.b
 * JD-Core Version:    0.7.0.1
 */