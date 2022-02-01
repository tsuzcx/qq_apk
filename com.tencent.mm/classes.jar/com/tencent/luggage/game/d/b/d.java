package com.tencent.luggage.game.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.v;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends r
{
  static final int CTRL_INDEX = 78;
  static final String NAME = "onKeyboardInput";
  
  public final void a(String paramString, v paramv)
  {
    AppMethodBeat.i(130608);
    if (!paramv.isRunning())
    {
      AppMethodBeat.o(130608);
      return;
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", paramString);
    D(localHashMap).i(paramv).bPO();
    AppMethodBeat.o(130608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.d
 * JD-Core Version:    0.7.0.1
 */