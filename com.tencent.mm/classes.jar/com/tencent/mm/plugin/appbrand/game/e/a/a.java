package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends p
{
  public static final int CTRL_INDEX = 667;
  public static final String NAME = "onGameRecorderStateChange";
  
  final void d(r paramr)
  {
    AppMethodBeat.i(45136);
    g(paramr);
    ae.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch pause");
    paramr = new HashMap(1);
    paramr.put("state", "pause");
    H(paramr).bja();
    AppMethodBeat.o(45136);
  }
  
  final void e(r paramr)
  {
    AppMethodBeat.i(45137);
    g(paramr);
    ae.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch resume");
    paramr = new HashMap(1);
    paramr.put("state", "resume");
    H(paramr).bja();
    AppMethodBeat.o(45137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.a
 * JD-Core Version:    0.7.0.1
 */