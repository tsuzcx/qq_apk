package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$1
  implements DialogInterface.OnClickListener
{
  t$1(t paramt, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(112213);
    com.tencent.mm.plugin.game.f.c.ax(t.a(this.nDD), this.val$url);
    com.tencent.mm.game.report.c.a(t.a(this.nDD), t.b(this.nDD).scene, t.b(this.nDD).cFj, t.b(this.nDD).position, 17, t.b(this.nDD).field_appId, t.c(this.nDD), t.b(this.nDD).cnG, t.b(this.nDD).nml);
    AppMethodBeat.o(112213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t.1
 * JD-Core Version:    0.7.0.1
 */