package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a.2;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashSet;
import java.util.LinkedList;

final class BackupMoveChooseUI$2
  implements View.OnClickListener
{
  BackupMoveChooseUI$2(BackupMoveChooseUI paramBackupMoveChooseUI) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = new PLong();
    Object localObject2 = new PInt();
    a locala = BackupMoveChooseUI.a(this.hJm);
    paramView = new LinkedList();
    if (locala.hIR.size() <= 0)
    {
      localObject1 = g.z(paramView);
      localObject2 = com.tencent.mm.plugin.backup.d.b.atS().atW();
      if (paramView.size() != 0) {
        break label606;
      }
      ((com.tencent.mm.plugin.backup.d.a)localObject2).hHw = new LinkedList();
      label77:
      paramView = com.tencent.mm.plugin.backup.d.b.atS().atU();
      paramView.hIq = ((LinkedList)localObject1);
      com.tencent.mm.plugin.backup.d.b.atS();
      if (com.tencent.mm.plugin.backup.d.b.ats().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
        break label659;
      }
      d.hIx = true;
      label112:
      com.tencent.mm.plugin.backup.d.b.atS();
      paramView.hIt = com.tencent.mm.plugin.backup.d.b.ats().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      com.tencent.mm.plugin.backup.d.b.atS();
      paramView.hIu = com.tencent.mm.plugin.backup.d.b.ats().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      com.tencent.mm.plugin.backup.d.b.atS();
      if (com.tencent.mm.plugin.backup.d.b.ats().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label666;
      }
      d.hGZ = true;
      label173:
      y.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(paramView.hIt), Long.valueOf(paramView.hIu), Boolean.valueOf(d.hGZ) });
      au.Hx();
      c.Dz().c(ac.a.uup, Boolean.valueOf(true));
      paramView = com.tencent.mm.plugin.backup.d.b.atS().atW();
      if (paramView.hHr != null) {
        paramView.hHr.cancel();
      }
      e.post(new a.2(paramView), "BakMoveChooseServer.calculateChooseConvSize");
      if (BackupMoveChooseUI.a(this.hJm).hIS)
      {
        h.nFQ.a(485L, 22L, 1L, false);
        h.nFQ.f(11788, new Object[] { Integer.valueOf(4) });
      }
      if ((BackupMoveChooseUI.access$100() != 1) || (BackupMoveChooseUI.access$200() != 1)) {
        break label673;
      }
      h.nFQ.a(485L, 26L, 1L, false);
      h.nFQ.a(485L, 27L, 1L, false);
      h.nFQ.f(11788, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      h.nFQ.f(11788, new Object[] { Integer.valueOf(8) });
      paramView = new Intent(this.hJm, BackupMoveQRCodeUI.class);
      MMWizardActivity.C(this.hJm, paramView);
      h.nFQ.a(485L, 23L, 1L, false);
      return;
      ((PLong)localObject1).value = 0L;
      ((PInt)localObject2).value = 0;
      LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.atS().atW().atP();
      if (localLinkedList != null)
      {
        int i = 0;
        while (i < locala.getCount())
        {
          if (locala.hIR.contains(Integer.valueOf(i)))
          {
            paramView.add(localLinkedList.get(i));
            ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).hFG;
            ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).hFH));
          }
          i += 1;
        }
      }
      y.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
      break;
      label606:
      ((com.tencent.mm.plugin.backup.d.a)localObject2).hHw = new LinkedList(paramView.subList(paramView.size() * 3 / 4, paramView.size()));
      ((com.tencent.mm.plugin.backup.d.a)localObject2).hHw.addAll(paramView.subList(0, paramView.size() * 3 / 4));
      break label77;
      label659:
      d.hIx = false;
      break label112;
      label666:
      d.hGZ = false;
      break label173;
      label673:
      if (BackupMoveChooseUI.access$100() == 1)
      {
        h.nFQ.a(485L, 26L, 1L, false);
        h.nFQ.f(11788, new Object[] { Integer.valueOf(5) });
      }
      else if (BackupMoveChooseUI.access$200() == 1)
      {
        h.nFQ.a(485L, 27L, 1L, false);
        h.nFQ.f(11788, new Object[] { Integer.valueOf(6) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.2
 * JD-Core Version:    0.7.0.1
 */