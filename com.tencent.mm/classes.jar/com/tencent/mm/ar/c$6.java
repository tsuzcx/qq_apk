package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Queue;

final class c$6
  implements w.a
{
  c$6(c paramc) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(16475);
    if (paramm.getType() != 182)
    {
      AppMethodBeat.o(16475);
      return 0;
    }
    this.fCU.frp = false;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " will retry");
      this.fCU.fCS.ag(10000L, 10000L);
      AppMethodBeat.o(16475);
      return 0;
    }
    if ((!this.fCU.fCN.isEmpty()) && (this.fCU.fCS.dtj())) {
      this.fCU.fCS.ag(500L, 500L);
    }
    if (paramb != null)
    {
      paramm = new c.a(this.fCU);
      paramm.errType = paramInt1;
      paramm.errCode = paramInt2;
      paramm.errMsg = paramString;
      paramm.fDb = ((ajj)paramb.fsW.fta);
      this.fCU.fCO.add(paramm);
    }
    if ((!this.fCU.fCO.isEmpty()) && (this.fCU.fCT.dtj())) {
      this.fCU.fCT.ag(50L, 50L);
    }
    AppMethodBeat.o(16475);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ar.c.6
 * JD-Core Version:    0.7.0.1
 */