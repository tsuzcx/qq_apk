package com.tencent.mm.platformtools;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements b
{
  public final void bW(boolean paramBoolean)
  {
    y.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      return;
    }
    System.currentTimeMillis();
    al localal = new al(l.WW(), l.WV());
    g.Dk().a(localal, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.a.1
 * JD-Core Version:    0.7.0.1
 */