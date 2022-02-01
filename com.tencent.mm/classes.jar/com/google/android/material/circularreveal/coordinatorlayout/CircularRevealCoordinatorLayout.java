package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
import com.google.android.material.circularreveal.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularRevealCoordinatorLayout
  extends CoordinatorLayout
  implements c
{
  private final b dsW;
  
  public CircularRevealCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209117);
    this.dsW = new b(this);
    AppMethodBeat.o(209117);
  }
  
  public final void Wl()
  {
    AppMethodBeat.i(209127);
    this.dsW.Wl();
    AppMethodBeat.o(209127);
  }
  
  public final void Wm()
  {
    AppMethodBeat.i(209136);
    this.dsW.Wm();
    AppMethodBeat.o(209136);
  }
  
  public final boolean Wn()
  {
    AppMethodBeat.i(209257);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209257);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209227);
    if (this.dsW != null)
    {
      this.dsW.draw(paramCanvas);
      AppMethodBeat.o(209227);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(209227);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(209238);
    super.draw(paramCanvas);
    AppMethodBeat.o(209238);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.dsW.dtd;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(209184);
    int i = this.dsW.dtb.getColor();
    AppMethodBeat.o(209184);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(209160);
    c.d locald = this.dsW.getRevealInfo();
    AppMethodBeat.o(209160);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(209247);
    if (this.dsW != null)
    {
      bool = this.dsW.isOpaque();
      AppMethodBeat.o(209247);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209247);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209214);
    this.dsW.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(209214);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(209170);
    this.dsW.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(209170);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(209148);
    this.dsW.setRevealInfo(paramd);
    AppMethodBeat.o(209148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */