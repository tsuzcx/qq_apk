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
  private final b bzV;
  
  public CircularRevealLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236689);
    this.bzV = new b(this);
    AppMethodBeat.o(236689);
  }
  
  public final void b(Canvas paramCanvas)
  {
    AppMethodBeat.i(236718);
    super.draw(paramCanvas);
    AppMethodBeat.o(236718);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236715);
    if (this.bzV != null)
    {
      this.bzV.draw(paramCanvas);
      AppMethodBeat.o(236715);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(236715);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.bzV.bAc;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(236705);
    int i = this.bzV.bAa.getColor();
    AppMethodBeat.o(236705);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(236698);
    c.d locald = this.bzV.getRevealInfo();
    AppMethodBeat.o(236698);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(236722);
    if (this.bzV != null)
    {
      bool = this.bzV.isOpaque();
      AppMethodBeat.o(236722);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236722);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236712);
    this.bzV.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(236712);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(236709);
    this.bzV.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(236709);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(236702);
    this.bzV.setRevealInfo(paramd);
    AppMethodBeat.o(236702);
  }
  
  public final void wM()
  {
    AppMethodBeat.i(236691);
    this.bzV.wM();
    AppMethodBeat.o(236691);
  }
  
  public final void wN()
  {
    AppMethodBeat.i(236694);
    this.bzV.wN();
    AppMethodBeat.o(236694);
  }
  
  public final boolean wO()
  {
    AppMethodBeat.i(236723);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236723);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealLinearLayout
 * JD-Core Version:    0.7.0.1
 */