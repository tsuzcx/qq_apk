package com.tencent.luggage.game.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends s
{
  static final int CTRL_INDEX = 78;
  static final String NAME = "onKeyboardInput";
  
  public final void a(String paramString, y paramy)
  {
    AppMethodBeat.i(130608);
    if (!paramy.isRunning())
    {
      AppMethodBeat.o(130608);
      return;
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", paramString);
    K(localHashMap).h(paramy).cpV();
    AppMethodBeat.o(130608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.d
 * JD-Core Version:    0.7.0.1
 */