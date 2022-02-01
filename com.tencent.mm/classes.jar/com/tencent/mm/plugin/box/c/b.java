package com.tencent.mm.plugin.box.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;

public final class b
{
  public static String a(HashMap<String, String> paramHashMap, String paramString)
  {
    AppMethodBeat.i(76335);
    h(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(paramString);
    localStringBuffer.append("?");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.toUrlParams(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(76335);
    return paramHashMap;
  }
  
  private static void h(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(76336);
    paramHashMap.put("lang", com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(com.tencent.mm.plugin.websearch.api.ad.WL(2)));
    paramHashMap.put("netType", com.tencent.mm.plugin.websearch.api.ad.UD());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", j.hju);
    AppMethodBeat.o(76336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.b
 * JD-Core Version:    0.7.0.1
 */