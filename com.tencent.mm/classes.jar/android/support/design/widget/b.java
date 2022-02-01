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
import android.graphics.drawable.Drawable.ConstantState;

public class b
  extends Drawable
{
  float borderWidth;
  final RectF fV = new RectF();
  final a mH = new a((byte)0);
  private int mI;
  private int mJ;
  private int mK;
  private int mL;
  private ColorStateList mM;
  private int mN;
  private boolean mO = true;
  final Paint paint = new Paint(1);
  final Rect rect = new Rect();
  float rotation;
  
  public b()
  {
    this.paint.setStyle(Paint.Style.STROKE);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mI = paramInt1;
    this.mJ = paramInt2;
    this.mK = paramInt3;
    this.mL = paramInt4;
  }
  
  public final void c(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.mN = paramColorStateList.getColorForState(getState(), this.mN);
    }
    this.mM = paramColorStateList;
    this.mO = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mO)
    {
      localObject1 = this.paint;
      Object localObject2 = this.rect;
      copyBounds((Rect)localObject2);
      f1 = this.borderWidth / ((Rect)localObject2).height();
      int i = android.support.v4.graphics.b.o(this.mI, this.mN);
      int j = android.support.v4.graphics.b.o(this.mJ, this.mN);
      int k = android.support.v4.graphics.b.o(android.support.v4.graphics.b.q(this.mJ, 0), this.mN);
      int m = android.support.v4.graphics.b.o(android.support.v4.graphics.b.q(this.mL, 0), this.mN);
      int n = android.support.v4.graphics.b.o(this.mL, this.mN);
      int i1 = android.support.v4.graphics.b.o(this.mK, this.mN);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.mO = false;
    }
    float f1 = this.paint.getStrokeWidth() / 2.0F;
    Object localObject1 = this.fV;
    copyBounds(this.rect);
    ((RectF)localObject1).set(this.rect);
    ((RectF)localObject1).left += f1;
    ((RectF)localObject1).top += f1;
    ((RectF)localObject1).right -= f1;
    ((RectF)localObject1).bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(this.rotation, ((RectF)localObject1).centerX(), ((RectF)localObject1).centerY());
    paramCanvas.drawOval((RectF)localObject1, this.paint);
    paramCanvas.restore();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mH;
  }
  
  public int getOpacity()
  {
    if (this.borderWidth > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = Math.round(this.borderWidth);
    paramRect.set(i, i, i, i);
    return true;
  }
  
  public boolean isStateful()
  {
    return ((this.mM != null) && (this.mM.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mO = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mM != null)
    {
      int i = this.mM.getColorForState(paramArrayOfInt, this.mN);
      if (i != this.mN)
      {
        this.mO = true;
        this.mN = i;
      }
    }
    if (this.mO) {
      invalidateSelf();
    }
    return this.mO;
  }
  
  public void setAlpha(int paramInt)
  {
    this.paint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public final void setBorderWidth(float paramFloat)
  {
    if (this.borderWidth != paramFloat)
    {
      this.borderWidth = paramFloat;
      this.paint.setStrokeWidth(1.3333F * paramFloat);
      this.mO = true;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  final class a
    extends Drawable.ConstantState
  {
    private a() {}
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      return b.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.b
 * JD-Core Version:    0.7.0.1
 */