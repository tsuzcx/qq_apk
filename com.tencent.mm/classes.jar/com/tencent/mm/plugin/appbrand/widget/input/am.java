package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View nlZ;
  private final a nma;
  private int nmb;
  private int nmc;
  private boolean nmd;
  
  private am(View paramView, a parama)
  {
    this.nlZ = paramView;
    this.nma = parama;
  }
  
  public static void a(View paramView, a parama)
  {
    AppMethodBeat.i(133758);
    paramView = new am(paramView, parama);
    paramView.nlZ.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(133758);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(133759);
    if (!this.nmd)
    {
      this.nmd = true;
      this.nmb = this.nlZ.getWidth();
      this.nmc = this.nlZ.getHeight();
      AppMethodBeat.o(133759);
      return;
    }
    if ((this.nlZ.getWidth() != this.nmb) || (this.nlZ.getHeight() != this.nmc))
    {
      this.nma.bED();
      this.nmb = this.nlZ.getWidth();
      this.nmc = this.nlZ.getHeight();
    }
    AppMethodBeat.o(133759);
  }
  
  public static abstract interface a
  {
    public abstract void bED();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */