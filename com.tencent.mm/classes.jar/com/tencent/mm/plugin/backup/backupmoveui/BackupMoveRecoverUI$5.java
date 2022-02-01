package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class BackupMoveRecoverUI$5
  implements View.OnClickListener
{
  BackupMoveRecoverUI$5(BackupMoveRecoverUI paramBackupMoveRecoverUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21447);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.BackupMoveRecoverUI", "minimize BackupMoveRecoverUI");
    BackupMoveRecoverUI.j(this.oNp);
    a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(21447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.5
 * JD-Core Version:    0.7.0.1
 */