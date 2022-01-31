package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class AppBrandIDCardVerifyPwdFrag$2
  implements View.OnClickListener
{
  AppBrandIDCardVerifyPwdFrag$2(AppBrandIDCardVerifyPwdFrag paramAppBrandIDCardVerifyPwdFrag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133252);
    if (AppBrandIDCardVerifyPwdFrag.a(this.iQF) != null) {
      AppBrandIDCardVerifyPwdFrag.a(this.iQF).aMD();
    }
    paramView = new d(this.iQF.getContext(), 1, false);
    paramView.sao = new AppBrandIDCardVerifyPwdFrag.2.1(this);
    paramView.sap = new AppBrandIDCardVerifyPwdFrag.2.2(this);
    paramView.crd();
    AppMethodBeat.o(133252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.2
 * JD-Core Version:    0.7.0.1
 */