package com.tencent.mm.plugin.lite.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.api.e;
import org.json.JSONObject;

public class m
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271584);
    LiteAppCenter.onEventTriggered("testEvent", "{data: 'test data'}");
    AppMethodBeat.o(271584);
  }
  
  public final int fEx()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.m
 * JD-Core Version:    0.7.0.1
 */