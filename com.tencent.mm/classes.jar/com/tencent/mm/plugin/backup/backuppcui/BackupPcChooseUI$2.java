package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(17575);
    Object localObject = BackupPcChooseUI.a(this.jEK);
    paramView = new LinkedList();
    if (((a)localObject).jCr.size() <= 0) {}
    for (;;)
    {
      localObject = g.A(paramView);
      aw.aaz();
      boolean bool = ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yEv, Boolean.FALSE)).booleanValue();
      ab.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.access$100()), Long.valueOf(BackupPcChooseUI.access$200()), Long.valueOf(BackupPcChooseUI.aTN()), Integer.valueOf(BackupPcChooseUI.access$400()) });
      if (!bool) {
        break;
      }
      com.tencent.mm.ui.base.h.a(this.jEK, 2131297342, 0, 2131297394, 0, false, new BackupPcChooseUI.2.1(this, paramView, (LinkedList)localObject), null, 2131689739);
      AppMethodBeat.o(17575);
      return;
      LinkedList localLinkedList = b.aTX().aUb().aTn();
      if (localLinkedList != null)
      {
        int i = 0;
        while (i < ((a)localObject).getCount())
        {
          if (((a)localObject).jCr.contains(Integer.valueOf(i))) {
            paramView.add(localLinkedList.get(i));
          }
          i += 1;
        }
      }
      ab.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramView.size()) });
    }
    b.aTX().aUb().F(paramView);
    b.aTX().aTY().rq(2);
    b.aTX().aSL().jyN = 12;
    b.aTX().aTZ().G((LinkedList)localObject);
    b.aTX().aTZ().hJ(paramView.size());
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 8L, 1L, false);
    com.tencent.mm.plugin.report.service.h.qsU.e(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.aTX().aTY().jEg) });
    if ((BackupPcChooseUI.access$100() == 1) && (BackupPcChooseUI.access$400() == 1))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 32L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 35L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.aTX().aTY().jEg) });
    }
    for (;;)
    {
      this.jEK.finish();
      AppMethodBeat.o(17575);
      return;
      if (BackupPcChooseUI.access$100() == 1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 32L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.aTX().aTY().jEg) });
      }
      else if (BackupPcChooseUI.access$400() == 1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 35L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.aTX().aTY().jEg) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.2
 * JD-Core Version:    0.7.0.1
 */