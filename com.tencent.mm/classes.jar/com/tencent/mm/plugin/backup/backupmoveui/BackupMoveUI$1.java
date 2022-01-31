package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;

final class BackupMoveUI$1
  implements View.OnClickListener
{
  BackupMoveUI$1(BackupMoveUI paramBackupMoveUI) {}
  
  public final void onClick(View paramView)
  {
    b.atS().atT().stop();
    b.atS().atU().cancel(true);
    b.atS().atn().hFu = -100;
    BackupMoveUI.a(this.hJH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.1
 * JD-Core Version:    0.7.0.1
 */