package com.tencent.mm.booter;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.y;

final class k$1
  implements a.a
{
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (paramBoolean)
    {
      y.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
      k.Y(paramFloat2);
      k.Z(paramFloat1);
      k.bb(true);
      if (k.wf() != null)
      {
        k.wf().c(k.wg());
        k.bb(false);
      }
      return false;
    }
    y.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.k.1
 * JD-Core Version:    0.7.0.1
 */