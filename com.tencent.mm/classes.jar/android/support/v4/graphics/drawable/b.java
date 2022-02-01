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
  private int Ir = 160;
  private int Is = 119;
  public final BitmapShader It;
  private final Matrix Iu = new Matrix();
  public float Iv;
  final Rect Iw = new Rect();
  private final RectF Ix = new RectF();
  private boolean Iy = true;
  public boolean Iz;
  public final Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  public final Paint mPaint = new Paint(3);
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.Ir = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.mBitmapWidth = this.mBitmap.getScaledWidth(this.Ir);
      this.mBitmapHeight = this.mBitmap.getScaledHeight(this.Ir);
      paramResources = this.mBitmap;
      paramBitmap = Shader.TileMode.CLAMP;
      this.It = new BitmapShader(paramResources, paramBitmap, paramBitmap);
      return;
    }
    this.mBitmapHeight = -1;
    this.mBitmapWidth = -1;
    this.It = null;
  }
  
  private void ej()
  {
    this.Iv = (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
  }
  
  public static boolean z(float paramFloat)
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
    eh();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.Iw, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.Ix, this.Iv, this.Iv, this.mPaint);
  }
  
  final void eh()
  {
    if (this.Iy)
    {
      if (!this.Iz) {
        break label220;
      }
      int i = Math.min(this.mBitmapWidth, this.mBitmapHeight);
      a(this.Is, i, i, getBounds(), this.Iw);
      i = Math.min(this.Iw.width(), this.Iw.height());
      int j = Math.max(0, (this.Iw.width() - i) / 2);
      int k = Math.max(0, (this.Iw.height() - i) / 2);
      this.Iw.inset(j, k);
      this.Iv = (i * 0.5F);
    }
    for (;;)
    {
      this.Ix.set(this.Iw);
      if (this.It != null)
      {
        this.Iu.setTranslate(this.Ix.left, this.Ix.top);
        this.Iu.preScale(this.Ix.width() / this.mBitmap.getWidth(), this.Ix.height() / this.mBitmap.getHeight());
        this.It.setLocalMatrix(this.Iu);
        this.mPaint.setShader(this.It);
      }
      this.Iy = false;
      return;
      label220:
      a(this.Is, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.Iw);
    }
  }
  
  public final void ei()
  {
    this.Iz = true;
    this.Iy = true;
    ej();
    this.mPaint.setShader(this.It);
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
    if ((this.Is != 119) || (this.Iz)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (z(this.Iv)));
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.Iz) {
      ej();
    }
    this.Iy = true;
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