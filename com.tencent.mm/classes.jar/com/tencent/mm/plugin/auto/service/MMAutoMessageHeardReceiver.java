package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.auto.model.a;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.by;

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
    if ((!h.baF().mDv) || (!h.baC().aZN()))
    {
      Log.e("MicroMsg.auto.MMAutoMessageHeardReceiver", "kernel or account not ready.");
      AppMethodBeat.o(21161);
      return;
    }
    if (!a.cUy())
    {
      AppMethodBeat.o(21161);
      return;
    }
    if (!a.cUz())
    {
      Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not open car mode");
      AppMethodBeat.o(21161);
      return;
    }
    if (!a.cUA())
    {
      Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not install auto app");
      AppMethodBeat.o(21161);
      return;
    }
    paramIntent = com.tencent.mm.plugin.auto.model.b.uVJ;
    com.tencent.mm.plugin.auto.model.b.jX(2L);
    bh.bCz();
    c.bzG().bxO(paramContext);
    AppMethodBeat.o(21161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageHeardReceiver
 * JD-Core Version:    0.7.0.1
 */