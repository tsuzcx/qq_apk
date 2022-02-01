package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class al
  extends aj
{
  public String EAP;
  public String EAQ;
  public int EAR;
  public String EAS;
  public int EAT;
  public String EAU;
  public String EAV;
  public int EAW;
  public q EAX;
  public b EAY;
  public RealnameGuideHelper Evs;
  public String EyY;
  public i Ezn;
  public long gbJ;
  public int gbp;
  public int gbq;
  public int tVd;
  public String ybP;
  
  public al(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65279);
    this.EAX = null;
    this.ybP = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    localHashMap.put("sessionUserName", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65279);
  }
  
  public final int cOe()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65280);
    Log.i("MicroMsg.NetSceneLuckyMoneyBusiOpen", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.EAP = paramJSONObject.optString("spidName");
    this.gbp = paramJSONObject.optInt("hbStatus");
    this.gbq = paramJSONObject.optInt("receiveStatus");
    this.EyY = paramJSONObject.optString("statusMess");
    this.EAQ = paramJSONObject.optString("hintMess");
    this.gbJ = paramJSONObject.optLong("amount");
    this.EAR = paramJSONObject.optInt("recNum");
    this.tVd = paramJSONObject.optInt("totalNum");
    this.Ezn = new i();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.Ezn.jqz = paramString.optInt("enable");
      this.Ezn.EyE = paramString.optString("fissionContent");
      this.Ezn.EyD = paramString.optString("fissionUrl");
    }
    this.EAT = paramJSONObject.optInt("focusFlag");
    this.EAU = paramJSONObject.optString("focusWording");
    this.EAV = paramJSONObject.optString("focusAppidUserName");
    this.EAW = paramJSONObject.optInt("isFocus");
    this.EAS = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.EAX = ad.bf(paramJSONObject);
      this.EAX.Ezb = paramJSONObject.optString("spidLogo");
      this.EAX.Eza = paramJSONObject.optString("spidName");
      this.EAX.EtJ = paramJSONObject.optString("spidWishing");
      if ((paramInt == 0) && (paramJSONObject.has("real_name_info")))
      {
        Object localObject = paramJSONObject.optJSONObject("real_name_info");
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).optString("guide_flag");
          String str1 = ((JSONObject)localObject).optString("guide_wording");
          String str2 = ((JSONObject)localObject).optString("left_button_wording");
          String str3 = ((JSONObject)localObject).optString("right_button_wording");
          localObject = ((JSONObject)localObject).optString("upload_credit_url");
          this.Evs = new RealnameGuideHelper();
          this.Evs.a(paramString, str1, str2, str3, (String)localObject, 1005);
        }
      }
      if ((paramInt == 0) && (paramJSONObject.has("intercept_win"))) {
        this.EAY = b.cg(paramJSONObject.optJSONObject("intercept_win"));
      }
      AppMethodBeat.o(65280);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.NetSceneLuckyMoneyBusiOpen", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.al
 * JD-Core Version:    0.7.0.1
 */