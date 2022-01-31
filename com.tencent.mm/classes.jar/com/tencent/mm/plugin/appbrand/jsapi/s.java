package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends p
{
  private static final int CTRL_INDEX = 248;
  private static final String NAME = "onUserCaptureScreen";
  private static s hxg;
  
  static
  {
    AppMethodBeat.i(86965);
    hxg = new s();
    AppMethodBeat.o(86965);
  }
  
  public static void k(c paramc)
  {
    AppMethodBeat.i(86964);
    ab.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramc.getAppId() });
    hxg.i(paramc).aBz();
    AppMethodBeat.o(86964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s
 * JD-Core Version:    0.7.0.1
 */