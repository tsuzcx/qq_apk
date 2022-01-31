package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.sdk.platformtools.ab;

final class i$5
  implements b.a
{
  i$5(i parami) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113743);
    if (!paramBoolean)
    {
      AppMethodBeat.o(113743);
      return false;
    }
    ab.d("MicroMsg.ViewMapUI", "onGetLocation flong " + paramFloat1 + " flat " + paramFloat2);
    if ((paramFloat2 == 0.0D) && (paramFloat1 == 0.0D))
    {
      AppMethodBeat.o(113743);
      return true;
    }
    ab.d("MicroMsg.ViewMapUI", "myLocation " + this.ohX.ofn.nZV + " " + this.ohX.ofn.nZW);
    ab.d("MicroMsg.ViewMapUI", "location my show");
    this.ohX.ofn.nZV = paramFloat2;
    this.ohX.ofn.nZW = paramFloat1;
    this.ohX.ofr.a(this.ohX.ofn.nZV, this.ohX.ofn.nZW, this.ohX.ofy, this.ohX.ofn.nZU);
    AppMethodBeat.o(113743);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.5
 * JD-Core Version:    0.7.0.1
 */