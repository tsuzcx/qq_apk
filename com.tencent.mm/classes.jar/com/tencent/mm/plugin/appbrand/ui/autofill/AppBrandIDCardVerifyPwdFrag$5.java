package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class AppBrandIDCardVerifyPwdFrag$5
  implements View.OnClickListener
{
  AppBrandIDCardVerifyPwdFrag$5(AppBrandIDCardVerifyPwdFrag paramAppBrandIDCardVerifyPwdFrag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133257);
    ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
    if (AppBrandIDCardVerifyPwdFrag.a(this.iQF) != null) {
      AppBrandIDCardVerifyPwdFrag.a(this.iQF).a(AppBrandIDCardVerifyPwdFrag.e(this.iQF).getText().toString(), AppBrandIDCardVerifyPwdFrag.d(this.iQF));
    }
    AppMethodBeat.o(133257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.5
 * JD-Core Version:    0.7.0.1
 */