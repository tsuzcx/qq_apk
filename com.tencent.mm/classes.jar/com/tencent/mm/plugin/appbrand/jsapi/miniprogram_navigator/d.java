package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.r;

public final class d
  extends y<r>
{
  static final int CTRL_INDEX = 191;
  public static final String NAME = "exitMiniProgram";
  
  public final String n(r paramr)
  {
    AppMethodBeat.i(147178);
    paramr.getRuntime().finish();
    paramr = e("ok", null);
    AppMethodBeat.o(147178);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d
 * JD-Core Version:    0.7.0.1
 */