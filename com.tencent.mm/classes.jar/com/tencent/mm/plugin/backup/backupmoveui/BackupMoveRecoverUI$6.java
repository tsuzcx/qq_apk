package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class BackupMoveRecoverUI$6
  implements View.OnClickListener
{
  BackupMoveRecoverUI$6(BackupMoveRecoverUI paramBackupMoveRecoverUI) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      paramView = new Intent();
      paramView.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
      this.hJA.startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
      y.e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
      this.hJA.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.6
 * JD-Core Version:    0.7.0.1
 */