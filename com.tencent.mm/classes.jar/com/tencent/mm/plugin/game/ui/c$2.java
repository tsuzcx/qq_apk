package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14217, new Object[] { this.kWS.kOM.field_appId, Integer.valueOf(6), "", this.kWS.kOM.cvy, Integer.valueOf(2) });
    paramDialogInterface.dismiss();
    y.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c.2
 * JD-Core Version:    0.7.0.1
 */