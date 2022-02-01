package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private g callback;
  private sy nTI;
  private sx nTJ;
  private final com.tencent.mm.al.b rr;
  
  public m(int paramInt1, int paramInt2, String paramString1, String paramString2, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(186987);
    b.a locala = new b.a();
    locala.gUU = new sx();
    locala.gUV = new sy();
    locala.funcId = 3781;
    locala.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
    this.rr = locala.atI();
    this.nTJ = ((sx)this.rr.gUS.gUX);
    this.nTJ.CUG = paramInt1;
    this.nTJ.tav = paramInt2;
    this.nTJ.CUH = paramString1;
    this.nTJ.url = paramString2;
    this.nTJ.CUI = ((int)(System.currentTimeMillis() / 1000L));
    this.nTJ.CUd = paramb;
    AppMethodBeat.o(186987);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(186988);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(186988);
    return i;
  }
  
  public final int getType()
  {
    return 3781;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186989);
    ad.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.nTI = ((sy)((com.tencent.mm.al.b)paramq).gUT.gUX);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(186989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */