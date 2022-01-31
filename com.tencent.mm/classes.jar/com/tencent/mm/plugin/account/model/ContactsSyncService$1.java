package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.y;

final class ContactsSyncService$1
  implements b
{
  ContactsSyncService$1(ContactsSyncService paramContactsSyncService) {}
  
  public final void bW(boolean paramBoolean)
  {
    y.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ContactsSyncService.a(this.fjq);
      return;
    }
    g.Dk().a(133, this.fjq);
    System.currentTimeMillis();
    al localal = new al(l.WW(), l.WV());
    g.Dk().a(localal, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService.1
 * JD-Core Version:    0.7.0.1
 */