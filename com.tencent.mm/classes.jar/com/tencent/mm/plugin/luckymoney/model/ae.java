package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
  extends ac
{
  public int dBA;
  public int dBB;
  public long dBN;
  public int owW;
  public String uhB;
  public RealnameGuideHelper uis;
  public f ulL;
  public String ulw;
  public String una;
  public String unb;
  public int unc;
  public String und;
  public int une;
  public String unf;
  public String ung;
  public int unh;
  public l uni;
  
  public ae(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65279);
    this.uni = null;
    this.uhB = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bs.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    localHashMap.put("sessionUserName", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65279);
  }
  
  public final int bVS()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65280);
    this.una = paramJSONObject.optString("spidName");
    this.dBA = paramJSONObject.optInt("hbStatus");
    this.dBB = paramJSONObject.optInt("receiveStatus");
    this.ulw = paramJSONObject.optString("statusMess");
    this.unb = paramJSONObject.optString("hintMess");
    this.dBN = paramJSONObject.optLong("amount");
    this.unc = paramJSONObject.optInt("recNum");
    this.owW = paramJSONObject.optInt("totalNum");
    this.ulL = new f();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.ulL.fFp = paramString.optInt("enable");
      this.ulL.ulh = paramString.optString("fissionContent");
      this.ulL.ulg = paramString.optString("fissionUrl");
    }
    this.une = paramJSONObject.optInt("focusFlag");
    this.unf = paramJSONObject.optString("focusWording");
    this.ung = paramJSONObject.optString("focusAppidUserName");
    this.unh = paramJSONObject.optInt("isFocus");
    this.und = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.uni = x.au(paramJSONObject);
      this.uni.ulz = paramJSONObject.optString("spidLogo");
      this.uni.uly = paramJSONObject.optString("spidName");
      this.uni.ugH = paramJSONObject.optString("spidWishing");
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
          this.uis = new RealnameGuideHelper();
          this.uis.b(paramString, paramJSONObject, str1, str2, (String)localObject, 1005);
        }
      }
      AppMethodBeat.o(65280);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ae
 * JD-Core Version:    0.7.0.1
 */