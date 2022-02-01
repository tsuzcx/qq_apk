package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aj.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

public final class c
  extends com.tencent.mm.sdk.b.c<aj>
{
  public c()
  {
    AppMethodBeat.i(161616);
    this.__eventId = aj.class.getName().hashCode();
    AppMethodBeat.o(161616);
  }
  
  private static boolean a(aj paramaj)
  {
    AppMethodBeat.i(130988);
    if (paramaj.dcf.dch == 0) {}
    try
    {
      int i = u.aqS() | 0x1000;
      g.afB().afk().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.bb.k("", "", "", "", "", "", "", "", i, "", ""));
      ad.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      AppMethodBeat.o(130988);
      return false;
    }
    catch (Exception paramaj)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramaj, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.c
 * JD-Core Version:    0.7.0.1
 */