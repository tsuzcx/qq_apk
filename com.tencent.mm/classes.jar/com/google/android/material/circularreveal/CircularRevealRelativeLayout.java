package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularRevealRelativeLayout
  extends RelativeLayout
  implements c
{
  private final b dsW;
  
  public CircularRevealRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209072);
    this.dsW = new b(this);
    AppMethodBeat.o(209072);
  }
  
  public final void Wl()
  {
    AppMethodBeat.i(209078);
    this.dsW.Wl();
    AppMethodBeat.o(209078);
  }
  
  public final void Wm()
  {
    AppMethodBeat.i(209084);
    this.dsW.Wm();
    AppMethodBeat.o(209084);
  }
  
  public final boolean Wn()
  {
    AppMethodBeat.i(209171);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209171);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209144);
    if (this.dsW != null)
    {
      this.dsW.draw(paramCanvas);
      AppMethodBeat.o(209144);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(209144);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(209154);
    super.draw(paramCanvas);
    AppMethodBeat.o(209154);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.dsW.dtd;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(209107);
    int i = this.dsW.dtb.getColor();
    AppMethodBeat.o(209107);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(209089);
    c.d locald = this.dsW.getRevealInfo();
    AppMethodBeat.o(209089);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(209163);
    if (this.dsW != null)
    {
      bool = this.dsW.isOpaque();
      AppMethodBeat.o(209163);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209163);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209137);
    this.dsW.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(209137);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(209120);
    this.dsW.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(209120);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(209098);
    this.dsW.setRevealInfo(paramd);
    AppMethodBeat.o(209098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealRelativeLayout
 * JD-Core Version:    0.7.0.1
 */