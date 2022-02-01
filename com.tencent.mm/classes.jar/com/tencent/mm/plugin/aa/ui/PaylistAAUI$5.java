package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$5
  implements d.a
{
  PaylistAAUI$5(PaylistAAUI paramPaylistAAUI) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(63714);
    this.jaM.hideLoading();
    if (((paramObject instanceof String)) && (!paramObject.toString().equalsIgnoreCase("ok"))) {
      Toast.makeText(this.jaM, paramObject.toString(), 1).show();
    }
    for (;;)
    {
      ae.e("MicroMsg.Aa.PaylistAAUI", "urgeAAPay fail");
      AppMethodBeat.o(63714);
      return;
      Toast.makeText(this.jaM, 2131764598, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.5
 * JD-Core Version:    0.7.0.1
 */