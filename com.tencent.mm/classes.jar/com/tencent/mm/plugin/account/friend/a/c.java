package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class c
  extends com.tencent.mm.sdk.b.c<ak>
{
  public c()
  {
    AppMethodBeat.i(161616);
    this.__eventId = ak.class.getName().hashCode();
    AppMethodBeat.o(161616);
  }
  
  private static boolean a(ak paramak)
  {
    AppMethodBeat.i(130988);
    if (paramak.dlY.dma == 0) {}
    try
    {
      int i = v.aAO() | 0x1000;
      g.ajR().ajA().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      ae.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      AppMethodBeat.o(130988);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.c
 * JD-Core Version:    0.7.0.1
 */