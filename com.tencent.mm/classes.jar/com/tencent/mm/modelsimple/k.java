package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(20609);
    Log.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[] { paramString });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aiz();
    ((c.a)localObject).otF = new aja();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
    ((c.a)localObject).funcId = 1067;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aiz)c.b.b(this.rr.otB);
    ((aiz)localObject).YRs = paramString;
    ((aiz)localObject).ZqS = b.cX(new byte[0]);
    AppMethodBeat.o(20609);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20610);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20610);
    return i;
  }
  
  public final int getType()
  {
    return 1067;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20611);
    Log.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k
 * JD-Core Version:    0.7.0.1
 */