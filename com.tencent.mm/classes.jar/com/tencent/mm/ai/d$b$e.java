package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d$b$e
{
  public int efU;
  public String efV;
  public List<String> efW;
  public String efX;
  
  public static e kO(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      e locale = new e();
      paramString = new JSONObject(paramString);
      locale.efU = paramString.optInt("reputation_level", -1);
      locale.efV = paramString.optString("scope_of_business");
      locale.efX = paramString.optString("guarantee_detail_h5_url");
      paramString = paramString.optJSONArray("guarantee_info");
      if (paramString != null)
      {
        int j = paramString.length();
        if (j > 0)
        {
          locale.efW = new ArrayList();
          int i = 0;
          while (i < j)
          {
            String str = paramString.getString(i);
            if (!bk.bl(str)) {
              locale.efW.add(str);
            }
            i += 1;
          }
        }
      }
      return locale;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.e
 * JD-Core Version:    0.7.0.1
 */