package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(17574);
    b.aTX().aUb().F(this.jEL);
    b.aTX().aTY().rq(2);
    b.aTX().aSL().jyN = 12;
    b.aTX().aTZ().G(this.jEM);
    b.aTX().aTZ().hJ(this.jEL.size());
    h.qsU.idkeyStat(400L, 8L, 1L, false);
    h.qsU.e(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.aTX().aTY().jEg) });
    if ((BackupPcChooseUI.access$100() == 1) && (BackupPcChooseUI.access$400() == 1))
    {
      h.qsU.idkeyStat(400L, 32L, 1L, false);
      h.qsU.idkeyStat(400L, 35L, 1L, false);
      h.qsU.e(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.aTX().aTY().jEg) });
    }
    for (;;)
    {
      this.jEN.jEK.finish();
      AppMethodBeat.o(17574);
      return;
      if (BackupPcChooseUI.access$100() == 1)
      {
        h.qsU.idkeyStat(400L, 32L, 1L, false);
        h.qsU.e(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.aTX().aTY().jEg) });
      }
      else if (BackupPcChooseUI.access$400() == 1)
      {
        h.qsU.idkeyStat(400L, 35L, 1L, false);
        h.qsU.e(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.aTX().aTY().jEg) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.2.1
 * JD-Core Version:    0.7.0.1
 */