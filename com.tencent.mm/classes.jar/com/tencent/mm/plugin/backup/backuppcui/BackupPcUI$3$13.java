package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class BackupPcUI$3$13
  implements View.OnClickListener
{
  BackupPcUI$3$13(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.hLn.hLm, R.l.backup_pc_error_alert_stop_recover_tip, R.l.backup_pc_error_alert_stop_recover, R.l.backup_pc_stop_recover, R.l.backup_cancel, false, new BackupPcUI.3.13.1(this), null, R.e.backup_red);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.13
 * JD-Core Version:    0.7.0.1
 */