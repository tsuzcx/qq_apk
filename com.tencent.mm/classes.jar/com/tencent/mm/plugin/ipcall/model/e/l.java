package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.ac;

public final class l
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  private cic tKK;
  private cid tKL;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(25484);
    this.rr = null;
    this.tKK = null;
    this.tKL = null;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new cic();
    ((b.a)localObject1).hvu = new cid();
    ((b.a)localObject1).funcId = 227;
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aAz();
    this.tKK = ((cic)this.rr.hvr.hvw);
    this.tKK.Exf = paramInt;
    this.tKK.FvT = paramLong;
    localObject1 = this.tKK;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((cic)localObject1).Fwm = paramInt;
      ac.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.tKK.Exf), Long.valueOf(this.tKK.FvT), Integer.valueOf(this.tKK.Fwm) });
      localObject1 = this.tKK;
      Object localObject2 = i.cUx();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tIG + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJW + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).iOg + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJX + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJM + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJN + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJO + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJP + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJQ + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJR + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJS + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJT + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJU + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJV + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJY + "," + c.cVS() + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKh + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).countryCode + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKi + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKj + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKk + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKf + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKm;
      ac.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((cic)localObject1).Fwj = z.FI((String)localObject2);
      localObject1 = this.tKK;
      localObject2 = i.cUx();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tIG + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJW + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKe;
      ac.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((cic)localObject1).Fwk = z.FI((String)localObject2);
      localObject1 = this.tKK;
      localObject2 = i.cUx();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tIG + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tJW + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).tKd;
      ac.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((cic)localObject1).Fwl = z.FI((String)localObject2);
      AppMethodBeat.o(25484);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25485);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKL = ((cid)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.l
 * JD-Core Version:    0.7.0.1
 */