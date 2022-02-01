package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static final String a(String paramString, int paramInt, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(163913);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("data", paramJSONArray);
      label37:
      paramString = localJSONObject.toString();
      AppMethodBeat.o(163913);
      return paramString;
    }
    catch (Exception paramString)
    {
      break label37;
    }
  }
  
  public static final String a(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(163912);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("data", paramJSONObject);
      label37:
      paramString = localJSONObject.toString();
      AppMethodBeat.o(163912);
      return paramString;
    }
    catch (Exception paramString)
    {
      break label37;
    }
  }
  
  public static final void a(Object paramObject, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(163914);
    f.a(paramObject, paramJSONObject);
    AppMethodBeat.o(163914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.a
 * JD-Core Version:    0.7.0.1
 */