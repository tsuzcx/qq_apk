package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.sdk.platformtools.y;

final class i$5
  implements a.a
{
  i$5(i parami) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    y.d("MicroMsg.ViewMapUI", "onGetLocation flong " + paramFloat1 + " flat " + paramFloat2);
    if ((paramFloat2 == 0.0D) && (paramFloat1 == 0.0D)) {
      return true;
    }
    y.d("MicroMsg.ViewMapUI", "myLocation " + this.lKF.lIa.lCJ + " " + this.lKF.lIa.lCK);
    y.d("MicroMsg.ViewMapUI", "location my show");
    this.lKF.lIa.lCJ = paramFloat2;
    this.lKF.lIa.lCK = paramFloat1;
    this.lKF.lIe.a(this.lKF.lIa.lCJ, this.lKF.lIa.lCK, this.lKF.lIl, this.lKF.lIa.lCI);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.5
 * JD-Core Version:    0.7.0.1
 */