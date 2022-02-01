package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class y
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b rr;
  
  public y()
  {
    AppMethodBeat.i(112831);
    b.a locala = new b.a();
    locala.hvt = new auf();
    locala.hvu = new aug();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.funcId = 1088;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(112831);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(112832);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aug)this.rr.hvs.hvw;
      ac.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + paramq.EMI + " has_share_card:" + paramq.EMJ);
      if (paramq.EMI > 0)
      {
        l.bTV();
        if (TextUtils.isEmpty((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFc, null)))
        {
          am.bQh();
          com.tencent.mm.plugin.card.b.b.zF(1);
        }
      }
      if (paramq.EMJ > 0)
      {
        l.bTX();
        paramq = (Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFm, Long.valueOf(0L));
        if ((paramq != null) && (paramq.longValue() == 0L)) {
          am.bQp().bQJ();
        }
      }
    }
    com.tencent.mm.kernel.g.agR().agA().set(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */