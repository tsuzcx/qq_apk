package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends m
  implements k
{
  private f callback;
  private bok nPh;
  private bol nPi;
  private com.tencent.mm.ai.b rr;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21869);
    this.rr = null;
    this.nPh = null;
    this.nPi = null;
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new bok();
    ((b.a)localObject1).fsY = new bol();
    ((b.a)localObject1).funcId = 227;
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).ado();
    this.nPh = ((bok)this.rr.fsV.fta);
    this.nPh.wQP = paramInt;
    this.nPh.xCm = paramLong;
    localObject1 = this.nPh;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((bok)localObject1).xCF = paramInt;
      ab.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.nPh.wQP), Long.valueOf(this.nPh.xCm), Integer.valueOf(this.nPh.xCF) });
      localObject1 = this.nPh;
      Object localObject2 = i.bJp();
      localObject2 = ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nMZ + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nNa + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOt + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).gAF + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOu + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOj + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOk + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOl + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOm + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOn + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOo + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOp + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOq + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOr + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOs + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOv + "," + c.bKK() + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOE + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).countryCode + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOF + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOG + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOH + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOC + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOJ;
      ab.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((bok)localObject1).xCC = aa.wA((String)localObject2);
      localObject1 = this.nPh;
      localObject2 = i.bJp();
      localObject2 = ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nMZ + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nNa + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOt + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOB;
      ab.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((bok)localObject1).xCD = aa.wA((String)localObject2);
      localObject1 = this.nPh;
      localObject2 = i.bJp();
      localObject2 = ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nMZ + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nNa + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOt + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).nOA;
      ab.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((bok)localObject1).xCE = aa.wA((String)localObject2);
      AppMethodBeat.o(21869);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21870);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21870);
    return i;
  }
  
  public final int getType()
  {
    return 227;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21871);
    ab.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nPi = ((bol)((com.tencent.mm.ai.b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(21871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.l
 * JD-Core Version:    0.7.0.1
 */