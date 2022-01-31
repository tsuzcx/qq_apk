package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class b$5
  implements View.OnClickListener
{
  b$5(b paramb) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
    if (b.a(this.hfr) != null) {
      b.a(this.hfr).a(b.e(this.hfr).getText().toString(), b.d(this.hfr));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b.5
 * JD-Core Version:    0.7.0.1
 */