package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View ovG;
  private final a ovH;
  private int ovI;
  private int ovJ;
  private boolean ovK;
  
  private am(View paramView, a parama)
  {
    this.ovG = paramView;
    this.ovH = parama;
  }
  
  public static void a(View paramView, a parama)
  {
    AppMethodBeat.i(133758);
    paramView = new am(paramView, parama);
    paramView.ovG.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(133758);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(133759);
    if (!this.ovK)
    {
      this.ovK = true;
      this.ovI = this.ovG.getWidth();
      this.ovJ = this.ovG.getHeight();
      AppMethodBeat.o(133759);
      return;
    }
    if ((this.ovG.getWidth() != this.ovI) || (this.ovG.getHeight() != this.ovJ))
    {
      this.ovH.caR();
      this.ovI = this.ovG.getWidth();
      this.ovJ = this.ovG.getHeight();
    }
    AppMethodBeat.o(133759);
  }
  
  public static abstract interface a
  {
    public abstract void caR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */