package com.tencent.mm.plugin.game.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.game.luggage.d.a;
import com.tencent.mm.sdk.platformtools.ab;

final class aw$7
  implements d.a
{
  aw$7(String paramString, GameWebPerformanceInfo paramGameWebPerformanceInfo, c paramc, Bundle paramBundle) {}
  
  public final void tU()
  {
    AppMethodBeat.i(111470);
    ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    l.q(new aw.7.1(this));
    AppMethodBeat.o(111470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw.7
 * JD-Core Version:    0.7.0.1
 */