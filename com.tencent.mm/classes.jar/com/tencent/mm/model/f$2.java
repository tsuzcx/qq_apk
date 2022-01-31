package com.tencent.mm.model;

import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class f$2
  implements Runnable
{
  f$2(f paramf, Map paramMap) {}
  
  public final void run()
  {
    int i = bk.getInt((String)this.dUG.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
    if (bk.getInt((String)this.dUG.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0)
    {
      d.nQr.dI(i, 0);
      return;
    }
    d.nQr.dI(i, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.f.2
 * JD-Core Version:    0.7.0.1
 */