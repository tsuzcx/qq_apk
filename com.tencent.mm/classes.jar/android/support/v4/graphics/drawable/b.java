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
  private int Kj = 160;
  private int Kk = 119;
  public final BitmapShader Kl;
  private final Matrix Km = new Matrix();
  public float Kn;
  final Rect Ko = new Rect();
  private final RectF Kp = new RectF();
  private boolean Kq = true;
  public boolean Kr;
  public final Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  public final Paint mPaint = new Paint(3);
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.Kj = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.mBitmapWidth = this.mBitmap.getScaledWidth(this.Kj);
      this.mBitmapHeight = this.mBitmap.getScaledHeight(this.Kj);
      paramResources = this.mBitmap;
      paramBitmap = Shader.TileMode.CLAMP;
      this.Kl = new BitmapShader(paramResources, paramBitmap, paramBitmap);
      return;
    }
    this.mBitmapHeight = -1;
    this.mBitmapWidth = -1;
    this.Kl = null;
  }
  
  private void eA()
  {
    this.Kn = (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
  }
  
  public static boolean x(float paramFloat)
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
    ey();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.Ko, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.Kp, this.Kn, this.Kn, this.mPaint);
  }
  
  final void ey()
  {
    if (this.Kq)
    {
      if (!this.Kr) {
        break label220;
      }
      int i = Math.min(this.mBitmapWidth, this.mBitmapHeight);
      a(this.Kk, i, i, getBounds(), this.Ko);
      i = Math.min(this.Ko.width(), this.Ko.height());
      int j = Math.max(0, (this.Ko.width() - i) / 2);
      int k = Math.max(0, (this.Ko.height() - i) / 2);
      this.Ko.inset(j, k);
      this.Kn = (i * 0.5F);
    }
    for (;;)
    {
      this.Kp.set(this.Ko);
      if (this.Kl != null)
      {
        this.Km.setTranslate(this.Kp.left, this.Kp.top);
        this.Km.preScale(this.Kp.width() / this.mBitmap.getWidth(), this.Kp.height() / this.mBitmap.getHeight());
        this.Kl.setLocalMatrix(this.Km);
        this.mPaint.setShader(this.Kl);
      }
      this.Kq = false;
      return;
      label220:
      a(this.Kk, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.Ko);
    }
  }
  
  public final void ez()
  {
    this.Kr = true;
    this.Kq = true;
    eA();
    this.mPaint.setShader(this.Kl);
    invalidateSelf();
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
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmapWidth;
  }
  
  public int getOpacity()
  {
    if ((this.Kk != 119) || (this.Kr)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (x(this.Kn)));
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.Kr) {
      eA();
    }
    this.Kq = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.graphics.drawable.b
 * JD-Core Version:    0.7.0.1
 */