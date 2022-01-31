package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.b.a;

final class RegByEmailUI$2
  implements DialogInterface.OnClickListener
{
  RegByEmailUI$2(RegByEmailUI paramRegByEmailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125302);
    a.xD(RegByEmailUI.f(this.gHH));
    this.gHH.hideVKB();
    this.gHH.finish();
    AppMethodBeat.o(125302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI.2
 * JD-Core Version:    0.7.0.1
 */