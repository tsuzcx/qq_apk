package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(111699);
    h.qsU.e(14217, new Object[] { this.nuU.nmJ.field_appId, Integer.valueOf(6), "", this.nuU.nmJ.djJ, Integer.valueOf(2) });
    paramDialogInterface.dismiss();
    ab.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
    AppMethodBeat.o(111699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c.2
 * JD-Core Version:    0.7.0.1
 */