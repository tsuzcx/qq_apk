package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!com.tencent.mm.kernel.g.DK()) || (a.CW())) {
      y.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
    }
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
      {
        y.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
        g.a.aZT().gx(true);
        return;
      }
    } while (!"android.intent.action.BATTERY_LOW".equals(paramIntent.getAction()));
    y.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
    g.a.aZT();
    g.pauseDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.d.a
 * JD-Core Version:    0.7.0.1
 */