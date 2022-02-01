package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k
{
  private f callback;
  private vf phc;
  private ve phd;
  private final com.tencent.mm.ak.b rr;
  
  public m(int paramInt1, int paramInt2, String paramString1, String paramString2, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(189781);
    b.a locala = new b.a();
    locala.hQF = new ve();
    locala.hQG = new vf();
    locala.funcId = 3781;
    locala.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
    this.rr = locala.aDS();
    this.phd = ((ve)this.rr.hQD.hQJ);
    this.phd.GmY = paramInt1;
    this.phd.vxx = paramInt2;
    this.phd.GmZ = paramString1;
    this.phd.url = paramString2;
    this.phd.Gna = ((int)(System.currentTimeMillis() / 1000L));
    this.phd.Gmw = paramb;
    AppMethodBeat.o(189781);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(189782);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(189782);
    return i;
  }
  
  public final int getType()
  {
    return 3781;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189783);
    ae.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.phc = ((vf)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(189783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */