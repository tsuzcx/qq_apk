package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;

final class BakFinishUI$3
  implements Runnable
{
  BakFinishUI$3(BakFinishUI paramBakFinishUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(17923);
    ab.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
    Intent localIntent = new Intent(this.jIv, BakConnErrorUI.class);
    MMWizardActivity.J(this.jIv, localIntent);
    AppMethodBeat.o(17923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI.3
 * JD-Core Version:    0.7.0.1
 */