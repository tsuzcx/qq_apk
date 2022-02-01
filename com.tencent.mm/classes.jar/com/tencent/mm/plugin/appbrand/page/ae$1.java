package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.bt;

final class ae$1
  implements View.OnClickListener
{
  ae$1(ae paramae) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47864);
    h.a(this.lbG.getAppId(), this.lbG.jzm, 22, "", bt.aGK(), 1, 0);
    AppMethodBeat.o(47864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.1
 * JD-Core Version:    0.7.0.1
 */