package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
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
    locala.lBU = new brm();
    locala.lBV = new brn();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.funcId = 1088;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(112831);
  }
  
  public final int doScene(g paramg, i parami)
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
      params = (brn)d.c.b(this.rr.lBS);
      Log.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + params.Tcb + " has_share_card:" + params.Tcc);
      if (params.Tcb > 0)
      {
        l.cLg();
        if (TextUtils.isEmpty((String)h.aHG().aHp().get(ar.a.VhS, null)))
        {
          am.cHr();
          b.HG(1);
        }
      }
      if (params.Tcc > 0)
      {
        l.cLi();
        params = (Long)h.aHG().aHp().get(ar.a.Vic, Long.valueOf(0L));
        if ((params != null) && (params.longValue() == 0L)) {
          am.cHz().cHW();
        }
      }
    }
    h.aHG().aHp().i(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */