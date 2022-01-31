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
    AppMethodBeat.i(17944);
    Intent localIntent = new Intent(this.jIE, BakFinishUI.class);
    localIntent.putExtra("cmd", BakOperatingUI.j(this.jIE));
    MMWizardActivity.J(this.jIE, localIntent);
    AppMethodBeat.o(17944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.11
 * JD-Core Version:    0.7.0.1
 */