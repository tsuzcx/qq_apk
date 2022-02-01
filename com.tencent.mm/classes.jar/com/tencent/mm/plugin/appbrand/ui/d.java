package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.w;

final class d
  extends j
{
  public d(Context paramContext, w paramw, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext, paramw, paramWxaVersionInfo);
  }
  
  protected final void cKP()
  {
    AppMethodBeat.i(322109);
    super.cKP();
    b(getContext().getString(a.g.app_brand_action_plugin_splash_loading), a.w(getContext(), a.a.Dark_0), "white", a.w(getContext(), a.a.white));
    setBackgroundResource(a.a.Dark_0);
    AppMethodBeat.o(322109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */