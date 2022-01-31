package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1$2
  implements Runnable
{
  h$1$2(h.1 param1, View paramView, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(133088);
    this.iOA.setVisibility(8);
    this.qN.removeView(this.iOA);
    AppMethodBeat.o(133088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.1.2
 * JD-Core Version:    0.7.0.1
 */