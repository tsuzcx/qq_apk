package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c$b$a
{
  public ArrayList<String> cRb;
  
  public static a ez(String paramString)
  {
    AppMethodBeat.i(116356);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116356);
      return null;
    }
    locala = new a();
    ad.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("origin_name_list");
      if (paramString != null)
      {
        locala.cRb = new ArrayList();
        int i = 0;
        while (i < paramString.length())
        {
          locala.cRb.add(paramString.optString(i));
          i += 1;
        }
      }
      return locala;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(116356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.a
 * JD-Core Version:    0.7.0.1
 */