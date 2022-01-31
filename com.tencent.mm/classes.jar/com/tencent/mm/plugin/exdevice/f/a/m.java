package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public String lHo;
  public String lHp;
  private b rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19469);
    this.callback = null;
    this.rr = null;
    this.lHo = paramString1;
    this.lHp = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cmw();
    ((b.a)localObject).fsY = new cmx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
    ((b.a)localObject).funcId = 1040;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cmw)this.rr.fsV.fta;
    ((cmw)localObject).xgy = paramString1;
    ((cmw)localObject).lHp = paramString2;
    AppMethodBeat.o(19469);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19470);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19470);
    return i;
  }
  
  public final int getType()
  {
    return 1040;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19471);
    ab.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.m
 * JD-Core Version:    0.7.0.1
 */