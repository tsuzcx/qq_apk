package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.d.b;
import java.util.HashSet;

final class BackupMoveChooseUI$4
  implements View.OnClickListener
{
  BackupMoveChooseUI$4(BackupMoveChooseUI paramBackupMoveChooseUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    if (b.atS().atW().hHx)
    {
      paramView = BackupMoveChooseUI.a(this.hJm);
      if (paramView.hIR.size() != paramView.getCount()) {
        break label64;
      }
      paramView.hIR.clear();
    }
    for (paramView.hIS = false;; paramView.hIS = true)
    {
      paramView.notifyDataSetChanged();
      paramView.hIQ.a(paramView.hIR);
      return;
      label64:
      while (i < paramView.getCount())
      {
        paramView.hIR.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.4
 * JD-Core Version:    0.7.0.1
 */