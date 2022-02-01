package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public int countdown;
  public String desc;
  public int fwo;
  public int fwp;
  public int fwq;
  public String fwr;
  public String iTw;
  public String iTx;
  public String url;
  
  public static c Kd(String paramString)
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
    localc.fwr = ((String)paramString.get(".e.Title"));
    localc.fwq = Util.getInt((String)paramString.get(".e.Action"), 0);
    localc.fwp = Util.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.fwo = Util.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.iTw = ((String)paramString.get(".e.Ok"));
    localc.iTx = ((String)paramString.get(".e.Cancel"));
    localc.countdown = Util.getInt((String)paramString.get("e.Countdown"), 0);
    if (qt(localc.fwp))
    {
      AppMethodBeat.o(134108);
      return localc;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramString.get(".e"));
      localc.desc = localJSONObject.getString("Content");
      localc.url = localJSONObject.getString("Url");
      localc.fwr = localJSONObject.getString("Title");
      localc.fwq = Util.getInt(localJSONObject.getString("Action"), 0);
      localc.fwp = Util.getInt(localJSONObject.getString("ShowType"), 0);
      localc.fwo = Util.getInt(localJSONObject.getString("DispSec"), 30);
      localc.iTw = ((String)paramString.get(".e.Ok"));
      localc.iTx = ((String)paramString.get(".e.Cancel"));
      localc.countdown = Util.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = qt(localc.fwp);
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
  
  private static boolean qt(int paramInt)
  {
    if (paramInt == 4) {}
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c
 * JD-Core Version:    0.7.0.1
 */