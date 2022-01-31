package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$c$a
{
  public long appid = 0L;
  public String efK;
  public String efL;
  public int efM;
  public String efN;
  public String efO;
  
  public static a kM(String paramString)
  {
    y.i("MicroMsg.BizInfo", "EnterpriseBizInfo = " + paramString);
    a locala = new a();
    if ((paramString == null) || (paramString.length() <= 0)) {
      return locala;
    }
    try
    {
      paramString = new JSONObject(paramString);
      locala.efK = paramString.optString("belong");
      locala.efL = paramString.optString("freeze_wording");
      locala.efM = paramString.optInt("child_type");
      locala.efN = paramString.optString("home_url");
      paramString = paramString.optString("exattr");
      if (bk.bl(paramString))
      {
        locala.efO = null;
        return locala;
      }
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramString) });
      return locala;
    }
    paramString = new JSONObject(paramString);
    locala.efO = paramString.optString("chat_extension_url");
    locala.appid = paramString.optLong("app_id");
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.c.a
 * JD-Core Version:    0.7.0.1
 */