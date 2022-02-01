package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class am
  extends ak
{
  public String CAf;
  public RealnameGuideHelper Koa;
  public String KrL;
  public j Ksa;
  public String KtM;
  public String KtN;
  public int KtO;
  public String KtP;
  public int KtQ;
  public String KtR;
  public String KtS;
  public int KtT;
  public q KtU;
  public c KtV;
  public int ihA;
  public long ihV;
  public int ihz;
  public int wYz;
  
  public am(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65279);
    this.KtU = null;
    this.CAf = paramString1;
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
  
  public final int drJ()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65280);
    Log.i("MicroMsg.NetSceneLuckyMoneyBusiOpen", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.KtM = paramJSONObject.optString("spidName");
    this.ihz = paramJSONObject.optInt("hbStatus");
    this.ihA = paramJSONObject.optInt("receiveStatus");
    this.KrL = paramJSONObject.optString("statusMess");
    this.KtN = paramJSONObject.optString("hintMess");
    this.ihV = paramJSONObject.optLong("amount");
    this.KtO = paramJSONObject.optInt("recNum");
    this.wYz = paramJSONObject.optInt("totalNum");
    this.Ksa = new j();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.Ksa.lTH = paramString.optInt("enable");
      this.Ksa.Krr = paramString.optString("fissionContent");
      this.Ksa.Krq = paramString.optString("fissionUrl");
    }
    this.KtQ = paramJSONObject.optInt("focusFlag");
    this.KtR = paramJSONObject.optString("focusWording");
    this.KtS = paramJSONObject.optString("focusAppidUserName");
    this.KtT = paramJSONObject.optInt("isFocus");
    this.KtP = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.KtU = ae.bt(paramJSONObject);
      this.KtU.KrO = paramJSONObject.optString("spidLogo");
      this.KtU.KrN = paramJSONObject.optString("spidName");
      this.KtU.Kmq = paramJSONObject.optString("spidWishing");
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
          this.Koa = new RealnameGuideHelper();
          this.Koa.a(paramString, str1, str2, str3, (String)localObject, 1005);
        }
      }
      if ((paramInt == 0) && (paramJSONObject.has("intercept_win"))) {
        this.KtV = c.cC(paramJSONObject.optJSONObject("intercept_win"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.am
 * JD-Core Version:    0.7.0.1
 */