package androidx.core.graphics.drawable;

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
  private float Rx;
  private int brb = 160;
  private final BitmapShader brc;
  private final Matrix brd = new Matrix();
  final Rect bre = new Rect();
  private final RectF brf = new RectF();
  private boolean brg = true;
  private boolean brh;
  public final Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  public final Paint mPaint = new Paint(3);
  private int tJ = 119;
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.brb = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.mBitmapWidth = this.mBitmap.getScaledWidth(this.brb);
      this.mBitmapHeight = this.mBitmap.getScaledHeight(this.brb);
      paramResources = this.mBitmap;
      paramBitmap = Shader.TileMode.CLAMP;
      this.brc = new BitmapShader(paramResources, paramBitmap, paramBitmap);
      return;
    }
    this.mBitmapHeight = -1;
    this.mBitmapWidth = -1;
    this.brc = null;
  }
  
  private void DM()
  {
    this.Rx = (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
  }
  
  private static boolean an(float paramFloat)
  {
    return paramFloat > 0.05F;
  }
  
  final void DK()
  {
    if (this.brg)
    {
      if (!this.brh) {
        break label220;
      }
      int i = Math.min(this.mBitmapWidth, this.mBitmapHeight);
      a(this.tJ, i, i, getBounds(), this.bre);
      i = Math.min(this.bre.width(), this.bre.height());
      int j = Math.max(0, (this.bre.width() - i) / 2);
      int k = Math.max(0, (this.bre.height() - i) / 2);
      this.bre.inset(j, k);
      this.Rx = (i * 0.5F);
    }
    for (;;)
    {
      this.brf.set(this.bre);
      if (this.brc != null)
      {
        this.brd.setTranslate(this.brf.left, this.brf.top);
        this.brd.preScale(this.brf.width() / this.mBitmap.getWidth(), this.brf.height() / this.mBitmap.getHeight());
        this.brc.setLocalMatrix(this.brd);
        this.mPaint.setShader(this.brc);
      }
      this.brg = false;
      return;
      label220:
      a(this.tJ, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.bre);
    }
  }
  
  public final void DL()
  {
    this.brh = true;
    this.brg = true;
    DM();
    this.mPaint.setShader(this.brc);
    invalidateSelf();
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
    DK();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.bre, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.brf, this.Rx, this.Rx, this.mPaint);
  }
  
  public int getAlpha()
  {
    return this.mPaint.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mPaint.getColorFilter();
  }
  
  public final float getCornerRadius()
  {
    return this.Rx;
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
    if ((this.tJ != 119) || (this.brh)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (an(this.Rx)));
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.brh) {
      DM();
    }
    this.brg = true;
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
    if (this.Rx == paramFloat) {
      return;
    }
    this.brh = false;
    if (an(paramFloat)) {
      this.mPaint.setShader(this.brc);
    }
    for (;;)
    {
      this.Rx = paramFloat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.drawable.b
 * JD-Core Version:    0.7.0.1
 */