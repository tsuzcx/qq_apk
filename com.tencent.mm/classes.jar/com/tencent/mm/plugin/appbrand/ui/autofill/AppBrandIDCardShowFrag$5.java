package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.ga;
import java.util.LinkedList;

final class AppBrandIDCardShowFrag$5
  implements View.OnClickListener
{
  AppBrandIDCardShowFrag$5(AppBrandIDCardShowFrag paramAppBrandIDCardShowFrag, ccl paramccl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133206);
    if (AppBrandIDCardShowFrag.a(this.iQn) != null) {
      AppBrandIDCardShowFrag.a(this.iQn).Ff(((ga)this.iQo.xMX.get(0)).url);
    }
    AppMethodBeat.o(133206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.5
 * JD-Core Version:    0.7.0.1
 */