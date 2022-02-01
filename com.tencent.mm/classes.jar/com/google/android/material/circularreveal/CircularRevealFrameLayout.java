package com.google.android.material.circularreveal;

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
  private final b dsW;
  
  public CircularRevealFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209102);
    this.dsW = new b(this);
    AppMethodBeat.o(209102);
  }
  
  public final void Wl()
  {
    AppMethodBeat.i(209113);
    this.dsW.Wl();
    AppMethodBeat.o(209113);
  }
  
  public final void Wm()
  {
    AppMethodBeat.i(209123);
    this.dsW.Wm();
    AppMethodBeat.o(209123);
  }
  
  public final boolean Wn()
  {
    AppMethodBeat.i(209240);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209240);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209207);
    if (this.dsW != null)
    {
      this.dsW.draw(paramCanvas);
      AppMethodBeat.o(209207);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(209207);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(209224);
    super.draw(paramCanvas);
    AppMethodBeat.o(209224);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.dsW.dtd;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(209161);
    int i = this.dsW.dtb.getColor();
    AppMethodBeat.o(209161);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(209135);
    c.d locald = this.dsW.getRevealInfo();
    AppMethodBeat.o(209135);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(209233);
    if (this.dsW != null)
    {
      bool = this.dsW.isOpaque();
      AppMethodBeat.o(209233);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209233);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209196);
    this.dsW.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(209196);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(209176);
    this.dsW.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(209176);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(209150);
    this.dsW.setRevealInfo(paramd);
    AppMethodBeat.o(209150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealFrameLayout
 * JD-Core Version:    0.7.0.1
 */