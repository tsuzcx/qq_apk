package com.tencent.mm.plugin.box.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
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
    localStringBuffer.append(ad.toUrlParams(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(76335);
    return paramHashMap;
  }
  
  private static void h(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(76336);
    paramHashMap.put("lang", ac.iM(aj.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(ad.We(2)));
    paramHashMap.put("netType", ad.Ux());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", i.hgG);
    AppMethodBeat.o(76336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.b
 * JD-Core Version:    0.7.0.1
 */