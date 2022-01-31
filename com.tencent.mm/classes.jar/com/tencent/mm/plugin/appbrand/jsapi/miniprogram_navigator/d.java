package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.r;

public final class d
  extends u<r>
{
  static final int CTRL_INDEX = 191;
  public static final String NAME = "exitMiniProgram";
  
  public final String h(r paramr)
  {
    AppMethodBeat.i(101979);
    paramr.getRuntime().finish();
    paramr = j("ok", null);
    AppMethodBeat.o(101979);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d
 * JD-Core Version:    0.7.0.1
 */