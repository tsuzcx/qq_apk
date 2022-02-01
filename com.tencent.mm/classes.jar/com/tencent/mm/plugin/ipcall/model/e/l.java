package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b rr;
  private ccz sDc;
  private cda sDd;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(25484);
    this.rr = null;
    this.sDc = null;
    this.sDd = null;
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new ccz();
    ((b.a)localObject1).gUV = new cda();
    ((b.a)localObject1).funcId = 227;
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).atI();
    this.sDc = ((ccz)this.rr.gUS.gUX);
    this.sDc.DdZ = paramInt;
    this.sDc.DYX = paramLong;
    localObject1 = this.sDc;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((ccz)localObject1).DZq = paramInt;
      ad.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.sDc.DdZ), Long.valueOf(this.sDc.DYX), Integer.valueOf(this.sDc.DZq) });
      localObject1 = this.sDc;
      Object localObject2 = i.cHm();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sAY + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCo + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).ioa + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCp + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCe + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCf + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCg + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCh + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCi + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCj + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCk + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCl + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCm + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCn + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCq + "," + c.cIH() + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCz + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).countryCode + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCA + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCB + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCC + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCx + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCE;
      ad.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((ccz)localObject1).DZn = z.BE((String)localObject2);
      localObject1 = this.sDc;
      localObject2 = i.cHm();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sAY + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCo + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCw;
      ad.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((ccz)localObject1).DZo = z.BE((String)localObject2);
      localObject1 = this.sDc;
      localObject2 = i.cHm();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sAY + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCo + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).sCv;
      ad.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((ccz)localObject1).DZp = z.BE((String)localObject2);
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
    ad.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.sDd = ((cda)((com.tencent.mm.al.b)paramq).gUT.gUX);
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