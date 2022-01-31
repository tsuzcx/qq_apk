package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.a;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;

final class BackupPcChooseUI$3
  implements View.OnClickListener
{
  BackupPcChooseUI$3(BackupPcChooseUI paramBackupPcChooseUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.hLh, BackupSelectExtUI.class);
    paramView.putExtra("BACKUP_MODE", 1);
    paramView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.access$100());
    paramView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", b.auw().auy().hKT);
    paramView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.auH());
    paramView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.access$200());
    paramView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.aun());
    paramView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.auw().auA().hHt);
    this.hLh.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.3
 * JD-Core Version:    0.7.0.1
 */