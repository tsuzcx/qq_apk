package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public String tff;
  public s tfw;
  public List<String> tfx;
  public String tfy;
  public String tfz;
  
  public ak(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65293);
    this.tfz = null;
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
  
  public final String bOB()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean cLz()
  {
    return (this.tfw == null) || (this.tfw.tdt == 1);
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
      paramString.tem = paramJSONObject.optInt("recTotalNum");
      paramString.ten = paramJSONObject.optLong("recTotalAmount");
      paramString.teo = paramJSONObject.optInt("sendTotalNum");
      paramString.tep = paramJSONObject.optLong("sendTotalAmount");
      paramString.tdt = paramJSONObject.optInt("isContinue");
      paramString.teq = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          t localt = new t();
          localt.ter = localJSONObject.optString("sendName");
          localt.tdk = localJSONObject.optString("sendHeadImg");
          localt.tes = localJSONObject.optLong("receiveAmount");
          localt.tet = localJSONObject.optString("receiveTime");
          localt.dDN = localJSONObject.optInt("hbType");
          localt.teu = localJSONObject.optString("sendTitle");
          localt.tev = localJSONObject.optString("sendTime");
          localt.tdp = localJSONObject.optLong("totalAmount");
          localt.tew = localJSONObject.optLong("totalNum");
          localt.tdn = localJSONObject.optLong("recNum");
          localt.status = localJSONObject.optInt("status");
          localt.tex = localJSONObject.optInt("thxCount");
          localt.tdq = localJSONObject.optString("receiveId");
          localt.sZn = localJSONObject.optString("sendId");
          localt.tdB = localJSONObject.optInt("hbKind");
          localLinkedList.add(localt);
          paramInt += 1;
        }
      }
      paramString.tdC = localLinkedList;
      this.tfw = paramString;
      this.tfx = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!bt.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.tfx.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.tfy = paramJSONObject.optString("recordYear");
      this.tfz = paramJSONObject.optString("clickedUrl");
      this.tff = paramJSONObject.optString("processContent");
      AppMethodBeat.o(65294);
      return;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", paramString, "", new Object[0]);
      AppMethodBeat.o(65294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ak
 * JD-Core Version:    0.7.0.1
 */