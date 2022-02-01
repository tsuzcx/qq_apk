package com.tencent.mm.broadcast;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public String desc;
  public int hAM;
  public int hAN;
  public int hAO;
  public String hAP;
  public String lvB;
  public String lvC;
  public int lvD;
  public String url;
  
  public static c CJ(String paramString)
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
    localc.hAP = ((String)paramString.get(".e.Title"));
    localc.hAO = Util.getInt((String)paramString.get(".e.Action"), 0);
    localc.hAN = Util.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.hAM = Util.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.lvB = ((String)paramString.get(".e.Ok"));
    localc.lvC = ((String)paramString.get(".e.Cancel"));
    localc.lvD = Util.getInt((String)paramString.get("e.Countdown"), 0);
    if (qt(localc.hAN))
    {
      AppMethodBeat.o(134108);
      return localc;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramString.get(".e"));
      localc.desc = localJSONObject.getString("Content");
      localc.url = localJSONObject.getString("Url");
      localc.hAP = localJSONObject.getString("Title");
      localc.hAO = Util.getInt(localJSONObject.getString("Action"), 0);
      localc.hAN = Util.getInt(localJSONObject.getString("ShowType"), 0);
      localc.hAM = Util.getInt(localJSONObject.getString("DispSec"), 30);
      localc.lvB = ((String)paramString.get(".e.Ok"));
      localc.lvC = ((String)paramString.get(".e.Cancel"));
      localc.lvD = Util.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = qt(localc.hAN);
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
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8) || (paramInt == 9)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.broadcast.c
 * JD-Core Version:    0.7.0.1
 */