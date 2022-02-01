package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  public String coverUrl;
  public String pBk;
  private b rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23537);
    this.callback = null;
    this.rr = null;
    this.coverUrl = paramString1;
    this.pBk = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dll();
    ((b.a)localObject).hvu = new dlm();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
    ((b.a)localObject).funcId = 1040;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dll)this.rr.hvr.hvw;
    ((dll)localObject).EUW = paramString1;
    ((dll)localObject).pBk = paramString2;
    AppMethodBeat.o(23537);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23538);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23538);
    return i;
  }
  
  public final int getType()
  {
    return 1040;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23539);
    ac.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.m
 * JD-Core Version:    0.7.0.1
 */