package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class b
  extends com.tencent.mm.plugin.appbrand.menu.a.a
{
  b()
  {
    super(r.iqR.ordinal());
    AppMethodBeat.i(132193);
    AppMethodBeat.o(132193);
  }
  
  public final void a(Context paramContext, v paramv, l paraml, String paramString)
  {
    AppMethodBeat.i(132194);
    paramv = paramv.getRuntime().atj();
    if (((paramv instanceof s)) && (((s)paramv).iwS)) {
      paraml.e(this.irp, paramContext.getString(2131296586));
    }
    AppMethodBeat.o(132194);
  }
  
  public final void a(Context paramContext, v paramv, String paramString, q paramq)
  {
    AppMethodBeat.i(132195);
    paramv.getRuntime().atj().aq(paramv.getRuntime().getAppConfig().ayn(), true);
    if (paramv.iuy != null) {
      e.a(paramString, paramv.hzM, 20, "", bo.aox(), 1, 0);
    }
    AppMethodBeat.o(132195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b
 * JD-Core Version:    0.7.0.1
 */