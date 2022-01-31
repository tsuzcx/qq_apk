package com.tencent.mm.plugin.g;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.ag.n;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.p.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMAppMgr;

final class e$1
  implements p.a
{
  e$1(e parame) {}
  
  public final void a(p paramp) {}
  
  public final void a(p paramp, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramp.foreground))
    {
      if (!e.awC()) {
        y.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
      }
    }
    else {
      return;
    }
    com.tencent.mrs.a.onDestroy();
    MMAppMgr.czD();
    y.appenderClose();
    BaseEvent.onSingalCrash(0);
    y.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
    if (com.tencent.mm.platformtools.a.UH())
    {
      y.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
      return;
    }
    paramp = ae.getContext();
    paramp.stopService(new Intent(paramp, NotifyReceiver.NotifyService.class));
    n.p(new e.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.g.e.1
 * JD-Core Version:    0.7.0.1
 */