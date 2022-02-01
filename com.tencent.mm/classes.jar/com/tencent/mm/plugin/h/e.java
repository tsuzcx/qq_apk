package com.tencent.mm.plugin.h;

import android.content.Intent;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.am.s.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMAppMgr;

public final class e
  extends com.tencent.mm.kernel.a.c.a
{
  private ax okV;
  
  public e(ax paramax)
  {
    this.okV = paramax;
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(22638);
    bh.a(this.okV, new s.a()
    {
      public final void a(s paramAnonymouss) {}
      
      public final void a(s paramAnonymouss, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22637);
        if ((paramAnonymousBoolean) && (!paramAnonymouss.foreground))
        {
          if (!e.dbc())
          {
            Log.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
            AppMethodBeat.o(22637);
            return;
          }
          MMAppMgr.jjY();
          Log.appenderClose();
          Mars.onSingalCrash(0);
          Log.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
          if (com.tencent.mm.platformtools.a.bTp())
          {
            Log.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
            AppMethodBeat.o(22637);
            return;
          }
          c.bV(new Intent(MMApplicationContext.getContext(), NotifyReceiver.NotifyService.class));
          p.M(new e.1.1(this));
        }
        AppMethodBeat.o(22637);
      }
    });
    AppMethodBeat.o(22638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.h.e
 * JD-Core Version:    0.7.0.1
 */