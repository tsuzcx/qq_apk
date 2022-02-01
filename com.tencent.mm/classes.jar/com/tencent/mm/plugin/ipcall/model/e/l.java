package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b rr;
  private cnc uNx;
  private cnd uNy;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(25484);
    this.rr = null;
    this.uNx = null;
    this.uNy = null;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new cnc();
    ((b.a)localObject1).hNN = new cnd();
    ((b.a)localObject1).funcId = 227;
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((b.a)localObject1).hNO = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDC();
    this.uNx = ((cnc)this.rr.hNK.hNQ);
    this.uNx.GeI = paramInt;
    this.uNx.HfZ = paramLong;
    localObject1 = this.uNx;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((cnc)localObject1).Hgs = paramInt;
      ad.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.uNx.GeI), Long.valueOf(this.uNx.HfZ), Integer.valueOf(this.uNx.Hgs) });
      localObject1 = this.uNx;
      Object localObject2 = i.ddI();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uLt + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMJ + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).jhp + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMK + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMz + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMA + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMB + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMC + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMD + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uME + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMF + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMG + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMH + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMI + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uML + "," + c.dfd() + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMU + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).countryCode + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMV + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMW + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMX + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMS + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMZ;
      ad.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((cnc)localObject1).Hgp = z.IX((String)localObject2);
      localObject1 = this.uNx;
      localObject2 = i.ddI();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uLt + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMJ + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMR;
      ad.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((cnc)localObject1).Hgq = z.IX((String)localObject2);
      localObject1 = this.uNx;
      localObject2 = i.ddI();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uLt + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMJ + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uMQ;
      ad.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((cnc)localObject1).Hgr = z.IX((String)localObject2);
      AppMethodBeat.o(25484);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25485);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25485);
    return i;
  }
  
  public final int getType()
  {
    return 227;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25486);
    ad.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNy = ((cnd)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.l
 * JD-Core Version:    0.7.0.1
 */