package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(21658);
    ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
    hx localhx = new hx();
    localhx.cxg.scene = 2;
    com.tencent.mm.sdk.b.a.ymk.l(localhx);
    a.a(this.nLB, System.currentTimeMillis());
    AppMethodBeat.o(21658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.1
 * JD-Core Version:    0.7.0.1
 */