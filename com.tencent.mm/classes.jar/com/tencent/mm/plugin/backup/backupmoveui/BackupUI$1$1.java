package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;

final class BackupUI$1$1
  implements DialogInterface.OnClickListener
{
  BackupUI$1$1(BackupUI.1 param1, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(21486);
    ad.i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(this.jDt) });
    g.yhR.idkeyStat(485L, 21L, 1L, false);
    g.yhR.f(11788, new Object[] { Integer.valueOf(3) });
    paramDialogInterface = new Intent(this.nxi.nxh, BackupMoveChooseUI.class);
    MMWizardActivity.al(this.nxi.nxh, paramDialogInterface);
    AppMethodBeat.o(21486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI.1.1
 * JD-Core Version:    0.7.0.1
 */