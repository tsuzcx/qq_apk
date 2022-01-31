package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backuppcmodel.a;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.ui.MMWizardActivity;

final class BackupPcUI$3$9
  implements View.OnClickListener
{
  BackupPcUI$3$9(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17602);
    paramView = new Intent(this.jEQ.jEP, BackupPcChooseUI.class);
    MMWizardActivity.J(this.jEQ.jEP, paramView);
    b.aTX().aUb().cancel();
    b.aTX().aUb().aTW();
    b.aTX().aUb().fB(false);
    AppMethodBeat.o(17602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.9
 * JD-Core Version:    0.7.0.1
 */