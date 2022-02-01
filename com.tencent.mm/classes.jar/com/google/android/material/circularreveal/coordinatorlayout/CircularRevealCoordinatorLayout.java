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
  private final b bzV;
  
  public CircularRevealCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236956);
    this.bzV = new b(this);
    AppMethodBeat.o(236956);
  }
  
  public final void b(Canvas paramCanvas)
  {
    AppMethodBeat.i(236971);
    super.draw(paramCanvas);
    AppMethodBeat.o(236971);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236970);
    if (this.bzV != null)
    {
      this.bzV.draw(paramCanvas);
      AppMethodBeat.o(236970);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(236970);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.bzV.bAc;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(236963);
    int i = this.bzV.bAa.getColor();
    AppMethodBeat.o(236963);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(236961);
    c.d locald = this.bzV.getRevealInfo();
    AppMethodBeat.o(236961);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(236972);
    if (this.bzV != null)
    {
      bool = this.bzV.isOpaque();
      AppMethodBeat.o(236972);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236972);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236967);
    this.bzV.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(236967);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(236962);
    this.bzV.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(236962);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(236960);
    this.bzV.setRevealInfo(paramd);
    AppMethodBeat.o(236960);
  }
  
  public final void wM()
  {
    AppMethodBeat.i(236957);
    this.bzV.wM();
    AppMethodBeat.o(236957);
  }
  
  public final void wN()
  {
    AppMethodBeat.i(236959);
    this.bzV.wN();
    AppMethodBeat.o(236959);
  }
  
  public final boolean wO()
  {
    AppMethodBeat.i(236974);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236974);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */