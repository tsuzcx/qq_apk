package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

final class a$2
  implements Runnable
{
  a$2(long paramLong, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(124505);
    if ((a.aoh() != null) && (a.aoh().isAlive())) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.giS.size()), Long.valueOf(this.giU), this.giV });
      a.giS.add(this.giV);
      if (!bool) {
        break;
      }
      AppMethodBeat.o(124505);
      return;
    }
    a.b(d.a(new a.a((byte)0), "AddrBookSyncHelper_addrBookRead", 1));
    l.dx(true);
    a.aoh().start();
    AppMethodBeat.o(124505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.a.2
 * JD-Core Version:    0.7.0.1
 */