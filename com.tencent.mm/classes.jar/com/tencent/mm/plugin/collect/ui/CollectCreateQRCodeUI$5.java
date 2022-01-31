package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class CollectCreateQRCodeUI$5
  implements DialogInterface.OnClickListener
{
  CollectCreateQRCodeUI$5(CollectCreateQRCodeUI paramCollectCreateQRCodeUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41237);
    if (!bo.isNullOrNil(this.kRq.kNB))
    {
      ab.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { this.kRq.kNB });
      e.m(this.kRn.getContext(), this.kRq.kNB, true);
    }
    AppMethodBeat.o(41237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.5
 * JD-Core Version:    0.7.0.1
 */