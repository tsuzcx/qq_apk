package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.kz.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class b$4
  extends c<kz>
{
  b$4(b paramb)
  {
    AppMethodBeat.i(161072);
    this.__eventId = kz.class.getName().hashCode();
    AppMethodBeat.o(161072);
  }
  
  private static boolean a(kz paramkz)
  {
    AppMethodBeat.i(108399);
    if ((paramkz != null) && ((paramkz instanceof kz)))
    {
      ad.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
      if (paramkz.dpr.result)
      {
        g.afB().afk().set(ae.a.Fgo, Boolean.TRUE);
        g.afB().afk().set(ae.a.Fgp, Boolean.TRUE);
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