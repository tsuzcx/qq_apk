package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View mGt;
  private final a mGu;
  private int mGv;
  private int mGw;
  private boolean mGx;
  
  private am(View paramView, a parama)
  {
    this.mGt = paramView;
    this.mGu = parama;
  }
  
  public static void a(View paramView, a parama)
  {
    AppMethodBeat.i(133758);
    paramView = new am(paramView, parama);
    paramView.mGt.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
    AppMethodBeat.o(133758);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(133759);
    if (!this.mGx)
    {
      this.mGx = true;
      this.mGv = this.mGt.getWidth();
      this.mGw = this.mGt.getHeight();
      AppMethodBeat.o(133759);
      return;
    }
    if ((this.mGt.getWidth() != this.mGv) || (this.mGt.getHeight() != this.mGw))
    {
      this.mGu.bzI();
      this.mGv = this.mGt.getWidth();
      this.mGw = this.mGt.getHeight();
    }
    AppMethodBeat.o(133759);
  }
  
  public static abstract interface a
  {
    public abstract void bzI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */