package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;

final class BackupPcChooseUI$2
  implements View.OnClickListener
{
  BackupPcChooseUI$2(BackupPcChooseUI paramBackupPcChooseUI) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = BackupPcChooseUI.a(this.hLh);
    paramView = new LinkedList();
    if (((a)localObject).hIR.size() <= 0) {}
    for (;;)
    {
      localObject = g.z(paramView);
      au.Hx();
      boolean bool = ((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uus, Boolean.valueOf(false))).booleanValue();
      y.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.access$100()), Long.valueOf(BackupPcChooseUI.access$200()), Long.valueOf(BackupPcChooseUI.aun()), Integer.valueOf(BackupPcChooseUI.auH()) });
      if (!bool) {
        break;
      }
      com.tencent.mm.ui.base.h.a(this.hLh, R.l.backup_pc_has_move_tip, 0, R.l.backup_sure, 0, false, new BackupPcChooseUI.2.1(this, paramView, (LinkedList)localObject), null, R.e.backup_green);
      return;
      LinkedList localLinkedList = b.auw().auA().atP();
      if (localLinkedList != null)
      {
        int i = 0;
        while (i < ((a)localObject).getCount())
        {
          if (((a)localObject).hIR.contains(Integer.valueOf(i))) {
            paramView.add(localLinkedList.get(i));
          }
          i += 1;
        }
      }
      y.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramView.size()) });
    }
    b.auw().auA().E(paramView);
    b.auw().aux().nB(2);
    b.auw().atn().hFu = 12;
    b.auw().auy().F((LinkedList)localObject);
    b.auw().auy().cH(paramView.size());
    com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 8L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.auw().aux().hKD) });
    if ((BackupPcChooseUI.access$100() == 1) && (BackupPcChooseUI.auH() == 1))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 32L, 1L, false);
      com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 35L, 1L, false);
      com.tencent.mm.plugin.report.service.h.nFQ.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.auw().aux().hKD) });
    }
    for (;;)
    {
      this.hLh.finish();
      return;
      if (BackupPcChooseUI.access$100() == 1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 32L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.auw().aux().hKD) });
      }
      else if (BackupPcChooseUI.auH() == 1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 35L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.auw().aux().hKD) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.2
 * JD-Core Version:    0.7.0.1
 */