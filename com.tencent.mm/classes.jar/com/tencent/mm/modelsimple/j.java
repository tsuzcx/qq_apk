package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public j(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20617);
    ad.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new agt();
    ((b.a)localObject).hNN = new agu();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
    ((b.a)localObject).funcId = 1066;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    if (paramString2 != null)
    {
      localObject = paramString2;
      if (paramString2.length() > 32)
      {
        localObject = paramString2;
        if (paramInt == 19) {}
      }
    }
    for (localObject = paramString2.substring(0, 32);; localObject = "")
    {
      paramString2 = (agt)this.rr.hNK.hNQ;
      paramString2.FGE = paramString1;
      paramString2.tRT = paramInt;
      paramString2.GeN = com.tencent.mm.bx.b.aNZ((String)localObject);
      if (paramArrayOfByte == null) {}
      for (paramString2.Gcf = com.tencent.mm.bx.b.cj(new byte[0]);; paramString2.Gcf = com.tencent.mm.bx.b.cj(paramArrayOfByte))
      {
        ad.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramString2.Gcf.zr.length) });
        AppMethodBeat.o(20617);
        return;
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20618);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20618);
    return i;
  }
  
  public final int getType()
  {
    return 1066;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20619);
    ad.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.j
 * JD-Core Version:    0.7.0.1
 */