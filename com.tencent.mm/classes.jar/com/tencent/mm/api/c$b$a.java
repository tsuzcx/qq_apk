package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c$b$a
{
  public ArrayList<String> cFW;
  
  public static a dD(String paramString)
  {
    AppMethodBeat.i(116356);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116356);
      return null;
    }
    locala = new a();
    ac.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("origin_name_list");
      if (paramString != null)
      {
        locala.cFW = new ArrayList();
        int i = 0;
        while (i < paramString.length())
        {
          locala.cFW.add(paramString.optString(i));
          i += 1;
        }
      }
      return locala;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(116356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.a
 * JD-Core Version:    0.7.0.1
 */