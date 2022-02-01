package com.tencent.mm.plugin.e;

import android.content.Intent;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMAppMgr;

public final class e
  extends com.tencent.mm.kernel.a.c.a
{
  private as hIM;
  
  public e(as paramas)
  {
    this.hIM = paramas;
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(22638);
    bc.a(this.hIM, new q.a()
    {
      public final void a(q paramAnonymousq) {}
      
      public final void a(q paramAnonymousq, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22637);
        if ((paramAnonymousBoolean) && (!paramAnonymousq.foreground))
        {
          if (!e.bNQ())
          {
            ae.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
            AppMethodBeat.o(22637);
            return;
          }
          MMAppMgr.fAZ();
          ae.appenderClose();
          Mars.onSingalCrash(0);
          ae.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
          if (com.tencent.mm.platformtools.a.aQJ())
          {
            ae.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
            AppMethodBeat.o(22637);
            return;
          }
          d.bg(new Intent(ak.getContext(), NotifyReceiver.NotifyService.class));
          o.D(new Runnable()
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
    });
    AppMethodBeat.o(22638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.e.e
 * JD-Core Version:    0.7.0.1
 */