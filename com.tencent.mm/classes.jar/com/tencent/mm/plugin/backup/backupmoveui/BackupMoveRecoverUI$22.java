package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BackupMoveRecoverUI$22
  implements View.OnClickListener
{
  BackupMoveRecoverUI$22(BackupMoveRecoverUI paramBackupMoveRecoverUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
    b.atS().atV();
    if (!c.atX())
    {
      y.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
      b.atS().atn().hFu = -22;
      this.hJA.nt(-22);
      h.nFQ.a(485L, 6L, 1L, false);
      return;
    }
    b.atS().atV().atF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.22
 * JD-Core Version:    0.7.0.1
 */