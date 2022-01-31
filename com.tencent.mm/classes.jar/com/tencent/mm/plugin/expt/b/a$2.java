package com.tencent.mm.plugin.expt.b;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$2
  implements n
{
  a$2(a parama) {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    if (!"expt".equals(paramString))
    {
      y.w("MicroMsg.ExptService", "receive expt xml but subtype[%s] is error", new Object[] { paramString });
      return null;
    }
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      y.w("MicroMsg.ExptService", "receive expt xml but map is null");
      return null;
    }
    paramString = (String)paramMap.get(".sysmsg.content");
    this.jIq.BW(paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.a.2
 * JD-Core Version:    0.7.0.1
 */