package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$b$b
{
  public int cIQ;
  public int cIR;
  public int cIS;
  
  public static b dP(String paramString)
  {
    AppMethodBeat.i(116357);
    ad.i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(paramString)));
    b localb = new b();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(116357);
      return localb;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localb.cIQ = paramString.optInt("hardware_flag");
      localb.cIR = paramString.optInt("connect_status_display_mode");
      localb.cIS = paramString.optInt("special_internal_brand_type");
      AppMethodBeat.o(116357);
      return localb;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.m(paramString) });
      }
    }
  }
  
  public final boolean JI()
  {
    return (this.cIQ & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.b
 * JD-Core Version:    0.7.0.1
 */