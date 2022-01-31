package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.TimerTask;

final class p$4
  extends TimerTask
{
  p$4(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(101860);
    if ((p.a(this.hml).isBusy()) && (this.hml.azi())) {
      ab.i("MicroMsg.RemoteDebugMsgMrg", "testServer");
    }
    for (;;)
    {
      al.d(new u.7(p.d(this.hml)));
      AppMethodBeat.o(101860);
      return;
      this.hml.azh();
      long l = System.currentTimeMillis();
      if (l - p.a(this.hml).hlt >= 10000L)
      {
        p localp = this.hml;
        Object localObject = new cum();
        ((cum)localObject).ydg = localp.bER.hlk;
        ((cum)localObject).ydh = localp.bER.ayV();
        localObject = t.a(1001, (a)localObject);
        localp.hlO.a((ctv)localObject);
      }
      if ((p.a(this.hml).isReady()) && (l - p.a(this.hml).hlu >= 30000L)) {
        this.hml.da(p.a(this.hml).ayV(), 2147483647);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.p.4
 * JD-Core Version:    0.7.0.1
 */