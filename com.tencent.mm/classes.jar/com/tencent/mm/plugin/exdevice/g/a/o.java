package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elz;
import com.tencent.mm.protocal.protobuf.ema;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  public int opType;
  public int rCU;
  public int rCV;
  private d rr;
  
  public o(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23540);
    this.callback = null;
    this.rr = null;
    this.opType = paramInt1;
    this.rCU = paramInt2;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new elz();
    ((d.a)localObject).iLO = new ema();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
    ((d.a)localObject).funcId = 1044;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (elz)this.rr.iLK.iLR;
    ((elz)localObject).dYx = this.opType;
    ((elz)localObject).cSx = this.rCU;
    AppMethodBeat.o(23540);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23541);
    this.callback = parami;
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
      this.rCV = ((ema)this.rr.iLL.iLR).cSx;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.o
 * JD-Core Version:    0.7.0.1
 */