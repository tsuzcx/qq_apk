package com.tencent.mm.plugin.misc.b;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  extends n.a
{
  b$2(b paramb) {}
  
  public final void et(int paramInt)
  {
    try
    {
      if (!b.bim())
      {
        b.a(this.mdZ, 0);
        return;
      }
      String str = q.zq();
      y.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str });
      if (!str.equals(b.access$300()))
      {
        y.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.access$300(), str });
        b.EM(str);
        b.b(this.mdZ);
        b.c(this.mdZ);
        this.mdZ.tF(2);
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SimcardService", localException, "", new Object[0]);
      return;
    }
    b.a(this.mdZ, b.d(this.mdZ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b.2
 * JD-Core Version:    0.7.0.1
 */