package com.tencent.mm.platformtools;

import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

final class a$2
  implements Runnable
{
  a$2(long paramLong, b paramb) {}
  
  public final void run()
  {
    if ((a.UI() != null) && (a.UI().isAlive())) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.eQX.size()), Long.valueOf(this.eQZ), this.eRa });
      a.eQX.add(this.eRa);
      if (!bool) {
        break;
      }
      return;
    }
    a.b(e.c(new a.a((byte)0), "AddrBookSyncHelper_addrBookRead", 1));
    l.WM();
    a.UI().start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.a.2
 * JD-Core Version:    0.7.0.1
 */