package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.ga;
import java.util.LinkedList;

final class AppBrandIDCardShowFrag$7
  implements View.OnClickListener
{
  AppBrandIDCardShowFrag$7(AppBrandIDCardShowFrag paramAppBrandIDCardShowFrag, ccl paramccl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133208);
    if (AppBrandIDCardShowFrag.a(this.iQn) != null) {
      AppBrandIDCardShowFrag.a(this.iQn).Fg(((ga)this.iQo.xMX.get(1)).url);
    }
    AppMethodBeat.o(133208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.7
 * JD-Core Version:    0.7.0.1
 */