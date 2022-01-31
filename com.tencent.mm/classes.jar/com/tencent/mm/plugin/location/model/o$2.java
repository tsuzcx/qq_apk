package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.sdk.platformtools.y;

final class o$2
  implements a.a
{
  o$2(o paramo) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    y.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1) });
    if (this.lEk.lEg)
    {
      this.lEk.lEg = false;
      this.lEk.lEi = System.currentTimeMillis();
      long l = this.lEk.lEi - this.lEk.lEh;
      y.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
      h.nFQ.f(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
    }
    if ((this.lEk.lDX != null) && (this.lEk.lDX.tRA != null))
    {
      this.lEk.lDX.tRA.sDn = paramFloat2;
      this.lEk.lDX.tRA.sDm = paramFloat1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o.2
 * JD-Core Version:    0.7.0.1
 */