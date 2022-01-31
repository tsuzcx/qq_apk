package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ao
  extends ak
{
  public com.tencent.mm.plugin.wallet_core.model.b cHz;
  public int kNn;
  public String ojA;
  public String opA;
  public String opB;
  public String opC;
  public String opD;
  public String opE;
  public String opF;
  public int opG;
  public String opy;
  public String opz;
  
  public ao(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7)
  {
    this(paramInt1, paramLong1, paramLong2, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt3, paramString7, "", 0, 0, "", "", 0);
  }
  
  public ao(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10, int paramInt6)
  {
    AppMethodBeat.i(42415);
    this.opC = "";
    this.opD = "";
    this.opE = "";
    ab.i("MicroMsg.NetScenePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", new Object[] { paramString8, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), bo.nullAsNil(paramString9) });
    this.kNn = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalNum", String.valueOf(paramInt1));
    localHashMap.put("totalAmount", String.valueOf(paramLong1));
    localHashMap.put("perValue", String.valueOf(paramLong2));
    localHashMap.put("hbType", String.valueOf(paramInt2));
    localHashMap.put("wishing", URLEncoder.encode(bo.nullAsNil(paramString1)));
    localHashMap.put("sendUserName", paramString5);
    if (!bo.isNullOrNil(paramString8)) {
      localHashMap.put("unique_id", paramString8);
    }
    localHashMap.put("user_confirm_jump", String.valueOf(paramInt4));
    localHashMap.put("unpay_type", String.valueOf(paramInt5));
    localHashMap.put("cancel_sendid", paramString9);
    localHashMap.put("expression_md5", paramString10);
    localHashMap.put("expression_type", String.valueOf(paramInt6));
    if (!bo.isNullOrNil(paramString3)) {
      localHashMap.put("username", paramString3);
    }
    if (!bo.isNullOrNil(paramString2))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString2));
      localHashMap.put("nickName", URLEncoder.encode(bo.nullAsNil(paramString6)));
      if (!bo.isNullOrNil(paramString4)) {
        localHashMap.put("receiveNickName", URLEncoder.encode(paramString4));
      }
    }
    localHashMap.put("inWay", String.valueOf(paramInt3));
    if ((paramInt3 == 0) || (paramInt3 == 1) || (paramInt3 == 7)) {
      localHashMap.put("needSendToMySelf", "0");
    }
    localHashMap.put("showSourceMac", URLEncoder.encode(paramString7));
    setRequestData(localHashMap);
    AppMethodBeat.o(42415);
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.b a(ao paramao, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42417);
    com.tencent.mm.plugin.wallet_core.model.b localb = new com.tencent.mm.plugin.wallet_core.model.b();
    localb.cyA = paramJSONObject.optString("retmsg");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("showmess");
    localb.opC = localJSONObject.optString("left_button_wording");
    localb.opD = localJSONObject.optString("right_button_wording");
    localb.kNB = localJSONObject.optString("right_button_url");
    if (paramao != null) {
      paramao.opG = paramJSONObject.optInt("return_to_session", 0);
    }
    AppMethodBeat.o(42417);
    return localb;
  }
  
  public static boolean k(m paramm)
  {
    AppMethodBeat.i(42418);
    try
    {
      paramm = new JSONObject(aa.b(((avi)((com.tencent.mm.ai.b)paramm.getReqResp()).fsW.fta).xkL));
      if (paramm.has("showmess"))
      {
        boolean bool = bo.hl(paramm.optJSONObject("showmess").optInt("return_to_session", 0), 1);
        if (bool)
        {
          AppMethodBeat.o(42418);
          return true;
        }
      }
    }
    catch (Exception paramm)
    {
      ab.i("MicroMsg.NetScenePrepareLuckyMoney", "ifReturnByReturnToSession() Exception：%s", new Object[] { paramm.getMessage() });
      AppMethodBeat.o(42418);
    }
    return false;
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/requestwxhb";
  }
  
  public final int getType()
  {
    return 1575;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42416);
    this.ojA = paramJSONObject.optString("sendId");
    this.opy = paramJSONObject.optString("reqkey");
    this.opz = paramJSONObject.optString("sendMsgXml");
    this.opA = paramJSONObject.optString("guide_flag", "0");
    this.opB = paramJSONObject.optString("guide_wording");
    this.opC = paramJSONObject.optString("left_button_wording", "");
    this.opD = paramJSONObject.optString("right_button_wording", "");
    this.opE = paramJSONObject.optString("upload_credit_url", "");
    this.opF = paramJSONObject.optString("id_sign", "");
    if (paramJSONObject.has("showmess"))
    {
      ab.i("MicroMsg.NetScenePrepareLuckyMoney", "has alert item");
      this.cHz = a(this, paramJSONObject);
    }
    AppMethodBeat.o(42416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ao
 * JD-Core Version:    0.7.0.1
 */