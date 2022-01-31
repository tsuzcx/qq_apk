package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class ProfileInformationCache
{
  private static final ConcurrentHashMap<String, JSONObject> infoCache;
  
  static
  {
    AppMethodBeat.i(72475);
    infoCache = new ConcurrentHashMap();
    AppMethodBeat.o(72475);
  }
  
  public static JSONObject getProfileInformation(String paramString)
  {
    AppMethodBeat.i(72473);
    paramString = (JSONObject)infoCache.get(paramString);
    AppMethodBeat.o(72473);
    return paramString;
  }
  
  public static void putProfileInformation(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72474);
    infoCache.put(paramString, paramJSONObject);
    AppMethodBeat.o(72474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.ProfileInformationCache
 * JD-Core Version:    0.7.0.1
 */