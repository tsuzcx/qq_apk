package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;

final class BackupUI$1$1
  implements DialogInterface.OnClickListener
{
  BackupUI$1$1(BackupUI.1 param1, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(this.hJL) });
    h.nFQ.a(485L, 21L, 1L, false);
    h.nFQ.f(11788, new Object[] { Integer.valueOf(3) });
    paramDialogInterface = new Intent(this.hJM.hJK, BackupMoveChooseUI.class);
    MMWizardActivity.C(this.hJM.hJK, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI.1.1
 * JD-Core Version:    0.7.0.1
 */