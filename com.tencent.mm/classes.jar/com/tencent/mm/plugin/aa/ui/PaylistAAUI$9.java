package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$9
  implements d.a
{
  PaylistAAUI$9(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(40874);
    ab.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", new Object[] { paramObject });
    PaylistAAUI localPaylistAAUI = this.grF;
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString())
    {
      PaylistAAUI.a(localPaylistAAUI, paramObject);
      AppMethodBeat.o(40874);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.9
 * JD-Core Version:    0.7.0.1
 */