package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
  extends aa
{
  public int cMQ;
  public int cMR;
  public long cNd;
  public int kNn;
  public String ojA;
  public RealnameGuideHelper okp;
  public e onF;
  public String onq;
  public String ooG;
  public String ooH;
  public int ooI;
  public String ooJ;
  public int ooK;
  public String ooL;
  public String ooM;
  public int ooN;
  public k ooO;
  
  public ac(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(42391);
    this.ooO = null;
    this.ojA = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bo.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    localHashMap.put("sessionUserName", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(42391);
  }
  
  public final int bhH()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42392);
    this.ooG = paramJSONObject.optString("spidName");
    this.cMQ = paramJSONObject.optInt("hbStatus");
    this.cMR = paramJSONObject.optInt("receiveStatus");
    this.onq = paramJSONObject.optString("statusMess");
    this.ooH = paramJSONObject.optString("hintMess");
    this.cNd = paramJSONObject.optLong("amount");
    this.ooI = paramJSONObject.optInt("recNum");
    this.kNn = paramJSONObject.optInt("totalNum");
    this.onF = new e();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.onF.eoD = paramString.optInt("enable");
      this.onF.onb = paramString.optString("fissionContent");
      this.onF.ona = paramString.optString("fissionUrl");
    }
    this.ooK = paramJSONObject.optInt("focusFlag");
    this.ooL = paramJSONObject.optString("focusWording");
    this.ooM = paramJSONObject.optString("focusAppidUserName");
    this.ooN = paramJSONObject.optInt("isFocus");
    this.ooJ = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.ooO = v.ae(paramJSONObject);
      this.ooO.ont = paramJSONObject.optString("spidLogo");
      this.ooO.ons = paramJSONObject.optString("spidName");
      this.ooO.oiG = paramJSONObject.optString("spidWishing");
      if ((paramInt == 0) && (paramJSONObject.has("real_name_info")))
      {
        Object localObject = paramJSONObject.optJSONObject("real_name_info");
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).optString("guide_flag");
          paramJSONObject = ((JSONObject)localObject).optString("guide_wording");
          String str1 = ((JSONObject)localObject).optString("left_button_wording");
          String str2 = ((JSONObject)localObject).optString("right_button_wording");
          localObject = ((JSONObject)localObject).optString("upload_credit_url");
          this.okp = new RealnameGuideHelper();
          this.okp.a(paramString, paramJSONObject, str1, str2, (String)localObject, 1005);
        }
      }
      AppMethodBeat.o(42392);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ac
 * JD-Core Version:    0.7.0.1
 */