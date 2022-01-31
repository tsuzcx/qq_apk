package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.a;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.report.service.h;

final class BackupPcUI$3$1$1
  implements DialogInterface.OnClickListener
{
  BackupPcUI$3$1$1(BackupPcUI.3.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.auw().aux().nB(2);
    b.auw().atn().hFu = 12;
    this.hLo.hLn.nt(12);
    b.auw().auA().auv();
    b.auw().auA().ee(true);
    h.nFQ.a(400L, 7L, 1L, false);
    h.nFQ.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.auw().aux().hKD) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.1.1
 * JD-Core Version:    0.7.0.1
 */