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

public final class at
  extends av
{
  public String yXA;
  public String yXg;
  public x yXx;
  public List<String> yXy;
  public String yXz;
  
  public at(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65293);
    this.yXA = null;
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
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean efl()
  {
    return (this.yXx == null) || (this.yXx.yVn == 1);
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
      paramString.yWi = paramJSONObject.optInt("recTotalNum");
      paramString.yWj = paramJSONObject.optLong("recTotalAmount");
      paramString.yWk = paramJSONObject.optInt("sendTotalNum");
      paramString.yWl = paramJSONObject.optLong("sendTotalAmount");
      paramString.yVn = paramJSONObject.optInt("isContinue");
      paramString.yWm = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          y localy = new y();
          localy.yWn = localJSONObject.optString("sendName");
          localy.yVe = localJSONObject.optString("sendHeadImg");
          localy.yWo = localJSONObject.optLong("receiveAmount");
          localy.yWp = localJSONObject.optString("receiveTime");
          localy.egY = localJSONObject.optInt("hbType");
          localy.yWq = localJSONObject.optString("sendTitle");
          localy.yWr = localJSONObject.optString("sendTime");
          localy.yVj = localJSONObject.optLong("totalAmount");
          localy.yWs = localJSONObject.optLong("totalNum");
          localy.yVh = localJSONObject.optLong("recNum");
          localy.status = localJSONObject.optInt("status");
          localy.yWt = localJSONObject.optInt("thxCount");
          localy.yVk = localJSONObject.optString("receiveId");
          localy.yQE = localJSONObject.optString("sendId");
          localy.yVv = localJSONObject.optInt("hbKind");
          localy.yWu = localJSONObject.optString("sendsuffix");
          localy.yWv = localJSONObject.optString("sendDesc");
          localLinkedList.add(localy);
          paramInt += 1;
        }
      }
      paramString.yVw = localLinkedList;
      this.yXx = paramString;
      this.yXy = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!Util.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.yXy.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.yXz = paramJSONObject.optString("recordYear");
      this.yXA = paramJSONObject.optString("clickedUrl");
      this.yXg = paramJSONObject.optString("processContent");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.at
 * JD-Core Version:    0.7.0.1
 */