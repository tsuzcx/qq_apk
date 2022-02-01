package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public j(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20617);
    ac.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aek();
    ((b.a)localObject).hvu = new ael();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
    ((b.a)localObject).funcId = 1066;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
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
      paramString2 = (aek)this.rr.hvr.hvw;
      paramString2.EaV = paramString1;
      paramString2.sVo = paramInt;
      paramString2.Exk = com.tencent.mm.bw.b.aIw((String)localObject);
      if (paramArrayOfByte == null) {}
      for (paramString2.EuL = com.tencent.mm.bw.b.cc(new byte[0]);; paramString2.EuL = com.tencent.mm.bw.b.cc(paramArrayOfByte))
      {
        ac.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramString2.EuL.xy.length) });
        AppMethodBeat.o(20617);
        return;
      }
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20618);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.j
 * JD-Core Version:    0.7.0.1
 */