package com.tencent.mm.plugin.appbrand.widget.music;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  extends Drawable
{
  private RectF eU;
  private Drawable mhK;
  float mhL;
  private int mhM;
  private Paint paint;
  
  public a(Drawable paramDrawable)
  {
    AppMethodBeat.i(133769);
    this.mhM = com.tencent.mm.cd.a.ap(aj.getContext(), 2131165289);
    this.mhK = paramDrawable;
    this.paint = new Paint(1);
    this.paint.setColor(aj.getResources().getColor(2131100537));
    AppMethodBeat.o(133769);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133770);
    Drawable localDrawable = this.mhK;
    Rect localRect = localDrawable.getBounds();
    int i = localRect.right;
    int j = localRect.left;
    int k = localRect.bottom;
    int m = localRect.top;
    float f1 = i - j;
    float f2 = k - m;
    i = paramCanvas.save();
    paramCanvas.rotate(this.mhL, f1 * 0.5F + localRect.left, localRect.top + f2 * 0.5F);
    paramCanvas.drawOval(this.eU, this.paint);
    localDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(133770);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.mhM;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.mhM;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(133774);
    if (this.mhK != null)
    {
      int i = this.mhK.getOpacity();
      AppMethodBeat.o(133774);
      return i;
    }
    AppMethodBeat.o(133774);
    return -2;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(133772);
    if (this.mhK != null) {
      this.mhK.setAlpha(paramInt);
    }
    this.paint.setAlpha(paramInt);
    AppMethodBeat.o(133772);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133771);
    if (this.mhK != null) {
      this.mhK.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.eU = new RectF(paramInt1, paramInt2, paramInt3, paramInt4);
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