package com.tencent.mm.plugin.messenger.b;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$1
  implements o
{
  a$1(a parama) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    y.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", new Object[] { paramMap.toString() });
    a.a(this.mdK, paramString, paramMap, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a.1
 * JD-Core Version:    0.7.0.1
 */