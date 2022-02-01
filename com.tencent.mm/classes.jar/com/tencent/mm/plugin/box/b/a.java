package com.tencent.mm.plugin.box.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  private g callback;
  public String dlj;
  private b hEg;
  private long ntS;
  public bgs ntT;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76328);
    this.dlj = paramString1;
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweappbox";
    locala.hvt = new bgr();
    locala.hvu = new bgs();
    this.hEg = locala.aAz();
    ((bgr)this.hEg.hvr.hvw).EVL = paramString2;
    ac.i("MicroMsg.Box.NetSceneBox", "Create NetSceneBox %s %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(76328);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(76329);
    this.ntS = System.currentTimeMillis();
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.Box.NetSceneBox", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.ntS) });
    this.ntT = ((bgs)this.hEg.hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(76330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.b.a
 * JD-Core Version:    0.7.0.1
 */