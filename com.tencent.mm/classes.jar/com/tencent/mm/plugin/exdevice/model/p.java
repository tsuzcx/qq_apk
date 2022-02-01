package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.fpe;
import com.tencent.mm.protocal.protobuf.fpf;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  public String hEl;
  c rr;
  public int ysb;
  
  public p(dao paramdao, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(23388);
    this.callback = null;
    this.rr = null;
    this.hEl = null;
    this.ysb = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fpe();
    ((c.a)localObject).otF = new fpf();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((c.a)localObject).funcId = 1717;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    Log.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "deviceid %s", new Object[] { paramString2 });
    localObject = (fpe)c.b.b(this.rr.otB);
    ((fpe)localObject).YJY = paramString1;
    ((fpe)localObject).ZoO = paramString2;
    ((fpe)localObject).abPi = paramdao;
    ((fpe)localObject).abPj = paramInt;
    this.hEl = paramString2;
    this.ysb = paramInt;
    AppMethodBeat.o(23388);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23390);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.p
 * JD-Core Version:    0.7.0.1
 */