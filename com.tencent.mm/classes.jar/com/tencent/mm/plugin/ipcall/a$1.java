package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.kn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(25281);
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
    kn localkn = new kn();
    localkn.fIb.scene = 2;
    EventCenter.instance.publish(localkn);
    a.a(this.DOg, System.currentTimeMillis());
    AppMethodBeat.o(25281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.1
 * JD-Core Version:    0.7.0.1
 */