package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$3
  implements d.a
{
  PaylistAAUI$3(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(40867);
    ab.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", new Object[] { paramObject });
    this.grF.hideLoading();
    if ((paramObject instanceof String))
    {
      Toast.makeText(this.grF, paramObject.toString(), 1).show();
      AppMethodBeat.o(40867);
      return;
    }
    Toast.makeText(this.grF, 2131298418, 1).show();
    AppMethodBeat.o(40867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.3
 * JD-Core Version:    0.7.0.1
 */