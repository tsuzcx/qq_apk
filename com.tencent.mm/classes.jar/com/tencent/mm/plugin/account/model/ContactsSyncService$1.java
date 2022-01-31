package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ab;

final class ContactsSyncService$1
  implements b
{
  ContactsSyncService$1(ContactsSyncService paramContactsSyncService) {}
  
  public final void cY(boolean paramBoolean)
  {
    AppMethodBeat.i(124661);
    ab.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ContactsSyncService.a(this.gAI);
      AppMethodBeat.o(124661);
      return;
    }
    g.Rc().a(133, this.gAI);
    System.currentTimeMillis();
    l.aqv();
    al localal = new al(l.aqz(), l.aqy());
    g.Rc().a(localal, 0);
    AppMethodBeat.o(124661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService.1
 * JD-Core Version:    0.7.0.1
 */