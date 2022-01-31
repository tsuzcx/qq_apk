package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends m
  implements k
{
  public int cFm;
  private f callback;
  public String fhP;
  public String lHC;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(19466);
    this.callback = null;
    this.rr = null;
    this.lHC = paramString3;
    this.fhP = paramString2;
    this.cFm = paramInt;
    this.lHC = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bac();
    ((b.a)localObject).fsY = new bad();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/addlike";
    ((b.a)localObject).funcId = 1041;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bac)this.rr.fsV.fta;
    ((bac)localObject).lOy = paramString2;
    ((bac)localObject).username = paramString1;
    ((bac)localObject).cFm = paramInt;
    ((bac)localObject).fhi = paramString3;
    AppMethodBeat.o(19466);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19467);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19467);
    return i;
  }
  
  public final int getType()
  {
    return 1041;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19468);
    ab.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.l
 * JD-Core Version:    0.7.0.1
 */