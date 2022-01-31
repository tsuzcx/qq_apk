package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.d.b;
import java.util.HashSet;

final class BackupMoveChooseUI$4
  implements View.OnClickListener
{
  BackupMoveChooseUI$4(BackupMoveChooseUI paramBackupMoveChooseUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(17327);
    if (b.aTr().aTv().jAT)
    {
      paramView = BackupMoveChooseUI.a(this.jCN);
      if (paramView.jCr.size() != paramView.getCount()) {
        break label76;
      }
      paramView.jCr.clear();
    }
    for (paramView.jCs = false;; paramView.jCs = true)
    {
      paramView.notifyDataSetChanged();
      paramView.jCq.a(paramView.jCr);
      AppMethodBeat.o(17327);
      return;
      label76:
      while (i < paramView.getCount())
      {
        paramView.jCr.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.4
 * JD-Core Version:    0.7.0.1
 */