package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$b$b
{
  public int cRM;
  public int cRN;
  public int cRO;
  
  public static b eF(String paramString)
  {
    AppMethodBeat.i(116357);
    ae.i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(paramString)));
    b localb = new b();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(116357);
      return localb;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localb.cRM = paramString.optInt("hardware_flag");
      localb.cRN = paramString.optInt("connect_status_display_mode");
      localb.cRO = paramString.optInt("special_internal_brand_type");
      AppMethodBeat.o(116357);
      return localb;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bu.o(paramString) });
      }
    }
  }
  
  public final boolean KY()
  {
    return (this.cRM & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.b
 * JD-Core Version:    0.7.0.1
 */