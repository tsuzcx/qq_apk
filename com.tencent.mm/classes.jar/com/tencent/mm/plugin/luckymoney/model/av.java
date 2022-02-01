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

public final class av
  extends ax
{
  public x KuC;
  public List<String> KuD;
  public String KuE;
  public String KuF;
  public String Kuj;
  
  public av(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65293);
    this.KuF = null;
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
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean fXm()
  {
    return (this.KuC == null) || (this.KuC.KrX == 1);
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
      paramString = new x();
      paramString.Ktb = paramJSONObject.optInt("recTotalNum");
      paramString.Ktc = paramJSONObject.optLong("recTotalAmount");
      paramString.Ktd = paramJSONObject.optInt("sendTotalNum");
      paramString.Kte = paramJSONObject.optLong("sendTotalAmount");
      paramString.KrX = paramJSONObject.optInt("isContinue");
      paramString.Ktf = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          y localy = new y();
          localy.Ktg = localJSONObject.optString("sendName");
          localy.KrO = localJSONObject.optString("sendHeadImg");
          localy.Kth = localJSONObject.optLong("receiveAmount");
          localy.Kti = localJSONObject.optString("receiveTime");
          localy.ihy = localJSONObject.optInt("hbType");
          localy.Ktj = localJSONObject.optString("sendTitle");
          localy.Ktk = localJSONObject.optString("sendTime");
          localy.KrT = localJSONObject.optLong("totalAmount");
          localy.Ktl = localJSONObject.optLong("totalNum");
          localy.KrR = localJSONObject.optLong("recNum");
          localy.status = localJSONObject.optInt("status");
          localy.Ktm = localJSONObject.optInt("thxCount");
          localy.KrU = localJSONObject.optString("receiveId");
          localy.CAf = localJSONObject.optString("sendId");
          localy.Ksf = localJSONObject.optInt("hbKind");
          localy.Ktn = localJSONObject.optString("sendsuffix");
          localy.Kto = localJSONObject.optString("sendDesc");
          localLinkedList.add(localy);
          paramInt += 1;
        }
      }
      paramString.Ksg = localLinkedList;
      this.KuC = paramString;
      this.KuD = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!Util.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.KuD.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.KuE = paramJSONObject.optString("recordYear");
      this.KuF = paramJSONObject.optString("clickedUrl");
      this.Kuj = paramJSONObject.optString("processContent");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.av
 * JD-Core Version:    0.7.0.1
 */