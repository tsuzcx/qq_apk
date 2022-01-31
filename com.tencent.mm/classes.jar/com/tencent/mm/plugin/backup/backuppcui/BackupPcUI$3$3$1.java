package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BackupPcUI$3$3$1
  implements DialogInterface.OnClickListener
{
  BackupPcUI$3$3$1(BackupPcUI.3.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
    h.nFQ.a(400L, 10L, 1L, false);
    b.auw().auy().nC(4);
    b.auw().atT().stop();
    b.auw().auy().cancel(true);
    b.auw().atn().hFu = -100;
    BackupPcUI.l(this.hLq.hLn.hLm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.3.1
 * JD-Core Version:    0.7.0.1
 */