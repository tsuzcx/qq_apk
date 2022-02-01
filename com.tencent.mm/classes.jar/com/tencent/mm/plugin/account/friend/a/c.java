package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

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
    if (paramak.dkW.dkY == 0) {}
    try
    {
      int i = u.aAy() | 0x1000;
      g.ajC().ajl().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new com.tencent.mm.bb.l("", "", "", "", "", "", "", "", i, "", ""));
      ad.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      AppMethodBeat.o(130988);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.c
 * JD-Core Version:    0.7.0.1
 */