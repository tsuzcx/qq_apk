package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18847);
    b.a(this.kJe, this.lU);
    this.kJe.notifyDataSetChanged();
    AppMethodBeat.o(18847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b.1
 * JD-Core Version:    0.7.0.1
 */