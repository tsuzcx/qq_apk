package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;

final class BakOperatingUI$2
  implements Runnable
{
  BakOperatingUI$2(BakOperatingUI paramBakOperatingUI, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", new Object[] { Integer.valueOf(this.bEf) });
    if (this.bEf == 15)
    {
      BakOperatingUI.n(this.hPc);
      return;
    }
    Intent localIntent = new Intent(this.hPc, BakConnErrorUI.class);
    MMWizardActivity.C(this.hPc, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.2
 * JD-Core Version:    0.7.0.1
 */