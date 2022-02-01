package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class e
  implements e.a
{
  public final String h(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(47715);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      Log.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
      AppMethodBeat.o(47715);
      return "";
    }
    paramMap = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(47715);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.e
 * JD-Core Version:    0.7.0.1
 */