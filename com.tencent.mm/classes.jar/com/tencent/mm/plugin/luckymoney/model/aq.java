package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aq
  extends am
{
  public a dwa;
  public int owW;
  public String skK;
  public String uhB;
  public String unT;
  public String unU;
  public String unV;
  public String unW;
  public String unX;
  public String unY;
  public String unZ;
  public int uoa;
  
  public aq(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7)
  {
    this(paramInt1, paramLong1, paramLong2, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt3, paramString7, "", 0, 0, "", "", 0);
  }
  
  public aq(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10, int paramInt6)
  {
    AppMethodBeat.i(65303);
    this.unW = "";
    this.unX = "";
    this.unY = "";
    ac.i("MicroMsg.NetScenePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", new Object[] { paramString8, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), bs.nullAsNil(paramString9) });
    this.owW = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalNum", String.valueOf(paramInt1));
    localHashMap.put("totalAmount", String.valueOf(paramLong1));
    localHashMap.put("perValue", String.valueOf(paramLong2));
    localHashMap.put("hbType", String.valueOf(paramInt2));
    localHashMap.put("wishing", URLEncoder.encode(bs.nullAsNil(paramString1)));
    localHashMap.put("sendUserName", paramString5);
    if (!bs.isNullOrNil(paramString8)) {
      localHashMap.put("unique_id", paramString8);
    }
    localHashMap.put("user_confirm_jump", String.valueOf(paramInt4));
    localHashMap.put("unpay_type", String.valueOf(paramInt5));
    localHashMap.put("cancel_sendid", paramString9);
    localHashMap.put("expression_md5", paramString10);
    localHashMap.put("expression_type", String.valueOf(paramInt6));
    if (!bs.isNullOrNil(paramString3)) {
      localHashMap.put("username", paramString3);
    }
    if (!bs.isNullOrNil(paramString2))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString2));
      localHashMap.put("nickName", URLEncoder.encode(bs.nullAsNil(paramString6)));
      if (!bs.isNullOrNil(paramString4)) {
        localHashMap.put("receiveNickName", URLEncoder.encode(paramString4));
      }
    }
    localHashMap.put("inWay", String.valueOf(paramInt3));
    if ((paramInt3 == 0) || (paramInt3 == 1) || (paramInt3 == 7)) {
      localHashMap.put("needSendToMySelf", "0");
    }
    localHashMap.put("showSourceMac", URLEncoder.encode(paramString7));
    setRequestData(localHashMap);
    AppMethodBeat.o(65303);
  }
  
  public static a a(aq paramaq, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65305);
    a locala = new a();
    locala.dlQ = paramJSONObject.optString("retmsg");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("showmess");
    locala.unW = localJSONObject.optString("left_button_wording");
    locala.unX = localJSONObject.optString("right_button_wording");
    locala.oxl = localJSONObject.optString("right_button_url");
    if (paramaq != null) {
      paramaq.uoa = paramJSONObject.optInt("return_to_session", 0);
    }
    AppMethodBeat.o(65305);
    return locala;
  }
  
  public static boolean j(n paramn)
  {
    AppMethodBeat.i(65306);
    try
    {
      paramn = new JSONObject(z.b(((bkf)((b)paramn.getReqResp()).hvs.hvw).EZQ));
      if (paramn.has("showmess"))
      {
        boolean bool = bs.jl(paramn.optJSONObject("showmess").optInt("return_to_session", 0), 1);
        if (bool)
        {
          AppMethodBeat.o(65306);
          return true;
        }
      }
    }
    catch (Exception paramn)
    {
      ac.i("MicroMsg.NetScenePrepareLuckyMoney", "ifReturnByReturnToSession() Exception：%s", new Object[] { paramn.getMessage() });
      AppMethodBeat.o(65306);
    }
    return false;
  }
  
  public final String bVR()
  {
    return "/cgi-bin/mmpay-bin/requestwxhb";
  }
  
  public final int getType()
  {
    return 1575;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65304);
    this.uhB = paramJSONObject.optString("sendId");
    this.skK = paramJSONObject.optString("reqkey");
    this.unT = paramJSONObject.optString("sendMsgXml");
    this.unU = paramJSONObject.optString("guide_flag", "0");
    this.unV = paramJSONObject.optString("guide_wording");
    this.unW = paramJSONObject.optString("left_button_wording", "");
    this.unX = paramJSONObject.optString("right_button_wording", "");
    this.unY = paramJSONObject.optString("upload_credit_url", "");
    this.unZ = paramJSONObject.optString("id_sign", "");
    if (paramJSONObject.has("showmess"))
    {
      ac.i("MicroMsg.NetScenePrepareLuckyMoney", "has alert item");
      this.dwa = a(this, paramJSONObject);
    }
    AppMethodBeat.o(65304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aq
 * JD-Core Version:    0.7.0.1
 */