package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
import com.google.android.material.circularreveal.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularRevealCardView
  extends CardView
  implements c
{
  private final b bzV;
  
  public CircularRevealCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236926);
    this.bzV = new b(this);
    AppMethodBeat.o(236926);
  }
  
  public final void b(Canvas paramCanvas)
  {
    AppMethodBeat.i(236938);
    super.draw(paramCanvas);
    AppMethodBeat.o(236938);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236937);
    if (this.bzV != null)
    {
      this.bzV.draw(paramCanvas);
      AppMethodBeat.o(236937);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(236937);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.bzV.bAc;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(236934);
    int i = this.bzV.bAa.getColor();
    AppMethodBeat.o(236934);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(236930);
    c.d locald = this.bzV.getRevealInfo();
    AppMethodBeat.o(236930);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(236939);
    if (this.bzV != null)
    {
      bool = this.bzV.isOpaque();
      AppMethodBeat.o(236939);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236939);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236936);
    this.bzV.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(236936);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(236932);
    this.bzV.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(236932);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(236929);
    this.bzV.setRevealInfo(paramd);
    AppMethodBeat.o(236929);
  }
  
  public final void wM()
  {
    AppMethodBeat.i(236927);
    this.bzV.wM();
    AppMethodBeat.o(236927);
  }
  
  public final void wN()
  {
    AppMethodBeat.i(236928);
    this.bzV.wN();
    AppMethodBeat.o(236928);
  }
  
  public final boolean wO()
  {
    AppMethodBeat.i(236940);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(236940);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.cardview.CircularRevealCardView
 * JD-Core Version:    0.7.0.1
 */