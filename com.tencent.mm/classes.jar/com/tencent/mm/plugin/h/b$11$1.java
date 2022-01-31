package com.tencent.mm.plugin.h;

import com.tencent.mm.h.a.cf;
import com.tencent.mm.h.a.cf.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$11$1
  implements Runnable
{
  b$11$1(b.11 param11, cf paramcf) {}
  
  public final void run()
  {
    if (this.ijA == null) {}
    while (bk.bl(this.ijA.bIs.talker)) {
      return;
    }
    try
    {
      com.tencent.mm.plugin.h.b.b localb = b.ayE().ayF();
      long l = this.ijA.bIs.bIt;
      String str = this.ijA.bIs.talker;
      int i = this.ijA.bIs.msgType;
      y.i("MicroMsg.WxFileIndexStorage", "delete by msg [%d %d %s] result[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(localb.dXw.delete("WxFileIndex2", "msgId=? AND msgType=? AND username=? ", new String[] { String.valueOf(l), String.valueOf(i), str })) });
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CalcWxService", localException, "", new Object[0]);
      h.nFQ.a(664L, 6L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.11.1
 * JD-Core Version:    0.7.0.1
 */