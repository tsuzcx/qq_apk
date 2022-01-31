package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.sdk.platformtools.y;

final class g$4
  implements a.a
{
  g$4(g paramg) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    y.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble1) });
    if ((f.t(paramDouble1)) && (!this.lKi.lJV.lHj))
    {
      y.d("MicroMsg.ShareMapUI", "set driving mode");
      this.lKi.lJV.lHm = false;
      this.lKi.lJV.hj(true);
      this.lKi.lJT.beo();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.4
 * JD-Core Version:    0.7.0.1
 */