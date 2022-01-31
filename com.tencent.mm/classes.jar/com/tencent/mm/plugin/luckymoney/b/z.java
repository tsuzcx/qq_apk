package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends ab
{
  public String lRl;
  public h lRv;
  public List<String> lRw;
  public String lRx;
  public String lRy = null;
  
  public z(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    localHashMap.put("type", String.valueOf(paramInt3));
    localHashMap.put("year", paramString1);
    localHashMap.put("ver", paramString2);
    localHashMap.put("processContent", paramString3);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = new h();
      paramString.lQt = paramJSONObject.optInt("recTotalNum");
      paramString.lQu = paramJSONObject.optLong("recTotalAmount");
      paramString.lQv = paramJSONObject.optInt("sendTotalNum");
      paramString.lQw = paramJSONObject.optLong("sendTotalAmount");
      paramString.lQe = paramJSONObject.optInt("isContinue");
      paramString.kEe = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          i locali = new i();
          locali.lQx = localJSONObject.optString("sendName");
          locali.lPV = localJSONObject.optString("sendHeadImg");
          locali.lQy = localJSONObject.optLong("receiveAmount");
          locali.lQz = localJSONObject.optString("receiveTime");
          locali.lPR = localJSONObject.optInt("hbType");
          locali.lQA = localJSONObject.optString("sendTitle");
          locali.lQB = localJSONObject.optString("sendTime");
          locali.lQa = localJSONObject.optLong("totalAmount");
          locali.lQC = localJSONObject.optLong("totalNum");
          locali.lPY = localJSONObject.optLong("recNum");
          locali.status = localJSONObject.optInt("status");
          locali.lQD = localJSONObject.optInt("thxCount");
          locali.lQb = localJSONObject.optString("receiveId");
          locali.lMg = localJSONObject.optString("sendId");
          locali.lQm = localJSONObject.optInt("hbKind");
          localLinkedList.add(locali);
          paramInt += 1;
        }
      }
      paramString.lQn = localLinkedList;
      this.lRv = paramString;
      this.lRw = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!bk.bl(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.lRw.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.lRx = paramJSONObject.optString("recordYear");
      this.lRy = paramJSONObject.optString("clickedUrl");
      this.lRl = paramJSONObject.optString("processContent");
      return;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", paramString, "", new Object[0]);
    }
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean bfN()
  {
    return (this.lRv == null) || (this.lRv.lQe == 1);
  }
  
  public final int getType()
  {
    return 1514;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.z
 * JD-Core Version:    0.7.0.1
 */