package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.mi.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class b$4
  extends IListener<mi>
{
  b$4(b paramb)
  {
    AppMethodBeat.i(161072);
    this.__eventId = mi.class.getName().hashCode();
    AppMethodBeat.o(161072);
  }
  
  private static boolean a(mi parammi)
  {
    AppMethodBeat.i(108399);
    if ((parammi != null) && ((parammi instanceof mi)))
    {
      Log.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
      if (parammi.dRI.result)
      {
        g.aAh().azQ().set(ar.a.NSP, Boolean.TRUE);
        g.aAh().azQ().set(ar.a.NSQ, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(108399);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.4
 * JD-Core Version:    0.7.0.1
 */