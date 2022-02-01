package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.l;
import com.tencent.mm.f.a.an;
import com.tencent.mm.f.a.an.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class c
  extends IListener<an>
{
  public c()
  {
    AppMethodBeat.i(161616);
    this.__eventId = an.class.getName().hashCode();
    AppMethodBeat.o(161616);
  }
  
  private static boolean a(an paraman)
  {
    AppMethodBeat.i(130988);
    if (paraman.fvU.fvW == 0) {}
    try
    {
      int i = z.bdn() | 0x1000;
      h.aHG().aHp().i(34, Integer.valueOf(i));
      ((n)h.ae(n.class)).bbK().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      Log.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      AppMethodBeat.o(130988);
      return false;
    }
    catch (Exception paraman)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paraman, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.c
 * JD-Core Version:    0.7.0.1
 */