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
  public String vqa;
  public s vqr;
  public List<String> vqs;
  public String vqt;
  public String vqu;
  
  public ak(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65293);
    this.vqu = null;
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
  
  public final String cau()
  {
    return "/cgi-bin/mmpay-bin/qrylistwxhb";
  }
  
  public final boolean dir()
  {
    return (this.vqr == null) || (this.vqr.voo == 1);
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
      paramString.vph = paramJSONObject.optInt("recTotalNum");
      paramString.vpi = paramJSONObject.optLong("recTotalAmount");
      paramString.vpj = paramJSONObject.optInt("sendTotalNum");
      paramString.vpk = paramJSONObject.optLong("sendTotalAmount");
      paramString.voo = paramJSONObject.optInt("isContinue");
      paramString.vpl = paramJSONObject.optInt("gameCount");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("record");
      LinkedList localLinkedList = new LinkedList();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt);
          t localt = new t();
          localt.vpm = localJSONObject.optString("sendName");
          localt.vof = localJSONObject.optString("sendHeadImg");
          localt.vpn = localJSONObject.optLong("receiveAmount");
          localt.vpo = localJSONObject.optString("receiveTime");
          localt.dNM = localJSONObject.optInt("hbType");
          localt.vpp = localJSONObject.optString("sendTitle");
          localt.vpq = localJSONObject.optString("sendTime");
          localt.vok = localJSONObject.optLong("totalAmount");
          localt.vpr = localJSONObject.optLong("totalNum");
          localt.voi = localJSONObject.optLong("recNum");
          localt.status = localJSONObject.optInt("status");
          localt.vps = localJSONObject.optInt("thxCount");
          localt.vol = localJSONObject.optString("receiveId");
          localt.vkl = localJSONObject.optString("sendId");
          localt.vow = localJSONObject.optInt("hbKind");
          localLinkedList.add(localt);
          paramInt += 1;
        }
      }
      paramString.vox = localLinkedList;
      this.vqr = paramString;
      this.vqs = new ArrayList();
      paramString = paramJSONObject.optString("years");
      if (!bt.isNullOrNil(paramString))
      {
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          paramInt = 0;
          while (paramInt < paramString.length)
          {
            this.vqs.add(paramString[paramInt]);
            paramInt += 1;
          }
        }
      }
      this.vqt = paramJSONObject.optString("recordYear");
      this.vqu = paramJSONObject.optString("clickedUrl");
      this.vqa = paramJSONObject.optString("processContent");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ak
 * JD-Core Version:    0.7.0.1
 */