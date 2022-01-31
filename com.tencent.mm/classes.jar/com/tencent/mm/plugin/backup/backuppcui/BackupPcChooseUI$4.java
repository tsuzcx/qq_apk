package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import java.util.HashSet;

final class BackupPcChooseUI$4
  implements View.OnClickListener
{
  BackupPcChooseUI$4(BackupPcChooseUI paramBackupPcChooseUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    if (b.auw().auA().hHx)
    {
      paramView = BackupPcChooseUI.a(this.hLh);
      if (paramView.hIR.size() != paramView.getCount()) {
        break label63;
      }
      paramView.hIR.clear();
    }
    for (a.hLc = false;; a.hLc = true)
    {
      paramView.notifyDataSetChanged();
      paramView.hLb.a(paramView.hIR);
      return;
      label63:
      while (i < paramView.getCount())
      {
        paramView.hIR.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.4
 * JD-Core Version:    0.7.0.1
 */