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
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends m
  implements k
{
  public String bYu;
  private f callback;
  public int lFv;
  b rr;
  
  public n(avn paramavn, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(19319);
    this.callback = null;
    this.rr = null;
    this.bYu = null;
    this.lFv = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cln();
    ((b.a)localObject).fsY = new clo();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((b.a)localObject).funcId = 1717;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cln)this.rr.fsV.fta;
    ((cln)localObject).wsq = paramString1;
    ((cln)localObject).wNG = paramString2;
    ((cln)localObject).xVB = paramavn;
    ((cln)localObject).xVC = paramInt;
    this.bYu = paramString2;
    this.lFv = paramInt;
    AppMethodBeat.o(19319);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19321);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19321);
    return i;
  }
  
  public final int getType()
  {
    return 1717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19320);
    ab.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */