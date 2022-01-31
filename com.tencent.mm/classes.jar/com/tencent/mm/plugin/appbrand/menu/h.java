package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class h
  extends a
{
  h()
  {
    super(r.iqY.ordinal());
    AppMethodBeat.i(132211);
    AppMethodBeat.o(132211);
  }
  
  public final void a(Context paramContext, v paramv, l paraml, String paramString)
  {
    AppMethodBeat.i(132212);
    if (bp.dud()) {
      paraml.a(this.irp, paramContext.getResources().getColor(2131690393), paramContext.getString(2131296585));
    }
    AppMethodBeat.o(132212);
  }
  
  public final void a(Context paramContext, v paramv, String paramString, q paramq)
  {
    AppMethodBeat.i(132213);
    paramContext = new d();
    paramq = paramv.ws();
    new JSONObject();
    paramContext.h(paramq);
    e.a(paramString, paramv.hzM, 10, "", bo.aox(), 1, 0);
    AppMethodBeat.o(132213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.h
 * JD-Core Version:    0.7.0.1
 */