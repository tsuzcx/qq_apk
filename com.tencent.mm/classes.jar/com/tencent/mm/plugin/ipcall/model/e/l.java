package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.ae;

public final class l
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  private cnw uZk;
  private cnx uZl;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(25484);
    this.rr = null;
    this.uZk = null;
    this.uZl = null;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new cnw();
    ((b.a)localObject1).hQG = new cnx();
    ((b.a)localObject1).funcId = 227;
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((b.a)localObject1).hQH = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDS();
    this.uZk = ((cnw)this.rr.hQD.hQJ);
    this.uZk.Gxq = paramInt;
    this.uZk.Hzz = paramLong;
    localObject1 = this.uZk;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((cnw)localObject1).HzS = paramInt;
      ae.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.uZk.Gxq), Long.valueOf(this.uZk.Hzz), Integer.valueOf(this.uZk.HzS) });
      localObject1 = this.uZk;
      Object localObject2 = i.dgA();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uXg + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYw + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).jki + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYx + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYm + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYn + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYo + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYp + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYq + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYr + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYs + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYt + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYu + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYv + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYy + "," + c.dhV() + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYH + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).countryCode + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYI + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYJ + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYK + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYF + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYM;
      ae.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((cnw)localObject1).HzP = z.Jw((String)localObject2);
      localObject1 = this.uZk;
      localObject2 = i.dgA();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uXg + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYw + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYE;
      ae.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((cnw)localObject1).HzQ = z.Jw((String)localObject2);
      localObject1 = this.uZk;
      localObject2 = i.dgA();
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).roomId + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uXg + "," + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYw + ((com.tencent.mm.plugin.ipcall.model.d.b)localObject2).uYD;
      ae.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((cnw)localObject1).HzR = z.Jw((String)localObject2);
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
    ae.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZl = ((cnx)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
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