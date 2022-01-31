package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bk;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends ab
{
  public String lMg;
  public String lRA;
  public String lRB;
  
  public af(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramInt1));
    localHashMap.put("wishing", URLEncoder.encode(bk.pm(paramString1)));
    localHashMap.put("sendUserName", paramString4);
    if (!bk.bl(paramString3)) {
      localHashMap.put("username", paramString3);
    }
    if (!bk.bl(paramString2)) {
      localHashMap.put("headImg", URLEncoder.encode(paramString2));
    }
    if (!bk.bl(paramString5)) {
      localHashMap.put("nickName", URLEncoder.encode(bk.pm(paramString5)));
    }
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("imageId", paramString6);
    localHashMap.put("imageAesKey", paramString7);
    localHashMap.put("imageLength", String.valueOf(paramInt3));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.lMg = paramJSONObject.optString("sendId");
    this.lRA = paramJSONObject.optString("reqkey");
    this.lRB = paramJSONObject.optString("sendMsgXml");
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/yearrequestwxhb";
  }
  
  public final int getType()
  {
    return 1643;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.af
 * JD-Core Version:    0.7.0.1
 */