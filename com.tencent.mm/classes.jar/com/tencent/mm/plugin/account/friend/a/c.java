package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.ag.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class c
  extends com.tencent.mm.sdk.b.c<ag>
{
  public c()
  {
    AppMethodBeat.i(108323);
    this.__eventId = ag.class.getName().hashCode();
    AppMethodBeat.o(108323);
  }
  
  private static boolean a(ag paramag)
  {
    AppMethodBeat.i(108324);
    if (paramag.cno.cnq == 0) {}
    try
    {
      int i = r.Zy() | 0x1000;
      g.RL().Ru().set(34, Integer.valueOf(i));
      ((j)g.E(j.class)).Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      ab.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      AppMethodBeat.o(108324);
      return false;
    }
    catch (Exception paramag)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramag, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.c
 * JD-Core Version:    0.7.0.1
 */