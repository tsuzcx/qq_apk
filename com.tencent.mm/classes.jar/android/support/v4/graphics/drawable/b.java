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
  private boolean HA = true;
  public boolean HB;
  private int HC;
  private int HD;
  private int Ht = 160;
  private int Hu = 119;
  public final BitmapShader Hv;
  private final Matrix Hw = new Matrix();
  public float Hx;
  final Rect Hy = new Rect();
  private final RectF Hz = new RectF();
  public final Bitmap mBitmap;
  public final Paint mPaint = new Paint(3);
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.Ht = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.HC = this.mBitmap.getScaledWidth(this.Ht);
      this.HD = this.mBitmap.getScaledHeight(this.Ht);
      paramResources = this.mBitmap;
      paramBitmap = Shader.TileMode.CLAMP;
      this.Hv = new BitmapShader(paramResources, paramBitmap, paramBitmap);
      return;
    }
    this.HD = -1;
    this.HC = -1;
    this.Hv = null;
  }
  
  private void dY()
  {
    this.Hx = (Math.min(this.HD, this.HC) / 2);
  }
  
  public static boolean v(float paramFloat)
  {
    return paramFloat > 0.05F;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    throw new UnsupportedOperationException();
  }
  
  final void dW()
  {
    if (this.HA)
    {
      if (!this.HB) {
        break label220;
      }
      int i = Math.min(this.HC, this.HD);
      a(this.Hu, i, i, getBounds(), this.Hy);
      i = Math.min(this.Hy.width(), this.Hy.height());
      int j = Math.max(0, (this.Hy.width() - i) / 2);
      int k = Math.max(0, (this.Hy.height() - i) / 2);
      this.Hy.inset(j, k);
      this.Hx = (i * 0.5F);
    }
    for (;;)
    {
      this.Hz.set(this.Hy);
      if (this.Hv != null)
      {
        this.Hw.setTranslate(this.Hz.left, this.Hz.top);
        this.Hw.preScale(this.Hz.width() / this.mBitmap.getWidth(), this.Hz.height() / this.mBitmap.getHeight());
        this.Hv.setLocalMatrix(this.Hw);
        this.mPaint.setShader(this.Hv);
      }
      this.HA = false;
      return;
      label220:
      a(this.Hu, this.HC, this.HD, getBounds(), this.Hy);
    }
  }
  
  public final void dX()
  {
    this.HB = true;
    this.HA = true;
    dY();
    this.mPaint.setShader(this.Hv);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    if (localBitmap == null) {
      return;
    }
    dW();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.Hy, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.Hz, this.Hx, this.Hx, this.mPaint);
  }
  
  public int getAlpha()
  {
    return this.mPaint.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mPaint.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return this.HD;
  }
  
  public int getIntrinsicWidth()
  {
    return this.HC;
  }
  
  public int getOpacity()
  {
    if ((this.Hu != 119) || (this.HB)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (v(this.Hx)));
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.HB) {
      dY();
    }
    this.HA = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.graphics.drawable.b
 * JD-Core Version:    0.7.0.1
 */