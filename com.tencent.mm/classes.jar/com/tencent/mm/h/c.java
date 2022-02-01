package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public String Title;
  public int dDF;
  public int dDG;
  public int dDH;
  public String desc;
  public String gpn;
  public String gpo;
  public int gpp;
  public String url;
  
  public static c Dm(String paramString)
  {
    AppMethodBeat.i(134108);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134108);
      return null;
    }
    c localc = new c();
    paramString = XmlParser.parseXml(paramString, "e", null);
    if (paramString == null)
    {
      Log.d("MicroMsg.BroadcastEntity", "this is not errmsg");
      AppMethodBeat.o(134108);
      return null;
    }
    localc.desc = ((String)paramString.get(".e.Content"));
    localc.url = ((String)paramString.get(".e.Url"));
    localc.Title = ((String)paramString.get(".e.Title"));
    localc.dDH = Util.getInt((String)paramString.get(".e.Action"), 0);
    localc.dDG = Util.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.dDF = Util.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.gpn = ((String)paramString.get(".e.Ok"));
    localc.gpo = ((String)paramString.get(".e.Cancel"));
    localc.gpp = Util.getInt((String)paramString.get("e.Countdown"), 0);
    if (oe(localc.dDG))
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
      localc.dDH = Util.getInt(localJSONObject.getString("Action"), 0);
      localc.dDG = Util.getInt(localJSONObject.getString("ShowType"), 0);
      localc.dDF = Util.getInt(localJSONObject.getString("DispSec"), 30);
      localc.gpn = ((String)paramString.get(".e.Ok"));
      localc.gpo = ((String)paramString.get(".e.Cancel"));
      localc.gpp = Util.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = oe(localc.dDG);
      if (bool)
      {
        AppMethodBeat.o(134108);
        return localc;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.BroadcastEntity", paramString, "", new Object[0]);
      AppMethodBeat.o(134108);
    }
    return null;
  }
  
  private static boolean oe(int paramInt)
  {
    if (paramInt == 4) {}
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c
 * JD-Core Version:    0.7.0.1
 */