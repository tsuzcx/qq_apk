package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandIDCardShowFrag$1
  implements View.OnClickListener
{
  AppBrandIDCardShowFrag$1(AppBrandIDCardShowFrag paramAppBrandIDCardShowFrag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133202);
    if (AppBrandIDCardShowFrag.a(this.iQn) != null) {
      AppBrandIDCardShowFrag.a(this.iQn).back();
    }
    AppMethodBeat.o(133202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.1
 * JD-Core Version:    0.7.0.1
 */