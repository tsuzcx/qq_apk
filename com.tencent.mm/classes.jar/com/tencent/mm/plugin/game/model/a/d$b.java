package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class d$b
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!com.tencent.mm.kernel.g.DK()) || (a.CW())) {
      y.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
    }
    int i;
    do
    {
      return;
      i = aq.getNetType(ae.getContext());
    } while (i == d.access$200());
    d.eo(i);
    if (i == 0)
    {
      y.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, checkDownload", new Object[] { Integer.valueOf(i) });
      g.a.aZT().gx(false);
      return;
    }
    y.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, pauseDownload", new Object[] { Integer.valueOf(i) });
    g.a.aZT();
    g.pauseDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.d.b
 * JD-Core Version:    0.7.0.1
 */