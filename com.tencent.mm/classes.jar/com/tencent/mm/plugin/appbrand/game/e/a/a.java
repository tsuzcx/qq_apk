package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends s
{
  public static final int CTRL_INDEX = 667;
  public static final String NAME = "onGameRecorderStateChange";
  
  public final void a(y paramy, int paramInt, String paramString)
  {
    AppMethodBeat.i(318380);
    h(paramy);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramy = new HashMap(3);
    paramy.put("state", "error");
    paramy.put("errCode", Integer.valueOf(paramInt));
    paramy.put("errMsg", paramString);
    K(paramy).cpV();
    AppMethodBeat.o(318380);
  }
  
  final void f(y paramy)
  {
    AppMethodBeat.i(45136);
    h(paramy);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch pause");
    paramy = new HashMap(1);
    paramy.put("state", "pause");
    K(paramy).cpV();
    AppMethodBeat.o(45136);
  }
  
  final void g(y paramy)
  {
    AppMethodBeat.i(45137);
    h(paramy);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch resume");
    paramy = new HashMap(1);
    paramy.put("state", "resume");
    K(paramy).cpV();
    AppMethodBeat.o(45137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.a
 * JD-Core Version:    0.7.0.1
 */