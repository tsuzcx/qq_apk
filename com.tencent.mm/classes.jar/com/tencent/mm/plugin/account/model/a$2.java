package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  extends ah
{
  a$2(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.fjm.eAp = true;
    boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(this.fjm.ekR);
    if (!bool) {
      this.fjm.eAp = false;
    }
    y.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a.2
 * JD-Core Version:    0.7.0.1
 */