package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BackupPcUI$3$2$1
  implements DialogInterface.OnClickListener
{
  BackupPcUI$3$2$1(BackupPcUI.3.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
    b.auw().atT().stop();
    b.auw().auz().a(true, true, -100);
    h.nFQ.a(400L, 52L, 1L, false);
    b.auw().auz().nC(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.2.1
 * JD-Core Version:    0.7.0.1
 */