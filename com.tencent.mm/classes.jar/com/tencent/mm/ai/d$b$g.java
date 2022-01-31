package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$g
{
  public String efZ;
  public String ega;
  public boolean egb;
  
  public static g kP(String paramString)
  {
    y.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
    g localg = new g();
    if ((paramString == null) || (paramString.length() <= 0)) {
      return localg;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localg.efZ = paramString.optString("RegisterBody");
        localg.ega = paramString.optString("IntroUrl");
        if (paramString.optInt("IsClose", 0) == 1)
        {
          bool = true;
          localg.egb = bool;
          return localg;
        }
      }
      catch (JSONException paramString)
      {
        y.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { bk.j(paramString) });
        return localg;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.g
 * JD-Core Version:    0.7.0.1
 */