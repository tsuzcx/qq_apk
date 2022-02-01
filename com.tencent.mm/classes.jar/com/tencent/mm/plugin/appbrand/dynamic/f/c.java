package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.ac.b.c
{
  public String data;
  
  public c()
  {
    super("onDataPush");
  }
  
  c(int paramInt)
  {
    super("onDataPush", paramInt);
  }
  
  public final JSONObject aZh()
  {
    AppMethodBeat.i(121393);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", Util.nullAsNil(this.data));
      label27:
      AppMethodBeat.o(121393);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.c
 * JD-Core Version:    0.7.0.1
 */