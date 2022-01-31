package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveRecoverUI$1$21
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$21(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17384);
    ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
    b.aTr().aTu();
    if (!c.aTw())
    {
      ab.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
      b.aTr().aSL().jyN = -22;
      this.jDd.rf(-22);
      h.qsU.idkeyStat(485L, 6L, 1L, false);
      AppMethodBeat.o(17384);
      return;
    }
    b.aTr().aTu().aTd();
    AppMethodBeat.o(17384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.21
 * JD-Core Version:    0.7.0.1
 */