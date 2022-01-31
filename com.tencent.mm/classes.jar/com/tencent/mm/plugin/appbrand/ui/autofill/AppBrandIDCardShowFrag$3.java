package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandIDCardShowFrag$3
  implements View.OnClickListener
{
  AppBrandIDCardShowFrag$3(AppBrandIDCardShowFrag paramAppBrandIDCardShowFrag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133204);
    ab.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
    if (AppBrandIDCardShowFrag.a(this.iQn) != null) {
      AppBrandIDCardShowFrag.a(this.iQn).aMC();
    }
    AppMethodBeat.o(133204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.3
 * JD-Core Version:    0.7.0.1
 */