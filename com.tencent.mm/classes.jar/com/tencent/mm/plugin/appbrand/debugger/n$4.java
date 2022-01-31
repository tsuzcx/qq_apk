package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.c.cgk;
import com.tencent.mm.protocal.c.chb;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.TimerTask;

final class n$4
  extends TimerTask
{
  n$4(n paramn) {}
  
  public final void run()
  {
    if ((n.a(this.fSL).isBusy()) && (this.fSL.aeI())) {
      y.i("MicroMsg.RemoteDebugMsgMrg", "testServer");
    }
    for (;;)
    {
      ai.d(new s.7(n.d(this.fSL)));
      return;
      this.fSL.aeH();
      long l = System.currentTimeMillis();
      if (l - n.a(this.fSL).fRS >= 10000L)
      {
        n localn = this.fSL;
        Object localObject = new chb();
        ((chb)localObject).tVQ = localn.fSm.fRJ;
        ((chb)localObject).tVR = localn.fSm.aeA();
        localObject = r.a(1001, (a)localObject);
        localn.fSo.a((cgk)localObject);
      }
      if ((n.a(this.fSL).isReady()) && (l - n.a(this.fSL).fRT >= 30000L)) {
        this.fSL.bP(n.a(this.fSL).aeA(), 2147483647);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n.4
 * JD-Core Version:    0.7.0.1
 */