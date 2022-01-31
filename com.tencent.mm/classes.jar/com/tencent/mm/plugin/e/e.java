package com.tencent.mm.plugin.e;

import android.content.Intent;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.n;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.p.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMAppMgr;

public final class e
  extends com.tencent.mm.kernel.a.c.a
{
  private am flO;
  
  public e(am paramam)
  {
    this.flO = paramam;
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(18526);
    aw.a(this.flO, new p.a()
    {
      public final void a(p paramAnonymousp) {}
      
      public final void a(p paramAnonymousp, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(18525);
        if ((paramAnonymousBoolean) && (!paramAnonymousp.foreground))
        {
          if (!e.aWf())
          {
            ab.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
            AppMethodBeat.o(18525);
            return;
          }
          com.tencent.mrs.a.onDestroy();
          MMAppMgr.dCx();
          ab.appenderClose();
          BaseEvent.onSingalCrash(0);
          ab.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
          if (com.tencent.mm.platformtools.a.aog())
          {
            ab.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
            AppMethodBeat.o(18525);
            return;
          }
          d.aH(new Intent(ah.getContext(), NotifyReceiver.NotifyService.class));
          n.w(new e.1.1(this));
        }
        AppMethodBeat.o(18525);
      }
    });
    AppMethodBeat.o(18526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.e.e
 * JD-Core Version:    0.7.0.1
 */