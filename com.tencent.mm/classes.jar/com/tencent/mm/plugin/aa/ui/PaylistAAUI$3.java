package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$3
  implements d.a
{
  PaylistAAUI$3(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aE(Object paramObject)
  {
    y.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", new Object[] { paramObject });
    if (PaylistAAUI.d(this.eZM) != null) {
      PaylistAAUI.d(this.eZM).dismiss();
    }
    if ((paramObject instanceof String))
    {
      Toast.makeText(this.eZM, paramObject.toString(), 1).show();
      return;
    }
    Toast.makeText(this.eZM, a.i.close_paylist_failed, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.3
 * JD-Core Version:    0.7.0.1
 */