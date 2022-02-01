package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  private b gPp;
  private aij vlk;
  private aik vll;
  
  public a(String paramString)
  {
    AppMethodBeat.i(65035);
    b.a locala = new b.a();
    locala.hNM = new aij();
    locala.hNN = new aik();
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.gPp = locala.aDC();
    this.vlk = ((aij)this.gPp.hNK.hNQ);
    this.vlk.vkl = paramString;
    AppMethodBeat.o(65035);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65037);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(65037);
    return i;
  }
  
  public final int getType()
  {
    return 1987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65036);
    this.vll = ((aik)((b)paramq).hNL.hNQ);
    ad.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.vll.dlw), this.vll.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vll.dlw, this.vll.paA, this);
    }
    AppMethodBeat.o(65036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */