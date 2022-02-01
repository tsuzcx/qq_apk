package com.tencent.matrix.c;

import com.tencent.matrix.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString) {}
  
  public final void run()
  {
    b.b localb = com.tencent.matrix.a.b.VJ().VK();
    Log.i("Matrix.battery.LifeCycle", "currStat, charging = " + com.tencent.matrix.a.b.b.bo(localb.mContext) + ", fg = " + localb.isForeground() + ", screenOn = " + com.tencent.matrix.a.b.b.bp(localb.mContext));
    if ("android.intent.action.ACTION_POWER_CONNECTED".equals(this.nAF)) {
      a.WV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.matrix.c.b.3.1
 * JD-Core Version:    0.7.0.1
 */