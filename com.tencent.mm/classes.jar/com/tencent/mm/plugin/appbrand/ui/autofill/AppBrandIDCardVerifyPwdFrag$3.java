package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.ui.base.h;

final class AppBrandIDCardVerifyPwdFrag$3
  implements View.OnClickListener
{
  AppBrandIDCardVerifyPwdFrag$3(AppBrandIDCardVerifyPwdFrag paramAppBrandIDCardVerifyPwdFrag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133255);
    h.a(this.iQF.getContext(), this.iQF.getString(2131296691) + AppBrandIDCardVerifyPwdFrag.d(this.iQF).wsk, this.iQF.getString(2131296686), this.iQF.getString(2131297018), this.iQF.getString(2131296888), false, new AppBrandIDCardVerifyPwdFrag.3.1(this), new AppBrandIDCardVerifyPwdFrag.3.2(this));
    AppMethodBeat.o(133255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.3
 * JD-Core Version:    0.7.0.1
 */