package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.a;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.ui.MMWizardActivity;

final class BackupPcUI$3$9
  implements View.OnClickListener
{
  BackupPcUI$3$9(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.hLn.hLm, BackupPcChooseUI.class);
    MMWizardActivity.C(this.hLn.hLm, paramView);
    b.auw().auA().cancel();
    b.auw().auA().auv();
    b.auw().auA().ee(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.9
 * JD-Core Version:    0.7.0.1
 */