package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class i$1
  implements b.a
{
  i$1(i parami) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113318);
    if (!paramBoolean)
    {
      AppMethodBeat.o(113318);
      return false;
    }
    if ((this.oau.oaq != -1000.0D) && (this.oau.oar != -1000.0D)) {
      this.oau.oat = f.a(this.oau.oar, this.oau.oaq, paramFloat1, paramFloat2, paramInt, paramDouble1);
    }
    this.oau.oaq = paramFloat2;
    this.oau.oar = paramFloat1;
    if ((this.oau.oap == 900.0D) || (this.oau.oao == 900.0D))
    {
      i locali1 = this.oau;
      i locali2 = this.oau;
      paramDouble1 = f.h(paramFloat2, paramFloat1);
      locali2.oao = paramDouble1;
      locali1.oap = paramDouble1;
    }
    for (;;)
    {
      ab.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(this.oau.oao), Double.valueOf(this.oau.oap), Boolean.valueOf(this.oau.oat) });
      AppMethodBeat.o(113318);
      return true;
      this.oau.oap = this.oau.oao;
      this.oau.oao = f.h(paramFloat2, paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i.1
 * JD-Core Version:    0.7.0.1
 */