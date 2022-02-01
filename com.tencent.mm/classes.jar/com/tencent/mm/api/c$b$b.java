package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$b$b
{
  public int hdm;
  public int hdn;
  public int hdo;
  
  public static b hF(String paramString)
  {
    AppMethodBeat.i(116357);
    Log.i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(paramString)));
    b localb = new b();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(116357);
      return localb;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localb.hdm = paramString.optInt("hardware_flag");
      localb.hdn = paramString.optInt("connect_status_display_mode");
      localb.hdo = paramString.optInt("special_internal_brand_type");
      AppMethodBeat.o(116357);
      return localb;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.BizInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
  }
  
  public final boolean aBs()
  {
    return (this.hdm & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.b
 * JD-Core Version:    0.7.0.1
 */