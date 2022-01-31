package com.tencent.mm.bd;

import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;

public final class b$1
  implements Runnable
{
  public b$1(b paramb, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (b.a(this.eyi)) {
      y.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
    }
    do
    {
      return;
      if (!b.b(this.eyi))
      {
        y.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
        return;
      }
      b.PU();
      if ((b.c(this.eyi).size() == 0) && (b.d(this.eyi).size() == 0)) {
        b.e(this.eyi);
      }
    } while (!b.a(this.eyi, this.eya, this.eyb, this.eyc));
    y.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[] { Integer.valueOf(this.eya), Float.valueOf(this.eyb), Float.valueOf(this.eyc), Integer.valueOf(this.egz) });
    b.a(this.eyi, true);
    g.DP().Dz().c(ac.a.utr, Long.valueOf(bk.UX()));
    a.udP.c(b.f(this.eyi));
    if (b.g(this.eyi) != null) {
      b.g(this.eyi).finish();
    }
    b.h(this.eyi);
    b.a(this.eyi, bk.UZ());
    b.a(this.eyi, new c(this.eyb, this.eyc, this.eyd, this.eyf, this.eyg, this.eyh, this.eya, this.egz));
    SwEngine.setImei(b.PV());
    SwEngine.creatLocationEngine(ae.getContext(), b.g(this.eyi));
    SwEngine.startContinousLocationUpdate(b.i(this.eyi), this.eyi.exO, this.eyi.exP, b.j(this.eyi), b.k(this.eyi));
    b.PW();
    b.a(this.eyi, this.eyi.exQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bd.b.1
 * JD-Core Version:    0.7.0.1
 */