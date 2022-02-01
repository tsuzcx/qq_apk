package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bq;

public class MMAutoMessageHeardReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(21161);
    paramContext = y.getStringExtra(paramIntent, "key_username");
    if (paramContext == null)
    {
      AppMethodBeat.o(21161);
      return;
    }
    ad.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", new Object[] { paramContext });
    if ((!g.ajD().gBW) || (!g.ajA().aiK()))
    {
      ad.e("MicroMsg.auto.MMAutoMessageHeardReceiver", "kernel or account not ready.");
      AppMethodBeat.o(21161);
      return;
    }
    ba.aBQ();
    c.azv().aTB(paramContext);
    AppMethodBeat.o(21161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageHeardReceiver
 * JD-Core Version:    0.7.0.1
 */