package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d$b$a
{
  public ArrayList<String> fvG;
  
  public static a rD(String paramString)
  {
    AppMethodBeat.i(11271);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11271);
      return null;
    }
    locala = new a();
    ab.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("origin_name_list");
      if (paramString != null)
      {
        locala.fvG = new ArrayList();
        int i = 0;
        while (i < paramString.length())
        {
          locala.fvG.add(paramString.optString(i));
          i += 1;
        }
      }
      return locala;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(11271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.a
 * JD-Core Version:    0.7.0.1
 */