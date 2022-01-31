package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class CollectCreateQRCodeUI$5
  implements DialogInterface.OnClickListener
{
  CollectCreateQRCodeUI$5(CollectCreateQRCodeUI paramCollectCreateQRCodeUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bk.bl(this.iKL.iHx))
    {
      y.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { this.iKL.iHx });
      e.l(this.iKI.mController.uMN, this.iKL.iHx, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.5
 * JD-Core Version:    0.7.0.1
 */