package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public s unL;
  public List<String> unM;
  public String unN;
  public String unO;
  public String unu;
  
  public ak(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65293);
    this.unO = null;
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
  
  public final String bVR()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean cZf()
  {
    return (this.unL == null) || (this.unL.ulI == 1);
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
      paramString.umB = paramJSONObject.optInt("recTotalNum");
      paramString.umC = paramJSONObject.optLong("recTotalAmount");
      paramString.umD = paramJSONObject.optInt("sendTotalNum");
      paramString.umE = paramJSONObject.optLong("sendTotalAmount");
      paramString.ulI = paramJSONObject.optInt("isContinue");
      paramString.umF = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          t localt = new t();
          localt.umG = localJSONObject.optString("sendName");
          localt.ulz = localJSONObject.optString("sendHeadImg");
          localt.umH = localJSONObject.optLong("receiveAmount");
          localt.umI = localJSONObject.optString("receiveTime");
          localt.dBz = localJSONObject.optInt("hbType");
          localt.umJ = localJSONObject.optString("sendTitle");
          localt.umK = localJSONObject.optString("sendTime");
          localt.ulE = localJSONObject.optLong("totalAmount");
          localt.umL = localJSONObject.optLong("totalNum");
          localt.ulC = localJSONObject.optLong("recNum");
          localt.status = localJSONObject.optInt("status");
          localt.umM = localJSONObject.optInt("thxCount");
          localt.ulF = localJSONObject.optString("receiveId");
          localt.uhB = localJSONObject.optString("sendId");
          localt.ulQ = localJSONObject.optInt("hbKind");
          localLinkedList.add(localt);
          paramInt += 1;
        }
      }
      paramString.ulR = localLinkedList;
      this.unL = paramString;
      this.unM = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!bs.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.unM.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.unN = paramJSONObject.optString("recordYear");
      this.unO = paramJSONObject.optString("clickedUrl");
      this.unu = paramJSONObject.optString("processContent");
      AppMethodBeat.o(65294);
      return;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", paramString, "", new Object[0]);
      AppMethodBeat.o(65294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ak
 * JD-Core Version:    0.7.0.1
 */