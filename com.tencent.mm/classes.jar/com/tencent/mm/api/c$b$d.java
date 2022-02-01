package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class c$b$d
{
  public String cJa;
  
  public static d dS(String paramString)
  {
    AppMethodBeat.i(116360);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116360);
      return null;
    }
    ad.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
    d locald = new d();
    try
    {
      locald.cJa = new JSONObject(paramString).optString("VerifyDesc");
      ad.i("MicroMsg.BizInfo", "desc[%s]", new Object[] { locald.cJa });
      AppMethodBeat.o(116360);
      return locald;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.m(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.d
 * JD-Core Version:    0.7.0.1
 */