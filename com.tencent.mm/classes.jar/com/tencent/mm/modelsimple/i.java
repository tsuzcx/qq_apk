package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(20609);
    ae.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[] { paramString });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ady();
    ((b.a)localObject).hQG = new adz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
    ((b.a)localObject).funcId = 1067;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ady)this.rr.hQD.hQJ;
    ((ady)localObject).FZa = paramString;
    ((ady)localObject).GuM = com.tencent.mm.bw.b.cm(new byte[0]);
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
    ae.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.i
 * JD-Core Version:    0.7.0.1
 */