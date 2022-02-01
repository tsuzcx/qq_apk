package com.tencent.mm.modelstat;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class c$3
  implements Runnable
{
  c$3(c paramc, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(151010);
    String str = this.val$intent.getStringExtra("ui");
    int i = this.val$intent.getIntExtra("uiHashCode", 0);
    int j = this.val$intent.getIntExtra("opCode", 0);
    long l1 = this.val$intent.getLongExtra("nowMilliSecond", 0L);
    long l2 = this.val$intent.getLongExtra("elapsedRealtime", 0L);
    Log.d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d, elapsed time:%d", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Long.valueOf(Util.milliSecondsToNow(l1)), Long.valueOf(l2) });
    if (2147483632 == j)
    {
      c.a(this.mcO);
      AppMethodBeat.o(151010);
      return;
    }
    c.a(this.mcO, j, str, i, l1, l2);
    AppMethodBeat.o(151010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.3
 * JD-Core Version:    0.7.0.1
 */