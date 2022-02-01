package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aq.a;
import com.tencent.mm.ay.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class BindQQEventListenerImpl
  extends IListener<com.tencent.mm.autogen.a.aq>
{
  public BindQQEventListenerImpl()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161616);
    this.__eventId = com.tencent.mm.autogen.a.aq.class.getName().hashCode();
    AppMethodBeat.o(161616);
  }
  
  private static boolean a(com.tencent.mm.autogen.a.aq paramaq)
  {
    AppMethodBeat.i(130988);
    if (paramaq.hAp.hAr == 0) {}
    try
    {
      int i = z.bBf() | 0x1000;
      h.baE().ban().B(34, Integer.valueOf(i));
      ((n)h.ax(n.class)).bzz().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      Log.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      AppMethodBeat.o(130988);
      return false;
    }
    catch (Exception paramaq)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramaq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.BindQQEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */