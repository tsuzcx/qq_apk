package com.tencent.mm.modelfriend;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.y;

final class AddrBookObserver$AddrBookService$1
  implements b
{
  AddrBookObserver$AddrBookService$1(AddrBookObserver.AddrBookService paramAddrBookService) {}
  
  public final void bW(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      y.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
      this.ekS.stopSelf();
      AddrBookObserver.AddrBookService.ekO = false;
      return;
    }
    System.currentTimeMillis();
    al localal = new al(l.WW(), l.WV());
    g.Dk().a(localal, 0);
    this.ekS.stopSelf();
    AddrBookObserver.AddrBookService.ekO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService.1
 * JD-Core Version:    0.7.0.1
 */