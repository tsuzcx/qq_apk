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
  public int dNN;
  public int dNO;
  public long dOa;
  public int par;
  public String vkl;
  public RealnameGuideHelper vla;
  public String voc;
  public f vor;
  public String vpG;
  public String vpH;
  public int vpI;
  public String vpJ;
  public int vpK;
  public String vpL;
  public String vpM;
  public int vpN;
  public l vpO;
  
  public ae(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65279);
    this.vpO = null;
    this.vkl = paramString1;
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
  
  public final int cav()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65280);
    this.vpG = paramJSONObject.optString("spidName");
    this.dNN = paramJSONObject.optInt("hbStatus");
    this.dNO = paramJSONObject.optInt("receiveStatus");
    this.voc = paramJSONObject.optString("statusMess");
    this.vpH = paramJSONObject.optString("hintMess");
    this.dOa = paramJSONObject.optLong("amount");
    this.vpI = paramJSONObject.optInt("recNum");
    this.par = paramJSONObject.optInt("totalNum");
    this.vor = new f();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.vor.fYO = paramString.optInt("enable");
      this.vor.vnN = paramString.optString("fissionContent");
      this.vor.vnM = paramString.optString("fissionUrl");
    }
    this.vpK = paramJSONObject.optInt("focusFlag");
    this.vpL = paramJSONObject.optString("focusWording");
    this.vpM = paramJSONObject.optString("focusAppidUserName");
    this.vpN = paramJSONObject.optInt("isFocus");
    this.vpJ = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.vpO = x.aD(paramJSONObject);
      this.vpO.vof = paramJSONObject.optString("spidLogo");
      this.vpO.voe = paramJSONObject.optString("spidName");
      this.vpO.vjr = paramJSONObject.optString("spidWishing");
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
          this.vla = new RealnameGuideHelper();
          this.vla.b(paramString, paramJSONObject, str1, str2, (String)localObject, 1005);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ae
 * JD-Core Version:    0.7.0.1
 */