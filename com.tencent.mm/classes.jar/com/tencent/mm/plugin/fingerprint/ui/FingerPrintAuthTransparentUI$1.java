package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class FingerPrintAuthTransparentUI$1
  implements c
{
  FingerPrintAuthTransparentUI$1(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void aR(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
      FingerPrintAuthTransparentUI.a(this.kma, paramInt2);
      FingerPrintAuthTransparentUI.a(this.kma);
      return;
    case 2002: 
      y.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
      FingerPrintAuthTransparentUI.b(this.kma);
      FingerPrintAuthTransparentUI.a(this.kma, true);
      return;
    case 2001: 
      y.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
      return;
    case 2005: 
    case 2007: 
    case 10308: 
      y.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
      str = ae.getContext().getString(a.i.soter_on_error_common);
      if (paramInt1 == 10308)
      {
        str = ae.getContext().getString(a.i.soter_on_error_max_trial);
        a.c(6, -1000223, -1, "too many trial");
      }
      for (;;)
      {
        FingerPrintAuthTransparentUI.a(this.kma, str);
        return;
        a.c(1000, -1000223, paramInt1, "fingerprint error");
      }
    }
    y.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
    String str = ae.getContext().getString(a.i.soter_on_error_common);
    a.c(1000, -1000223, paramInt1, "fingerprint error");
    a.zk(2);
    FingerPrintAuthTransparentUI.a(this.kma, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */