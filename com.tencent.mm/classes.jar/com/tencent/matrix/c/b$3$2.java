package com.tencent.matrix.c;

import com.tencent.matrix.a.a.a;
import com.tencent.matrix.a.b.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;

final class b$3$2
  implements Runnable
{
  b$3$2(b.3 param3, b.b paramb, long paramLong) {}
  
  public final void run()
  {
    long l;
    int i;
    if ((!com.tencent.matrix.a.b.b.bo(this.dSU.mContext)) && ((!this.dSU.isForeground()) || (!com.tencent.matrix.a.b.b.bp(this.dSU.mContext))))
    {
      if ((!a.VQ().VN()) && (!b.access$200()) && (this.dTv >= 300000L)) {
        b.Xo();
      }
      Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy, bgMillis = " + this.dTv);
      l = this.dTv;
      if (l >= 300000L)
      {
        if (l >= 600000L) {
          break label127;
        }
        i = 70;
      }
    }
    for (;;)
    {
      f.Iyx.idkeyStat(1540L, i, 1L, false);
      return;
      label127:
      if (l < 1800000L) {
        i = 71;
      } else {
        i = 72;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.matrix.c.b.3.2
 * JD-Core Version:    0.7.0.1
 */