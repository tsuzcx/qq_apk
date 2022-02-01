package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.sdk.platformtools.ad;

public final class z
  extends n
  implements k
{
  private g callback;
  private azj gXW;
  private a<z> gXX;
  private final b rr;
  
  public z()
  {
    AppMethodBeat.i(191064);
    ad.i("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "NetSceneGetReceiptAssisPluginMenu begin");
    b.a locala = new b.a();
    locala.funcId = 1769;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassismenu";
    azi localazi = new azi();
    localazi.timestamp = ce.asR();
    locala.gUU = localazi;
    locala.gUV = new azj();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(191064);
  }
  
  public z(a<z> parama)
  {
    this();
    this.gXX = parama;
  }
  
  public final azj avY()
  {
    AppMethodBeat.i(191067);
    if (this.gXW == null)
    {
      localazj = new azj();
      AppMethodBeat.o(191067);
      return localazj;
    }
    azj localazj = this.gXW;
    AppMethodBeat.o(191067);
    return localazj;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(191065);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(191065);
    return i;
  }
  
  public final int getType()
  {
    return 1769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(191066);
    ad.w("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.gXW = ((azj)((b)paramq).gUT.gUX);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gXX != null) {
      this.gXX.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(191066);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.z
 * JD-Core Version:    0.7.0.1
 */