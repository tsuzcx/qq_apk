package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View ngR;
  private final a ngS;
  private int ngT;
  private int ngU;
  private boolean ngV;
  
  private am(View paramView, a parama)
  {
    this.ngR = paramView;
    this.ngS = parama;
  }
  
  public static void a(View paramView, a parama)
  {
    AppMethodBeat.i(133758);
    paramView = new am(paramView, parama);
    paramView.ngR.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(133758);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(133759);
    if (!this.ngV)
    {
      this.ngV = true;
      this.ngT = this.ngR.getWidth();
      this.ngU = this.ngR.getHeight();
      AppMethodBeat.o(133759);
      return;
    }
    if ((this.ngR.getWidth() != this.ngT) || (this.ngR.getHeight() != this.ngU))
    {
      this.ngS.bDL();
      this.ngT = this.ngR.getWidth();
      this.ngU = this.ngR.getHeight();
    }
    AppMethodBeat.o(133759);
  }
  
  public static abstract interface a
  {
    public abstract void bDL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */