package com.tencent.luggage.game.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  static final int CTRL_INDEX = -2;
  static final String NAME = "onKeyboardConfirm";
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.s params)
  {
    AppMethodBeat.i(130607);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", paramString);
    K(localHashMap).g(params).bEo();
    AppMethodBeat.o(130607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.b
 * JD-Core Version:    0.7.0.1
 */