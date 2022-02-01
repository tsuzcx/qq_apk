package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bk;

public class MMAutoMessageHeardReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(21161);
    paramContext = x.getStringExtra(paramIntent, "key_username");
    if (paramContext == null)
    {
      AppMethodBeat.o(21161);
      return;
    }
    ac.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", new Object[] { paramContext });
    az.ayM();
    c.awG().aNK(paramContext);
    AppMethodBeat.o(21161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageHeardReceiver
 * JD-Core Version:    0.7.0.1
 */