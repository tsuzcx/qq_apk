package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements a.a
{
  i$1(i parami) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    if ((this.lDi.lDe != -1000.0D) && (this.lDi.lDf != -1000.0D)) {
      this.lDi.lDh = f.a(this.lDi.lDf, this.lDi.lDe, paramFloat1, paramFloat2, paramInt, paramDouble1);
    }
    this.lDi.lDe = paramFloat2;
    this.lDi.lDf = paramFloat1;
    if ((this.lDi.lDd == 900.0D) || (this.lDi.lDc == 900.0D))
    {
      i locali1 = this.lDi;
      i locali2 = this.lDi;
      paramDouble1 = f.f(paramFloat2, paramFloat1);
      locali2.lDc = paramDouble1;
      locali1.lDd = paramDouble1;
    }
    for (;;)
    {
      y.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(this.lDi.lDc), Double.valueOf(this.lDi.lDd), Boolean.valueOf(this.lDi.lDh) });
      return true;
      this.lDi.lDd = this.lDi.lDc;
      this.lDi.lDc = f.f(paramFloat2, paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i.1
 * JD-Core Version:    0.7.0.1
 */