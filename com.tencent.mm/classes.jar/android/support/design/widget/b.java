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
  final RectF hO = new RectF();
  final a oF = new a((byte)0);
  private int oG;
  private int oH;
  private int oI;
  private int oJ;
  private ColorStateList oK;
  private int oL;
  private boolean oM = true;
  final Paint paint = new Paint(1);
  final Rect rect = new Rect();
  float rotation;
  
  public b()
  {
    this.paint.setStyle(Paint.Style.STROKE);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.oG = paramInt1;
    this.oH = paramInt2;
    this.oI = paramInt3;
    this.oJ = paramInt4;
  }
  
  public final void c(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.oL = paramColorStateList.getColorForState(getState(), this.oL);
    }
    this.oK = paramColorStateList;
    this.oM = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.oM)
    {
      localObject1 = this.paint;
      Object localObject2 = this.rect;
      copyBounds((Rect)localObject2);
      f1 = this.borderWidth / ((Rect)localObject2).height();
      int i = android.support.v4.graphics.b.v(this.oG, this.oL);
      int j = android.support.v4.graphics.b.v(this.oH, this.oL);
      int k = android.support.v4.graphics.b.v(android.support.v4.graphics.b.x(this.oH, 0), this.oL);
      int m = android.support.v4.graphics.b.v(android.support.v4.graphics.b.x(this.oJ, 0), this.oL);
      int n = android.support.v4.graphics.b.v(this.oJ, this.oL);
      int i1 = android.support.v4.graphics.b.v(this.oI, this.oL);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.oM = false;
    }
    float f1 = this.paint.getStrokeWidth() / 2.0F;
    Object localObject1 = this.hO;
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
    return this.oF;
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
    return ((this.oK != null) && (this.oK.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.oM = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.oK != null)
    {
      int i = this.oK.getColorForState(paramArrayOfInt, this.oL);
      if (i != this.oL)
      {
        this.oM = true;
        this.oL = i;
      }
    }
    if (this.oM) {
      invalidateSelf();
    }
    return this.oM;
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
      this.oM = true;
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