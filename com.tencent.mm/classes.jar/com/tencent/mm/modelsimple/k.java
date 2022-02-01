package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public k(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20617);
    ae.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ahd();
    ((b.a)localObject).hQG = new ahe();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
    ((b.a)localObject).funcId = 1066;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
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
      paramString2 = (ahd)this.rr.hQD.hQJ;
      paramString2.FZa = paramString1;
      paramString2.ucK = paramInt;
      paramString2.Gxv = com.tencent.mm.bw.b.aPw((String)localObject);
      if (paramArrayOfByte == null) {}
      for (paramString2.GuM = com.tencent.mm.bw.b.cm(new byte[0]);; paramString2.GuM = com.tencent.mm.bw.b.cm(paramArrayOfByte))
      {
        ae.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramString2.GuM.zr.length) });
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
    ae.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k
 * JD-Core Version:    0.7.0.1
 */