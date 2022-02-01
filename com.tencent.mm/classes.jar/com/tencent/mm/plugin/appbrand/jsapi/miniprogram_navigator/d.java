package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;

public final class d
  extends ab<s>
{
  static final int CTRL_INDEX = 191;
  public static final String NAME = "exitMiniProgram";
  
  public final String p(s params)
  {
    AppMethodBeat.i(147178);
    params.getRuntime().finish();
    params = h("ok", null);
    AppMethodBeat.o(147178);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d
 * JD-Core Version:    0.7.0.1
 */