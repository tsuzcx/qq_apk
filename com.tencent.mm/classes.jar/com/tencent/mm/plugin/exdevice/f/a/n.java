package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends m
  implements k
{
  private f callback;
  public int lHT;
  public int lHU;
  public int opType;
  private b rr;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(19472);
    this.callback = null;
    this.rr = null;
    this.opType = paramInt1;
    this.lHT = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cmy();
    ((b.a)localObject).fsY = new cmz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
    ((b.a)localObject).funcId = 1044;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cmy)this.rr.fsV.fta;
    ((cmy)localObject).cFm = this.opType;
    ((cmy)localObject).bsY = this.lHT;
    AppMethodBeat.o(19472);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19473);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19473);
    return i;
  }
  
  public final int getType()
  {
    return 1044;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19474);
    ab.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.lHU = ((cmz)this.rr.fsW.fta).bsY;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.n
 * JD-Core Version:    0.7.0.1
 */