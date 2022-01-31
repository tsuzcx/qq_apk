package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class e$b
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(111514);
    if ((!g.RG()) || (a.QP()))
    {
      ab.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
      AppMethodBeat.o(111514);
      return;
    }
    int i = at.getNetType(ah.getContext());
    if (i == e.access$200())
    {
      AppMethodBeat.o(111514);
      return;
    }
    e.gb(i);
    if (i == 0)
    {
      ab.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, checkDownload", new Object[] { Integer.valueOf(i) });
      h.a.bHb().ig(false);
      AppMethodBeat.o(111514);
      return;
    }
    ab.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, pauseDownload", new Object[] { Integer.valueOf(i) });
    h.a.bHb();
    h.pauseDownload();
    AppMethodBeat.o(111514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e.b
 * JD-Core Version:    0.7.0.1
 */