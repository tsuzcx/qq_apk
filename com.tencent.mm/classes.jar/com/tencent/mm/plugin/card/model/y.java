package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class y
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public y()
  {
    AppMethodBeat.i(112831);
    d.a locala = new d.a();
    locala.iLN = new bkd();
    locala.iLO = new bke();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.funcId = 1088;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(112831);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112832);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112832);
    return i;
  }
  
  public final int getType()
  {
    return 1088;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112833);
    Log.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bke)this.rr.iLL.iLR;
      Log.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + params.LTr + " has_share_card:" + params.LTs);
      if (params.LTr > 0)
      {
        l.cxE();
        if (TextUtils.isEmpty((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTS, null)))
        {
          am.ctP();
          b.Ef(1);
        }
      }
      if (params.LTs > 0)
      {
        l.cxG();
        params = (Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUc, Long.valueOf(0L));
        if ((params != null) && (params.longValue() == 0L)) {
          am.ctX().cuu();
        }
      }
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */