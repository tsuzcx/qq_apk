package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularRevealGridLayout
  extends GridLayout
  implements c
{
  private final b dsW;
  
  public CircularRevealGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209069);
    this.dsW = new b(this);
    AppMethodBeat.o(209069);
  }
  
  public final void Wl()
  {
    AppMethodBeat.i(209073);
    this.dsW.Wl();
    AppMethodBeat.o(209073);
  }
  
  public final void Wm()
  {
    AppMethodBeat.i(209079);
    this.dsW.Wm();
    AppMethodBeat.o(209079);
  }
  
  public final boolean Wn()
  {
    AppMethodBeat.i(209156);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209156);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209132);
    if (this.dsW != null)
    {
      this.dsW.draw(paramCanvas);
      AppMethodBeat.o(209132);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(209132);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(209139);
    super.draw(paramCanvas);
    AppMethodBeat.o(209139);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.dsW.dtd;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(209099);
    int i = this.dsW.dtb.getColor();
    AppMethodBeat.o(209099);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(209087);
    c.d locald = this.dsW.getRevealInfo();
    AppMethodBeat.o(209087);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(209146);
    if (this.dsW != null)
    {
      bool = this.dsW.isOpaque();
      AppMethodBeat.o(209146);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209146);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209124);
    this.dsW.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(209124);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(209106);
    this.dsW.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(209106);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(209091);
    this.dsW.setRevealInfo(paramd);
    AppMethodBeat.o(209091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealGridLayout
 * JD-Core Version:    0.7.0.1
 */