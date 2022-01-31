package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.report.service.h;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(c paramc, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(111698);
    h.qsU.e(14217, new Object[] { this.nuU.nmJ.field_appId, Integer.valueOf(5), "", this.nuU.nmJ.djJ, Integer.valueOf(2) });
    c.a(this.nuU, this.nuT);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(111698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c.1
 * JD-Core Version:    0.7.0.1
 */