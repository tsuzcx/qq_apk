package com.tencent.mm.i;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public int bGu;
  public int bGv;
  public String bGw;
  public String desc;
  public String dkM;
  public String dkN;
  public int dkO;
  public int showType;
  public String url;
  
  public static c eK(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    c localc = new c();
    paramString = bn.s(paramString, "e");
    if (paramString == null)
    {
      y.d("MicroMsg.BroadcastEntity", "this is not errmsg");
      return null;
    }
    localc.desc = ((String)paramString.get(".e.Content"));
    localc.url = ((String)paramString.get(".e.Url"));
    localc.bGw = ((String)paramString.get(".e.Title"));
    localc.bGv = bk.getInt((String)paramString.get(".e.Action"), 0);
    localc.showType = bk.getInt((String)paramString.get(".e.ShowType"), 0);
    localc.bGu = bk.getInt((String)paramString.get(".e.DispSec"), 30);
    localc.dkM = ((String)paramString.get(".e.Ok"));
    localc.dkN = ((String)paramString.get(".e.Cancel"));
    localc.dkO = bk.getInt((String)paramString.get("e.Countdown"), 0);
    if (ge(localc.showType)) {
      return localc;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramString.get(".e"));
      localc.desc = localJSONObject.getString("Content");
      localc.url = localJSONObject.getString("Url");
      localc.bGw = localJSONObject.getString("Title");
      localc.bGv = bk.getInt(localJSONObject.getString("Action"), 0);
      localc.showType = bk.getInt(localJSONObject.getString("ShowType"), 0);
      localc.bGu = bk.getInt(localJSONObject.getString("DispSec"), 30);
      localc.dkM = ((String)paramString.get(".e.Ok"));
      localc.dkN = ((String)paramString.get(".e.Cancel"));
      localc.dkO = bk.getInt((String)paramString.get("e.Countdown"), 0);
      boolean bool = ge(localc.showType);
      if (bool) {
        return localc;
      }
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.BroadcastEntity", paramString, "", new Object[0]);
    }
    return null;
  }
  
  private static boolean ge(int paramInt)
  {
    if (paramInt == 4) {}
    while ((paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.c
 * JD-Core Version:    0.7.0.1
 */