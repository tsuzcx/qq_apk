package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai
  extends ak
{
  public String opa;
  public q opr;
  public List<String> ops;
  public String opt;
  public String opu;
  
  public ai(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(42405);
    this.opu = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    localHashMap.put("type", String.valueOf(paramInt3));
    localHashMap.put("year", paramString1);
    localHashMap.put("ver", paramString2);
    localHashMap.put("processContent", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(42405);
  }
  
  public final boolean bNr()
  {
    return (this.opr == null) || (this.opr.onC == 1);
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final int getType()
  {
    return 1514;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42406);
    try
    {
      paramString = new q();
      paramString.ooj = paramJSONObject.optInt("recTotalNum");
      paramString.ook = paramJSONObject.optLong("recTotalAmount");
      paramString.ool = paramJSONObject.optInt("sendTotalNum");
      paramString.oom = paramJSONObject.optLong("sendTotalAmount");
      paramString.onC = paramJSONObject.optInt("isContinue");
      paramString.nao = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          r localr = new r();
          localr.oon = localJSONObject.optString("sendName");
          localr.ont = localJSONObject.optString("sendHeadImg");
          localr.ooo = localJSONObject.optLong("receiveAmount");
          localr.oop = localJSONObject.optString("receiveTime");
          localr.cMP = localJSONObject.optInt("hbType");
          localr.ooq = localJSONObject.optString("sendTitle");
          localr.oor = localJSONObject.optString("sendTime");
          localr.ony = localJSONObject.optLong("totalAmount");
          localr.oos = localJSONObject.optLong("totalNum");
          localr.onw = localJSONObject.optLong("recNum");
          localr.status = localJSONObject.optInt("status");
          localr.oot = localJSONObject.optInt("thxCount");
          localr.onz = localJSONObject.optString("receiveId");
          localr.ojA = localJSONObject.optString("sendId");
          localr.onK = localJSONObject.optInt("hbKind");
          localLinkedList.add(localr);
          paramInt += 1;
        }
      }
      paramString.onL = localLinkedList;
      this.opr = paramString;
      this.ops = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!bo.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.ops.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.opt = paramJSONObject.optString("recordYear");
      this.opu = paramJSONObject.optString("clickedUrl");
      this.opa = paramJSONObject.optString("processContent");
      AppMethodBeat.o(42406);
      return;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", paramString, "", new Object[0]);
      AppMethodBeat.o(42406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ai
 * JD-Core Version:    0.7.0.1
 */