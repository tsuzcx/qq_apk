package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.mm.j.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(a parama, String paramString, d paramd, int paramInt) {}
  
  public final void run()
  {
    a.a locala = (a.a)a.a(this.iIl).get(this.BF);
    if (locala != null)
    {
      if (this.eiR != null)
      {
        int i = this.eiR.field_retCode;
        locala.L(this.BF, this.iIk, i);
        a.a(this.iIl).remove(this.BF);
        if (this.eiR.field_retCode == 0)
        {
          h.nFQ.a(724L, 8L, 1L, false);
          return;
        }
        h.nFQ.a(724L, 9L, 1L, false);
        return;
      }
      y.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
      return;
    }
    y.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a.1
 * JD-Core Version:    0.7.0.1
 */