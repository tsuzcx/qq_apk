package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74665);
    if (this.mDS.mDR == null)
    {
      AppMethodBeat.o(74665);
      return;
    }
    this.mDS.mDR.bxs();
    AppMethodBeat.o(74665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a.1
 * JD-Core Version:    0.7.0.1
 */