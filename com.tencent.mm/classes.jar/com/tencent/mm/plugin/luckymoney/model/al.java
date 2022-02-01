package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class al
  extends ak
{
  public al(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(65277);
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("timeStamp", paramString2);
    localHashMap.put("nonceStr", paramString3);
    if (paramString4 != null) {
      localHashMap.put("package", URLEncoder.encode(paramString4));
    }
    localHashMap.put("signType", paramString5);
    if (paramString6 != null) {
      localHashMap.put("paySign", URLEncoder.encode(paramString6));
    }
    localHashMap.put("way", "3");
    if (paramString7 != null) {
      localHashMap.put("jsapiH5Url", URLEncoder.encode(paramString7));
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(65277);
  }
  
  public al(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(65278);
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("timeStamp", paramString2);
    localHashMap.put("nonceStr", paramString3);
    if (paramString4 != null) {
      localHashMap.put("package", URLEncoder.encode(paramString4));
    }
    localHashMap.put("signType", paramString5);
    if (paramString6 != null) {
      localHashMap.put("paySign", URLEncoder.encode(paramString6));
    }
    localHashMap.put("way", "4");
    if (paramString7 != null) {
      localHashMap.put("androidSign", URLEncoder.encode(paramString7));
    }
    if (paramString8 != null) {
      localHashMap.put("androidPackage", URLEncoder.encode(paramString8));
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(65278);
  }
  
  public final int drJ()
  {
    return 2;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.al
 * JD-Core Version:    0.7.0.1
 */