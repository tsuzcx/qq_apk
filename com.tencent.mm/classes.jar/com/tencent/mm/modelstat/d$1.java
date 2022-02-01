package com.tencent.mm.modelstat;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;

final class d$1
  implements Runnable
{
  d$1(int paramInt1, String paramString, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(224408);
    Intent localIntent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
    localIntent.putExtra("opCode", this.Jtm);
    localIntent.putExtra("ui", this.jCH);
    localIntent.putExtra("uiHashCode", this.jCI);
    localIntent.putExtra("nowMilliSecond", bu.fpO());
    localIntent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
    i.bk(localIntent);
    Context localContext = ak.getContext();
    if (localContext != null)
    {
      if (!ak.cpe()) {
        break label111;
      }
      c.aLY().j(localIntent);
    }
    for (;;)
    {
      localIntent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
      localContext.sendBroadcast(localIntent);
      AppMethodBeat.o(224408);
      return;
      label111:
      ae.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[] { localIntent, localIntent.getExtras() });
      localContext.sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.d.1
 * JD-Core Version:    0.7.0.1
 */