package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.ui.base.l;

public final class g
  extends a
{
  public g()
  {
    super(r.iqW.ordinal());
    AppMethodBeat.i(132208);
    AppMethodBeat.o(132208);
  }
  
  public final void a(Context paramContext, v paramv, l paraml, String paramString)
  {
    AppMethodBeat.i(132209);
    paramv = (AppBrandSysConfigWC)paramv.U(AppBrandSysConfigWC.class);
    if (paramv.hiX.gXe == 1) {
      if (!paramv.bDk) {
        break label58;
      }
    }
    label58:
    for (paramContext = paramContext.getString(2131296755);; paramContext = paramContext.getString(2131296762))
    {
      paraml.e(r.iqW.ordinal(), paramContext);
      AppMethodBeat.o(132209);
      return;
    }
  }
  
  public final void a(Context paramContext, v paramv, String paramString, q paramq)
  {
    AppMethodBeat.i(132210);
    if (!((AppBrandSysConfigWC)paramv.U(AppBrandSysConfigWC.class)).bDk) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppBrandPerformanceManager.Ev(paramString);
      Toast.makeText(paramContext, 2131296763, 0).show();
      AppMethodBeat.o(132210);
      return;
    }
    AppBrandPerformanceManager.Ew(paramString);
    Toast.makeText(paramContext, 2131296756, 0).show();
    AppMethodBeat.o(132210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.g
 * JD-Core Version:    0.7.0.1
 */