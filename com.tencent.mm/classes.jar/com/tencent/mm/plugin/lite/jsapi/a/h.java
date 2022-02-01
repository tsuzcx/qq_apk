package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.jsapi.b;
import org.json.JSONObject;

public class h
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(233563);
    LiteAppCenter.onEventTriggered("testEvent", "{data: 'test data'}");
    AppMethodBeat.o(233563);
  }
  
  public final int ewF()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.h
 * JD-Core Version:    0.7.0.1
 */