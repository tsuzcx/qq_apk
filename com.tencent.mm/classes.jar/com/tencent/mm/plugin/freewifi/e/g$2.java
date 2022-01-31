package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.y;

final class g$2
  implements a.a
{
  g$2(g paramg) {}
  
  public final void onFail(int paramInt)
  {
    g.c(this.kpB);
  }
  
  public final void onSuccess()
  {
    y.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", new Object[] { m.B(this.kpB.intent), Integer.valueOf(m.C(this.kpB.intent)) });
    g.b(this.kpB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.g.2
 * JD-Core Version:    0.7.0.1
 */