package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class d$b$d
{
  public int efP = 0;
  public String efQ;
  public String efR;
  public String efS;
  public String efT;
  
  public static d kN(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    y.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
    d locald = new d();
    try
    {
      paramString = new JSONObject(paramString);
      locald.efP = paramString.optInt("Type");
      locald.efQ = paramString.optString("Description");
      locald.efR = paramString.optString("Name");
      locald.efS = paramString.optString("IntroUrl");
      locald.efT = paramString.optString("VerifySubTitle");
      y.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locald.efP), locald.efQ, locald.efR, locald.efS });
      return locald;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.d
 * JD-Core Version:    0.7.0.1
 */