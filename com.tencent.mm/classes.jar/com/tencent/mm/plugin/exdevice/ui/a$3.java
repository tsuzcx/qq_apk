package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20004);
    if (a.c(this.lNr) != null)
    {
      paramView = a.c(this.lNr);
      a.a(this.lNr);
      paramView.bqU();
    }
    AppMethodBeat.o(20004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a.3
 * JD-Core Version:    0.7.0.1
 */