package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public k(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20617);
    Log.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ajp();
    ((d.a)localObject).iLO = new ajq();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
    ((d.a)localObject).funcId = 1066;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
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
      paramString2 = (ajp)this.rr.iLK.iLR;
      paramString2.KSV = paramString1;
      paramString2.xub = paramInt;
      paramString2.Lte = b.bfZ((String)localObject);
      if (paramArrayOfByte == null) {}
      for (paramString2.Lqr = b.cD(new byte[0]);; paramString2.Lqr = b.cD(paramArrayOfByte))
      {
        Log.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramString2.Lqr.zy.length) });
        AppMethodBeat.o(20617);
        return;
      }
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20618);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20618);
    return i;
  }
  
  public final int getType()
  {
    return 1066;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20619);
    Log.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k
 * JD-Core Version:    0.7.0.1
 */