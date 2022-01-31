package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveRecoverUI$1$6
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$6(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17365);
    try
    {
      paramView = new Intent();
      paramView.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
      this.jDd.jDc.startActivity(paramView);
      AppMethodBeat.o(17365);
      return;
    }
    catch (Exception paramView)
    {
      ab.e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
      this.jDd.jDc.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
      AppMethodBeat.o(17365);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.6
 * JD-Core Version:    0.7.0.1
 */