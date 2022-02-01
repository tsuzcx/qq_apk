package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.frw;
import com.tencent.mm.protocal.protobuf.frx;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends p
  implements m
{
  private h callback;
  public int opType;
  private c rr;
  public int yuD;
  public int yuE;
  
  public o(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23540);
    this.callback = null;
    this.rr = null;
    this.opType = paramInt1;
    this.yuD = paramInt2;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new frw();
    ((c.a)localObject).otF = new frx();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
    ((c.a)localObject).funcId = 1044;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (frw)c.b.b(this.rr.otB);
    ((frw)localObject).hYl = this.opType;
    ((frw)localObject).eQp = this.yuD;
    AppMethodBeat.o(23540);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23541);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23541);
    return i;
  }
  
  public final int getType()
  {
    return 1044;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23542);
    Log.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.yuE = ((frx)c.c.b(this.rr.otC)).eQp;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.o
 * JD-Core Version:    0.7.0.1
 */