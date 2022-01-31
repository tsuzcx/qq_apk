package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a.2;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(17325);
    Object localObject1 = new PLong();
    Object localObject2 = new PInt();
    a locala = BackupMoveChooseUI.a(this.jCN);
    paramView = new LinkedList();
    if (locala.jCr.size() <= 0)
    {
      localObject1 = g.A(paramView);
      localObject2 = com.tencent.mm.plugin.backup.d.b.aTr().aTv();
      if (paramView.size() != 0) {
        break label617;
      }
      ((com.tencent.mm.plugin.backup.d.a)localObject2).jAS = new LinkedList();
      label83:
      paramView = com.tencent.mm.plugin.backup.d.b.aTr().aTt();
      paramView.jBO = ((LinkedList)localObject1);
      com.tencent.mm.plugin.backup.d.b.aTr();
      if (com.tencent.mm.plugin.backup.d.b.aSQ().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
        break label670;
      }
      com.tencent.mm.plugin.backup.d.d.jBV = true;
      label118:
      com.tencent.mm.plugin.backup.d.b.aTr();
      paramView.jBR = com.tencent.mm.plugin.backup.d.b.aSQ().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      com.tencent.mm.plugin.backup.d.b.aTr();
      paramView.jBS = com.tencent.mm.plugin.backup.d.b.aSQ().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      com.tencent.mm.plugin.backup.d.b.aTr();
      if (com.tencent.mm.plugin.backup.d.b.aSQ().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label677;
      }
      com.tencent.mm.plugin.backup.d.d.jAv = true;
      label179:
      ab.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(paramView.jBR), Long.valueOf(paramView.jBS), Boolean.valueOf(com.tencent.mm.plugin.backup.d.d.jAv) });
      aw.aaz();
      c.Ru().set(ac.a.yEs, Boolean.TRUE);
      paramView = com.tencent.mm.plugin.backup.d.b.aTr().aTv();
      if (paramView.jAN != null) {
        paramView.jAN.cancel();
      }
      com.tencent.mm.sdk.g.d.post(new a.2(paramView), "BackupMoveChooseServer.calculateChooseConvSize");
      if (BackupMoveChooseUI.a(this.jCN).jCs)
      {
        h.qsU.idkeyStat(485L, 22L, 1L, false);
        h.qsU.e(11788, new Object[] { Integer.valueOf(4) });
      }
      if ((BackupMoveChooseUI.access$100() != 1) || (BackupMoveChooseUI.access$200() != 1)) {
        break label684;
      }
      h.qsU.idkeyStat(485L, 26L, 1L, false);
      h.qsU.idkeyStat(485L, 27L, 1L, false);
      h.qsU.e(11788, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      h.qsU.e(11788, new Object[] { Integer.valueOf(8) });
      paramView = new Intent(this.jCN, BackupMoveQRCodeUI.class);
      MMWizardActivity.J(this.jCN, paramView);
      h.qsU.idkeyStat(485L, 23L, 1L, false);
      AppMethodBeat.o(17325);
      return;
      ((PLong)localObject1).value = 0L;
      ((PInt)localObject2).value = 0;
      LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.aTr().aTv().aTn();
      if (localLinkedList != null)
      {
        int i = 0;
        while (i < locala.getCount())
        {
          if (locala.jCr.contains(Integer.valueOf(i)))
          {
            paramView.add(localLinkedList.get(i));
            ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).jzd;
            ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).jze));
          }
          i += 1;
        }
      }
      ab.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
      break;
      label617:
      ((com.tencent.mm.plugin.backup.d.a)localObject2).jAS = new LinkedList(paramView.subList(paramView.size() * 3 / 4, paramView.size()));
      ((com.tencent.mm.plugin.backup.d.a)localObject2).jAS.addAll(paramView.subList(0, paramView.size() * 3 / 4));
      break label83;
      label670:
      com.tencent.mm.plugin.backup.d.d.jBV = false;
      break label118;
      label677:
      com.tencent.mm.plugin.backup.d.d.jAv = false;
      break label179;
      label684:
      if (BackupMoveChooseUI.access$100() == 1)
      {
        h.qsU.idkeyStat(485L, 26L, 1L, false);
        h.qsU.e(11788, new Object[] { Integer.valueOf(5) });
      }
      else if (BackupMoveChooseUI.access$200() == 1)
      {
        h.qsU.idkeyStat(485L, 27L, 1L, false);
        h.qsU.e(11788, new Object[] { Integer.valueOf(6) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.2
 * JD-Core Version:    0.7.0.1
 */