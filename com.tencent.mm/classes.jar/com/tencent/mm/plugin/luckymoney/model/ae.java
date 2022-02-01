package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
  extends ac
{
  public int dPd;
  public int dPe;
  public long dPq;
  public int pgV;
  public String vAh;
  public f vAw;
  public String vBL;
  public String vBM;
  public int vBN;
  public String vBO;
  public int vBP;
  public String vBQ;
  public String vBR;
  public int vBS;
  public l vBT;
  public String vwq;
  public RealnameGuideHelper vxf;
  
  public ae(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65279);
    this.vBT = null;
    this.vwq = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    localHashMap.put("sessionUserName", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65279);
  }
  
  public final int cbK()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65280);
    this.vBL = paramJSONObject.optString("spidName");
    this.dPd = paramJSONObject.optInt("hbStatus");
    this.dPe = paramJSONObject.optInt("receiveStatus");
    this.vAh = paramJSONObject.optString("statusMess");
    this.vBM = paramJSONObject.optString("hintMess");
    this.dPq = paramJSONObject.optLong("amount");
    this.vBN = paramJSONObject.optInt("recNum");
    this.pgV = paramJSONObject.optInt("totalNum");
    this.vAw = new f();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.vAw.gaV = paramString.optInt("enable");
      this.vAw.vzS = paramString.optString("fissionContent");
      this.vAw.vzR = paramString.optString("fissionUrl");
    }
    this.vBP = paramJSONObject.optInt("focusFlag");
    this.vBQ = paramJSONObject.optString("focusWording");
    this.vBR = paramJSONObject.optString("focusAppidUserName");
    this.vBS = paramJSONObject.optInt("isFocus");
    this.vBO = paramJSONObject.optString("smallHbButtonMess");
    try
    {
      this.vBT = x.aD(paramJSONObject);
      this.vBT.vAk = paramJSONObject.optString("spidLogo");
      this.vBT.vAj = paramJSONObject.optString("spidName");
      this.vBT.vvw = paramJSONObject.optString("spidWishing");
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
          this.vxf = new RealnameGuideHelper();
          this.vxf.b(paramString, paramJSONObject, str1, str2, (String)localObject, 1005);
        }
      }
      AppMethodBeat.o(65280);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ae
 * JD-Core Version:    0.7.0.1
 */