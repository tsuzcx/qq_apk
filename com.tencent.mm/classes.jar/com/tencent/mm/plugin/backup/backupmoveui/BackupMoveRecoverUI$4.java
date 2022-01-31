package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;

final class BackupMoveRecoverUI$4
  implements View.OnClickListener
{
  BackupMoveRecoverUI$4(BackupMoveRecoverUI paramBackupMoveRecoverUI) {}
  
  public final void onClick(View paramView)
  {
    b.atS().atT().stop();
    b.atS().atn().hFu = -100;
    BackupMoveRecoverUI.c(this.hJA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.4
 * JD-Core Version:    0.7.0.1
 */