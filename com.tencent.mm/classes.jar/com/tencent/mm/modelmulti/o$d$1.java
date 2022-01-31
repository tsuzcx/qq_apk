package com.tencent.mm.modelmulti;

import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class o$d$1
  implements o.b
{
  o$d$1(o.d paramd, int paramInt) {}
  
  public final boolean iU(int paramInt)
  {
    y.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { this.etW, Integer.valueOf(this.val$index) });
    paramInt = this.val$index;
    g.DQ();
    g.DN();
    f.aV(paramInt, a.CK());
    o.a(this.etW.etN, this.etW);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.d.1
 * JD-Core Version:    0.7.0.1
 */