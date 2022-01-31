package android.support.v4.a.a;

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
  private int Am = 160;
  private int An = 119;
  public final BitmapShader Ao;
  private final Matrix Ap = new Matrix();
  final Rect Aq = new Rect();
  private final RectF Ar = new RectF();
  private boolean As = true;
  public boolean At;
  private int Au;
  private int Av;
  public float js;
  public final Bitmap mBitmap;
  public final Paint mPaint = new Paint(3);
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.Am = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.Au = this.mBitmap.getScaledWidth(this.Am);
      this.Av = this.mBitmap.getScaledHeight(this.Am);
      this.Ao = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
    this.Av = -1;
    this.Au = -1;
    this.Ao = null;
  }
  
  private void cq()
  {
    this.js = (Math.min(this.Av, this.Au) / 2);
  }
  
  public static boolean q(float paramFloat)
  {
    return paramFloat > 0.05F;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    throw new UnsupportedOperationException();
  }
  
  final void co()
  {
    if (this.As)
    {
      if (!this.At) {
        break label220;
      }
      int i = Math.min(this.Au, this.Av);
      a(this.An, i, i, getBounds(), this.Aq);
      i = Math.min(this.Aq.width(), this.Aq.height());
      int j = Math.max(0, (this.Aq.width() - i) / 2);
      int k = Math.max(0, (this.Aq.height() - i) / 2);
      this.Aq.inset(j, k);
      this.js = (i * 0.5F);
    }
    for (;;)
    {
      this.Ar.set(this.Aq);
      if (this.Ao != null)
      {
        this.Ap.setTranslate(this.Ar.left, this.Ar.top);
        this.Ap.preScale(this.Ar.width() / this.mBitmap.getWidth(), this.Ar.height() / this.mBitmap.getHeight());
        this.Ao.setLocalMatrix(this.Ap);
        this.mPaint.setShader(this.Ao);
      }
      this.As = false;
      return;
      label220:
      a(this.An, this.Au, this.Av, getBounds(), this.Aq);
    }
  }
  
  public final void cp()
  {
    this.At = true;
    this.As = true;
    cq();
    this.mPaint.setShader(this.Ao);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    if (localBitmap == null) {
      return;
    }
    co();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.Aq, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.Ar, this.js, this.js, this.mPaint);
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
    return this.Av;
  }
  
  public int getIntrinsicWidth()
  {
    return this.Au;
  }
  
  public int getOpacity()
  {
    if ((this.An != 119) || (this.At)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (q(this.js)));
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.At) {
      cq();
    }
    this.As = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.a.a.b
 * JD-Core Version:    0.7.0.1
 */