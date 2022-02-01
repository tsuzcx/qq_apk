package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  private dpk DRM;
  private dpl DRN;
  private com.tencent.mm.an.i callback;
  private d rr;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(25484);
    this.rr = null;
    this.DRM = null;
    this.DRN = null;
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new dpk();
    ((d.a)localObject1).lBV = new dpl();
    ((d.a)localObject1).funcId = 227;
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).bgN();
    this.DRM = ((dpk)d.b.b(this.rr.lBR));
    this.DRM.Svu = paramInt;
    this.DRM.TWc = paramLong;
    localObject1 = this.DRM;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((dpk)localObject1).TWv = paramInt;
      Log.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.DRM.Svu), Long.valueOf(this.DRM.TWc), Integer.valueOf(this.DRM.TWv) });
      localObject1 = this.DRM;
      Object localObject2 = com.tencent.mm.plugin.ipcall.model.i.eJs();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).DPJ + "," + ((b)localObject2).DQY + "," + ((b)localObject2).mZK + "," + ((b)localObject2).DQZ + "," + ((b)localObject2).DQO + "," + ((b)localObject2).DQP + "," + ((b)localObject2).DQQ + "," + ((b)localObject2).DQR + "," + ((b)localObject2).DQS + "," + ((b)localObject2).DQT + "," + ((b)localObject2).DQU + "," + ((b)localObject2).DQV + "," + ((b)localObject2).DQW + "," + ((b)localObject2).DQX + "," + ((b)localObject2).DRa + "," + c.eKK() + "," + ((b)localObject2).DRj + "," + ((b)localObject2).countryCode + "," + ((b)localObject2).DRk + "," + ((b)localObject2).DRl + "," + ((b)localObject2).DRm + ((b)localObject2).DRh + "," + ((b)localObject2).DRo;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((dpk)localObject1).TWs = z.ZW((String)localObject2);
      localObject1 = this.DRM;
      localObject2 = com.tencent.mm.plugin.ipcall.model.i.eJs();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).DPJ + "," + ((b)localObject2).DQY + ((b)localObject2).DRg;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((dpk)localObject1).TWt = z.ZW((String)localObject2);
      localObject1 = this.DRM;
      localObject2 = com.tencent.mm.plugin.ipcall.model.i.eJs();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).DPJ + "," + ((b)localObject2).DQY + ((b)localObject2).DRf;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((dpk)localObject1).TWu = z.ZW((String)localObject2);
      AppMethodBeat.o(25484);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(25485);
    this.callback = parami;
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
    this.DRN = ((dpl)d.c.b(((d)params).lBS));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.l
 * JD-Core Version:    0.7.0.1
 */