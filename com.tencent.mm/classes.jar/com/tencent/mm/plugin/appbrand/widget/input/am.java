package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View meu;
  private final a mev;
  private int mew;
  private int mex;
  private boolean mey;
  
  private am(View paramView, a parama)
  {
    this.meu = paramView;
    this.mev = parama;
  }
  
  public static void a(View paramView, a parama)
  {
    AppMethodBeat.i(133758);
    paramView = new am(paramView, parama);
    paramView.meu.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(133758);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(133759);
    if (!this.mey)
    {
      this.mey = true;
      this.mew = this.meu.getWidth();
      this.mex = this.meu.getHeight();
      AppMethodBeat.o(133759);
      return;
    }
    if ((this.meu.getWidth() != this.mew) || (this.meu.getHeight() != this.mex))
    {
      this.mev.bsI();
      this.mew = this.meu.getWidth();
      this.mex = this.meu.getHeight();
    }
    AppMethodBeat.o(133759);
  }
  
  public static abstract interface a
  {
    public abstract void bsI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */