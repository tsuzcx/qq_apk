package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.protocal.protobuf.etu;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  public String fzB;
  d rr;
  public int vgd;
  
  public n(ckh paramckh, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(23388);
    this.callback = null;
    this.rr = null;
    this.fzB = null;
    this.vgd = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ett();
    ((d.a)localObject).lBV = new etu();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((d.a)localObject).funcId = 1717;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ett)d.b.b(this.rr.lBR);
    ((ett)localObject).RMK = paramString1;
    ((ett)localObject).SpT = paramString2;
    ((ett)localObject).UvD = paramckh;
    ((ett)localObject).UvE = paramInt;
    this.fzB = paramString2;
    this.vgd = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */