package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class y
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public y()
  {
    AppMethodBeat.i(87889);
    b.a locala = new b.a();
    locala.fsX = new ahu();
    locala.fsY = new ahv();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.funcId = 663;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(87889);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(87890);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87890);
    return i;
  }
  
  public final int getType()
  {
    return 663;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87891);
    ab.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ahv)this.rr.fsW.fta;
      ab.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + paramq.wZR + " has_share_card:" + paramq.wZS);
      if (paramq.wZR > 0)
      {
        l.bfz();
        if (TextUtils.isEmpty((String)g.RL().Ru().get(ac.a.yyS, null)))
        {
          am.bcc();
          com.tencent.mm.plugin.card.b.b.sW(1);
        }
      }
      if (paramq.wZS > 0)
      {
        l.bfB();
        paramq = (Long)g.RL().Ru().get(ac.a.yzc, Long.valueOf(0L));
        if ((paramq != null) && (paramq.longValue() == 0L)) {
          am.bck().bcy();
        }
      }
    }
    g.RL().Ru().set(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */