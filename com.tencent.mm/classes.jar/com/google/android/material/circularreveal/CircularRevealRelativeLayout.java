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
  private final b bzV;
  
  public CircularRevealRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236776);
    this.bzV = new b(this);
    AppMethodBeat.o(236776);
  }
  
  public final void b(Canvas paramCanvas)
  {
    AppMethodBeat.i(236790);
    super.draw(paramCanvas);
    AppMethodBeat.o(236790);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236789);
    if (this.bzV != null)
    {
      this.bzV.draw(paramCanvas);
      AppMethodBeat.o(236789);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(236789);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.bzV.bAc;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(236783);
    int i = this.bzV.bAa.getColor();
    AppMethodBeat.o(236783);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(236780);
    c.d locald = this.bzV.getRevealInfo();
    AppMethodBeat.o(236780);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(236792);
    if (this.bzV != null)
    {
      bool = this.bzV.isOpaque();
      AppMethodBeat.o(236792);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236792);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236787);
    this.bzV.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(236787);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(236785);
    this.bzV.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(236785);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(236781);
    this.bzV.setRevealInfo(paramd);
    AppMethodBeat.o(236781);
  }
  
  public final void wM()
  {
    AppMethodBeat.i(236777);
    this.bzV.wM();
    AppMethodBeat.o(236777);
  }
  
  public final void wN()
  {
    AppMethodBeat.i(236778);
    this.bzV.wN();
    AppMethodBeat.o(236778);
  }
  
  public final boolean wO()
  {
    AppMethodBeat.i(236795);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236795);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealRelativeLayout
 * JD-Core Version:    0.7.0.1
 */