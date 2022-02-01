package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;

final class BakOperatingUI$2
  implements Runnable
{
  BakOperatingUI$2(BakOperatingUI paramBakOperatingUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(21990);
    ad.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", new Object[] { Integer.valueOf(this.val$errType) });
    if (this.val$errType == 15)
    {
      BakOperatingUI.n(this.nCt);
      AppMethodBeat.o(21990);
      return;
    }
    Intent localIntent = new Intent(this.nCt, BakConnErrorUI.class);
    MMWizardActivity.al(this.nCt, localIntent);
    AppMethodBeat.o(21990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.2
 * JD-Core Version:    0.7.0.1
 */