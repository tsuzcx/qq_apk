package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$15
  implements d.a
{
  PaylistAAUI$15(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aE(Object paramObject)
  {
    y.i("MicroMsg.PaylistAAUI", "aapay failed: %s", new Object[] { paramObject });
    if (PaylistAAUI.d(this.eZM) != null) {
      PaylistAAUI.d(this.eZM).dismiss();
    }
    if (paramObject != null)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        str1 = paramObject.bQZ;
        str2 = paramObject.lRE;
        str3 = paramObject.lRF;
        locala = new c.a(this.eZM);
        locala.aeA(str1);
        locala.aeD(str3).a(new PaylistAAUI.15.1(this, paramObject));
        locala.aeE(str2);
        locala.aoP().show();
      }
      while ((!(paramObject instanceof String)) || (paramObject.toString().equalsIgnoreCase("ok")))
      {
        String str1;
        String str2;
        String str3;
        c.a locala;
        return;
      }
      Toast.makeText(this.eZM, paramObject.toString(), 1).show();
      return;
    }
    Toast.makeText(this.eZM, this.eZM.getString(a.i.aa_pay_failed), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.15
 * JD-Core Version:    0.7.0.1
 */