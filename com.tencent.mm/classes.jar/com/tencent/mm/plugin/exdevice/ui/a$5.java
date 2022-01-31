package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$5
  implements View.OnClickListener
{
  a$5(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20006);
    if (a.c(this.lNr) != null)
    {
      paramView = a.c(this.lNr);
      a.a(this.lNr);
      paramView.bqV();
    }
    AppMethodBeat.o(20006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a.5
 * JD-Core Version:    0.7.0.1
 */