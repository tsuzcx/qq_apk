package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class BackupMoveRecoverUI$23
  implements View.OnClickListener
{
  BackupMoveRecoverUI$23(BackupMoveRecoverUI paramBackupMoveRecoverUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
    h.a(this.hJA, R.l.backup_move_error_alert_stop_merge_tip, R.l.backup_move_error_alert_stop_merge, R.l.backup_move_recover_stop_merge, R.l.backup_cancel, false, new BackupMoveRecoverUI.23.1(this), null, R.e.backup_red);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.23
 * JD-Core Version:    0.7.0.1
 */