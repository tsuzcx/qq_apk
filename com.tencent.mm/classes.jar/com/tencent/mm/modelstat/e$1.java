package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class e$1
  implements Runnable
{
  e$1(e parame, boolean paramBoolean1, float paramFloat1, float paramFloat2, int paramInt1, boolean paramBoolean2, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(78716);
    for (;;)
    {
      try
      {
        boolean bool;
        if (g.RJ().QU())
        {
          g.RJ();
          bool = a.QP();
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(78716);
          return;
        }
        long l = bo.aoy();
        if ((e.a(this.fSM) != 0L) && (l - e.a(this.fSM) < 1800000L))
        {
          ab.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[] { Long.valueOf(l - e.a(this.fSM)) });
          AppMethodBeat.o(78716);
          return;
        }
        if (this.fSH)
        {
          localObject1 = e.b(this.fSM);
          break label727;
          if (i >= ((List)localObject1).size()) {
            break label721;
          }
          if ((!e.G(this.fSI, ((Float)((Pair)((List)localObject1).get(i)).first).floatValue())) || (!e.G(this.fSJ, ((Float)((Pair)((List)localObject1).get(i)).second).floatValue()))) {
            break label732;
          }
          localObject1 = (Pair)((List)localObject1).get(i);
          if (localObject1 == null)
          {
            ab.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
            AppMethodBeat.o(78716);
          }
        }
        else
        {
          localObject1 = e.c(this.fSM);
          break label727;
        }
        e.a(this.fSM, l);
        Object localObject3 = new StringBuilder();
        g.RJ();
        localObject3 = new p(a.getUin()).toString() + "_" + e.a(this.fSM);
        Object localObject1 = new StringBuilder().append(((Pair)localObject1).first).append(",").append(((Pair)localObject1).second).append(",").append(this.fwD).append(",");
        e.c localc;
        Object localObject4;
        if (this.fSK)
        {
          i = 1;
          if (this.fSH)
          {
            j = 10;
            localObject1 = j + i + "," + this.fSI + "," + this.fSJ + ",0," + this.fSL + "," + e.a(this.fSM) + ",";
            localc = new e.c(this.fSM);
            localObject4 = ah.getContext();
            i = e.d(this.fSM);
            j = e.e(this.fSM);
            if (localc.bsO == null) {
              localc.bsO = ((WifiManager)((Context)localObject4).getSystemService("wifi"));
            }
            localc.fTf = i;
            localc.fSE = j;
            localc.startTime = bo.aoy();
            localc.fTg = true;
            localc.thread.start();
            localObject4 = new e.b(this.fSM);
            ah.getContext();
            bool = ((e.b)localObject4).ma(e.f(this.fSM));
            if (bool) {
              continue;
            }
            ab.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool) });
            ((e.b)localObject4).akA();
            localc.akA();
            h.qsU.kvStat(13381, (String)localObject1 + (String)localObject3 + ",-10002,ERROR:StartFailed.");
            AppMethodBeat.o(78716);
          }
        }
        else
        {
          i = 2;
          continue;
        }
        int j = 20;
        continue;
        g.RM();
        new ap(g.RO().oNc.getLooper(), new e.1.1(this, (e.b)localObject4, localc, (String)localObject1, (String)localObject3), true).ag(3000L, 3000L);
        AppMethodBeat.o(78716);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(78716);
        return;
      }
      label721:
      Object localObject2 = null;
      continue;
      label727:
      int i = 0;
      continue;
      label732:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.1
 * JD-Core Version:    0.7.0.1
 */