package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ejp;
import com.tencent.mm.protocal.protobuf.ejq;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  public String dGL;
  public int rAw;
  d rr;
  
  public n(cce paramcce, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(23388);
    this.callback = null;
    this.rr = null;
    this.dGL = null;
    this.rAw = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ejp();
    ((d.a)localObject).iLO = new ejq();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((d.a)localObject).funcId = 1717;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ejp)this.rr.iLK.iLR;
    ((ejp)localObject).KLO = paramString1;
    ((ejp)localObject).Lox = paramString2;
    ((ejp)localObject).NiV = paramcce;
    ((ejp)localObject).NiW = paramInt;
    this.dGL = paramString2;
    this.rAw = paramInt;
    AppMethodBeat.o(23388);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23390);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23390);
    return i;
  }
  
  public final int getType()
  {
    return 1717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23389);
    Log.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */