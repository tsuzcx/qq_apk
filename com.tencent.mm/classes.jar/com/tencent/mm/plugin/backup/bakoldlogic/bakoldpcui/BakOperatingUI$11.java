package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

final class BakOperatingUI$11
  implements Runnable
{
  BakOperatingUI$11(BakOperatingUI paramBakOperatingUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(22000);
    Intent localIntent = new Intent(this.nCt, BakFinishUI.class);
    localIntent.putExtra("cmd", BakOperatingUI.j(this.nCt));
    MMWizardActivity.al(this.nCt, localIntent);
    AppMethodBeat.o(22000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.11
 * JD-Core Version:    0.7.0.1
 */