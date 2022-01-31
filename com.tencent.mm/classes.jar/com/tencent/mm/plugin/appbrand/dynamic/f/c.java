package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.z.b.c
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
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(10912);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", bo.nullAsNil(this.data));
      label28:
      AppMethodBeat.o(10912);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.c
 * JD-Core Version:    0.7.0.1
 */