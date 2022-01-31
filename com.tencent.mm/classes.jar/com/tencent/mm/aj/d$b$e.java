package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d$b$e
{
  public int fvW;
  public String fvX;
  public List<String> fvY;
  public String fvZ;
  
  public static e rI(String paramString)
  {
    AppMethodBeat.i(11276);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11276);
      return null;
    }
    try
    {
      e locale = new e();
      paramString = new JSONObject(paramString);
      locale.fvW = paramString.optInt("reputation_level", -1);
      locale.fvX = paramString.optString("scope_of_business");
      locale.fvZ = paramString.optString("guarantee_detail_h5_url");
      paramString = paramString.optJSONArray("guarantee_info");
      if (paramString != null)
      {
        int j = paramString.length();
        if (j > 0)
        {
          locale.fvY = new ArrayList();
          int i = 0;
          while (i < j)
          {
            String str = paramString.getString(i);
            if (!bo.isNullOrNil(str)) {
              locale.fvY.add(str);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(11276);
      return locale;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(11276);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.e
 * JD-Core Version:    0.7.0.1
 */