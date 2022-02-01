package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class ProfileInformationCache
{
  private static final ConcurrentHashMap<String, JSONObject> infoCache;
  
  static
  {
    AppMethodBeat.i(17911);
    infoCache = new ConcurrentHashMap();
    AppMethodBeat.o(17911);
  }
  
  public static JSONObject getProfileInformation(String paramString)
  {
    AppMethodBeat.i(17909);
    paramString = (JSONObject)infoCache.get(paramString);
    AppMethodBeat.o(17909);
    return paramString;
  }
  
  public static void putProfileInformation(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17910);
    infoCache.put(paramString, paramJSONObject);
    AppMethodBeat.o(17910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.ProfileInformationCache
 * JD-Core Version:    0.7.0.1
 */