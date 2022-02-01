package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.adq;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(20609);
    ad.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[] { paramString });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new adp();
    ((b.a)localObject).hNN = new adq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
    ((b.a)localObject).funcId = 1067;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (adp)this.rr.hNK.hNQ;
    ((adp)localObject).FGE = paramString;
    ((adp)localObject).Gcf = com.tencent.mm.bx.b.cj(new byte[0]);
    AppMethodBeat.o(20609);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20610);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20610);
    return i;
  }
  
  public final int getType()
  {
    return 1067;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20611);
    ad.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h
 * JD-Core Version:    0.7.0.1
 */