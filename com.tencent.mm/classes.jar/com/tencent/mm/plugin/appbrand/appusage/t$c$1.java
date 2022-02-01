package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.eoa;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.sdk.platformtools.Log;

final class t$c$1
  implements b.a
{
  int count = 0;
  
  t$c$1(t.c paramc) {}
  
  public final boolean a(boolean paramBoolean, final float paramFloat1, final float paramFloat2, int paramInt, double paramDouble1, final double paramDouble2)
  {
    AppMethodBeat.i(44559);
    f.bs(this);
    com.tencent.mm.modelgeo.d.bca().c(this);
    paramInt = this.count;
    this.count = (paramInt + 1);
    if ((paramInt <= 0) && (paramBoolean))
    {
      d.a locala = new d.a();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/uploaduserlocationinfo";
      locala.funcId = 1154;
      locala.iLO = new eob();
      eoa localeoa = new eoa();
      localeoa.latitude = paramFloat2;
      localeoa.longitude = paramFloat1;
      localeoa.NlN = paramDouble2;
      locala.iLN = localeoa;
      aa.a(locala.aXF(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(44558);
          Log.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Double.valueOf(paramDouble2) });
          AppMethodBeat.o(44558);
          return 0;
        }
      }, true);
    }
    AppMethodBeat.o(44559);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.t.c.1
 * JD-Core Version:    0.7.0.1
 */