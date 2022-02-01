package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class y
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public y()
  {
    AppMethodBeat.i(112831);
    b.a locala = new b.a();
    locala.hNM = new ayd();
    locala.hNN = new aye();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.funcId = 1088;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
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
    ad.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aye)this.rr.hNL.hNQ;
      ad.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + paramq.GvM + " has_share_card:" + paramq.GvN);
      if (paramq.GvM > 0)
      {
        l.bYA();
        if (TextUtils.isEmpty((String)g.ajC().ajl().get(al.a.Iru, null)))
        {
          am.bUM();
          com.tencent.mm.plugin.card.b.b.Ao(1);
        }
      }
      if (paramq.GvN > 0)
      {
        l.bYC();
        paramq = (Long)g.ajC().ajl().get(al.a.IrE, Long.valueOf(0L));
        if ((paramq != null) && (paramq.longValue() == 0L)) {
          am.bUU().bVo();
        }
      }
    }
    g.ajC().ajl().set(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */