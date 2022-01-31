package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements am.a
{
  d$2(d paramd, boolean paramBoolean) {}
  
  public final boolean tC()
  {
    if (!this.lqF)
    {
      y.i("MicroMsg.IPCallSensorManager", "off screen");
      if (this.lqE.lqD != null) {
        this.lqE.lqD.gW(true);
      }
    }
    do
    {
      return false;
      y.i("MicroMsg.IPCallSensorManager", "light screen");
    } while (this.lqE.lqD == null);
    this.lqE.lqD.gW(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */