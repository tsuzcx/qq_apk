package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class be
  extends ax
{
  public String CAf;
  public String Hgk;
  public String KuM;
  
  public be(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, int paramInt4, int paramInt5, String paramString8)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt2, "", "", paramString6, paramInt3, paramString7, paramInt4, paramInt5, paramString8);
  }
  
  private be(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8, int paramInt3, String paramString9, int paramInt4, int paramInt5, String paramString10)
  {
    AppMethodBeat.i(65307);
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramInt1));
    localHashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(paramString1)));
    localHashMap.put("sendUserName", paramString4);
    if (!Util.isNullOrNil(paramString3)) {
      localHashMap.put("username", paramString3);
    }
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("headImg", URLEncoder.encode(paramString2));
    }
    if (!Util.isNullOrNil(paramString5)) {
      localHashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString5)));
    }
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("imageId", paramString6);
    localHashMap.put("imageAesKey", paramString7);
    localHashMap.put("imageLength", "0");
    localHashMap.put("expressionurl", paramString8);
    localHashMap.put("expressiontype", String.valueOf(paramInt3));
    if (!Util.isNullOrNil(paramString9)) {
      localHashMap.put("unique_id", paramString9);
    }
    localHashMap.put("user_confirm_jump", String.valueOf(paramInt4));
    localHashMap.put("unpay_type", String.valueOf(paramInt5));
    if (!Util.isNullOrNil(paramString10)) {
      localHashMap.put("cancel_sendid", paramString10);
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(65307);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/yearrequestwxhb";
  }
  
  public final int getType()
  {
    return 1643;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65308);
    this.CAf = paramJSONObject.optString("sendId");
    this.Hgk = paramJSONObject.optString("reqkey");
    this.KuM = paramJSONObject.optString("sendMsgXml");
    AppMethodBeat.o(65308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.be
 * JD-Core Version:    0.7.0.1
 */