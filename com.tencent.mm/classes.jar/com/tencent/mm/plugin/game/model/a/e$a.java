package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class e$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(111513);
    if ((!g.RG()) || (a.QP()))
    {
      ab.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
      AppMethodBeat.o(111513);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(111513);
      return;
    }
    if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
    {
      ab.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
      h.a.bHb().ig(true);
      AppMethodBeat.o(111513);
      return;
    }
    if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction()))
    {
      ab.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
      h.a.bHb();
      h.pauseDownload();
    }
    AppMethodBeat.o(111513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e.a
 * JD-Core Version:    0.7.0.1
 */