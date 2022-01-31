package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BackupPcUI$3$4$1
  implements DialogInterface.OnClickListener
{
  BackupPcUI$3$4$1(BackupPcUI.3.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
    h.nFQ.a(400L, 18L, 1L, false);
    b.auw().auz().nC(4);
    b.auw().atT().stop();
    b.auw().auz().a(true, true, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.4.1
 * JD-Core Version:    0.7.0.1
 */