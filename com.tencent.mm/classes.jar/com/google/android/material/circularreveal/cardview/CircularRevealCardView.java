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
  private final b dsW;
  
  public CircularRevealCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209147);
    this.dsW = new b(this);
    AppMethodBeat.o(209147);
  }
  
  public final void Wl()
  {
    AppMethodBeat.i(209157);
    this.dsW.Wl();
    AppMethodBeat.o(209157);
  }
  
  public final void Wm()
  {
    AppMethodBeat.i(209166);
    this.dsW.Wm();
    AppMethodBeat.o(209166);
  }
  
  public final boolean Wn()
  {
    AppMethodBeat.i(209256);
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209256);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209234);
    if (this.dsW != null)
    {
      this.dsW.draw(paramCanvas);
      AppMethodBeat.o(209234);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(209234);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(209241);
    super.draw(paramCanvas);
    AppMethodBeat.o(209241);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.dsW.dtd;
  }
  
  public int getCircularRevealScrimColor()
  {
    AppMethodBeat.i(209198);
    int i = this.dsW.dtb.getColor();
    AppMethodBeat.o(209198);
    return i;
  }
  
  public c.d getRevealInfo()
  {
    AppMethodBeat.i(209182);
    c.d locald = this.dsW.getRevealInfo();
    AppMethodBeat.o(209182);
    return locald;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(209249);
    if (this.dsW != null)
    {
      bool = this.dsW.isOpaque();
      AppMethodBeat.o(209249);
      return bool;
    }
    boolean bool = super.isOpaque();
    AppMethodBeat.o(209249);
    return bool;
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209226);
    this.dsW.setCircularRevealOverlayDrawable(paramDrawable);
    AppMethodBeat.o(209226);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(209190);
    this.dsW.setCircularRevealScrimColor(paramInt);
    AppMethodBeat.o(209190);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(209173);
    this.dsW.setRevealInfo(paramd);
    AppMethodBeat.o(209173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.cardview.CircularRevealCardView
 * JD-Core Version:    0.7.0.1
 */