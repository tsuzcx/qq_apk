package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.d.b;

final class BackupMoveChooseUI$3
  implements View.OnClickListener
{
  BackupMoveChooseUI$3(BackupMoveChooseUI paramBackupMoveChooseUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.hJm, BackupSelectExtUI.class);
    paramView.putExtra("BACKUP_MODE", 2);
    paramView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.access$100());
    paramView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
    paramView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.access$200());
    paramView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.aun());
    paramView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.auo());
    paramView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.atS().atW().hHt);
    this.hJm.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.3
 * JD-Core Version:    0.7.0.1
 */