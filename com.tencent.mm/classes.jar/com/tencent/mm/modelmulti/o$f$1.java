package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class o$f$1
  implements o.b
{
  o$f$1(o.f paramf) {}
  
  public final boolean lM(int paramInt)
  {
    AppMethodBeat.i(58409);
    ab.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { this.fJR, this.fJR.fJE, Integer.valueOf(this.fJR.fHZ), Long.valueOf(this.fJR.fJQ) });
    if ((this.fJR.fHZ & 0x1) > 0)
    {
      g.RM();
      byte[] arrayOfByte = bo.apQ(bo.nullAsNil((String)g.RL().Ru().get(8195, null)));
      g.Rc().a(new f(this.fJR.fJQ, arrayOfByte), 0);
    }
    o.a(this.fJR.fJA, this.fJR);
    AppMethodBeat.o(58409);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.f.1
 * JD-Core Version:    0.7.0.1
 */