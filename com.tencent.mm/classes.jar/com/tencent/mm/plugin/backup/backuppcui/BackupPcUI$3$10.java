package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.c.a;

final class BackupPcUI$3$10
  implements View.OnClickListener
{
  BackupPcUI$3$10(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    b.auw().atT().stop();
    b.auw().auy().cancel(true);
    b.auw().atn().hFu = -100;
    BackupPcUI.g(this.hLn.hLm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.10
 * JD-Core Version:    0.7.0.1
 */