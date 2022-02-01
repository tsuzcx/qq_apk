package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
  extends ac
{
  public int dDO;
  public int dDP;
  public long dEb;
  public int nTB;
  public String sZn;
  public RealnameGuideHelper tac;
  public String tdh;
  public f tdw;
  public String teL;
  public String teM;
  public int teN;
  public String teO;
  public int teP;
  public String teQ;
  public String teR;
  public int teS;
  public l teT;
  
  public ae(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65279);
    this.teT = null;
    this.sZn = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bt.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    localHashMap.put("sessionUserName", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65279);
  }
  
  public final int bOC()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65280);
    this.teL = paramJSONObject.optString("spidName");
    this.dDO = paramJSONObject.optInt("hbStatus");
    this.dDP = paramJSONObject.optInt("receiveStatus");
    this.tdh = paramJSONObject.optString("statusMess");
    this.teM = paramJSONObject.optString("hintMess");
    this.dEb = paramJSONObject.optLong("amount");
    this.teN = paramJSONObject.optInt("recNum");
    this.nTB = paramJSONObject.optInt("totalNum");
    this.tdw = new f();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.tdw.fBI = paramString.optInt("enable");
      this.tdw.tcS = paramString.optString("fissionContent");
      this.tdw.tcR = paramString.optString("fissionUrl");
    }
    this.teP = paramJSONObject.optInt("focusFlag");
    this.teQ = paramJSONObject.optString("focusWording");
    this.teR = paramJSONObject.optString("focusAppidUserName");
    this.teS = paramJSONObject.optInt("isFocus");
    this.teO = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.teT = x.at(paramJSONObject);
      this.teT.tdk = paramJSONObject.optString("spidLogo");
      this.teT.tdj = paramJSONObject.optString("spidName");
      this.teT.sYt = paramJSONObject.optString("spidWishing");
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
          this.tac = new RealnameGuideHelper();
          this.tac.b(paramString, paramJSONObject, str1, str2, (String)localObject, 1005);
        }
      }
      AppMethodBeat.o(65280);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ae
 * JD-Core Version:    0.7.0.1
 */