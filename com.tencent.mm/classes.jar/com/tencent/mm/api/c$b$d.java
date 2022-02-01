package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class c$b$d
{
  public String cGh;
  
  public static d dH(String paramString)
  {
    AppMethodBeat.i(116360);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116360);
      return null;
    }
    ac.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
    d locald = new d();
    try
    {
      locald.cGh = new JSONObject(paramString).optString("VerifyDesc");
      ac.i("MicroMsg.BizInfo", "desc[%s]", new Object[] { locald.cGh });
      AppMethodBeat.o(116360);
      return locald;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.d
 * JD-Core Version:    0.7.0.1
 */