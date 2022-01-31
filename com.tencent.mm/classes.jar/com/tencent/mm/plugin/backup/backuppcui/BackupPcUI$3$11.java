package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.report.service.h;

final class BackupPcUI$3$11
  implements View.OnClickListener
{
  BackupPcUI$3$11(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17604);
    h.qsU.e(13735, new Object[] { Integer.valueOf(23), Integer.valueOf(b.aTX().aTY().jEg) });
    b.aTX().aTY().rq(4);
    b.aTX().aSL().jyN = 22;
    this.jEQ.rf(22);
    h.qsU.idkeyStat(400L, 16L, 1L, false);
    AppMethodBeat.o(17604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.11
 * JD-Core Version:    0.7.0.1
 */