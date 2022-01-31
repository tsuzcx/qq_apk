package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.sdk.platformtools.bo;

final class z$1
  implements View.OnClickListener
{
  z$1(z paramz) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(132375);
    e.a(this.ixG.getAppId(), this.ixG.hzM, 22, "", bo.aox(), 1, 0);
    AppMethodBeat.o(132375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.1
 * JD-Core Version:    0.7.0.1
 */