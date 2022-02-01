package com.tencent.mm.plugin.box.b;

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
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  public String dwW;
  private b hWL;
  private long nVi;
  public bla nVj;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76328);
    this.dwW = paramString1;
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweappbox";
    locala.hNM = new bkz();
    locala.hNN = new bla();
    this.hWL = locala.aDC();
    ((bkz)this.hWL.hNK.hNQ).GFj = paramString2;
    ad.i("MicroMsg.Box.NetSceneBox", "Create NetSceneBox %s %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(76328);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(76329);
    this.nVi = System.currentTimeMillis();
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    ad.i("MicroMsg.Box.NetSceneBox", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.nVi) });
    this.nVj = ((bla)this.hWL.hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(76330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.b.a
 * JD-Core Version:    0.7.0.1
 */