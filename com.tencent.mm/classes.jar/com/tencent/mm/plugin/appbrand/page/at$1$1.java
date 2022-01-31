package com.tencent.mm.plugin.appbrand.page;

import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class at$1$1
  implements Runnable
{
  at$1$1(at.1 param1, View.OnLayoutChangeListener paramOnLayoutChangeListener) {}
  
  public final void run()
  {
    AppMethodBeat.i(140873);
    at.a(this.ize.izc).ivI.removeOnLayoutChangeListener(this.izd);
    AppMethodBeat.o(140873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at.1.1
 * JD-Core Version:    0.7.0.1
 */