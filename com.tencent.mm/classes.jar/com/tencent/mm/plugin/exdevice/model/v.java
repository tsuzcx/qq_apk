package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ab;

public final class v
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public v(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(19344);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new byf();
    ((b.a)localObject).fsY = new byg();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
    ((b.a)localObject).funcId = 1270;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (byf)this.rr.fsV.fta;
    ((byf)localObject).wvw = new auh();
    ((byf)localObject).wvw.wsq = paramString1;
    ((byf)localObject).wvw.jJD = paramString2;
    ((byf)localObject).xKB = paramString3;
    AppMethodBeat.o(19344);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19346);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19346);
    return i;
  }
  
  public final int getType()
  {
    return 1270;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19345);
    ab.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.v
 * JD-Core Version:    0.7.0.1
 */