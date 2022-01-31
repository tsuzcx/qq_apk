package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class c
  implements e.a
{
  public final String g(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(132274);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      ab.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
      AppMethodBeat.o(132274);
      return "";
    }
    paramMap = bo.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(132274);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.c
 * JD-Core Version:    0.7.0.1
 */