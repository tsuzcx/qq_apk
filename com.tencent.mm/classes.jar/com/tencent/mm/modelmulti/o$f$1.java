package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class o$f$1
  implements o.b
{
  o$f$1(o.f paramf) {}
  
  public final boolean iU(int paramInt)
  {
    y.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { this.eue, this.eue.etR, Integer.valueOf(this.eue.esl), Long.valueOf(this.eue.eud) });
    if ((this.eue.esl & 0x1) > 0)
    {
      g.DQ();
      byte[] arrayOfByte = bk.ZM(bk.pm((String)g.DP().Dz().get(8195, null)));
      g.Dk().a(new f(this.eue.eud, arrayOfByte), 0);
    }
    o.a(this.eue.etN, this.eue);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.f.1
 * JD-Core Version:    0.7.0.1
 */