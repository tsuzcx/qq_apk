package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$b$h
{
  public String diA;
  public String diB;
  public boolean diC;
  public String diD;
  
  public static h fw(String paramString)
  {
    AppMethodBeat.i(116364);
    Log.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
    h localh = new h();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(116364);
      return localh;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localh.diA = paramString.optString("RegisterBody");
        localh.diB = paramString.optString("IntroUrl");
        if (paramString.optInt("IsClose", 0) != 1) {
          continue;
        }
        bool = true;
        localh.diC = bool;
        localh.diD = paramString.optString("AboutBizUrl");
      }
      catch (JSONException paramString)
      {
        boolean bool;
        Log.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { Util.stackTraceToString(paramString) });
        continue;
      }
      AppMethodBeat.o(116364);
      return localh;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.c.b.h
 * JD-Core Version:    0.7.0.1
 */