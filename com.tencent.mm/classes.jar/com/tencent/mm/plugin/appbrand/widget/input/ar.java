package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean uJA;
  private final View uJw;
  private final a uJx;
  private int uJy;
  private int uJz;
  
  private ar(View paramView, a parama)
  {
    this.uJw = paramView;
    this.uJx = parama;
  }
  
  public static void a(View paramView, a parama)
  {
    AppMethodBeat.i(133758);
    paramView = new ar(paramView, parama);
    paramView.uJw.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(133758);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(133759);
    if (!this.uJA)
    {
      this.uJA = true;
      this.uJy = this.uJw.getWidth();
      this.uJz = this.uJw.getHeight();
      AppMethodBeat.o(133759);
      return;
    }
    if ((this.uJw.getWidth() != this.uJy) || (this.uJw.getHeight() != this.uJz))
    {
      this.uJx.cQA();
      this.uJy = this.uJw.getWidth();
      this.uJz = this.uJw.getHeight();
    }
    AppMethodBeat.o(133759);
  }
  
  public static abstract interface a
  {
    public abstract void cQA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ar
 * JD-Core Version:    0.7.0.1
 */