package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class d$b$d
{
  public int fvR = 0;
  public String fvS;
  public String fvT;
  public String fvU;
  public String fvV;
  
  public static d rH(String paramString)
  {
    AppMethodBeat.i(11275);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11275);
      return null;
    }
    ab.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
    d locald = new d();
    try
    {
      paramString = new JSONObject(paramString);
      locald.fvR = paramString.optInt("Type");
      locald.fvS = paramString.optString("Description");
      locald.fvT = paramString.optString("Name");
      locald.fvU = paramString.optString("IntroUrl");
      locald.fvV = paramString.optString("VerifySubTitle");
      ab.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locald.fvR), locald.fvS, locald.fvT, locald.fvU });
      AppMethodBeat.o(11275);
      return locald;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.d
 * JD-Core Version:    0.7.0.1
 */