package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class BackupMoveRecoverUI$1$6
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$6(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21423);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    try
    {
      localObject = new Intent();
      ((Intent)localObject).setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
      paramView = this.nCr.nCq;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(21423);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ae.e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
        paramView = this.nCr.nCq;
        localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.6
 * JD-Core Version:    0.7.0.1
 */