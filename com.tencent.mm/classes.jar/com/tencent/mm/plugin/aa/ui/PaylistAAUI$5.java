package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$5
  implements d.a
{
  PaylistAAUI$5(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aE(Object paramObject)
  {
    if (PaylistAAUI.d(this.eZM) != null) {
      PaylistAAUI.d(this.eZM).dismiss();
    }
    if (((paramObject instanceof String)) && (!paramObject.toString().equalsIgnoreCase("ok"))) {
      Toast.makeText(this.eZM, paramObject.toString(), 1).show();
    }
    for (;;)
    {
      y.e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
      return;
      Toast.makeText(this.eZM, a.i.urge_aa_failed, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.5
 * JD-Core Version:    0.7.0.1
 */