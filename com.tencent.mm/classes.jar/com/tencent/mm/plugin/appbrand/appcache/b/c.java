package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ck.f;
import com.tencent.mm.ck.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public enum c
  implements n
{
  private c() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    paramString = (String)paramMap.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
    if (!bk.bl(paramString)) {
      g.cn(paramString).j(new c.1(this));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c
 * JD-Core Version:    0.7.0.1
 */