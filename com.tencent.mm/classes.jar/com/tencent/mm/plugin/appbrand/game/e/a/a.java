package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends p
{
  public static final int CTRL_INDEX = 667;
  public static final String NAME = "onGameRecorderStateChange";
  
  final void d(q paramq)
  {
    AppMethodBeat.i(45136);
    g(paramq);
    ac.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch pause");
    paramq = new HashMap(1);
    paramq.put("state", "pause");
    A(paramq).beN();
    AppMethodBeat.o(45136);
  }
  
  final void e(q paramq)
  {
    AppMethodBeat.i(45137);
    g(paramq);
    ac.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch resume");
    paramq = new HashMap(1);
    paramq.put("state", "resume");
    A(paramq).beN();
    AppMethodBeat.o(45137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.a
 * JD-Core Version:    0.7.0.1
 */