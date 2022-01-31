package com.tencent.mm.plugin.backup.backuppcui;

import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.a;
import java.util.LinkedList;

final class BackupPcChooseUI$5
  implements b.a
{
  BackupPcChooseUI$5(BackupPcChooseUI paramBackupPcChooseUI) {}
  
  public final void B(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17578);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(17578);
      return;
    }
    if (paramLinkedList.size() == 0)
    {
      BackupPcChooseUI.b(this.jEK).setVisibility(8);
      BackupPcChooseUI.c(this.jEK).setVisibility(0);
      switch (BackupPcChooseUI.access$100())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(17578);
        return;
        BackupPcChooseUI.c(this.jEK).setText(2131297309);
        AppMethodBeat.o(17578);
        return;
        BackupPcChooseUI.c(this.jEK).setText(2131297379);
      }
    }
    BackupPcChooseUI.d(this.jEK).setClickable(true);
    BackupPcChooseUI.d(this.jEK).setTextColor(this.jEK.getResources().getColor(2131689739));
    BackupPcChooseUI.b(this.jEK).setVisibility(8);
    BackupPcChooseUI.a(this.jEK).notifyDataSetChanged();
    AppMethodBeat.o(17578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.5
 * JD-Core Version:    0.7.0.1
 */