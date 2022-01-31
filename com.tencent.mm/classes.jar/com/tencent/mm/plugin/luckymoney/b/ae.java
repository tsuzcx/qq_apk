package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae
  extends ab
{
  public a bZo;
  public int iHi;
  public String lMg;
  public String lRA;
  public String lRB;
  public String lRC;
  public String lRD;
  public String lRE = "";
  public String lRF = "";
  public String lRG = "";
  public String lRH;
  
  public ae(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3)
  {
    this.iHi = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalNum", String.valueOf(paramInt1));
    localHashMap.put("totalAmount", String.valueOf(paramLong1));
    localHashMap.put("perValue", String.valueOf(paramLong2));
    localHashMap.put("hbType", String.valueOf(paramInt2));
    localHashMap.put("wishing", URLEncoder.encode(bk.pm(paramString1)));
    localHashMap.put("sendUserName", paramString5);
    if (!bk.bl(paramString3)) {
      localHashMap.put("username", paramString3);
    }
    if (!bk.bl(paramString2))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString2));
      localHashMap.put("nickName", URLEncoder.encode(bk.pm(paramString6)));
      if (!bk.bl(paramString4)) {
        localHashMap.put("receiveNickName", URLEncoder.encode(paramString4));
      }
    }
    localHashMap.put("inWay", String.valueOf(paramInt3));
    if ((paramInt3 == 0) || (paramInt3 == 1) || (paramInt3 == 7)) {
      localHashMap.put("needSendToMySelf", "0");
    }
    D(localHashMap);
  }
  
  public static a W(JSONObject paramJSONObject)
  {
    a locala = new a();
    locala.bQZ = paramJSONObject.optString("retmsg");
    paramJSONObject = paramJSONObject.optJSONObject("showmess");
    locala.lRE = paramJSONObject.optString("left_button_wording");
    locala.lRF = paramJSONObject.optString("right_button_wording");
    locala.iHx = paramJSONObject.optString("right_button_url");
    return locala;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.lMg = paramJSONObject.optString("sendId");
    this.lRA = paramJSONObject.optString("reqkey");
    this.lRB = paramJSONObject.optString("sendMsgXml");
    this.lRC = paramJSONObject.optString("guide_flag", "0");
    this.lRD = paramJSONObject.optString("guide_wording");
    this.lRE = paramJSONObject.optString("left_button_wording", "");
    this.lRF = paramJSONObject.optString("right_button_wording", "");
    this.lRG = paramJSONObject.optString("upload_credit_url", "");
    this.lRH = paramJSONObject.optString("id_sign", "");
    if (paramJSONObject.has("showmess"))
    {
      y.i("MicroMsg.NetSceneLuckyMoneyNormalBase", "has alert item");
      this.bZo = W(paramJSONObject);
    }
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/requestwxhb";
  }
  
  public final int getType()
  {
    return 1575;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.ae
 * JD-Core Version:    0.7.0.1
 */