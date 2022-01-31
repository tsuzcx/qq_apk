package com.tencent.mm.plugin.bizui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.widget.b.c;

final class a$2
  implements DialogInterface.OnClickListener
{
  a$2(c paramc, q.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70043);
    this.jMO.dismiss();
    if (this.jMQ != null) {
      this.jMQ.a(false, null, 0);
    }
    AppMethodBeat.o(70043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.a.2
 * JD-Core Version:    0.7.0.1
 */