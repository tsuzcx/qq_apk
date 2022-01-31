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
import android.support.v4.graphics.b;

class d
  extends Drawable
{
  final RectF gM = new RectF();
  float gN;
  private int gO;
  private int gP;
  private int gQ;
  private int gR;
  private ColorStateList gS;
  private int gT;
  private boolean gU = true;
  float gV;
  final Paint mPaint = new Paint(1);
  final Rect mRect = new Rect();
  
  public d()
  {
    this.mPaint.setStyle(Paint.Style.STROKE);
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.gT = paramColorStateList.getColorForState(getState(), this.gT);
    }
    this.gS = paramColorStateList;
    this.gU = true;
    invalidateSelf();
  }
  
  final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.gO = paramInt1;
    this.gP = paramInt2;
    this.gQ = paramInt3;
    this.gR = paramInt4;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.gU)
    {
      localObject1 = this.mPaint;
      Object localObject2 = this.mRect;
      copyBounds((Rect)localObject2);
      f1 = this.gN / ((Rect)localObject2).height();
      int i = b.n(this.gO, this.gT);
      int j = b.n(this.gP, this.gT);
      int k = b.n(b.p(this.gP, 0), this.gT);
      int m = b.n(b.p(this.gR, 0), this.gT);
      int n = b.n(this.gR, this.gT);
      int i1 = b.n(this.gQ, this.gT);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.gU = false;
    }
    float f1 = this.mPaint.getStrokeWidth() / 2.0F;
    Object localObject1 = this.gM;
    copyBounds(this.mRect);
    ((RectF)localObject1).set(this.mRect);
    ((RectF)localObject1).left += f1;
    ((RectF)localObject1).top += f1;
    ((RectF)localObject1).right -= f1;
    ((RectF)localObject1).bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(this.gV, ((RectF)localObject1).centerX(), ((RectF)localObject1).centerY());
    paramCanvas.drawOval((RectF)localObject1, this.mPaint);
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    if (this.gN > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = Math.round(this.gN);
    paramRect.set(i, i, i, i);
    return true;
  }
  
  public boolean isStateful()
  {
    return ((this.gS != null) && (this.gS.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.gU = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.gS != null)
    {
      int i = this.gS.getColorForState(paramArrayOfInt, this.gT);
      if (i != this.gT)
      {
        this.gU = true;
        this.gT = i;
      }
    }
    if (this.gU) {
      invalidateSelf();
    }
    return this.gU;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  final void setBorderWidth(float paramFloat)
  {
    if (this.gN != paramFloat)
    {
      this.gN = paramFloat;
      this.mPaint.setStrokeWidth(1.3333F * paramFloat);
      this.gU = true;
      invalidateSelf();
    }
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