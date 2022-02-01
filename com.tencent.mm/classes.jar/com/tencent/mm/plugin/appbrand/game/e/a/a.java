package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  public static final int CTRL_INDEX = 667;
  public static final String NAME = "onGameRecorderStateChange";
  
  final void e(com.tencent.mm.plugin.appbrand.s params)
  {
    AppMethodBeat.i(45136);
    g(params);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch pause");
    params = new HashMap(1);
    params.put("state", "pause");
    K(params).bEo();
    AppMethodBeat.o(45136);
  }
  
  final void f(com.tencent.mm.plugin.appbrand.s params)
  {
    AppMethodBeat.i(45137);
    g(params);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch resume");
    params = new HashMap(1);
    params.put("state", "resume");
    K(params).bEo();
    AppMethodBeat.o(45137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.a
 * JD-Core Version:    0.7.0.1
 */