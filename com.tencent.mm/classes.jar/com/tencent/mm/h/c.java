package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public String Title;
  public String desc;
  public int dlo;
  public int dlp;
  public int dlq;
  public String fHU;
  public String fHV;
  public int fHW;
  public String url;
  
  private static boolean la(int paramInt)
  {
    if (paramInt == 4) {}
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8)) {
      return true;
    }
    return false;
  }
  
  public static c uB(String paramString)
  {
    AppMethodBeat.i(134108);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134108);
      return null;
    }
    c localc = new c();
    paramString = bw.M(paramString, "e");
    if (paramString == null)
    {
      ad.d("MicroMsg.BroadcastEntity", "this is not errmsg");
      AppMethodBeat.o(134108);
      return null;
    }
    localc.desc = ((String)paramString.get(".e.Content"));
    localc.url = ((String)paramString.get(".e.Url"));
    localc.Title = ((String)paramString.get(".e.Title"));
    localc.dlq = bt.getInt((String)paramString.get(".e.Action"), 0);
    localc.dlp = bt.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.dlo = bt.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.fHU = ((String)paramString.get(".e.Ok"));
    localc.fHV = ((String)paramString.get(".e.Cancel"));
    localc.fHW = bt.getInt((String)paramString.get("e.Countdown"), 0);
    if (la(localc.dlp))
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
      localc.dlq = bt.getInt(localJSONObject.getString("Action"), 0);
      localc.dlp = bt.getInt(localJSONObject.getString("ShowType"), 0);
      localc.dlo = bt.getInt(localJSONObject.getString("DispSec"), 30);
      localc.fHU = ((String)paramString.get(".e.Ok"));
      localc.fHV = ((String)paramString.get(".e.Cancel"));
      localc.fHW = bt.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = la(localc.dlp);
      if (bool)
      {
        AppMethodBeat.o(134108);
        return localc;
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.BroadcastEntity", paramString, "", new Object[0]);
      AppMethodBeat.o(134108);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c
 * JD-Core Version:    0.7.0.1
 */