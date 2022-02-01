package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.luggage.l.a.a;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;

@SuppressLint({"ViewConstructor"})
final class e
  extends k
{
  public e(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext, paramAppBrandRuntime, paramWxaVersionInfo);
  }
  
  protected final void cjB()
  {
    AppMethodBeat.i(277390);
    super.cjB();
    b(getContext().getString(a.g.app_brand_action_plugin_splash_loading), a.w(getContext(), a.a.Dark_0), "white", a.w(getContext(), a.a.white));
    setBackgroundResource(a.a.Dark_0);
    AppMethodBeat.o(277390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */