package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class c
  extends IListener<am>
{
  public c()
  {
    AppMethodBeat.i(161616);
    this.__eventId = am.class.getName().hashCode();
    AppMethodBeat.o(161616);
  }
  
  private static boolean a(am paramam)
  {
    AppMethodBeat.i(130988);
    if (paramam.dDo.dDq == 0) {}
    try
    {
      int i = z.aUl() | 0x1000;
      g.aAh().azQ().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      Log.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      AppMethodBeat.o(130988);
      return false;
    }
    catch (Exception paramam)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramam, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.c
 * JD-Core Version:    0.7.0.1
 */