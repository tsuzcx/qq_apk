package com.tencent.mm.plugin.box.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
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
    localStringBuffer.append(z.aW(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(76335);
    return paramHashMap;
  }
  
  private static void h(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(76336);
    paramHashMap.put("lang", ab.iC(ai.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(z.Ul(2)));
    paramHashMap.put("netType", z.dkv());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", h.gMJ);
    AppMethodBeat.o(76336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.b
 * JD-Core Version:    0.7.0.1
 */