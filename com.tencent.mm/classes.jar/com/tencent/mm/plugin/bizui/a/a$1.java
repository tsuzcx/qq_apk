package com.tencent.mm.plugin.bizui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.widget.b.c;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(c paramc, q.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70042);
    this.jMO.dismiss();
    if (this.jMP != null) {
      this.jMP.a(true, this.jMO.dOY(), this.jMO.dOZ());
    }
    AppMethodBeat.o(70042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.a.1
 * JD-Core Version:    0.7.0.1
 */