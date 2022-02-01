package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$3
  implements d.a
{
  PaylistAAUI$3(PaylistAAUI paramPaylistAAUI) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(63712);
    ae.i("MicroMsg.Aa.PaylistAAUI", "close pay list failed: %s", new Object[] { paramObject });
    this.jaM.hideLoading();
    if ((paramObject instanceof String))
    {
      Toast.makeText(this.jaM, paramObject.toString(), 1).show();
      AppMethodBeat.o(63712);
      return;
    }
    Toast.makeText(this.jaM, 2131757430, 1).show();
    AppMethodBeat.o(63712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.3
 * JD-Core Version:    0.7.0.1
 */