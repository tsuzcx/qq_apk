package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$c$a
{
  public long appid = 0L;
  public String fvM;
  public String fvN;
  public int fvO;
  public String fvP;
  public String fvQ;
  
  public static a rG(String paramString)
  {
    AppMethodBeat.i(11273);
    ab.i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(paramString)));
    a locala = new a();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(11273);
      return locala;
    }
    try
    {
      paramString = new JSONObject(paramString);
      locala.fvM = paramString.optString("belong");
      locala.fvN = paramString.optString("freeze_wording");
      locala.fvO = paramString.optInt("child_type");
      locala.fvP = paramString.optString("home_url");
      paramString = paramString.optString("exattr");
      if (bo.isNullOrNil(paramString)) {
        locala.fvQ = null;
      }
      for (;;)
      {
        AppMethodBeat.o(11273);
        return locala;
        paramString = new JSONObject(paramString);
        locala.fvQ = paramString.optString("chat_extension_url");
        locala.appid = paramString.optLong("app_id");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.c.a
 * JD-Core Version:    0.7.0.1
 */