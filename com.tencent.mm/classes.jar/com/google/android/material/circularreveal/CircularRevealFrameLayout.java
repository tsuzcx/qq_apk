package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularRevealFrameLayout
  extends FrameLayout
  implements c
{
  private final b bzV;
  
  public CircularRevealFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236475);
    this.bzV = new b(this);
    AppMethodBeat.o(236475);
  }
  
  public final void b(Canvas paramCanvas)
  {
    AppMethodBeat.i(236494);
    super.draw(paramCanvas);
    AppMethodBeat.o(236494);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236492);
    if (this.bzV != null)
    {
      this.bzV.draw(paramCanvas);
      AppMethodBeat.o(236492);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(236492);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.bzV.bAc;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(236486);
    int i = this.bzV.bAa.getColor();
    AppMethodBeat.o(236486);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(236483);
    c.d locald = this.bzV.getRevealInfo();
    AppMethodBeat.o(236483);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(236496);
    if (this.bzV != null)
    {
      bool = this.bzV.isOpaque();
      AppMethodBeat.o(236496);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236496);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236488);
    this.bzV.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(236488);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(236487);
    this.bzV.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(236487);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(236485);
    this.bzV.setRevealInfo(paramd);
    AppMethodBeat.o(236485);
  }
  
  public final void wM()
  {
    AppMethodBeat.i(236478);
    this.bzV.wM();
    AppMethodBeat.o(236478);
  }
  
  public final void wN()
  {
    AppMethodBeat.i(236481);
    this.bzV.wN();
    AppMethodBeat.o(236481);
  }
  
  public final boolean wO()
  {
    AppMethodBeat.i(236499);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236499);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealFrameLayout
 * JD-Core Version:    0.7.0.1
 */