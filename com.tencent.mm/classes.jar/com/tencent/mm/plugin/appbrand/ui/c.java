package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
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
  
  protected final void buX()
  {
    AppMethodBeat.i(187020);
    super.buX();
    a(getContext().getString(2131755293), a.n(getContext(), 2131099726), "white", a.n(getContext(), 2131101179));
    setBackgroundResource(2131099726);
    AppMethodBeat.o(187020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */