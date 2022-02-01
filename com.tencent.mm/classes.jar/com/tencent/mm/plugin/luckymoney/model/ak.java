package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak
  extends ai
{
  public int egZ;
  public int eha;
  public long eht;
  public int qwe;
  public String yQE;
  public RealnameGuideHelper yRu;
  public String yVb;
  public i yVq;
  public String yWL;
  public String yWM;
  public int yWN;
  public String yWO;
  public int yWP;
  public String yWQ;
  public String yWR;
  public int yWS;
  public q yWT;
  
  public ak(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65279);
    this.yWT = null;
    this.yQE = paramString1;
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
  
  public final int czE()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65280);
    this.yWL = paramJSONObject.optString("spidName");
    this.egZ = paramJSONObject.optInt("hbStatus");
    this.eha = paramJSONObject.optInt("receiveStatus");
    this.yVb = paramJSONObject.optString("statusMess");
    this.yWM = paramJSONObject.optString("hintMess");
    this.eht = paramJSONObject.optLong("amount");
    this.yWN = paramJSONObject.optInt("recNum");
    this.qwe = paramJSONObject.optInt("totalNum");
    this.yVq = new i();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.yVq.gGn = paramString.optInt("enable");
      this.yVq.yUH = paramString.optString("fissionContent");
      this.yVq.yUG = paramString.optString("fissionUrl");
    }
    this.yWP = paramJSONObject.optInt("focusFlag");
    this.yWQ = paramJSONObject.optString("focusWording");
    this.yWR = paramJSONObject.optString("focusAppidUserName");
    this.yWS = paramJSONObject.optInt("isFocus");
    this.yWO = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.yWT = ac.aY(paramJSONObject);
      this.yWT.yVe = paramJSONObject.optString("spidLogo");
      this.yWT.yVd = paramJSONObject.optString("spidName");
      this.yWT.yPK = paramJSONObject.optString("spidWishing");
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
          this.yRu = new RealnameGuideHelper();
          this.yRu.b(paramString, paramJSONObject, str1, str2, (String)localObject, 1005);
        }
      }
      AppMethodBeat.o(65280);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ak
 * JD-Core Version:    0.7.0.1
 */