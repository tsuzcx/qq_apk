package com.tencent.mm.plugin.appbrand.widget.music;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.luggage.j.b.a.a;
import com.tencent.luggage.j.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends Drawable
{
  private RectF avO;
  private Paint paint;
  private Drawable uMS;
  float uMT;
  private int uMU;
  
  public a(Drawable paramDrawable)
  {
    AppMethodBeat.i(133769);
    this.uMU = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.b.Edge_2A);
    this.uMS = paramDrawable;
    this.paint = new Paint(1);
    this.paint.setColor(MMApplicationContext.getResources().getColor(a.a.light_bg_color));
    AppMethodBeat.o(133769);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133770);
    Drawable localDrawable = this.uMS;
    Rect localRect = localDrawable.getBounds();
    int i = localRect.right;
    int j = localRect.left;
    int k = localRect.bottom;
    int m = localRect.top;
    float f1 = i - j;
    float f2 = k - m;
    i = paramCanvas.save();
    paramCanvas.rotate(this.uMT, f1 * 0.5F + localRect.left, localRect.top + f2 * 0.5F);
    paramCanvas.drawOval(this.avO, this.paint);
    localDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(133770);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.uMU;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.uMU;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(133774);
    if (this.uMS != null)
    {
      int i = this.uMS.getOpacity();
      AppMethodBeat.o(133774);
      return i;
    }
    AppMethodBeat.o(133774);
    return -2;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(133772);
    if (this.uMS != null) {
      this.uMS.setAlpha(paramInt);
    }
    this.paint.setAlpha(paramInt);
    AppMethodBeat.o(133772);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133771);
    if (this.uMS != null) {
      this.uMS.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.avO = new RectF(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(133771);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(133773);
    this.paint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(133773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.a
 * JD-Core Version:    0.7.0.1
 */