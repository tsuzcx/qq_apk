package com.tencent.mm.plugin.comm;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.an.d;
import com.tencent.mm.sdk.platformtools.an.f;
import com.tencent.mm.sdk.platformtools.y;

final class PluginComm$2
  implements an.d
{
  PluginComm$2(PluginComm paramPluginComm) {}
  
  public final boolean pB(int paramInt)
  {
    boolean bool = false;
    y.i("PluginComm", "report");
    if (g.DK())
    {
      h.nFQ.a(934L, paramInt + 10, 1L, false);
      if ((d.spd) && (paramInt == 6))
      {
        String str = an.ufL.mt(true).toString();
        h.nFQ.d("overThread", str, null);
        y.d("PluginComm", "overThread:%s", new Object[] { str });
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.PluginComm.2
 * JD-Core Version:    0.7.0.1
 */