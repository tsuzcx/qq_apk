package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$b
{
  public int fvH;
  public int fvI;
  public int fvJ;
  
  public static b rE(String paramString)
  {
    AppMethodBeat.i(11272);
    ab.i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(paramString)));
    b localb = new b();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(11272);
      return localb;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localb.fvH = paramString.optInt("hardware_flag");
      localb.fvI = paramString.optInt("connect_status_display_mode");
      localb.fvJ = paramString.optInt("special_internal_brand_type");
      AppMethodBeat.o(11272);
      return localb;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramString) });
      }
    }
  }
  
  public final boolean aeJ()
  {
    return (this.fvH & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.b
 * JD-Core Version:    0.7.0.1
 */