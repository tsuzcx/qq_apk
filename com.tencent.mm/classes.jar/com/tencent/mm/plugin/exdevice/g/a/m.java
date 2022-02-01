package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.protocal.protobuf.drd;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private f callback;
  public String coverUrl;
  public String qeP;
  private b rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23537);
    this.callback = null;
    this.rr = null;
    this.coverUrl = paramString1;
    this.qeP = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new drc();
    ((b.a)localObject).hNN = new drd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
    ((b.a)localObject).funcId = 1040;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (drc)this.rr.hNK.hNQ;
    ((drc)localObject).GEt = paramString1;
    ((drc)localObject).qeP = paramString2;
    AppMethodBeat.o(23537);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23538);
    this.callback = paramf;
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
    ad.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.m
 * JD-Core Version:    0.7.0.1
 */