package com.google.android.material.internal;

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
import androidx.core.graphics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  extends Drawable
{
  final a bBj;
  private int bBk;
  private int bBl;
  private int bBm;
  private int bBn;
  private ColorStateList bBo;
  private int bBp;
  private boolean bBq;
  float borderWidth;
  final Rect byG;
  final RectF byj;
  final Paint paint;
  public float rotation;
  
  public a()
  {
    AppMethodBeat.i(237540);
    this.byG = new Rect();
    this.byj = new RectF();
    this.bBj = new a((byte)0);
    this.bBq = true;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(237540);
  }
  
  public final void d(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237555);
    if (paramColorStateList != null) {
      this.bBp = paramColorStateList.getColorForState(getState(), this.bBp);
    }
    this.bBo = paramColorStateList;
    this.bBq = true;
    invalidateSelf();
    AppMethodBeat.o(237555);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237548);
    if (this.bBq)
    {
      localObject1 = this.paint;
      Object localObject2 = this.byG;
      copyBounds((Rect)localObject2);
      f1 = this.borderWidth / ((Rect)localObject2).height();
      int i = b.A(this.bBk, this.bBp);
      int j = b.A(this.bBl, this.bBp);
      int k = b.A(b.C(this.bBl, 0), this.bBp);
      int m = b.A(b.C(this.bBn, 0), this.bBp);
      int n = b.A(this.bBn, this.bBp);
      int i1 = b.A(this.bBm, this.bBp);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.bBq = false;
    }
    float f1 = this.paint.getStrokeWidth() / 2.0F;
    Object localObject1 = this.byj;
    copyBounds(this.byG);
    ((RectF)localObject1).set(this.byG);
    ((RectF)localObject1).left += f1;
    ((RectF)localObject1).top += f1;
    ((RectF)localObject1).right -= f1;
    ((RectF)localObject1).bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(this.rotation, ((RectF)localObject1).centerX(), ((RectF)localObject1).centerY());
    paramCanvas.drawOval((RectF)localObject1, this.paint);
    paramCanvas.restore();
    AppMethodBeat.o(237548);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.bBj;
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
    AppMethodBeat.i(237551);
    int i = Math.round(this.borderWidth);
    paramRect.set(i, i, i, i);
    AppMethodBeat.o(237551);
    return true;
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(237560);
    if (((this.bBo != null) && (this.bBo.isStateful())) || (super.isStateful()))
    {
      AppMethodBeat.o(237560);
      return true;
    }
    AppMethodBeat.o(237560);
    return false;
  }
  
  public final void o(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bBk = paramInt1;
    this.bBl = paramInt2;
    this.bBm = paramInt3;
    this.bBn = paramInt4;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.bBq = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237563);
    if (this.bBo != null)
    {
      int i = this.bBo.getColorForState(paramArrayOfInt, this.bBp);
      if (i != this.bBp)
      {
        this.bBq = true;
        this.bBp = i;
      }
    }
    if (this.bBq) {
      invalidateSelf();
    }
    boolean bool = this.bBq;
    AppMethodBeat.o(237563);
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(237553);
    this.paint.setAlpha(paramInt);
    invalidateSelf();
    AppMethodBeat.o(237553);
  }
  
  public final void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(237544);
    if (this.borderWidth != paramFloat)
    {
      this.borderWidth = paramFloat;
      this.paint.setStrokeWidth(1.3333F * paramFloat);
      this.bBq = true;
      invalidateSelf();
    }
    AppMethodBeat.o(237544);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(237557);
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(237557);
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
      return a.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.internal.a
 * JD-Core Version:    0.7.0.1
 */