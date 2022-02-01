package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$b$b
{
  public int cFX;
  public int cFY;
  public int cFZ;
  
  public static b dE(String paramString)
  {
    AppMethodBeat.i(116357);
    ac.i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(paramString)));
    b localb = new b();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(116357);
      return localb;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localb.cFX = paramString.optInt("hardware_flag");
      localb.cFY = paramString.optInt("connect_status_display_mode");
      localb.cFZ = paramString.optInt("special_internal_brand_type");
      AppMethodBeat.o(116357);
      return localb;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
      }
    }
  }
  
  public final boolean Jr()
  {
    return (this.cFX & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.b
 * JD-Core Version:    0.7.0.1
 */