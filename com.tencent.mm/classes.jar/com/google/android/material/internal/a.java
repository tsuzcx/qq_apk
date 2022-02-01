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
  final RectF avO;
  float borderWidth;
  final a dul;
  private int dum;
  private int dun;
  private int duo;
  private int dup;
  private ColorStateList duq;
  private int dur;
  private boolean dus;
  final Paint paint;
  final Rect rect;
  public float rotation;
  
  public a()
  {
    AppMethodBeat.i(209290);
    this.rect = new Rect();
    this.avO = new RectF();
    this.dul = new a((byte)0);
    this.dus = true;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(209290);
  }
  
  public final void d(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209364);
    if (paramColorStateList != null) {
      this.dur = paramColorStateList.getColorForState(getState(), this.dur);
    }
    this.duq = paramColorStateList;
    this.dus = true;
    invalidateSelf();
    AppMethodBeat.o(209364);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209334);
    if (this.dus)
    {
      localObject1 = this.paint;
      Object localObject2 = this.rect;
      copyBounds((Rect)localObject2);
      f1 = this.borderWidth / ((Rect)localObject2).height();
      int i = b.av(this.dum, this.dur);
      int j = b.av(this.dun, this.dur);
      int k = b.av(b.ax(this.dun, 0), this.dur);
      int m = b.av(b.ax(this.dup, 0), this.dur);
      int n = b.av(this.dup, this.dur);
      int i1 = b.av(this.duo, this.dur);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.dus = false;
    }
    float f1 = this.paint.getStrokeWidth() / 2.0F;
    Object localObject1 = this.avO;
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
    AppMethodBeat.o(209334);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.dul;
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
    AppMethodBeat.i(209343);
    int i = Math.round(this.borderWidth);
    paramRect.set(i, i, i, i);
    AppMethodBeat.o(209343);
    return true;
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(209400);
    if (((this.duq != null) && (this.duq.isStateful())) || (super.isStateful()))
    {
      AppMethodBeat.o(209400);
      return true;
    }
    AppMethodBeat.o(209400);
    return false;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.dus = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209409);
    if (this.duq != null)
    {
      int i = this.duq.getColorForState(paramArrayOfInt, this.dur);
      if (i != this.dur)
      {
        this.dus = true;
        this.dur = i;
      }
    }
    if (this.dus) {
      invalidateSelf();
    }
    boolean bool = this.dus;
    AppMethodBeat.o(209409);
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(209352);
    this.paint.setAlpha(paramInt);
    invalidateSelf();
    AppMethodBeat.o(209352);
  }
  
  public final void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(209322);
    if (this.borderWidth != paramFloat)
    {
      this.borderWidth = paramFloat;
      this.paint.setStrokeWidth(1.3333F * paramFloat);
      this.dus = true;
      invalidateSelf();
    }
    AppMethodBeat.o(209322);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(209371);
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(209371);
  }
  
  public final void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dum = paramInt1;
    this.dun = paramInt2;
    this.duo = paramInt3;
    this.dup = paramInt4;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.a
 * JD-Core Version:    0.7.0.1
 */