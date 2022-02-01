package com.tencent.mm.plugin.e;

import android.content.Intent;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.al.q;
import com.tencent.mm.al.q.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMAppMgr;

public final class e
  extends com.tencent.mm.kernel.a.c.a
{
  private ap gNc;
  
  public e(ap paramap)
  {
    this.gNc = paramap;
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(22638);
    az.a(this.gNc, new q.a()
    {
      public final void a(q paramAnonymousq) {}
      
      public final void a(q paramAnonymousq, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22637);
        if ((paramAnonymousBoolean) && (!paramAnonymousq.foreground))
        {
          if (!e.bBH())
          {
            ad.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
            AppMethodBeat.o(22637);
            return;
          }
          MMAppMgr.eRc();
          ad.appenderClose();
          Mars.onSingalCrash(0);
          ad.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
          if (com.tencent.mm.platformtools.a.aGm())
          {
            ad.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
            AppMethodBeat.o(22637);
            return;
          }
          d.aZ(new Intent(aj.getContext(), NotifyReceiver.NotifyService.class));
          o.E(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.e.e
 * JD-Core Version:    0.7.0.1
 */