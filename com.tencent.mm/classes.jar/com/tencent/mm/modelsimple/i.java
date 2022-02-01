package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private final d rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(20609);
    Log.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[] { paramString });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new agb();
    ((d.a)localObject).iLO = new agc();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
    ((d.a)localObject).funcId = 1067;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (agb)this.rr.iLK.iLR;
    ((agb)localObject).KSV = paramString;
    ((agb)localObject).Lqr = b.cD(new byte[0]);
    AppMethodBeat.o(20609);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(20610);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.i
 * JD-Core Version:    0.7.0.1
 */