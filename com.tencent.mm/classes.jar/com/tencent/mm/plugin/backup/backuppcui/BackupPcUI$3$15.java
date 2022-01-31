package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.c.a;

final class BackupPcUI$3$15
  implements View.OnClickListener
{
  BackupPcUI$3$15(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17609);
    b.aTX().aTs().stop();
    b.aTX().aSL().jyN = -100;
    BackupPcUI.j(this.jEQ.jEP);
    AppMethodBeat.o(17609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.15
 * JD-Core Version:    0.7.0.1
 */