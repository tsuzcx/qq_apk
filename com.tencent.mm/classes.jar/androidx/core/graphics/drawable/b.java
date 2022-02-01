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
  private int KS = 160;
  private final BitmapShader KT;
  private final Matrix KU = new Matrix();
  final Rect KV = new Rect();
  private final RectF KW = new RectF();
  private boolean KX = true;
  private boolean KY;
  public final Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private final Paint mPaint = new Paint(3);
  private int sK = 119;
  private float zj;
  
  b(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.KS = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.mBitmapWidth = this.mBitmap.getScaledWidth(this.KS);
      this.mBitmapHeight = this.mBitmap.getScaledHeight(this.KS);
      paramResources = this.mBitmap;
      paramBitmap = Shader.TileMode.CLAMP;
      this.KT = new BitmapShader(paramResources, paramBitmap, paramBitmap);
      return;
    }
    this.mBitmapHeight = -1;
    this.mBitmapWidth = -1;
    this.KT = null;
  }
  
  private void gC()
  {
    this.zj = (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
  }
  
  private static boolean h(float paramFloat)
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
    gA();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.KV, this.mPaint);
      return;
    }
    paramCanvas.drawRoundRect(this.KW, this.zj, this.zj, this.mPaint);
  }
  
  final void gA()
  {
    if (this.KX)
    {
      if (!this.KY) {
        break label220;
      }
      int i = Math.min(this.mBitmapWidth, this.mBitmapHeight);
      a(this.sK, i, i, getBounds(), this.KV);
      i = Math.min(this.KV.width(), this.KV.height());
      int j = Math.max(0, (this.KV.width() - i) / 2);
      int k = Math.max(0, (this.KV.height() - i) / 2);
      this.KV.inset(j, k);
      this.zj = (i * 0.5F);
    }
    for (;;)
    {
      this.KW.set(this.KV);
      if (this.KT != null)
      {
        this.KU.setTranslate(this.KW.left, this.KW.top);
        this.KU.preScale(this.KW.width() / this.mBitmap.getWidth(), this.KW.height() / this.mBitmap.getHeight());
        this.KT.setLocalMatrix(this.KU);
        this.mPaint.setShader(this.KT);
      }
      this.KX = false;
      return;
      label220:
      a(this.sK, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.KV);
    }
  }
  
  public final void gB()
  {
    this.KY = true;
    this.KX = true;
    gC();
    this.mPaint.setShader(this.KT);
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
  
  public final float getCornerRadius()
  {
    return this.zj;
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
    if ((this.sK != 119) || (this.KY)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mPaint.getAlpha() < 255) || (h(this.zj)));
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.KY) {
      gC();
    }
    this.KX = true;
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
    if (this.zj == paramFloat) {
      return;
    }
    this.KY = false;
    if (h(paramFloat)) {
      this.mPaint.setShader(this.KT);
    }
    for (;;)
    {
      this.zj = paramFloat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.drawable.b
 * JD-Core Version:    0.7.0.1
 */