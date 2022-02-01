package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;

@SuppressLint({"ViewConstructor"})
final class c
  extends i
{
  public c(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext, paramAppBrandRuntime, paramWxaVersionInfo);
  }
  
  protected final void bob()
  {
    AppMethodBeat.i(196175);
    super.bob();
    a(getContext().getString(2131755293), a.n(getContext(), 2131099726), "white", a.n(getContext(), 2131101179));
    setBackgroundResource(2131099726);
    AppMethodBeat.o(196175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */