package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.y;

public final class d
  extends ab<y>
{
  static final int CTRL_INDEX = 191;
  public static final String NAME = "exitMiniProgram";
  
  public final String p(y paramy)
  {
    AppMethodBeat.i(147178);
    paramy.getRuntime().finish();
    paramy = ZP("ok");
    AppMethodBeat.o(147178);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d
 * JD-Core Version:    0.7.0.1
 */