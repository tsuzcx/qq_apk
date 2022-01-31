package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveRecoverUI$1$18
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$18(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17380);
    ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
    b.aTr().aTu();
    if (!c.aTw())
    {
      ab.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
      b.aTr().aSL().jyN = -22;
      this.jDd.rf(-22);
      h.qsU.idkeyStat(485L, 6L, 1L, false);
      AppMethodBeat.o(17380);
      return;
    }
    b.aTr().aTu().aTd();
    AppMethodBeat.o(17380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.18
 * JD-Core Version:    0.7.0.1
 */