package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public String Title;
  public String desc;
  public int dmq;
  public int dmr;
  public int dms;
  public String fJY;
  public String fJZ;
  public int fKa;
  public String url;
  
  private static boolean lc(int paramInt)
  {
    if (paramInt == 4) {}
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8)) {
      return true;
    }
    return false;
  }
  
  public static c uW(String paramString)
  {
    AppMethodBeat.i(134108);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134108);
      return null;
    }
    c localc = new c();
    paramString = bx.M(paramString, "e");
    if (paramString == null)
    {
      ae.d("MicroMsg.BroadcastEntity", "this is not errmsg");
      AppMethodBeat.o(134108);
      return null;
    }
    localc.desc = ((String)paramString.get(".e.Content"));
    localc.url = ((String)paramString.get(".e.Url"));
    localc.Title = ((String)paramString.get(".e.Title"));
    localc.dms = bu.getInt((String)paramString.get(".e.Action"), 0);
    localc.dmr = bu.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.dmq = bu.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.fJY = ((String)paramString.get(".e.Ok"));
    localc.fJZ = ((String)paramString.get(".e.Cancel"));
    localc.fKa = bu.getInt((String)paramString.get("e.Countdown"), 0);
    if (lc(localc.dmr))
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
      localc.dms = bu.getInt(localJSONObject.getString("Action"), 0);
      localc.dmr = bu.getInt(localJSONObject.getString("ShowType"), 0);
      localc.dmq = bu.getInt(localJSONObject.getString("DispSec"), 30);
      localc.fJY = ((String)paramString.get(".e.Ok"));
      localc.fJZ = ((String)paramString.get(".e.Cancel"));
      localc.fKa = bu.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = lc(localc.dmr);
      if (bool)
      {
        AppMethodBeat.o(134108);
        return localc;
      }
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.BroadcastEntity", paramString, "", new Object[0]);
      AppMethodBeat.o(134108);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c
 * JD-Core Version:    0.7.0.1
 */