package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$c
{
  public int fvK;
  public List<j> fvL = null;
  public int type;
  
  public static c rF(String paramString)
  {
    AppMethodBeat.i(11274);
    ab.i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(paramString)));
    c localc = new c();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(11274);
      return localc;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localc.fvK = paramString.optInt("update_time");
      localc.type = paramString.optInt("type", 0);
      localc.fvL = j.e(paramString.optJSONArray("button_list"));
      AppMethodBeat.o(11274);
      return localc;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.c
 * JD-Core Version:    0.7.0.1
 */