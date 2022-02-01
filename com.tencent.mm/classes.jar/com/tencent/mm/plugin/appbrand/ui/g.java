package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;

@SuppressLint({"ViewConstructor"})
final class g
  extends m
{
  public g(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext, paramAppBrandRuntime, paramWxaVersionInfo);
  }
  
  protected final void bWX()
  {
    AppMethodBeat.i(227599);
    super.bWX();
    b(getContext().getString(2131755329), a.n(getContext(), 2131099740), "white", a.n(getContext(), 2131101424));
    setBackgroundResource(2131099740);
    AppMethodBeat.o(227599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */