package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class e$1
  implements Runnable
{
  e$1(e parame, boolean paramBoolean1, float paramFloat1, float paramFloat2, int paramInt1, boolean paramBoolean2, int paramInt2) {}
  
  public final void run()
  {
    long l;
    try
    {
      if (!g.DN().Dc()) {
        break label677;
      }
      g.DN();
      if (a.CW()) {
        return;
      }
      l = bk.UY();
      if ((e.a(this.eCV) != 0L) && (l - e.a(this.eCV) < 1800000L))
      {
        y.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[] { Long.valueOf(l - e.a(this.eCV)) });
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[] { localException.getMessage() });
      return;
    }
    int i;
    if (this.eCQ)
    {
      localObject1 = e.b(this.eCV);
      break label678;
      if (i >= ((List)localObject1).size()) {
        break label671;
      }
      if ((!e.D(this.eCR, ((Float)((Pair)((List)localObject1).get(i)).first).floatValue())) || (!e.D(this.eCS, ((Float)((Pair)((List)localObject1).get(i)).second).floatValue()))) {
        break label683;
      }
      localObject1 = (Pair)((List)localObject1).get(i);
      label204:
      if (localObject1 == null) {
        y.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
      }
    }
    else
    {
      localObject1 = e.c(this.eCV);
      break label678;
    }
    e.a(this.eCV, l);
    Object localObject2 = new StringBuilder();
    g.DN();
    localObject2 = new o(a.CK()).toString() + "_" + e.a(this.eCV);
    Object localObject1 = new StringBuilder().append(((Pair)localObject1).first).append(",").append(((Pair)localObject1).second).append(",").append(this.egz).append(",");
    if (this.eCT)
    {
      i = 1;
      label345:
      if (!this.eCQ) {
        break label695;
      }
    }
    label671:
    label677:
    label678:
    label683:
    label695:
    for (int j = 10;; j = 20)
    {
      localObject1 = j + i + "," + this.eCR + "," + this.eCS + ",0," + this.eCU + "," + e.a(this.eCV) + ",";
      e.c localc = new e.c(this.eCV);
      Object localObject3 = ae.getContext();
      i = e.d(this.eCV);
      j = e.e(this.eCV);
      if (localc.bci == null) {
        localc.bci = ((WifiManager)((Context)localObject3).getSystemService("wifi"));
      }
      localc.eDo = i;
      localc.eCN = j;
      localc.startTime = bk.UY();
      localc.eDp = true;
      localc.thread.start();
      localObject3 = new e.b(this.eCV);
      boolean bool = ((e.b)localObject3).w(ae.getContext(), e.f(this.eCV));
      if (!bool)
      {
        y.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.valueOf(true), Boolean.valueOf(bool) });
        ((e.b)localObject3).Rr();
        localc.Rr();
        h.nFQ.aC(13381, (String)localObject1 + (String)localObject2 + ",-10002,ERROR:StartFailed.");
        return;
      }
      g.DQ();
      new am(g.DS().mnU.getLooper(), new e.1.1(this, (e.b)localObject3, localc, (String)localObject1, (String)localObject2), true).S(3000L, 3000L);
      return;
      localObject1 = null;
      break label204;
      return;
      i = 0;
      break;
      i += 1;
      break;
      i = 2;
      break label345;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.1
 * JD-Core Version:    0.7.0.1
 */