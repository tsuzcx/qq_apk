package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View rys;
  private final a ryt;
  private int ryu;
  private int ryv;
  private boolean ryw;
  
  private ar(View paramView, a parama)
  {
    this.rys = paramView;
    this.ryt = parama;
  }
  
  public static void a(View paramView, a parama)
  {
    AppMethodBeat.i(133758);
    paramView = new ar(paramView, parama);
    paramView.rys.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(133758);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(133759);
    if (!this.ryw)
    {
      this.ryw = true;
      this.ryu = this.rys.getWidth();
      this.ryv = this.rys.getHeight();
      AppMethodBeat.o(133759);
      return;
    }
    if ((this.rys.getWidth() != this.ryu) || (this.rys.getHeight() != this.ryv))
    {
      this.ryt.cnY();
      this.ryu = this.rys.getWidth();
      this.ryv = this.rys.getHeight();
    }
    AppMethodBeat.o(133759);
  }
  
  public static abstract interface a
  {
    public abstract void cnY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ar
 * JD-Core Version:    0.7.0.1
 */