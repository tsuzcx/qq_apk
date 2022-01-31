package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$9
  implements d.a
{
  PaylistAAUI$9(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aE(Object paramObject)
  {
    y.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", new Object[] { paramObject });
    PaylistAAUI localPaylistAAUI = this.eZM;
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString())
    {
      PaylistAAUI.a(localPaylistAAUI, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.9
 * JD-Core Version:    0.7.0.1
 */