package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public i(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(153482);
    ab.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new zx();
    ((b.a)localObject).fsY = new zy();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
    ((b.a)localObject).funcId = 1066;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
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
      paramString2 = (zx)this.rr.fsV.fta;
      paramString2.wxM = paramString1;
      paramString2.niK = paramInt;
      paramString2.wQU = com.tencent.mm.bv.b.ank((String)localObject);
      if (paramArrayOfByte == null) {}
      for (paramString2.wPb = com.tencent.mm.bv.b.bL(new byte[0]);; paramString2.wPb = com.tencent.mm.bv.b.bL(paramArrayOfByte))
      {
        ab.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramString2.wPb.pW.length) });
        AppMethodBeat.o(153482);
        return;
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16573);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16573);
    return i;
  }
  
  public final int getType()
  {
    return 1066;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16574);
    ab.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.i
 * JD-Core Version:    0.7.0.1
 */