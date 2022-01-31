package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class b$3$1
  implements DialogInterface.OnClickListener
{
  b$3$1(b.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.e(this.hft.hfr).cAG();
    y.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
    if (b.a(this.hft.hfr) != null) {
      b.a(this.hft.hfr).a(b.d(this.hft.hfr));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b.3.1
 * JD-Core Version:    0.7.0.1
 */