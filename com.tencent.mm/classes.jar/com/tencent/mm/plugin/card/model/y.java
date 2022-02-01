package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class y
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public y()
  {
    AppMethodBeat.i(112831);
    b.a locala = new b.a();
    locala.hQF = new ayt();
    locala.hQG = new ayu();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.funcId = 1088;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(112831);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112832);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112832);
    return i;
  }
  
  public final int getType()
  {
    return 1088;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112833);
    ae.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ayu)this.rr.hQE.hQJ;
      ae.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + paramq.GPl + " has_share_card:" + paramq.GPm);
      if (paramq.GPl > 0)
      {
        l.bZP();
        if (TextUtils.isEmpty((String)g.ajR().ajA().get(am.a.ILQ, null)))
        {
          am.bWb();
          com.tencent.mm.plugin.card.b.b.AA(1);
        }
      }
      if (paramq.GPm > 0)
      {
        l.bZR();
        paramq = (Long)g.ajR().ajA().get(am.a.IMa, Long.valueOf(0L));
        if ((paramq != null) && (paramq.longValue() == 0L)) {
          am.bWj().bWD();
        }
      }
    }
    g.ajR().ajA().set(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */