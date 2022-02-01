package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;

public class RoundRectDrawable
  extends Drawable
{
  public static final String TAG = "RoundRectDrawable";
  private final RoundRectDrawableState mBitmapState;
  private float mBorderWidth;
  final RectF mBounds = new RectF();
  private float mCornerRadius;
  private int mHeight;
  private int mTargetDensity = 160;
  private int mWidth;
  boolean reBuildCornerRadius = false;
  
  public RoundRectDrawable(Resources paramResources, RoundRectBitmap paramRoundRectBitmap)
  {
    this.mBitmapState = new RoundRectDrawableState(paramRoundRectBitmap);
    if (paramResources != null)
    {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      this.mBitmapState.mTargetDensity = this.mTargetDensity;
    }
    computeBitmapSize();
  }
  
  private RoundRectDrawable(RoundRectDrawableState paramRoundRectDrawableState, Resources paramResources)
  {
    this.mBitmapState = paramRoundRectDrawableState;
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramRoundRectDrawableState.mTargetDensity)
    {
      computeBitmapSize();
      return;
    }
  }
  
  private void computeBitmapSize()
  {
    this.mWidth = this.mBitmapState.mRoundRectBitmap.mBitmap.getScaledWidth(this.mTargetDensity);
    this.mHeight = this.mBitmapState.mRoundRectBitmap.mBitmap.getScaledHeight(this.mTargetDensity);
    int i = this.mBitmapState.mRoundRectBitmap.mBitmap.getDensity();
    this.mBorderWidth = (((int)(this.mBitmapState.mRoundRectBitmap.mBorderWidth * this.mTargetDensity) + (i >> 1)) / i);
  }
  
  public void draw(Canvas paramCanvas)
  {
    RectF localRectF1 = this.mBitmapState.mDrawableRect;
    RectF localRectF2 = this.mBitmapState.mBorderRect;
    Paint localPaint1 = this.mBitmapState.mBorderPaint;
    Paint localPaint2 = this.mBitmapState.mBitmapPaint;
    float f1;
    float f2;
    int i;
    if (this.reBuildCornerRadius)
    {
      f1 = 1.0F;
      if (Build.VERSION.SDK_INT >= 11)
      {
        f1 = localRectF1.width();
        f2 = localRectF1.height();
        i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        f1 = i / f1;
        f2 = j / f2;
        if (f1 >= f2) {
          break label183;
        }
      }
    }
    for (;;)
    {
      i = this.mBitmapState.mRoundRectBitmap.mBitmap.getDensity();
      this.mCornerRadius = ((this.mBitmapState.mRoundRectBitmap.mCornerRadius * this.mTargetDensity + (i >> 1)) / i / f1);
      this.reBuildCornerRadius = false;
      if (!this.mBitmapState.mOval) {
        break label197;
      }
      if (this.mBorderWidth <= 0.0F) {
        break;
      }
      paramCanvas.drawOval(localRectF1, localPaint2);
      paramCanvas.drawOval(localRectF2, localPaint1);
      return;
      label183:
      f1 = f2;
    }
    paramCanvas.drawOval(localRectF1, localPaint2);
    return;
    label197:
    if (this.mBorderWidth > 0.0F)
    {
      paramCanvas.drawRoundRect(localRectF1, Math.max(this.mCornerRadius, 0.0F), Math.max(this.mCornerRadius, 0.0F), localPaint2);
      paramCanvas.drawRoundRect(localRectF2, this.mCornerRadius, this.mCornerRadius, localPaint1);
      return;
    }
    paramCanvas.drawRoundRect(localRectF1, this.mCornerRadius, this.mCornerRadius, localPaint2);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.mBitmapState.mChangingConfigurations = getChangingConfigurations();
    return this.mBitmapState;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mBounds.set(paramRect);
    this.mBitmapState.updateShaderMatrix(this.mBounds);
    this.reBuildCornerRadius = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mBitmapState.mBitmapPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mBitmapState.mBitmapPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mBitmapState.mBorderPaint.setDither(paramBoolean);
    this.mBitmapState.mBitmapPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mBitmapState.mBitmapPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public RoundRectDrawable setOval(boolean paramBoolean)
  {
    this.mBitmapState.mOval = paramBoolean;
    return this;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeBitmapSize();
      invalidateSelf();
    }
  }
  
  static final class RoundRectDrawableState
    extends Drawable.ConstantState
  {
    final int mBitmapHeight;
    final Paint mBitmapPaint;
    final RectF mBitmapRect = new RectF();
    final BitmapShader mBitmapShader;
    final int mBitmapWidth;
    final Paint mBorderPaint;
    final RectF mBorderRect = new RectF();
    int mChangingConfigurations;
    final RectF mDrawableRect = new RectF();
    boolean mOval = false;
    final RoundRectBitmap mRoundRectBitmap;
    final Matrix mShaderMatrix = new Matrix();
    int mTargetDensity = 160;
    
    RoundRectDrawableState(RoundRectBitmap paramRoundRectBitmap)
    {
      this.mRoundRectBitmap = paramRoundRectBitmap;
      this.mBitmapWidth = this.mRoundRectBitmap.mBitmap.getWidth();
      this.mBitmapHeight = this.mRoundRectBitmap.mBitmap.getHeight();
      this.mBitmapRect.set(0.0F, 0.0F, this.mBitmapWidth, this.mBitmapHeight);
      this.mBitmapShader = new BitmapShader(this.mRoundRectBitmap.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
      this.mBitmapPaint = new Paint();
      this.mBitmapPaint.setStyle(Paint.Style.FILL);
      this.mBitmapPaint.setAntiAlias(true);
      this.mBitmapPaint.setShader(this.mBitmapShader);
      this.mBorderPaint = new Paint();
      this.mBorderPaint.setStyle(Paint.Style.STROKE);
      this.mBorderPaint.setAntiAlias(true);
      this.mBorderPaint.setColor(this.mRoundRectBitmap.mBoardColor);
      this.mBorderPaint.setStrokeWidth(this.mRoundRectBitmap.mBorderWidth);
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new RoundRectDrawable(this, null, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new RoundRectDrawable(this, paramResources, null);
    }
    
    void updateShaderMatrix(RectF paramRectF)
    {
      this.mBorderRect.set(this.mBitmapRect);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, paramRectF, Matrix.ScaleToFit.CENTER);
      this.mShaderMatrix.mapRect(this.mBorderRect);
      this.mBorderRect.inset(this.mRoundRectBitmap.mBorderWidth / 2.0F, this.mRoundRectBitmap.mBorderWidth / 2.0F);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
      this.mDrawableRect.set(this.mBorderRect);
      this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.image.RoundRectDrawable
 * JD-Core Version:    0.7.0.1
 */