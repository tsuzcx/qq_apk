package com.tencent.mm.plugin.i;

import com.tencent.mm.ah.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(ld paramld1, ld paramld2, ld paramld3) {}
  
  public final void run()
  {
    g.a locala = new g.a();
    long l2 = -1L;
    f.Na();
    long l1 = l2;
    if (f.Nc() != null)
    {
      l1 = l2;
      if (this.iAm != null)
      {
        f.Na();
        f.Nc().a(this.iAm, this.iAn, this.iAo);
        l1 = locala.zJ();
      }
    }
    y.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.zJ()), Long.valueOf(l1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.1
 * JD-Core Version:    0.7.0.1
 */