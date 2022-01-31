package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$5
  implements d.a
{
  PaylistAAUI$5(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(40869);
    this.grF.hideLoading();
    if (((paramObject instanceof String)) && (!paramObject.toString().equalsIgnoreCase("ok"))) {
      Toast.makeText(this.grF, paramObject.toString(), 1).show();
    }
    for (;;)
    {
      ab.e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
      AppMethodBeat.o(40869);
      return;
      Toast.makeText(this.grF, 2131304452, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.5
 * JD-Core Version:    0.7.0.1
 */