package com.tencent.mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public class ShortcutBroadCastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151431);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
      AppMethodBeat.o(151431);
      return;
    }
    h.cO(paramContext, paramContext.getString(c.h.app_added));
    AppMethodBeat.o(151431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.ShortcutBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */