package com.tencent.mm.plugin.appbrand.widget.music;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends Drawable
{
  private Drawable jrT;
  private RectF jrU;
  float jrV;
  private int jrW;
  private Paint paint;
  
  public a(Drawable paramDrawable)
  {
    AppMethodBeat.i(141890);
    this.jrW = com.tencent.mm.cb.a.ap(ah.getContext(), 2131427587);
    this.jrT = paramDrawable;
    this.paint = new Paint(1);
    this.paint.setColor(ah.getResources().getColor(2131690204));
    AppMethodBeat.o(141890);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141891);
    Drawable localDrawable = this.jrT;
    Rect localRect = localDrawable.getBounds();
    int i = localRect.right;
    int j = localRect.left;
    int k = localRect.bottom;
    int m = localRect.top;
    float f1 = i - j;
    float f2 = k - m;
    i = paramCanvas.save();
    paramCanvas.rotate(this.jrV, f1 * 0.5F + localRect.left, localRect.top + f2 * 0.5F);
    paramCanvas.drawOval(this.jrU, this.paint);
    localDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(141891);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.jrW;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.jrW;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(141895);
    if (this.jrT != null)
    {
      int i = this.jrT.getOpacity();
      AppMethodBeat.o(141895);
      return i;
    }
    AppMethodBeat.o(141895);
    return -2;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(141893);
    if (this.jrT != null) {
      this.jrT.setAlpha(paramInt);
    }
    this.paint.setAlpha(paramInt);
    AppMethodBeat.o(141893);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141892);
    if (this.jrT != null) {
      this.jrT.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jrU = new RectF(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141892);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(141894);
    this.paint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(141894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.a
 * JD-Core Version:    0.7.0.1
 */