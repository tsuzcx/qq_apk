package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.a;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.report.service.h;
import java.util.LinkedList;

final class BackupPcChooseUI$2$1
  implements DialogInterface.OnClickListener
{
  BackupPcChooseUI$2$1(BackupPcChooseUI.2 param2, LinkedList paramLinkedList1, LinkedList paramLinkedList2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.auw().auA().E(this.hLi);
    b.auw().aux().nB(2);
    b.auw().atn().hFu = 12;
    b.auw().auy().F(this.hLj);
    b.auw().auy().cH(this.hLi.size());
    h.nFQ.a(400L, 8L, 1L, false);
    h.nFQ.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.auw().aux().hKD) });
    if ((BackupPcChooseUI.access$100() == 1) && (BackupPcChooseUI.auH() == 1))
    {
      h.nFQ.a(400L, 32L, 1L, false);
      h.nFQ.a(400L, 35L, 1L, false);
      h.nFQ.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.auw().aux().hKD) });
    }
    for (;;)
    {
      this.hLk.hLh.finish();
      return;
      if (BackupPcChooseUI.access$100() == 1)
      {
        h.nFQ.a(400L, 32L, 1L, false);
        h.nFQ.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.auw().aux().hKD) });
      }
      else if (BackupPcChooseUI.auH() == 1)
      {
        h.nFQ.a(400L, 35L, 1L, false);
        h.nFQ.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.auw().aux().hKD) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.2.1
 * JD-Core Version:    0.7.0.1
 */