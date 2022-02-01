package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.protocal.protobuf.eie;
import com.tencent.mm.protocal.protobuf.eif;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class l
  extends p
  implements m
{
  private eie JIW;
  private eif JIX;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(25484);
    this.rr = null;
    this.JIW = null;
    this.JIX = null;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new eie();
    ((c.a)localObject1).otF = new eif();
    ((c.a)localObject1).funcId = 227;
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.rr = ((c.a)localObject1).bEF();
    this.JIW = ((eie)c.b.b(this.rr.otB));
    this.JIW.Zvz = paramInt;
    this.JIW.abmR = paramLong;
    localObject1 = this.JIW;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((eie)localObject1).abnk = paramInt;
      Log.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.JIW.Zvz), Long.valueOf(this.JIW.abmR), Integer.valueOf(this.JIW.abnk) });
      localObject1 = this.JIW;
      Object localObject2 = com.tencent.mm.plugin.ipcall.model.h.fRs();
      StringBuilder localStringBuilder = new StringBuilder().append(((b)localObject2).roomId).append(",").append(((b)localObject2).Hnt).append(",").append(((b)localObject2).JIi).append(",").append(((b)localObject2).pWt).append(",").append(((b)localObject2).JIj).append(",").append(((b)localObject2).JHY).append(",").append(((b)localObject2).JHZ).append(",").append(((b)localObject2).JIa).append(",").append(((b)localObject2).JIb).append(",").append(((b)localObject2).JIc).append(",").append(((b)localObject2).JId).append(",").append(((b)localObject2).JIe).append(",").append(((b)localObject2).JIf).append(",").append(((b)localObject2).JIg).append(",").append(((b)localObject2).JIh).append(",").append(((b)localObject2).JIk).append(",");
      MMApplicationContext.getContext();
      localObject2 = com.tencent.mm.plugin.voip.f.g.ibq() + "," + ((b)localObject2).JIt + "," + ((b)localObject2).countryCode + "," + ((b)localObject2).JIu + "," + ((b)localObject2).JIv + "," + ((b)localObject2).JIw + ((b)localObject2).JIr + "," + ((b)localObject2).JIy;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((eie)localObject1).abnh = w.Sk((String)localObject2);
      localObject1 = this.JIW;
      localObject2 = com.tencent.mm.plugin.ipcall.model.h.fRs();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).Hnt + "," + ((b)localObject2).JIi + ((b)localObject2).JIq;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((eie)localObject1).abni = w.Sk((String)localObject2);
      localObject1 = this.JIW;
      localObject2 = com.tencent.mm.plugin.ipcall.model.h.fRs();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).Hnt + "," + ((b)localObject2).JIi + ((b)localObject2).JIp;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((eie)localObject1).abnj = w.Sk((String)localObject2);
      AppMethodBeat.o(25484);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(25485);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25485);
    return i;
  }
  
  public final int getType()
  {
    return 227;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25486);
    Log.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.JIX = ((eif)c.c.b(((c)params).otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.l
 * JD-Core Version:    0.7.0.1
 */