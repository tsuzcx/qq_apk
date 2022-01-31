package com.tencent.mm.plugin.backup.backuppcui;

import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.a;
import java.util.LinkedList;

final class BackupPcChooseUI$5
  implements b.a
{
  BackupPcChooseUI$5(BackupPcChooseUI paramBackupPcChooseUI) {}
  
  public final void A(LinkedList<f.b> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    if (paramLinkedList.size() == 0)
    {
      BackupPcChooseUI.b(this.hLh).setVisibility(8);
      BackupPcChooseUI.c(this.hLh).setVisibility(0);
      switch (BackupPcChooseUI.access$100())
      {
      default: 
        return;
      case 0: 
        BackupPcChooseUI.c(this.hLh).setText(R.l.backup_pc_choose_empty_records);
        return;
      }
      BackupPcChooseUI.c(this.hLh).setText(R.l.backup_select_empty_records_in_select_time);
      return;
    }
    BackupPcChooseUI.d(this.hLh).setClickable(true);
    BackupPcChooseUI.d(this.hLh).setTextColor(this.hLh.getResources().getColor(R.e.backup_green));
    BackupPcChooseUI.b(this.hLh).setVisibility(8);
    BackupPcChooseUI.a(this.hLh).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.5
 * JD-Core Version:    0.7.0.1
 */