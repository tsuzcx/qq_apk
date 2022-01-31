package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(17590);
    b.aTX().aTY().rq(2);
    b.aTX().aSL().jyN = 12;
    this.jER.jEQ.rf(12);
    b.aTX().aUb().aTW();
    b.aTX().aUb().fB(true);
    h.qsU.idkeyStat(400L, 7L, 1L, false);
    h.qsU.e(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.aTX().aTY().jEg) });
    AppMethodBeat.o(17590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.1.1
 * JD-Core Version:    0.7.0.1
 */