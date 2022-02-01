package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends r
{
  public static final int CTRL_INDEX = 667;
  public static final String NAME = "onGameRecorderStateChange";
  
  public final void a(v paramv, int paramInt, String paramString)
  {
    AppMethodBeat.i(283330);
    i(paramv);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramv = new HashMap(3);
    paramv.put("state", "error");
    paramv.put("errCode", Integer.valueOf(paramInt));
    paramv.put("errMsg", paramString);
    D(paramv).bPO();
    AppMethodBeat.o(283330);
  }
  
  final void e(v paramv)
  {
    AppMethodBeat.i(45136);
    i(paramv);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch pause");
    paramv = new HashMap(1);
    paramv.put("state", "pause");
    D(paramv).bPO();
    AppMethodBeat.o(45136);
  }
  
  final void f(v paramv)
  {
    AppMethodBeat.i(45137);
    i(paramv);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch resume");
    paramv = new HashMap(1);
    paramv.put("state", "resume");
    D(paramv).bPO();
    AppMethodBeat.o(45137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.a
 * JD-Core Version:    0.7.0.1
 */