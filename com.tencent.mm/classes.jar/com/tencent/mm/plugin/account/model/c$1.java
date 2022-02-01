package com.tencent.mm.plugin.account.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class c$1
  implements DialogInterface.OnCancelListener
{
  public c$1(c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127824);
    ae.w("MicroMsg.DoInit", "do init canceled");
    g.ajj().a(this.jkn.dpw);
    if (this.jkn.dpw.getType() == 139)
    {
      g.ajj().b(139, this.jkn);
      AppMethodBeat.o(127824);
      return;
    }
    if (this.jkn.dpw.getType() == 138) {
      g.ajj().b(138, this.jkn);
    }
    AppMethodBeat.o(127824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c.1
 * JD-Core Version:    0.7.0.1
 */