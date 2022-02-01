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
  private final b bzV;
  
  public CircularRevealGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236542);
    this.bzV = new b(this);
    AppMethodBeat.o(236542);
  }
  
  public final void b(Canvas paramCanvas)
  {
    AppMethodBeat.i(236562);
    super.draw(paramCanvas);
    AppMethodBeat.o(236562);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236558);
    if (this.bzV != null)
    {
      this.bzV.draw(paramCanvas);
      AppMethodBeat.o(236558);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(236558);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.bzV.bAc;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(236551);
    int i = this.bzV.bAa.getColor();
    AppMethodBeat.o(236551);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(236548);
    c.d locald = this.bzV.getRevealInfo();
    AppMethodBeat.o(236548);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(236564);
    if (this.bzV != null)
    {
      bool = this.bzV.isOpaque();
      AppMethodBeat.o(236564);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236564);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236555);
    this.bzV.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(236555);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(236552);
    this.bzV.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(236552);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(236549);
    this.bzV.setRevealInfo(paramd);
    AppMethodBeat.o(236549);
  }
  
  public final void wM()
  {
    AppMethodBeat.i(236544);
    this.bzV.wM();
    AppMethodBeat.o(236544);
  }
  
  public final void wN()
  {
    AppMethodBeat.i(236547);
    this.bzV.wN();
    AppMethodBeat.o(236547);
  }
  
  public final boolean wO()
  {
    AppMethodBeat.i(236565);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236565);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealGridLayout
 * JD-Core Version:    0.7.0.1
 */