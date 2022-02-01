package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.protocal.protobuf.dfr;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private d rr;
  private dfq yrK;
  private dfr yrL;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(25484);
    this.rr = null;
    this.yrK = null;
    this.yrL = null;
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new dfq();
    ((d.a)localObject1).iLO = new dfr();
    ((d.a)localObject1).funcId = 227;
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((d.a)localObject1).iLP = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).aXF();
    this.yrK = ((dfq)this.rr.iLK.iLR);
    this.yrK.LsZ = paramInt;
    this.yrK.MKi = paramLong;
    localObject1 = this.yrK;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((dfq)localObject1).MKB = paramInt;
      Log.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.yrK.LsZ), Long.valueOf(this.yrK.MKi), Integer.valueOf(this.yrK.MKB) });
      localObject1 = this.yrK;
      Object localObject2 = com.tencent.mm.plugin.ipcall.model.i.eau();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).ypH + "," + ((b)localObject2).yqW + "," + ((b)localObject2).kik + "," + ((b)localObject2).yqX + "," + ((b)localObject2).yqM + "," + ((b)localObject2).yqN + "," + ((b)localObject2).yqO + "," + ((b)localObject2).yqP + "," + ((b)localObject2).yqQ + "," + ((b)localObject2).yqR + "," + ((b)localObject2).yqS + "," + ((b)localObject2).yqT + "," + ((b)localObject2).yqU + "," + ((b)localObject2).yqV + "," + ((b)localObject2).yqY + "," + c.ebM() + "," + ((b)localObject2).yrh + "," + ((b)localObject2).countryCode + "," + ((b)localObject2).yri + "," + ((b)localObject2).yrj + "," + ((b)localObject2).yrk + ((b)localObject2).yrf + "," + ((b)localObject2).yrm;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((dfq)localObject1).MKy = z.Su((String)localObject2);
      localObject1 = this.yrK;
      localObject2 = com.tencent.mm.plugin.ipcall.model.i.eau();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).ypH + "," + ((b)localObject2).yqW + ((b)localObject2).yre;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((dfq)localObject1).MKz = z.Su((String)localObject2);
      localObject1 = this.yrK;
      localObject2 = com.tencent.mm.plugin.ipcall.model.i.eau();
      localObject2 = ((b)localObject2).roomId + "," + ((b)localObject2).ypH + "," + ((b)localObject2).yqW + ((b)localObject2).yrd;
      Log.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((dfq)localObject1).MKA = z.Su((String)localObject2);
      AppMethodBeat.o(25484);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
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
    this.yrL = ((dfr)((d)params).iLL.iLR);
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