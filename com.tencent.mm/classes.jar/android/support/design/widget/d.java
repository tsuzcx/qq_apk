package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.a.b;

class d
  extends Drawable
{
  final RectF fS = new RectF();
  float fT;
  int fU;
  int fV;
  int fW;
  int fX;
  private ColorStateList fY;
  private int fZ;
  boolean ga = true;
  float gb;
  final Paint mPaint = new Paint(1);
  final Rect mRect = new Rect();
  
  public d()
  {
    this.mPaint.setStyle(Paint.Style.STROKE);
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.fZ = paramColorStateList.getColorForState(getState(), this.fZ);
    }
    this.fY = paramColorStateList;
    this.ga = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.ga)
    {
      localObject1 = this.mPaint;
      Object localObject2 = this.mRect;
      copyBounds((Rect)localObject2);
      f1 = this.fT / ((Rect)localObject2).height();
      int i = b.n(this.fU, this.fZ);
      int j = b.n(this.fV, this.fZ);
      int k = b.n(b.p(this.fV, 0), this.fZ);
      int m = b.n(b.p(this.fX, 0), this.fZ);
      int n = b.n(this.fX, this.fZ);
      int i1 = b.n(this.fW, this.fZ);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.ga = false;
    }
    float f1 = this.mPaint.getStrokeWidth() / 2.0F;
    Object localObject1 = this.fS;
    copyBounds(this.mRect);
    ((RectF)localObject1).set(this.mRect);
    ((RectF)localObject1).left += f1;
    ((RectF)localObject1).top += f1;
    ((RectF)localObject1).right -= f1;
    ((RectF)localObject1).bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(this.gb, ((RectF)localObject1).centerX(), ((RectF)localObject1).centerY());
    paramCanvas.drawOval((RectF)localObject1, this.mPaint);
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    if (this.fT > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = Math.round(this.fT);
    paramRect.set(i, i, i, i);
    return true;
  }
  
  public boolean isStateful()
  {
    return ((this.fY != null) && (this.fY.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.ga = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.fY != null)
    {
      int i = this.fY.getColorForState(paramArrayOfInt, this.fZ);
      if (i != this.fZ)
      {
        this.ga = true;
        this.fZ = i;
      }
    }
    if (this.ga) {
      invalidateSelf();
    }
    return this.ga;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.d
 * JD-Core Version:    0.7.0.1
 */