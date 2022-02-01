package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.auto.a.b;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bw;

public class MMAutoMessageHeardReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(21161);
    paramContext = IntentUtil.getStringExtra(paramIntent, "key_username");
    if (paramContext == null)
    {
      AppMethodBeat.o(21161);
      return;
    }
    Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", new Object[] { paramContext });
    if ((!g.aAi().hrr) || (!g.aAf().azp()))
    {
      Log.e("MicroMsg.auto.MMAutoMessageHeardReceiver", "kernel or account not ready.");
      AppMethodBeat.o(21161);
      return;
    }
    if (!com.tencent.mm.plugin.auto.a.a.ceB())
    {
      AppMethodBeat.o(21161);
      return;
    }
    if (!com.tencent.mm.plugin.auto.a.a.ceC())
    {
      Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not open car mode");
      AppMethodBeat.o(21161);
      return;
    }
    if (!com.tencent.mm.plugin.auto.a.a.ceD())
    {
      Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not install auto app");
      AppMethodBeat.o(21161);
      return;
    }
    paramIntent = b.oIG;
    b.Bt(2L);
    bg.aVF();
    c.aST().bka(paramContext);
    AppMethodBeat.o(21161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageHeardReceiver
 * JD-Core Version:    0.7.0.1
 */