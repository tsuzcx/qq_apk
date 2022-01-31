package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class c
  implements e.a
{
  public final String g(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      y.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
      return "";
    }
    return bk.pm((String)paramMap.get(paramString + ".title"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.c
 * JD-Core Version:    0.7.0.1
 */