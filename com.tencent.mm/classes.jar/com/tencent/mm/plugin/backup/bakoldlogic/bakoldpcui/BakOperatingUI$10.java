package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMWizardActivity;

final class BakOperatingUI$10
  implements Runnable
{
  BakOperatingUI$10(BakOperatingUI paramBakOperatingUI) {}
  
  public final void run()
  {
    if (6 == BakOperatingUI.j(this.hPc)) {
      BakOperatingUI.m(this.hPc).post(new BakOperatingUI.10.1(this));
    }
    while (1 != BakOperatingUI.j(this.hPc)) {
      return;
    }
    Intent localIntent = new Intent(this.hPc, BakFinishUI.class);
    localIntent.putExtra("cmd", BakOperatingUI.j(this.hPc));
    MMWizardActivity.C(this.hPc, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.10
 * JD-Core Version:    0.7.0.1
 */