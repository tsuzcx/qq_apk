package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View joE;
  private final am.a joF;
  private boolean joG;
  private int lastHeight;
  private int lastWidth;
  
  private am(View paramView, am.a parama)
  {
    this.joE = paramView;
    this.joF = parama;
  }
  
  public static void a(View paramView, am.a parama)
  {
    AppMethodBeat.i(67826);
    paramView = new am(paramView, parama);
    paramView.joE.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(67826);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(67827);
    if (!this.joG)
    {
      this.joG = true;
      this.lastWidth = this.joE.getWidth();
      this.lastHeight = this.joE.getHeight();
      AppMethodBeat.o(67827);
      return;
    }
    if ((this.joE.getWidth() != this.lastWidth) || (this.joE.getHeight() != this.lastHeight))
    {
      this.joF.aQs();
      this.lastWidth = this.joE.getWidth();
      this.lastHeight = this.joE.getHeight();
    }
    AppMethodBeat.o(67827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */