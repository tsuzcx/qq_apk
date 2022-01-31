package com.tencent.mm.ak;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  extends n.a
{
  b$3(b paramb) {}
  
  public final void et(int paramInt)
  {
    y.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 4) && (paramInt != 6)) {}
    while (!g.DN().Dc()) {
      return;
    }
    this.eiN.eiD.removeMessages(1);
    BaseEvent.onNetworkChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ak.b.3
 * JD-Core Version:    0.7.0.1
 */