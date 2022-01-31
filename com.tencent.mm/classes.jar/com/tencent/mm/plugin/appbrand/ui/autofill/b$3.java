package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.ui.base.h;

final class b$3
  implements View.OnClickListener
{
  b$3(b paramb) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.hfr.getContext(), this.hfr.getString(y.j.app_brand_idcard_verify_sms_msg) + b.d(this.hfr).syC, this.hfr.getString(y.j.app_brand_idcard_verify_sms_confirm_phone), this.hfr.getString(y.j.app_ok), this.hfr.getString(y.j.app_cancel), false, new b.3.1(this), new b.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b.3
 * JD-Core Version:    0.7.0.1
 */