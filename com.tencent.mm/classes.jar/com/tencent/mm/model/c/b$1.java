package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements w.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(118160);
    b.Pt();
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(86400) });
      b.access$100();
      b.kM(86400);
      b.access$300();
      AppMethodBeat.o(118160);
      return 0;
    }
    paramString = (afi)paramb.fsW.fta;
    b.access$100();
    b.kN(paramString.Timestamp);
    b.kM(paramString.wYF);
    b.V(paramString.wYG);
    b.W(paramString.wYE);
    b.access$300();
    ab.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramString.wYF) });
    AppMethodBeat.o(118160);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.c.b.1
 * JD-Core Version:    0.7.0.1
 */