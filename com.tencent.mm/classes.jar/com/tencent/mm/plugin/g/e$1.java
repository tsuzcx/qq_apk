package com.tencent.mm.plugin.g;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.an.t;
import com.tencent.mm.an.t.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.by.c;
import com.tencent.mm.platformtools.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMAppMgr;

final class e$1
  implements t.a
{
  e$1(e parame) {}
  
  public final void a(t paramt) {}
  
  public final void a(t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(22637);
    if ((paramBoolean) && (!paramt.foreground))
    {
      if (!e.cyl())
      {
        Log.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
        AppMethodBeat.o(22637);
        return;
      }
      MMAppMgr.hHO();
      Log.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
      if (a.bvd())
      {
        Log.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
        AppMethodBeat.o(22637);
        return;
      }
      c.bs(new Intent(MMApplicationContext.getContext(), NotifyReceiver.NotifyService.class));
      p.H(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22636);
          AppMethodBeat.o(22636);
        }
      });
    }
    AppMethodBeat.o(22637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.g.e.1
 * JD-Core Version:    0.7.0.1
 */