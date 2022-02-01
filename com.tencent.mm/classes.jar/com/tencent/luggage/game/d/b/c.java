package com.tencent.luggage.game.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.v;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends r
{
  static final int CTRL_INDEX = -2;
  static final String NAME = "onKeyboardConfirm";
  
  public final void a(String paramString, v paramv)
  {
    AppMethodBeat.i(130607);
    if (!paramv.isRunning())
    {
      AppMethodBeat.o(130607);
      return;
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", paramString);
    D(localHashMap).i(paramv).bPO();
    AppMethodBeat.o(130607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.c
 * JD-Core Version:    0.7.0.1
 */