package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class y
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public y()
  {
    AppMethodBeat.i(112831);
    c.a locala = new c.a();
    locala.otE = new cgf();
    locala.otF = new cgg();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.funcId = 1088;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(112831);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(112832);
    this.callback = paramh;
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
      params = (cgg)c.c.b(this.rr.otC);
      Log.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + params.aapq + " has_share_card:" + params.aapr);
      if (params.aapq > 0)
      {
        l.doO();
        if (TextUtils.isEmpty((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJm, null)))
        {
          am.dkI();
          com.tencent.mm.plugin.card.mgr.a.Ih(1);
        }
      }
      if (params.aapr > 0)
      {
        l.doQ();
        params = (Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJw, Long.valueOf(0L));
        if ((params != null) && (params.longValue() == 0L)) {
          am.dkQ().dln();
        }
      }
    }
    com.tencent.mm.kernel.h.baE().ban().B(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */