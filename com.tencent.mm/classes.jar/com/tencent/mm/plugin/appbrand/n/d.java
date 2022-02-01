package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class d
  implements f.a
{
  public final String e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(47715);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      ad.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
      AppMethodBeat.o(47715);
      return "";
    }
    paramMap = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(47715);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d
 * JD-Core Version:    0.7.0.1
 */