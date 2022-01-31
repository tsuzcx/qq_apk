package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ab;

final class o$2
  implements b.a
{
  o$2(o paramo) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113384);
    if (!paramBoolean)
    {
      AppMethodBeat.o(113384);
      return false;
    }
    ab.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1) });
    if (this.obx.obt)
    {
      this.obx.obt = false;
      this.obx.obv = System.currentTimeMillis();
      long l = this.obx.obv - this.obx.obu;
      ab.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
      h.qsU.e(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
    }
    if ((this.obx.obk != null) && (this.obx.obk.xYw != null))
    {
      this.obx.obk.xYw.wyP = paramFloat2;
      this.obx.obk.xYw.wyO = paramFloat1;
    }
    AppMethodBeat.o(113384);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o.2
 * JD-Core Version:    0.7.0.1
 */