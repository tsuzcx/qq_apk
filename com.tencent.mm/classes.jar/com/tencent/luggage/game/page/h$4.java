package com.tencent.luggage.game.page;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bd;

final class h$4
  implements bd
{
  h$4(h paramh) {}
  
  public final void a(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(178040);
    if ((paramFrameLayout != null) && (paramFrameLayout.getParent() == null)) {
      this.clm.clb.addView(paramFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(178040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.page.h.4
 * JD-Core Version:    0.7.0.1
 */