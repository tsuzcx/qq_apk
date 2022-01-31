package com.tencent.mm.ai;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class k$2
  implements a.a
{
  long lastReportTime = 0L;
  
  k$2(k paramk) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return true;
    }
    y.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    if (bk.UX() >= this.lastReportTime + this.egx.egu)
    {
      k.a(this.egx.userName, 0, paramFloat2, paramFloat1, (int)paramDouble2);
      this.lastReportTime = bk.UX();
    }
    if (this.egx.egr == 2) {
      this.egx.Mr();
    }
    if (!this.egx.egv)
    {
      this.egx.egv = true;
      o.a(2013, paramFloat1, paramFloat2, (int)paramDouble2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.k.2
 * JD-Core Version:    0.7.0.1
 */