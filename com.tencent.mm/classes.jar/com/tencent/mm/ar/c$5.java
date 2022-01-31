package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Queue;

final class c$5
  implements w.a
{
  c$5(c paramc, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(16474);
    if (paramm.getType() != 881)
    {
      AppMethodBeat.o(16474);
      return 0;
    }
    this.fCU.frp = false;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.fCX });
      if (paramInt1 == 4) {
        d.ahd().sT(this.fCX);
      }
      this.fCU.fCS.ag(10000L, 10000L);
      this.fCU.I(this.fCX, false);
      AppMethodBeat.o(16474);
      return 0;
    }
    if ((!this.fCU.fCN.isEmpty()) && (this.fCU.fCS.dtj())) {
      this.fCU.fCS.ag(500L, 500L);
    }
    s.a((anc)paramb.fsW.fta);
    ab.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.ahd().sT(this.fCX)), this.fCX });
    this.fCU.I(this.fCX, true);
    AppMethodBeat.o(16474);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ar.c.5
 * JD-Core Version:    0.7.0.1
 */