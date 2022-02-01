package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class b$4
  extends c<li>
{
  b$4(b paramb)
  {
    AppMethodBeat.i(161072);
    this.__eventId = li.class.getName().hashCode();
    AppMethodBeat.o(161072);
  }
  
  private static boolean a(li paramli)
  {
    AppMethodBeat.i(108399);
    if ((paramli != null) && ((paramli instanceof li)))
    {
      ac.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
      if (paramli.dnc.result)
      {
        g.agR().agA().set(ah.a.GEc, Boolean.TRUE);
        g.agR().agA().set(ah.a.GEd, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(108399);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.4
 * JD-Core Version:    0.7.0.1
 */