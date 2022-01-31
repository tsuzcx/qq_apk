package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends p
{
  public static final int CTRL_INDEX = 667;
  public static final String NAME = "onGameRecorderStateChange";
  
  final void d(r paramr)
  {
    AppMethodBeat.i(143150);
    i(paramr);
    ab.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch pause");
    paramr = new HashMap(1);
    paramr.put("state", "pause");
    w(paramr).aBz();
    AppMethodBeat.o(143150);
  }
  
  final void e(r paramr)
  {
    AppMethodBeat.i(143151);
    i(paramr);
    ab.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch resume");
    paramr = new HashMap(1);
    paramr.put("state", "resume");
    w(paramr).aBz();
    AppMethodBeat.o(143151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.a
 * JD-Core Version:    0.7.0.1
 */