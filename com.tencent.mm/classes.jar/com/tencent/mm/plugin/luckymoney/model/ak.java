package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak
  extends am
{
  public String vCf;
  public s vCw;
  public List<String> vCx;
  public String vCy;
  public String vCz;
  
  public ak(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65293);
    this.vCz = null;
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
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean dlq()
  {
    return (this.vCw == null) || (this.vCw.vAt == 1);
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
      paramString = new s();
      paramString.vBm = paramJSONObject.optInt("recTotalNum");
      paramString.vBn = paramJSONObject.optLong("recTotalAmount");
      paramString.vBo = paramJSONObject.optInt("sendTotalNum");
      paramString.vBp = paramJSONObject.optLong("sendTotalAmount");
      paramString.vAt = paramJSONObject.optInt("isContinue");
      paramString.vBq = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          t localt = new t();
          localt.vBr = localJSONObject.optString("sendName");
          localt.vAk = localJSONObject.optString("sendHeadImg");
          localt.vBs = localJSONObject.optLong("receiveAmount");
          localt.vBt = localJSONObject.optString("receiveTime");
          localt.dPc = localJSONObject.optInt("hbType");
          localt.vBu = localJSONObject.optString("sendTitle");
          localt.vBv = localJSONObject.optString("sendTime");
          localt.vAp = localJSONObject.optLong("totalAmount");
          localt.vBw = localJSONObject.optLong("totalNum");
          localt.vAn = localJSONObject.optLong("recNum");
          localt.status = localJSONObject.optInt("status");
          localt.vBx = localJSONObject.optInt("thxCount");
          localt.vAq = localJSONObject.optString("receiveId");
          localt.vwq = localJSONObject.optString("sendId");
          localt.vAB = localJSONObject.optInt("hbKind");
          localLinkedList.add(localt);
          paramInt += 1;
        }
      }
      paramString.vAC = localLinkedList;
      this.vCw = paramString;
      this.vCx = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!bu.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.vCx.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.vCy = paramJSONObject.optString("recordYear");
      this.vCz = paramJSONObject.optString("clickedUrl");
      this.vCf = paramJSONObject.optString("processContent");
      AppMethodBeat.o(65294);
      return;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", paramString, "", new Object[0]);
      AppMethodBeat.o(65294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ak
 * JD-Core Version:    0.7.0.1
 */