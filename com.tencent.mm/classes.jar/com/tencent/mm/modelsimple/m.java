package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private final c rr;
  
  public m(String paramString1, int paramInt, String paramString2)
  {
    this(paramString1, paramInt, paramString2, null, 0);
  }
  
  public m(String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(236733);
    Log.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s, %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aoa();
    ((c.a)localObject).otF = new aob();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
    ((c.a)localObject).funcId = 1066;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    if (paramString2 != null)
    {
      localObject = paramString2;
      if (paramString2.length() > 32)
      {
        localObject = paramString2;
        if (paramInt1 == 19) {}
      }
    }
    for (localObject = paramString2.substring(0, 32);; localObject = "")
    {
      paramString2 = (aoa)c.b.b(this.rr.otB);
      paramString2.YRs = paramString1;
      paramString2.IcB = paramInt1;
      paramString2.ZvE = b.bsj((String)localObject);
      if (paramArrayOfByte == null) {}
      for (paramString2.ZqS = b.cX(new byte[0]);; paramString2.ZqS = b.cX(paramArrayOfByte))
      {
        paramString2.ZvF = paramInt2;
        Log.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramString2.ZqS.Op.length) });
        AppMethodBeat.o(236733);
        return;
      }
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20618);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.modelsimple.m
 * JD-Core Version:    0.7.0.1
 */