package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class au
  extends aw
{
  public y EBC;
  public List<String> EBD;
  public String EBE;
  public String EBF;
  public String EBl;
  
  public au(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65293);
    this.EBF = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    localHashMap.put("type", String.valueOf(paramInt3));
    localHashMap.put("year", paramString1);
    localHashMap.put("ver", paramString2);
    localHashMap.put("processContent", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(65293);
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean eOJ()
  {
    return (this.EBC == null) || (this.EBC.Ezk == 1);
  }
  
  public final int getType()
  {
    return 1514;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65294);
    try
    {
      paramString = new y();
      paramString.EAl = paramJSONObject.optInt("recTotalNum");
      paramString.EAm = paramJSONObject.optLong("recTotalAmount");
      paramString.EAn = paramJSONObject.optInt("sendTotalNum");
      paramString.EAo = paramJSONObject.optLong("sendTotalAmount");
      paramString.Ezk = paramJSONObject.optInt("isContinue");
      paramString.EAp = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          z localz = new z();
          localz.EAq = localJSONObject.optString("sendName");
          localz.Ezb = localJSONObject.optString("sendHeadImg");
          localz.EAr = localJSONObject.optLong("receiveAmount");
          localz.EAs = localJSONObject.optString("receiveTime");
          localz.gbo = localJSONObject.optInt("hbType");
          localz.EAt = localJSONObject.optString("sendTitle");
          localz.EAu = localJSONObject.optString("sendTime");
          localz.Ezg = localJSONObject.optLong("totalAmount");
          localz.EAv = localJSONObject.optLong("totalNum");
          localz.Eze = localJSONObject.optLong("recNum");
          localz.status = localJSONObject.optInt("status");
          localz.EAw = localJSONObject.optInt("thxCount");
          localz.Ezh = localJSONObject.optString("receiveId");
          localz.ybP = localJSONObject.optString("sendId");
          localz.Ezs = localJSONObject.optInt("hbKind");
          localz.EAx = localJSONObject.optString("sendsuffix");
          localz.EAy = localJSONObject.optString("sendDesc");
          localLinkedList.add(localz);
          paramInt += 1;
        }
      }
      paramString.Ezu = localLinkedList;
      this.EBC = paramString;
      this.EBD = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!Util.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.EBD.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.EBE = paramJSONObject.optString("recordYear");
      this.EBF = paramJSONObject.optString("clickedUrl");
      this.EBl = paramJSONObject.optString("processContent");
      AppMethodBeat.o(65294);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", paramString, "", new Object[0]);
      AppMethodBeat.o(65294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.au
 * JD-Core Version:    0.7.0.1
 */