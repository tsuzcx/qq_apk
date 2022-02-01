package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public String Title;
  public int cZW;
  public int cZX;
  public int cZY;
  public String desc;
  public String fpN;
  public String fpO;
  public int fpP;
  public String url;
  
  private static boolean kD(int paramInt)
  {
    if (paramInt == 4) {}
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8)) {
      return true;
    }
    return false;
  }
  
  public static c rO(String paramString)
  {
    AppMethodBeat.i(134108);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134108);
      return null;
    }
    c localc = new c();
    paramString = bv.L(paramString, "e");
    if (paramString == null)
    {
      ac.d("MicroMsg.BroadcastEntity", "this is not errmsg");
      AppMethodBeat.o(134108);
      return null;
    }
    localc.desc = ((String)paramString.get(".e.Content"));
    localc.url = ((String)paramString.get(".e.Url"));
    localc.Title = ((String)paramString.get(".e.Title"));
    localc.cZY = bs.getInt((String)paramString.get(".e.Action"), 0);
    localc.cZX = bs.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.cZW = bs.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.fpN = ((String)paramString.get(".e.Ok"));
    localc.fpO = ((String)paramString.get(".e.Cancel"));
    localc.fpP = bs.getInt((String)paramString.get("e.Countdown"), 0);
    if (kD(localc.cZX))
    {
      AppMethodBeat.o(134108);
      return localc;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramString.get(".e"));
      localc.desc = localJSONObject.getString("Content");
      localc.url = localJSONObject.getString("Url");
      localc.Title = localJSONObject.getString("Title");
      localc.cZY = bs.getInt(localJSONObject.getString("Action"), 0);
      localc.cZX = bs.getInt(localJSONObject.getString("ShowType"), 0);
      localc.cZW = bs.getInt(localJSONObject.getString("DispSec"), 30);
      localc.fpN = ((String)paramString.get(".e.Ok"));
      localc.fpO = ((String)paramString.get(".e.Cancel"));
      localc.fpP = bs.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = kD(localc.cZX);
      if (bool)
      {
        AppMethodBeat.o(134108);
        return localc;
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.BroadcastEntity", paramString, "", new Object[0]);
      AppMethodBeat.o(134108);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c
 * JD-Core Version:    0.7.0.1
 */