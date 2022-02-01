package com.tencent.mm.plugin.expt.edge.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends p
  implements m
{
  private h callback;
  private List<ama> zyw;
  private com.tencent.mm.plugin.expt.edge.g.c zyx;
  
  public a(List<ama> paramList, com.tencent.mm.plugin.expt.edge.g.c paramc)
  {
    this.zyw = paramList;
    this.zyx = paramc;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(299748);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new amb();
    paramh.otF = new amc();
    paramh.uri = "/cgi-bin/mmfddataecappsvr/edgerealtimereport";
    paramh.funcId = 4871;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    paramh = paramh.bEF();
    ((amb)c.b.b(paramh.otB)).ZsZ.addAll(this.zyw);
    int i = dispatch(paramg, paramh, this);
    AppMethodBeat.o(299748);
    return i;
  }
  
  public final int getType()
  {
    return 4871;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(299757);
    Log.i("MicroMsg.NetSceneEdgeComputingRtReport", "[onGYNetEnd] netId[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (amc)c.c.b(((com.tencent.mm.am.c)params).otC);
      this.zyx.a(params.Zta, params.Ztb, this.zyw);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(299757);
      return;
      this.zyx.fp(this.zyw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.b.a
 * JD-Core Version:    0.7.0.1
 */