package com.tencent.mm.be;

import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(78527);
    if (b.a(this.fNW))
    {
      ab.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
      AppMethodBeat.o(78527);
      return;
    }
    if (!b.b(this.fNW))
    {
      ab.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
      AppMethodBeat.o(78527);
      return;
    }
    b.aiZ();
    if ((b.c(this.fNW).size() == 0) && (b.d(this.fNW).size() == 0)) {
      b.e(this.fNW);
    }
    if (!b.a(this.fNW, this.fNP, this.fNQ, this.fNR))
    {
      AppMethodBeat.o(78527);
      return;
    }
    ab.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[] { Integer.valueOf(this.fNP), Float.valueOf(this.fNQ), Float.valueOf(this.fNR), Integer.valueOf(this.fwD) });
    b.a(this.fNW, true);
    g.RL().Ru().set(ac.a.yDt, Long.valueOf(bo.aox()));
    a.ymk.c(b.f(this.fNW));
    if (b.g(this.fNW) != null) {
      b.g(this.fNW).finish();
    }
    b.h(this.fNW);
    b.a(this.fNW, bo.yB());
    b.a(this.fNW, new c(this.fNQ, this.fNR, this.fNS, this.fNT, this.fNU, this.fNV, this.fNP, this.fwD));
    SwEngine.setImei(b.aja());
    SwEngine.creatLocationEngine(ah.getContext(), b.g(this.fNW));
    SwEngine.startContinousLocationUpdate(b.i(this.fNW), this.fNW.fND, this.fNW.fNE, b.j(this.fNW), b.k(this.fNW));
    b.ajb();
    b.a(this.fNW, this.fNW.fNF);
    AppMethodBeat.o(78527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.b.1
 * JD-Core Version:    0.7.0.1
 */