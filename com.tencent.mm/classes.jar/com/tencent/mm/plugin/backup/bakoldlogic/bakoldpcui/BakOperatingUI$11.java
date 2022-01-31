package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

final class BakOperatingUI$11
  implements Runnable
{
  BakOperatingUI$11(BakOperatingUI paramBakOperatingUI) {}
  
  public final void run()
  {
    Intent localIntent = new Intent(this.hPc, BakFinishUI.class);
    localIntent.putExtra("cmd", BakOperatingUI.j(this.hPc));
    MMWizardActivity.C(this.hPc, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.11
 * JD-Core Version:    0.7.0.1
 */