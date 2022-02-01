package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public c()
  {
    AppMethodBeat.i(26149);
    d.a locala = new d.a();
    locala.lBU = new bta();
    locala.lBV = new btb();
    locala.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
    locala.funcId = 639;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(26149);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26151);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26151);
    return i;
  }
  
  public final int getType()
  {
    return 639;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(26150);
    Log.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(209408, Long.valueOf(System.currentTimeMillis()));
      params = (btb)d.c.b(this.rr.lBS);
      if ((params != null) && (params.RIq != null))
      {
        params = params.RIq;
        paramArrayOfByte = new ArrayList();
        int j = params.size();
        paramInt1 = i;
        while (paramInt1 < j)
        {
          cpq localcpq = (cpq)params.get(paramInt1);
          au localau = new au();
          localau.field_labelID = localcpq.TwW;
          localau.field_labelName = localcpq.TwV;
          localau.field_labelPYFull = f.ZJ(localcpq.TwV);
          localau.field_labelPYShort = f.ZK(localcpq.TwV);
          paramArrayOfByte.add(localau);
          paramInt1 += 1;
        }
        e.eLd().jy(paramArrayOfByte);
        e.eLd().jz(e.eLd().jA(paramArrayOfByte));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26150);
      return;
      Log.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.c
 * JD-Core Version:    0.7.0.1
 */