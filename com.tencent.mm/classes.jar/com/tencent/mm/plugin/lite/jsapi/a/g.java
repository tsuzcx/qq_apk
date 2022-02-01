package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.jsapi.b;
import org.json.JSONObject;

public class g
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(198846);
    LiteAppCenter.onEventTriggered("testEvent", "{data: 'test data'}");
    AppMethodBeat.o(198846);
  }
  
  public final int dTw()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.g
 * JD-Core Version:    0.7.0.1
 */