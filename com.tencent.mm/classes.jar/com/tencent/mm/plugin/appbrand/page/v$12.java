package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.i;

final class v$12
  implements View.OnClickListener
{
  v$12(v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141686);
    e.a(this.ixv.getAppId(), e.d.gPe);
    v.h(this.ixv).close();
    AppMethodBeat.o(141686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v.12
 * JD-Core Version:    0.7.0.1
 */