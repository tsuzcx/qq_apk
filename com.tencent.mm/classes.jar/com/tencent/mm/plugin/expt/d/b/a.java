package com.tencent.mm.plugin.expt.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.d.h.c;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends q
  implements m
{
  private i callback;
  private List<aiv> wdo;
  private c wdp;
  
  public a(List<aiv> paramList, c paramc)
  {
    this.wdo = paramList;
    this.wdp = paramc;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(253898);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new aiw();
    parami.lBV = new aix();
    parami.uri = "/cgi-bin/mmfddataecappsvr/edgerealtimereport";
    parami.funcId = 4871;
    parami.lBW = 0;
    parami.respCmdId = 0;
    parami = parami.bgN();
    ((aiw)d.b.b(parami.lBR)).Stp.addAll(this.wdo);
    int i = dispatch(paramg, parami, this);
    AppMethodBeat.o(253898);
    return i;
  }
  
  public final int getType()
  {
    return 4871;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(253900);
    Log.i("MicroMsg.NetSceneEdgeComputingRtReport", "[onGYNetEnd] netId[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (aix)d.c.b(((d)params).lBS);
      this.wdp.a(params.Stq, params.Str, this.wdo);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(253900);
      return;
      this.wdp.du(this.wdo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.a
 * JD-Core Version:    0.7.0.1
 */