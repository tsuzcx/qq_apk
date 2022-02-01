package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class e
  implements f.a
{
  public final String e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(47715);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      ac.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
      AppMethodBeat.o(47715);
      return "";
    }
    paramMap = bs.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(47715);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.e
 * JD-Core Version:    0.7.0.1
 */