package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$g
{
  public String fwb;
  public String fwc;
  public boolean fwd;
  
  public static g rJ(String paramString)
  {
    AppMethodBeat.i(11278);
    ab.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
    g localg = new g();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(11278);
      return localg;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localg.fwb = paramString.optString("RegisterBody");
        localg.fwc = paramString.optString("IntroUrl");
        if (paramString.optInt("IsClose", 0) != 1) {
          continue;
        }
        bool = true;
        localg.fwd = bool;
      }
      catch (JSONException paramString)
      {
        boolean bool;
        ab.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { bo.l(paramString) });
        continue;
      }
      AppMethodBeat.o(11278);
      return localg;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.g
 * JD-Core Version:    0.7.0.1
 */