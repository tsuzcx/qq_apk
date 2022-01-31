package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.d.b;

final class BackupMoveChooseUI$3
  implements View.OnClickListener
{
  BackupMoveChooseUI$3(BackupMoveChooseUI paramBackupMoveChooseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17326);
    paramView = new Intent(this.jCN, BackupSelectExtUI.class);
    paramView.putExtra("BACKUP_MODE", 2);
    paramView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.access$100());
    paramView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
    paramView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.access$200());
    paramView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.aTN());
    paramView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.aTO());
    paramView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.aTr().aTv().jAP);
    this.jCN.startActivityForResult(paramView, 0);
    AppMethodBeat.o(17326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.3
 * JD-Core Version:    0.7.0.1
 */