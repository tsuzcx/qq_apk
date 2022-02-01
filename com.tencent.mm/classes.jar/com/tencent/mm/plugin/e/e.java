package com.tencent.mm.plugin.e;

import android.content.Intent;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.o;
import com.tencent.mm.ak.t;
import com.tencent.mm.ak.t.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMAppMgr;

public final class e
  extends com.tencent.mm.kernel.a.c.a
{
  private aw iDw;
  
  public e(aw paramaw)
  {
    this.iDw = paramaw;
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(22638);
    bg.a(this.iDw, new t.a()
    {
      public final void a(t paramAnonymoust) {}
      
      public final void a(t paramAnonymoust, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22637);
        if ((paramAnonymousBoolean) && (!paramAnonymoust.foreground))
        {
          if (!e.ckQ())
          {
            Log.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
            AppMethodBeat.o(22637);
            return;
          }
          MMAppMgr.gIT();
          Log.appenderClose();
          Mars.onSingalCrash(0);
          Log.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
          if (com.tencent.mm.platformtools.a.bln())
          {
            Log.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
            AppMethodBeat.o(22637);
            return;
          }
          c.bs(new Intent(MMApplicationContext.getContext(), NotifyReceiver.NotifyService.class));
          o.H(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.e.e
 * JD-Core Version:    0.7.0.1
 */