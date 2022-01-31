package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.h.a.ht;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    y.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
    ht localht = new ht();
    localht.bPN.scene = 2;
    com.tencent.mm.sdk.b.a.udP.m(localht);
    a.a(this.loe, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.1
 * JD-Core Version:    0.7.0.1
 */