package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.ci.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, ci paramci) {}
  
  public final void run()
  {
    AppMethodBeat.i(18576);
    if (this.kku == null)
    {
      AppMethodBeat.o(18576);
      return;
    }
    if (bo.isNullOrNil(this.kku.cpN.talker))
    {
      AppMethodBeat.o(18576);
      return;
    }
    try
    {
      com.tencent.mm.plugin.f.b.b localb = b.bak().bal();
      long l = this.kku.cpN.cpO;
      String str = this.kku.cpN.talker;
      int i = this.kku.cpN.msgType;
      ab.i("MicroMsg.WxFileIndexStorage", "delete by msg [%d %d %s] result[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(localb.db.delete("WxFileIndex2", "msgId=? AND msgType=? AND username=? ", new String[] { String.valueOf(l), String.valueOf(i), str })) });
      AppMethodBeat.o(18576);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.CalcWxService", localException, "", new Object[0]);
      h.qsU.idkeyStat(664L, 6L, 1L, false);
      AppMethodBeat.o(18576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.3.1
 * JD-Core Version:    0.7.0.1
 */