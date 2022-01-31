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
  private int AY = 160;
  private int AZ = 119;
  public final BitmapShader Ba;
  private final Matrix Bb = new Matrix();
  final Rect Bc = new Rect();
  private final RectF Bd = new RectF();
  private boolean Be = true;
  public boolean Bf;
  private int Bg;
  private int Bh;
  public float kq;
  public final Bitmap mBitmap;
  public final Paint mPaint = new Paint(3);
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.AY = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.Bg = this.mBitmap.getScaledWidth(this.AY);
      this.Bh = this.mBitmap.getScaledHeight(this.AY);
      paramResources = this.mBitmap;
      paramBitmap = Shader.TileMode.CLAMP;
      this.Ba = new BitmapShader(paramResources, paramBitmap, paramBitmap);
      return;
    }
    this.Bh = -1;
    this.Bg = -1;
    this.Ba = null;
  }
  
  private void cT()
  {
    this.kq = (Math.min(this.Bh, this.Bg) / 2);
  }
  
  public static boolean r(float paramFloat)
  {
    return paramFloat > 0.05F;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    throw new UnsupportedOperationException();
  }
  
  final void cR()
  {
    if (this.Be)
    {
      if (!this.Bf) {
        break label220;
      }
      int i = Math.min(this.Bg, this.Bh);
      a(this.AZ, i, i, getBounds(), this.Bc);
      i = Math.min(this.Bc.width(), this.Bc.height());
      int j = Math.max(0, (this.Bc.width() - i) / 2);
      int k = Math.max(0, (this.Bc.height() - i) / 2);
      this.Bc.inset(j, k);
      this.kq = (i * 0.5F);
    }
    for (;;)
    {
      this.Bd.set(this.Bc);
      if (this.Ba != null)
      {
        this.Bb.setTranslate(this.Bd.left, this.Bd.top);
        this.Bb.preScale(this.Bd.width() / this.mBitmap.getWidth(), this.Bd.height() / this.mBitmap.getHeight());
        this.Ba.setLocalMatrix(this.Bb);
        this.mPaint.setShader(this.Ba);
      }
      this.Be = false;
      return;
      label220:
      a(this.AZ, this.Bg, this.Bh, getBounds(), this.Bc);
    }
  }
  
  public final void cS()
  {
    this.Bf = true;
    this.Be = true;
    cT();
    this.mPaint.setShader(this.Ba);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    if (localBitmap == null) {
      return;
    }
    cR();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.Bc, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.Bd, this.kq, this.kq, this.mPaint);
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
    return this.Bh;
  }
  
  public int getIntrinsicWidth()
  {
    return this.Bg;
  }
  
  public int getOpacity()
  {
    if ((this.AZ != 119) || (this.Bf)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (r(this.kq)));
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.Bf) {
      cT();
    }
    this.Be = true;
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