package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class ExtControlProviderNearBy$4
  implements b.a
{
  ExtControlProviderNearBy$4(ExtControlProviderNearBy paramExtControlProviderNearBy) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(20365);
    if (ExtControlProviderNearBy.g(this.meN))
    {
      AppMethodBeat.o(20365);
      return false;
    }
    ExtControlProviderNearBy.h(this.meN);
    if (!paramBoolean)
    {
      ab.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
      ExtControlProviderNearBy.f(this.meN);
      ExtControlProviderNearBy.c(this.meN).countDown();
      AppMethodBeat.o(20365);
      return false;
    }
    kr localkr = new kr();
    localkr.cAF.ctW = ExtControlProviderNearBy.i(this.meN);
    localkr.cAF.cAH = paramFloat1;
    localkr.cAF.cyV = paramFloat2;
    localkr.cAF.cAI = ((int)paramDouble2);
    localkr.cAF.cAJ = paramInt;
    localkr.cAF.cAK = "";
    localkr.cAF.cAL = "";
    if (a.ymk.l(localkr)) {
      ab.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
    }
    AppMethodBeat.o(20365);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.4
 * JD-Core Version:    0.7.0.1
 */