package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$5
  extends c<bq>
{
  b$5(b paramb)
  {
    AppMethodBeat.i(18582);
    this.__eventId = bq.class.getName().hashCode();
    AppMethodBeat.o(18582);
  }
  
  private boolean bat()
  {
    AppMethodBeat.i(18583);
    ab.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { this.kks.bas() });
    b.d(this.kks, true);
    try
    {
      g.RO().ac(new b.5.1(this));
      AppMethodBeat.o(18583);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { this.kks.bas() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.5
 * JD-Core Version:    0.7.0.1
 */