package com.tencent.mm.plugin.account.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;

public final class c$1
  implements DialogInterface.OnCancelListener
{
  public c$1(c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127824);
    ac.w("MicroMsg.DoInit", "do init canceled");
    g.agi().a(this.iOl.dcV);
    if (this.iOl.dcV.getType() == 139)
    {
      g.agi().b(139, this.iOl);
      AppMethodBeat.o(127824);
      return;
    }
    if (this.iOl.dcV.getType() == 138) {
      g.agi().b(138, this.iOl);
    }
    AppMethodBeat.o(127824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c.1
 * JD-Core Version:    0.7.0.1
 */