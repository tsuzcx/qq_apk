package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class AppBrandIDCardVerifyPwdFrag$3$1
  implements DialogInterface.OnClickListener
{
  AppBrandIDCardVerifyPwdFrag$3$1(AppBrandIDCardVerifyPwdFrag.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(133253);
    AppBrandIDCardVerifyPwdFrag.e(this.iQH.iQF).dDR();
    ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
    if (AppBrandIDCardVerifyPwdFrag.a(this.iQH.iQF) != null) {
      AppBrandIDCardVerifyPwdFrag.a(this.iQH.iQF).a(AppBrandIDCardVerifyPwdFrag.d(this.iQH.iQF));
    }
    AppMethodBeat.o(133253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.3.1
 * JD-Core Version:    0.7.0.1
 */