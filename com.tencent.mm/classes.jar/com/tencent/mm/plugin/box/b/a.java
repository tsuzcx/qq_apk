package com.tencent.mm.plugin.box.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private g callback;
  public String dnB;
  private b hdD;
  private long mRC;
  public bda mRD;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76328);
    this.dnB = paramString1;
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweappbox";
    locala.gUU = new bcz();
    locala.gUV = new bda();
    this.hdD = locala.atI();
    ((bcz)this.hdD.gUS.gUX).DAp = paramString2;
    ad.i("MicroMsg.Box.NetSceneBox", "Create NetSceneBox %s %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(76328);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(76329);
    this.mRC = System.currentTimeMillis();
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(76329);
    return i;
  }
  
  public final int getType()
  {
    return 1869;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76330);
    ad.i("MicroMsg.Box.NetSceneBox", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.mRC) });
    this.mRD = ((bda)this.hdD.gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(76330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.b.a
 * JD-Core Version:    0.7.0.1
 */