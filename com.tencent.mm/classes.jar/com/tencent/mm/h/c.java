package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public String Title;
  public int cnD;
  public int cnE;
  public String desc;
  public String ecg;
  public String ech;
  public int eci;
  public int showType;
  public String url;
  
  private static boolean iu(int paramInt)
  {
    if (paramInt == 4) {}
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8)) {
      return true;
    }
    return false;
  }
  
  public static c kQ(String paramString)
  {
    AppMethodBeat.i(123393);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123393);
      return null;
    }
    c localc = new c();
    paramString = br.F(paramString, "e");
    if (paramString == null)
    {
      ab.d("MicroMsg.BroadcastEntity", "this is not errmsg");
      AppMethodBeat.o(123393);
      return null;
    }
    localc.desc = ((String)paramString.get(".e.Content"));
    localc.url = ((String)paramString.get(".e.Url"));
    localc.Title = ((String)paramString.get(".e.Title"));
    localc.cnE = bo.getInt((String)paramString.get(".e.Action"), 0);
    localc.showType = bo.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.cnD = bo.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.ecg = ((String)paramString.get(".e.Ok"));
    localc.ech = ((String)paramString.get(".e.Cancel"));
    localc.eci = bo.getInt((String)paramString.get("e.Countdown"), 0);
    if (iu(localc.showType))
    {
      AppMethodBeat.o(123393);
      return localc;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramString.get(".e"));
      localc.desc = localJSONObject.getString("Content");
      localc.url = localJSONObject.getString("Url");
      localc.Title = localJSONObject.getString("Title");
      localc.cnE = bo.getInt(localJSONObject.getString("Action"), 0);
      localc.showType = bo.getInt(localJSONObject.getString("ShowType"), 0);
      localc.cnD = bo.getInt(localJSONObject.getString("DispSec"), 30);
      localc.ecg = ((String)paramString.get(".e.Ok"));
      localc.ech = ((String)paramString.get(".e.Cancel"));
      localc.eci = bo.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = iu(localc.showType);
      if (bool)
      {
        AppMethodBeat.o(123393);
        return localc;
      }
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.BroadcastEntity", paramString, "", new Object[0]);
      AppMethodBeat.o(123393);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c
 * JD-Core Version:    0.7.0.1
 */