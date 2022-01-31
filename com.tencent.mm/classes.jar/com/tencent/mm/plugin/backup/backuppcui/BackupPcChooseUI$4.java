package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import java.util.HashSet;

final class BackupPcChooseUI$4
  implements View.OnClickListener
{
  BackupPcChooseUI$4(BackupPcChooseUI paramBackupPcChooseUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(17577);
    if (b.aTX().aUb().jAT)
    {
      paramView = BackupPcChooseUI.a(this.jEK);
      if (paramView.jCr.size() != paramView.getCount()) {
        break label75;
      }
      paramView.jCr.clear();
    }
    for (a.jEF = false;; a.jEF = true)
    {
      paramView.notifyDataSetChanged();
      paramView.jEE.a(paramView.jCr);
      AppMethodBeat.o(17577);
      return;
      label75:
      while (i < paramView.getCount())
      {
        paramView.jCr.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.4
 * JD-Core Version:    0.7.0.1
 */