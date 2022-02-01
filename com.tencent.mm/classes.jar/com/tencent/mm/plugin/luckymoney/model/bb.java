package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bb
  extends aw
{
  public String ByI;
  public String EBL;
  public String EBM;
  public String EBN;
  public String EBO;
  public String EBP;
  public int EBQ;
  public a fUY;
  public String oDJ;
  public String oDK;
  public int tVd;
  public String ybP;
  
  public bb()
  {
    this.oDJ = "";
    this.oDK = "";
    this.EBO = "";
  }
  
  public bb(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7)
  {
    this(paramInt1, paramLong1, paramLong2, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt3, paramString7, "", 0, 0, "", "", 0, "");
  }
  
  public bb(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10, int paramInt6, String paramString11)
  {
    AppMethodBeat.i(234463);
    this.oDJ = "";
    this.oDK = "";
    this.EBO = "";
    Log.i("MicroMsg.NetScenePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", new Object[] { paramString8, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Util.nullAsNil(paramString9) });
    this.tVd = paramInt1;
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
      AppMethodBeat.o(234463);
      return;
      localHashMap.put("totalNum", String.valueOf(paramInt1));
    }
  }
  
  public static a a(bb parambb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65305);
    a locala = new a();
    locala.wording = paramJSONObject.optString("retmsg");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("showmess");
    locala.oDJ = localJSONObject.optString("left_button_wording");
    locala.oDK = localJSONObject.optString("right_button_wording");
    locala.tVu = localJSONObject.optString("right_button_url");
    if (parambb != null) {
      parambb.EBQ = paramJSONObject.optInt("return_to_session", 0);
    }
    AppMethodBeat.o(65305);
    return locala;
  }
  
  public static boolean l(q paramq)
  {
    AppMethodBeat.i(65306);
    try
    {
      paramq = new JSONObject(z.b(((ckc)d.c.b(((d)paramq.getReqResp()).lBS)).TrG));
      if (paramq.has("showmess"))
      {
        boolean bool = Util.isEqual(paramq.optJSONObject("showmess").optInt("return_to_session", 0), 1);
        if (bool)
        {
          AppMethodBeat.o(65306);
          return true;
        }
      }
    }
    catch (Exception paramq)
    {
      Log.i("MicroMsg.NetScenePrepareLuckyMoney", "ifReturnByReturnToSession() Exception：%s", new Object[] { paramq.getMessage() });
      AppMethodBeat.o(65306);
    }
    return false;
  }
  
  public String cOd()
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
    this.ybP = paramJSONObject.optString("sendId");
    this.ByI = paramJSONObject.optString("reqkey");
    this.EBL = paramJSONObject.optString("sendMsgXml");
    this.EBM = paramJSONObject.optString("guide_flag", "0");
    this.EBN = paramJSONObject.optString("guide_wording");
    this.oDJ = paramJSONObject.optString("left_button_wording", "");
    this.oDK = paramJSONObject.optString("right_button_wording", "");
    this.EBO = paramJSONObject.optString("upload_credit_url", "");
    this.EBP = paramJSONObject.optString("id_sign", "");
    if (paramJSONObject.has("showmess"))
    {
      Log.i("MicroMsg.NetScenePrepareLuckyMoney", "has alert item");
      this.fUY = a(this, paramJSONObject);
    }
    AppMethodBeat.o(65304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bb
 * JD-Core Version:    0.7.0.1
 */