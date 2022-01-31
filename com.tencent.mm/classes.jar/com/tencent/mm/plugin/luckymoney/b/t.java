package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
  extends r
{
  public int cec;
  public int ced;
  public long ceq;
  public int iHi;
  public RealnameGuideHelper lMW;
  public String lMg;
  public String lPS;
  public String lQR;
  public String lQS;
  public int lQT;
  public String lQU;
  public int lQV;
  public String lQW;
  public String lQX;
  public int lQY;
  public f lQZ = null;
  public a lQh;
  
  public t(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.lMg = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bk.bl(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    localHashMap.put("sessionUserName", paramString4);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.lQR = paramJSONObject.optString("spidName");
    this.cec = paramJSONObject.optInt("hbStatus");
    this.ced = paramJSONObject.optInt("receiveStatus");
    this.lPS = paramJSONObject.optString("statusMess");
    this.lQS = paramJSONObject.optString("hintMess");
    this.ceq = paramJSONObject.optLong("amount");
    this.lQT = paramJSONObject.optInt("recNum");
    this.iHi = paramJSONObject.optInt("totalNum");
    this.lQh = new a();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.lQh.dwF = paramString.optInt("enable");
      this.lQh.lPF = paramString.optString("fissionContent");
      this.lQh.lPE = paramString.optString("fissionUrl");
    }
    this.lQV = paramJSONObject.optInt("focusFlag");
    this.lQW = paramJSONObject.optString("focusWording");
    this.lQX = paramJSONObject.optString("focusAppidUserName");
    this.lQY = paramJSONObject.optInt("isFocus");
    this.lQU = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.lQZ = m.T(paramJSONObject);
      this.lQZ.lPV = paramJSONObject.optString("spidLogo");
      this.lQZ.lPU = paramJSONObject.optString("spidName");
      this.lQZ.lLm = paramJSONObject.optString("spidWishing");
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
          this.lMW = new RealnameGuideHelper();
          this.lMW.a(paramString, paramJSONObject, str1, str2, (String)localObject, 1005);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        y.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      }
    }
  }
  
  public final int aEA()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.t
 * JD-Core Version:    0.7.0.1
 */