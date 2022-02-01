package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bc
  extends ax
{
  public String CAf;
  public String Hgk;
  public String KuM;
  public String KuN;
  public String KuO;
  public String KuP;
  public String KuQ;
  public int KuR;
  public a iaV;
  public String rGU;
  public String right_button_wording;
  public int wYz;
  
  public bc()
  {
    this.rGU = "";
    this.right_button_wording = "";
    this.KuP = "";
  }
  
  public bc(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7)
  {
    this(paramInt1, paramLong1, paramLong2, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt3, paramString7, "", 0, 0, "", "", 0, "");
  }
  
  public bc(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10, int paramInt6, String paramString11)
  {
    AppMethodBeat.i(283983);
    this.rGU = "";
    this.right_button_wording = "";
    this.KuP = "";
    Log.i("MicroMsg.NetScenePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", new Object[] { paramString8, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Util.nullAsNil(paramString9) });
    this.wYz = paramInt1;
    HashMap localHashMap = new HashMap();
    if (paramInt2 == 3) {
      localHashMap.put("totalNum", "1");
    }
    for (;;)
    {
      localHashMap.put("totalAmount", String.valueOf(paramLong1));
      localHashMap.put("perValue", String.valueOf(paramLong2));
      localHashMap.put("hbType", String.valueOf(paramInt2));
      localHashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(paramString1)));
      localHashMap.put("sendUserName", paramString5);
      if (!Util.isNullOrNil(paramString8)) {
        localHashMap.put("unique_id", paramString8);
      }
      localHashMap.put("user_confirm_jump", String.valueOf(paramInt4));
      localHashMap.put("unpay_type", String.valueOf(paramInt5));
      localHashMap.put("cancel_sendid", paramString9);
      localHashMap.put("expression_md5", paramString10);
      localHashMap.put("expression_type", String.valueOf(paramInt6));
      if (!Util.isNullOrNil(paramString3)) {
        localHashMap.put("username", paramString3);
      }
      if (!Util.isNullOrNil(paramString2))
      {
        localHashMap.put("headImg", URLEncoder.encode(paramString2));
        localHashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString6)));
        if (!Util.isNullOrNil(paramString4)) {
          localHashMap.put("receiveNickName", URLEncoder.encode(paramString4));
        }
      }
      localHashMap.put("inWay", String.valueOf(paramInt3));
      if ((paramInt3 == 0) || (paramInt3 == 1) || (paramInt3 == 7)) {
        localHashMap.put("needSendToMySelf", "0");
      }
      localHashMap.put("showSourceMac", URLEncoder.encode(paramString7));
      localHashMap.put("exclusiveRecvUsername", paramString11);
      setRequestData(localHashMap);
      AppMethodBeat.o(283983);
      return;
      localHashMap.put("totalNum", String.valueOf(paramInt1));
    }
  }
  
  public static a a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65305);
    a locala = new a();
    locala.wording = paramJSONObject.optString("retmsg");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("showmess");
    locala.rGU = localJSONObject.optString("left_button_wording");
    locala.right_button_wording = localJSONObject.optString("right_button_wording");
    locala.wYO = localJSONObject.optString("right_button_url");
    if (parambc != null) {
      parambc.KuR = paramJSONObject.optInt("return_to_session", 0);
    }
    AppMethodBeat.o(65305);
    return locala;
  }
  
  public static boolean l(p paramp)
  {
    AppMethodBeat.i(65306);
    try
    {
      paramp = new JSONObject(w.b(((daj)c.c.b(((c)paramp.getReqResp()).otC)).aaFS));
      if (paramp.has("showmess"))
      {
        boolean bool = Util.isEqual(paramp.optJSONObject("showmess").optInt("return_to_session", 0), 1);
        if (bool)
        {
          AppMethodBeat.o(65306);
          return true;
        }
      }
    }
    catch (Exception paramp)
    {
      Log.i("MicroMsg.NetScenePrepareLuckyMoney", "ifReturnByReturnToSession() Exception：%s", new Object[] { paramp.getMessage() });
      AppMethodBeat.o(65306);
    }
    return false;
  }
  
  public String drI()
  {
    return "/cgi-bin/mmpay-bin/requestwxhb";
  }
  
  public int getType()
  {
    return 1575;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65304);
    Log.i("MicroMsg.NetScenePrepareLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.CAf = paramJSONObject.optString("sendId");
    this.Hgk = paramJSONObject.optString("reqkey");
    this.KuM = paramJSONObject.optString("sendMsgXml");
    this.KuN = paramJSONObject.optString("guide_flag", "0");
    this.KuO = paramJSONObject.optString("guide_wording");
    this.rGU = paramJSONObject.optString("left_button_wording", "");
    this.right_button_wording = paramJSONObject.optString("right_button_wording", "");
    this.KuP = paramJSONObject.optString("upload_credit_url", "");
    this.KuQ = paramJSONObject.optString("id_sign", "");
    if (paramJSONObject.has("showmess"))
    {
      Log.i("MicroMsg.NetScenePrepareLuckyMoney", "has alert item");
      this.iaV = a(this, paramJSONObject);
    }
    AppMethodBeat.o(65304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bc
 * JD-Core Version:    0.7.0.1
 */