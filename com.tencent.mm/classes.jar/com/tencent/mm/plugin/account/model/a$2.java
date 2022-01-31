package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class a$2
  extends ak
{
  a$2(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(124655);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124655);
      return;
      this.gAE.fQi = true;
      boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(this.gAE.fBi);
      if (!bool) {
        this.gAE.fQi = false;
      }
      ab.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a.2
 * JD-Core Version:    0.7.0.1
 */