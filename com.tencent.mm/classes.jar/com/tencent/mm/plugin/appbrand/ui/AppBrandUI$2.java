package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.l;

final class AppBrandUI$2
  extends com.tencent.mm.plugin.appbrand.b.e
{
  AppBrandUI$2(AppBrandUI paramAppBrandUI, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final void awt()
  {
    AppMethodBeat.i(133118);
    i locali = AppBrandUI.b(this.iPh).atG();
    if (locali == null)
    {
      AppMethodBeat.o(133118);
      return;
    }
    com.tencent.mm.plugin.appbrand.e.a(locali.mAppId, e.d.gPi);
    AppMethodBeat.o(133118);
  }
  
  public final void awu()
  {
    AppMethodBeat.i(133119);
    i locali = AppBrandUI.b(this.iPh).atG();
    if (locali == null)
    {
      AppMethodBeat.o(133119);
      return;
    }
    com.tencent.mm.plugin.appbrand.e.a(locali.mAppId, e.d.gPj);
    AppMethodBeat.o(133119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.2
 * JD-Core Version:    0.7.0.1
 */