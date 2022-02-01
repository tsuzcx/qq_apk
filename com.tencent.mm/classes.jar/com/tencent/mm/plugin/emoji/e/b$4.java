package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.ls.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class b$4
  extends c<ls>
{
  b$4(b paramb)
  {
    AppMethodBeat.i(161072);
    this.__eventId = ls.class.getName().hashCode();
    AppMethodBeat.o(161072);
  }
  
  private static boolean a(ls paramls)
  {
    AppMethodBeat.i(108399);
    if ((paramls != null) && ((paramls instanceof ls)))
    {
      ae.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
      if (paramls.dzV.result)
      {
        g.ajR().ajA().set(am.a.IKR, Boolean.TRUE);
        g.ajR().ajA().set(am.a.IKS, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(108399);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.4
 * JD-Core Version:    0.7.0.1
 */