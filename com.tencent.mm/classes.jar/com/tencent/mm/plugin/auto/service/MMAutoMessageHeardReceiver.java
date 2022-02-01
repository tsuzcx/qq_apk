package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.auto.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.br;

public class MMAutoMessageHeardReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(21161);
    paramContext = z.getStringExtra(paramIntent, "key_username");
    if (paramContext == null)
    {
      AppMethodBeat.o(21161);
      return;
    }
    ae.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", new Object[] { paramContext });
    if ((!g.ajS().gED) || (!g.ajP().aiZ()))
    {
      ae.e("MicroMsg.auto.MMAutoMessageHeardReceiver", "kernel or account not ready.");
      AppMethodBeat.o(21161);
      return;
    }
    if (!com.tencent.mm.plugin.auto.a.a.bHK())
    {
      AppMethodBeat.o(21161);
      return;
    }
    if (!com.tencent.mm.plugin.auto.a.a.bHL())
    {
      ae.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not open car mode");
      AppMethodBeat.o(21161);
      return;
    }
    if (!com.tencent.mm.plugin.auto.a.a.bHM())
    {
      ae.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not install auto app");
      AppMethodBeat.o(21161);
      return;
    }
    paramIntent = b.nxI;
    b.tn(2L);
    bc.aCg();
    c.azL().aVc(paramContext);
    AppMethodBeat.o(21161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageHeardReceiver
 * JD-Core Version:    0.7.0.1
 */