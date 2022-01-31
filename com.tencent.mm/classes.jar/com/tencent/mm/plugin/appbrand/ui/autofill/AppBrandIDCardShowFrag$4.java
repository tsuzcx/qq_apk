package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.ga;

final class AppBrandIDCardShowFrag$4
  implements View.OnClickListener
{
  AppBrandIDCardShowFrag$4(AppBrandIDCardShowFrag paramAppBrandIDCardShowFrag, ccl paramccl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133205);
    if (AppBrandIDCardShowFrag.a(this.iQn) != null) {
      AppBrandIDCardShowFrag.a(this.iQn).Fe(this.iQo.xMW.url);
    }
    AppMethodBeat.o(133205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.4
 * JD-Core Version:    0.7.0.1
 */