package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$a
{
  public String appId;
  public String dTX;
  public int gPR;
  public k.a gPS;
  public long lastUpdateTime;
  
  private long amy()
  {
    long l = System.currentTimeMillis() - this.lastUpdateTime;
    y.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
    return l;
  }
  
  public final boolean amx()
  {
    if (this.gPR < 0) {}
    do
    {
      do
      {
        return false;
        if (this.gPR != 0) {
          break;
        }
      } while (amy() <= 10000L);
      return true;
    } while (amy() <= this.gPR * 1000L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.e.a
 * JD-Core Version:    0.7.0.1
 */