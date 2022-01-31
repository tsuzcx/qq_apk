package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d$b$a
{
  public ArrayList<String> efE;
  
  public static a kJ(String paramString)
  {
    if (bk.bl(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      locala = new a();
      y.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", new Object[] { paramString });
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).optJSONArray("origin_name_list");
        paramString = locala;
        if (localJSONArray == null) {
          continue;
        }
        locala.efE = new ArrayList();
        int i = 0;
        for (;;)
        {
          paramString = locala;
          if (i >= localJSONArray.length()) {
            break;
          }
          locala.efE.add(localJSONArray.optString(i));
          i += 1;
        }
        return locala;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.a
 * JD-Core Version:    0.7.0.1
 */