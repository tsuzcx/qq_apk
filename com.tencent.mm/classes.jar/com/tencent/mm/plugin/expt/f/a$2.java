package com.tencent.mm.plugin.expt.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

final class a$2
  implements p
{
  a$2(a parama) {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(122318);
    if (!"expt".equals(paramString))
    {
      ad.w("MicroMsg.ExptService", "receive expt xml but subtype[%s] is error", new Object[] { paramString });
      AppMethodBeat.o(122318);
      return null;
    }
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      ad.w("MicroMsg.ExptService", "receive expt xml but map is null");
      AppMethodBeat.o(122318);
      return null;
    }
    paramString = (String)paramMap.get(".sysmsg.content");
    this.rax.afz(paramString);
    AppMethodBeat.o(122318);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.a.2
 * JD-Core Version:    0.7.0.1
 */