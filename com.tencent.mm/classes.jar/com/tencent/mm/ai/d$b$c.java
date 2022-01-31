package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$c
{
  public int efI;
  public List<j> efJ = null;
  public int type;
  
  public static c kL(String paramString)
  {
    y.i("MicroMsg.BizInfo", "MenuInfo = " + paramString);
    c localc = new c();
    if ((paramString == null) || (paramString.length() <= 0)) {
      return localc;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localc.efI = paramString.optInt("update_time");
      localc.type = paramString.optInt("type", 0);
      localc.efJ = j.d(paramString.optJSONArray("button_list"));
      return localc;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.c
 * JD-Core Version:    0.7.0.1
 */