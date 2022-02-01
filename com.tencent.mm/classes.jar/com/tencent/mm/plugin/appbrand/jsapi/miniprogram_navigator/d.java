package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.q;

public final class d
  extends y<q>
{
  static final int CTRL_INDEX = 191;
  public static final String NAME = "exitMiniProgram";
  
  public final String n(q paramq)
  {
    AppMethodBeat.i(147178);
    paramq.getRuntime().finish();
    paramq = e("ok", null);
    AppMethodBeat.o(147178);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d
 * JD-Core Version:    0.7.0.1
 */