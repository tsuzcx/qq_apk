package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  private ti oxd;
  private th oxe;
  private final com.tencent.mm.ak.b rr;
  
  public m(int paramInt1, int paramInt2, String paramString1, String paramString2, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(207043);
    b.a locala = new b.a();
    locala.hvt = new th();
    locala.hvu = new ti();
    locala.funcId = 3781;
    locala.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
    this.rr = locala.aAz();
    this.oxe = ((th)this.rr.hvr.hvw);
    this.oxe.Enq = paramInt1;
    this.oxe.uiK = paramInt2;
    this.oxe.Enr = paramString1;
    this.oxe.url = paramString2;
    this.oxe.Ens = ((int)(System.currentTimeMillis() / 1000L));
    this.oxe.EmO = paramb;
    AppMethodBeat.o(207043);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(207044);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(207044);
    return i;
  }
  
  public final int getType()
  {
    return 3781;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207045);
    ac.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.oxd = ((ti)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(207045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */