package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class BackupMoveRecoverUI$8
  implements View.OnClickListener
{
  BackupMoveRecoverUI$8(BackupMoveRecoverUI paramBackupMoveRecoverUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.hJA, R.l.backup_move_error_alert_stop_move_tip, R.l.backup_move_error_alert_stop_move, R.l.backup_move_recover_stop_move, R.l.backup_cancel, false, new BackupMoveRecoverUI.8.1(this), null, R.e.backup_red);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.8
 * JD-Core Version:    0.7.0.1
 */