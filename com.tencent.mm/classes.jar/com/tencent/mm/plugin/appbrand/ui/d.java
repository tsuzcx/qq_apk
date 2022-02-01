package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;

@SuppressLint({"ViewConstructor"})
final class d
  extends j
{
  public d(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext, paramAppBrandRuntime, paramWxaVersionInfo);
  }
  
  protected final void bze()
  {
    AppMethodBeat.i(188852);
    super.bze();
    b(getContext().getString(2131755293), a.n(getContext(), 2131099726), "white", a.n(getContext(), 2131101179));
    setBackgroundResource(2131099726);
    AppMethodBeat.o(188852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */