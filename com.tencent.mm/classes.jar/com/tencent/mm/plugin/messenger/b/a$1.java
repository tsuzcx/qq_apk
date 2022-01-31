package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class a$1
  implements o
{
  a$1(a parama) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(136919);
    ab.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", new Object[] { paramMap.toString() });
    a.a(this.oEg, paramString, paramMap, parama);
    AppMethodBeat.o(136919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a.1
 * JD-Core Version:    0.7.0.1
 */