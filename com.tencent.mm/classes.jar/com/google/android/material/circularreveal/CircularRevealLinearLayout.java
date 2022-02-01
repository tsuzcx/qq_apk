package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularRevealLinearLayout
  extends LinearLayout
  implements c
{
  private final b dsW;
  
  public CircularRevealLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209104);
    this.dsW = new b(this);
    AppMethodBeat.o(209104);
  }
  
  public final void Wl()
  {
    AppMethodBeat.i(209110);
    this.dsW.Wl();
    AppMethodBeat.o(209110);
  }
  
  public final void Wm()
  {
    AppMethodBeat.i(209121);
    this.dsW.Wm();
    AppMethodBeat.o(209121);
  }
  
  public final boolean Wn()
  {
    AppMethodBeat.i(209229);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209229);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209195);
    if (this.dsW != null)
    {
      this.dsW.draw(paramCanvas);
      AppMethodBeat.o(209195);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(209195);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(209205);
    super.draw(paramCanvas);
    AppMethodBeat.o(209205);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.dsW.dtd;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(209153);
    int i = this.dsW.dtb.getColor();
    AppMethodBeat.o(209153);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(209130);
    c.d locald = this.dsW.getRevealInfo();
    AppMethodBeat.o(209130);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(209216);
    if (this.dsW != null)
    {
      bool = this.dsW.isOpaque();
      AppMethodBeat.o(209216);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209216);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209187);
    this.dsW.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(209187);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(209165);
    this.dsW.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(209165);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(209142);
    this.dsW.setRevealInfo(paramd);
    AppMethodBeat.o(209142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealLinearLayout
 * JD-Core Version:    0.7.0.1
 */