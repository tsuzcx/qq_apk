package com.tencent.mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public class ShortcutBroadCastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(79060);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
      AppMethodBeat.o(79060);
      return;
    }
    h.bO(paramContext, paramContext.getString(2131296540));
    AppMethodBeat.o(79060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.ShortcutBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */