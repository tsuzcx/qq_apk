package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.b;
import java.util.LinkedList;

final class BackupMoveChooseUI$5
  implements b.b
{
  BackupMoveChooseUI$5(BackupMoveChooseUI paramBackupMoveChooseUI) {}
  
  public final void B(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17328);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(17328);
      return;
    }
    if (paramLinkedList.size() == 0)
    {
      BackupMoveChooseUI.b(this.jCN).setVisibility(8);
      BackupMoveChooseUI.c(this.jCN).setVisibility(0);
      switch (BackupMoveChooseUI.access$100())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(17328);
        return;
        BackupMoveChooseUI.c(this.jCN).setText(2131297231);
        AppMethodBeat.o(17328);
        return;
        BackupMoveChooseUI.c(this.jCN).setText(2131297379);
      }
    }
    BackupMoveChooseUI.d(this.jCN).setClickable(true);
    BackupMoveChooseUI.d(this.jCN).setTextColor(this.jCN.getResources().getColor(2131689739));
    BackupMoveChooseUI.b(this.jCN).setVisibility(8);
    BackupMoveChooseUI.a(this.jCN).notifyDataSetChanged();
    AppMethodBeat.o(17328);
  }
  
  public final void C(LinkedList<f.b> paramLinkedList) {}
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.5
 * JD-Core Version:    0.7.0.1
 */