package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private f callback;
  private vd pay;
  private vc paz;
  private final com.tencent.mm.al.b rr;
  
  public m(int paramInt1, int paramInt2, String paramString1, String paramString2, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(198947);
    b.a locala = new b.a();
    locala.hNM = new vc();
    locala.hNN = new vd();
    locala.funcId = 3781;
    locala.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
    this.rr = locala.aDC();
    this.paz = ((vc)this.rr.hNK.hNQ);
    this.paz.FUz = paramInt1;
    this.paz.vls = paramInt2;
    this.paz.FUA = paramString1;
    this.paz.url = paramString2;
    this.paz.FUB = ((int)(System.currentTimeMillis() / 1000L));
    this.paz.FTX = paramb;
    AppMethodBeat.o(198947);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(198948);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(198948);
    return i;
  }
  
  public final int getType()
  {
    return 3781;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198949);
    ad.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.pay = ((vd)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */